package mq.simple;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
/**
 * @description rabbitmq 生产者demo
 * @author: gaobh
 * @date: 2018/4/23 17:52
 * @version: v1.0
 */
public class MqProviderDemo {
    /**
     * 队列名称
     */
    private final static String QUEUE_NAME = "queueDemo2";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建链接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //默认链接的主机名，RabbitMQ-Server安装在本机
        connectionFactory.setHost("127.0.0.1");
        //创建连接
        Connection conn = connectionFactory.newConnection();

        //创建信息管道
        Channel channel = conn.createChannel();

        //进行信息声明1.队列名2.是否持久化3.是否局限与链接4.不再使用是否删除5.其他的属性
        //设置队列持久化，当rabbitmq服务停止时，队列也存在
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        String msg = "Hello World!";
        //在RabbitMQ中，消息是不能直接发送到队列，他需要发送到交换器（exchange）中
        // 第一参数空表示使用默认的exchange，
        // 第三个参数设置消息持久化（即服务断开后再重启数据任然存在）
        // 第四参数是发送的消息（字节数组）
        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
        System.out.println("发送 message[" + msg + "] to " + QUEUE_NAME + " success!");
        //关闭通道和连接
        channel.close();
        conn.close();
    }
}
