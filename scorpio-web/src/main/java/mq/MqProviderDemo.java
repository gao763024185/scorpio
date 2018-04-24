package mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description rabbitmq 生产者demo
 * @author: gaobh
 * @date: 2018/4/23 17:52
 * @version: v1.0
 */
public class MqProviderDemo {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建链接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //默认链接的主机名，RabbitMQ-Server安装在本机
        connectionFactory.setHost("127.0.0.1");
        //创建链接
        Connection conn = connectionFactory.newConnection();

        //创建信息管道
        Channel channel = conn.createChannel();
        //创建一个名为queueDemo1的队列，防止队列不存在
        String queueName = "queueDemo1";

        //进行信息声明1.队列名2.是否持久化3.是否局限与链接4.不再使用是否删除5.其他的属性
        channel.queueDeclare(queueName, false, false, false, null);
        String msg = "Hello World!";
        //发送消息
        //在RabbitMQ中，消息是不能直接发送到队列，他需要发送到交换器（exchange）中
        //第一参数空表示使用默认的exchange，第二参数表示发送到的queue，第三参数是发送的消息是（字节数组）
        channel.basicPublish("", queueName, null, msg.getBytes());
        System.out.println("发送 message[" + msg + "] to" + queueName + "success!");
        //关闭通道
        channel.close();
        //关闭连接
        conn.close();
    }
}
