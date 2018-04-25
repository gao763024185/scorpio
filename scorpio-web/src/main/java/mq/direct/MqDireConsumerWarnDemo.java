package mq.direct;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * @description 根据绑定建来确定转发队列的direct类型的转发器demo
 * @author: gaobh
 * @date: 2018/4/25 15:47
 * @version: v1.0
 */
@SuppressWarnings("ALL")
public class MqDireConsumerWarnDemo {
    private final static String EXCHANGE_NAME = "ex_log_direct";
    private final static String[] SEVERITIES = {"info", "waring", "error"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();
        String severity = SEVERITIES[1];
        channel.queueBind(queueName, EXCHANGE_NAME, severity);
        System.out.println(" [*] Waiting for " + severity + " logs. To exit press CTRL+C");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };

        channel.basicConsume(queueName, true, consumer);
    }

}
