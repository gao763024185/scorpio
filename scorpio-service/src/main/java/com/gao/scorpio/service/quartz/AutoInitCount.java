package com.gao.scorpio.service.quartz;

import com.gao.scorpio.service.TimerRunService;
import com.gao.scorpio.service.LogsService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description quartz定时器--项目启动自动载入日志访问量
 * @author: gaobh
 * @date: 2018/3/27 11:26
 * @version: v1.0
 */
@Service
public class AutoInitCount implements Job {
//    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LogsService logsService;
    @Autowired
    private TimerRunService timerRunService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        logger.error("---------quartz start------");
        timerRunService.saveCount();
    }

}
