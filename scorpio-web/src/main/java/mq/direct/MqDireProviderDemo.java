package mq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @description 根据绑定建来确定转发队列的direct类型的转发器demo
 * @author: gaobh
 * @date: 2018/4/25 15:36
 * @version: v1.0
 */
public class MqDireProviderDemo {
    private final static String EXCHANGE_NAME = "ex_log_direct";
    private final static String[] SEVERITIES = {"info", "waring", "error"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        for (int i = 0; i < 6; i++) {
            String severity = getSeverity();
            String message = severity + "_log :" + UUID.randomUUID().toString();
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }

    /**
     * 随机产生一种日志类型
     *
     * @return
     */
    private static String getSeverity() {
        Random random = new Random();
        int ranVal = random.nextInt(3);
        return SEVERITIES[ranVal];
    }
}
