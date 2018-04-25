package mq.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description rabbitmq 消费消息demo
 * @author: gaobh
 * @date: 2018/4/24 9:20
 * @version: v1.0
 */
public class MqConsumerDemo {

    /**
     * 队列名称
     */
    private final static String QUEUE_NAME = "queueDemo2";

    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接工厂、创建连接、创建通道与发送端一样
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        Connection conn = connectionFactory.newConnection();
        Channel channel = conn.createChannel();
        //此处再次声明队列是为了防止消费者先运行此程序，队列不存在时创建队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        //声明一个消费者，配置好获取消息的方式（DefaultConsumer替代了3.X版本的QueueingConsumer）
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("ReceiveLogsDirect1 Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        //接收
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}
