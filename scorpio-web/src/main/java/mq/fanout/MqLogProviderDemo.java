package mq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @description 通过自定义转发器给每个队列发送日志
 * @author: gaobh
 * @date: 2018/4/25 14:35
 * @version: v1.0
 */
public class MqLogProviderDemo {

    private final static String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        //fanout类型转发器把所有它接收到的消息广播到所有他所知道的队列
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String message = new Date().toLocaleString() + " : fanout something";
        //往转发器上发送消息
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }

}
