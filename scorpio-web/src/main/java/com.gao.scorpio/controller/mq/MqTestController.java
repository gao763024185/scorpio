package com.gao.scorpio.controller.mq;

import com.gao.scorpio.service.mq.MqProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description
 * @author: gaobh
 * @date: 2018/4/27 10:07
 * @version: v1.0
 */
@Controller
@RequestMapping("/abc")
public class MqTestController {

    @Autowired
    private MqProviderService mqProviderService;

    /**
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendQueue")
    public String testQueue() {
        try {
            mqProviderService.sendData("scorpio", "hello rabbitmq");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "发送完毕";
    }
}
