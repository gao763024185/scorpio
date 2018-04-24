package mq;

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
    public static void main(String[] args) throws IOException, TimeoutException {

        //创建链接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //默认链接的主机名，RabbitMQ-Server安装在本机
        connectionFactory.setHost("127.0.0.1");
        //创建链接
        Connection conn = connectionFactory.newConnection();
        //创建信息通道
        Channel channel = conn.createChannel();
        //定义Queue名称
        String queueName = "queueDemo1";
        //进行信息声明1.队列名2.是否持久化3.是否局限与链接4.不再使用是否删除5.其他的属性
        channel.queueDeclare(queueName, false, false, false, null);


        //声明一个消费者，配置好获取消息的方式
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("ReceiveLogsDirect1 Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        //接收
        channel.basicConsume(queueName, true, consumer);

    }
}
