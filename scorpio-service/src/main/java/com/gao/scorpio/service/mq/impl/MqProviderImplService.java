package com.gao.scorpio.service.mq.impl;

import com.gao.scorpio.service.mq.MqProviderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: gaobh
 * @date: 2018/4/26 14:25
 * @version: v1.0
 */
@Service
public class MqProviderImplService implements MqProviderService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 生产者发送消息
     *
     * @param key
     * @param obj
     */
    @Override
    public void sendData(String key, Object obj) {
        amqpTemplate.convertAndSend(key, obj);
    }

}
