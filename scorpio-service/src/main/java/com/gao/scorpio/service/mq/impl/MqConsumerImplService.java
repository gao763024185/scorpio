package com.gao.scorpio.service.mq.impl;

import com.gao.scorpio.service.mq.MqConsumerService;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: gaobh
 * @date: 2018/4/26 14:25
 * @version: v1.0
 */
@Service
public class MqConsumerImplService implements MqConsumerService {
    /**
     * 消费者接收消息
     *
     * @param key
     * @param obj
     */
    @Override
    public void receiveData(String key, Object obj) {
        System.out.println("[receive]:"+obj);
    }
}
