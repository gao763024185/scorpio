package com.gao.scorpio.controller.starter;

import com.gao.scorpio.service.TimerRunService;
import com.gao.scorpio.service.LogsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @description 定时器
 * @author: gaobh
 * @date: 2017/5/16
 * @version: v1.0
 */
@Component
public class PlateformStarter {

    @Resource
    private TimerRunService timerRunService;
    @Resource
    private LogsService logsService;

    @PostConstruct
    public void init() {
        logsService.installLogsCount();//启动时载入访问次数
//        timerRunService.countTimer();//启动保存访问次数的定时器
    }
}
