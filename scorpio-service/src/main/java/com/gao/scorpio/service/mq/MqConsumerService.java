package com.gao.scorpio.service.mq;

/**
 * @description
 * @author: gaobh
 * @date: 2018/4/26 14:23
 * @version: v1.0
 */
public interface MqConsumerService {
    /**
     * 消费者接收消息
     * @param key
     * @param obj
     */
    void receiveData(String key, Object obj);
}
