package mq.topic;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @description topic转发器类型的demo
 * @author: gaobh
 * @date: 2018/4/25 16:15
 * @version: v1.0
 */
@SuppressWarnings("ALL")
public class MqTopicConsumer2Demo {

    private static final String EXCHANGE_NAME = "topic_logs";
    private static final String QUEUE_NAME = "topic_queue";
    public static void main(String[] args) throws Exception {
        // 创建连接和频道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "*.critical");
        System.out.println(" [*] Waiting for messages about critical . To exit press CTRL+C");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                String routingKey = envelope.getRoutingKey();
                System.out.println(" [x] Received routingKey = " + routingKey
                        + ",msg = " + message + ".");
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
