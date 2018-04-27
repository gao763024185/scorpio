package com.gao.scorpio.service.mq;

import com.gao.scorpio.service.mq.impl.MqConsumerImplService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @description
 * @author: gaobh
 * @date: 2018/4/27 9:53
 * @version: v1.0
 */
public class MqConsumerServiceTest {
    @Autowired
    private MqConsumerImplService mqConsumerImplService;
    @Test
    public void receiveData() throws Exception {
//        mqConsumerImplService.receiveData();
    }

}