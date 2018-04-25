package mq.dupli;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description 多个消费者下的新的生产者
 * @author: gaobh
 * @date: 2018/4/25 10:13
 * @version: v1.0
 */
public class DupliMqProviderDemo {
    private final static String QUEUE_NAME = "workQueue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        for (int i = 10; i > 0; i--) {
            String dots = "";
            for (int j = 0; j <= i; j++) {
                dots += ".";
            }
            String message = "helloWorld" + dots + dots.length();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
