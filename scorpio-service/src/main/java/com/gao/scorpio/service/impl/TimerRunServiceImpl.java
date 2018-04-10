package com.gao.scorpio.service.impl;

import com.gao.scorpio.entity.Logs;
import com.gao.scorpio.entity.LogsExample;
import com.gao.scorpio.service.TimerRunService;
import com.gao.scorpio.service.LogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

/**
 * @description 定时器service（定时器采用quartz，spring自带定时器暂时未启用）
 * @author: gaobh
 * @date: 2017/5/17
 * @version: v1.0
 */
@Service
public class TimerRunServiceImpl implements TimerRunService {
    @Resource
    ServletContext context;
    @Resource
    private LogsService logsService;

    @Override
    public void countTimer() {
        /**
         * 10分钟执行一次
         */
        final long timeInterval = 10 * 60 * 1000;

        new Thread() {
            public void run() {
                while (true) {
                    count();
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /**
     * 保存访问量
     */
    @Override
    public void saveCount() {
        this.count();
    }


    @SuppressWarnings("Duplicates")
    public void count() {
        List<Map<String, String>> mapList = (List) context.getAttribute("list");
        if (mapList != null && mapList.size() > 0) {
            for (Map<String, String> map : mapList) {
                LogsExample logsExample = new LogsExample();
                LogsExample.Criteria criteria = logsExample.createCriteria();
                criteria.andLogIdEqualTo(map.get("logId"));
                Logs logs = new Logs();
                logs.setCount(Integer.valueOf(map.get("count")));
                logsService.updateByExampleSelective(logs, logsExample);
            }
        }
    }
}
