package mq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @description topic转发器类型的demo
 * @author: gaobh
 * @date: 2018/4/25 16:11
 * @version: v1.0
 */
public class MqTopicProviderDemo {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String[] routing_keys = new String[]{"kernel.info", "cron.warning", "auth.info", "kernel.critical"};
        for (String routing_key : routing_keys) {
            String msg = UUID.randomUUID().toString();
            channel.basicPublish(EXCHANGE_NAME, routing_key, null, msg.getBytes());
            System.out.println(" [x] Sent routingKey = " + routing_key + " ,msg = " + msg + ".");
        }
        channel.close();
        connection.close();
    }
}
