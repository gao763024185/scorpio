package mq.dupli;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description 多个消费者情况下的消费者1
 * @author: gaobh
 * @date: 2018/4/25 10:21
 * @version: v1.0
 */
@SuppressWarnings("ALL")
public class DupliMqConsumer1Demo {
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
        //打开消息应答机制，以防其中一个消费者突然宕机时，出现消息丢失问题
        //此处ack=false 理解为关闭通道的自动应答，改为消费完数据之后手动应答，防止数据丢失后，无应答
        boolean ack = false;
        channel.basicConsume(QUEUE_NAME, ack, consumer);


    }
}
