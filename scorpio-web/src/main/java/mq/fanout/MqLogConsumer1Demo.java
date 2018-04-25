package mq.fanout;

import com.rabbitmq.client.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @description 日志消费者 打印到日志文件
 * @author: gaobh
 * @date: 2018/4/25 14:42
 * @version: v1.0
 */
public class MqLogConsumer1Demo {
    private final static String EXCHANGE_NAME = "ex_log";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //创建一个非持久的、唯一的且自动删除的队列
        String queueName = channel.queueDeclare().getQueue();
        //为转发器指定一个队列，设置binding
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println(" [*] Waiting for message.To exit press CTRL+C");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                String dir = "e://logs";
                String logFileName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                File file = new File(dir, logFileName + ".txt");
                FileOutputStream fos = new FileOutputStream(file, true);
                fos.write((message + "\r\n").getBytes());
                fos.flush();
                fos.close();
            }
        };
        channel.basicConsume(queueName,true,consumer);
    }
}
