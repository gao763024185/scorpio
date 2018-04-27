package com.gao.scorpio.service.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @description
 * @author: gaobh
 * @date: 2018/4/27 16:16
 * @version: v1.0
 */
public class MqConsumer1Service implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("消费者消费："+message.toString());
    }
}
