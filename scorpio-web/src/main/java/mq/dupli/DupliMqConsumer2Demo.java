package mq.dupli;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description
 * @author: gaobh
 * @date: 2018/4/25 10:41
 * @version: v1.0
 */
@SuppressWarnings("ALL")
public class DupliMqConsumer2Demo {
    private final static String QUEUE_NAME = "workQueue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //区分不同工作进程的输出
        final int hashCode = DupliMqConsumer1Demo.class.hashCode();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(hashCode + "[*] Waiting for message.To exit press CTRL+C");
        //设置最大服务转发消息数量
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(hashCode + " [x] Received '" + message + "'");
                try {
                    for (char ch : message.toCharArray()) {
                        if (ch == '.') {
                            Thread.sleep(1000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //另外需要在每次处理完成一个消息后，手动发一次应答。
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
                System.out.println(hashCode + " [x] Done");
            }
        };
        boolean ack = false;
        channel.basicConsume(QUEUE_NAME, ack, consumer);
    }
}
