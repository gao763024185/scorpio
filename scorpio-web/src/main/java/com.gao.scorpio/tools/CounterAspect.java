package com.gao.scorpio.tools;

import org.apache.commons.collections.map.HashedMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by 高保红 on 2017/8/2.
 */
@Aspect
public class CounterAspect {

    @Resource
    ServletContext context;

    @Pointcut("execution(* com.gao.scorpio.controller.user.UserInfoController.detail(..))")
    public void count() {
    }

    @Around("count()")
    public Object countNum(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("出错啦");
        }

        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;
        ModelMap mapping = null;
        String logId = null;
        //通过分析aop监听参数分析出request等信息
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof HttpServletRequest) {
                request = (HttpServletRequest) args[i];
            }
            if (args[i] instanceof ModelMap) {
                mapping = (ModelMap) args[i];
            }
            if (args[i] instanceof String) {
                logId = (String) args[i];
            }
        }
        System.out.println("我是counterAspect:" + logId);
        synchronized (context) {
            List<Map<String, String>> list = new ArrayList<>();
            list = (List<Map<String, String>>) context.getAttribute("list");
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list != null && list.size() > 0) {
                for (Map<String, String> map1 : list) {
                    Integer count = 1;
                    if (logId.equals(map1.get("logId"))) {
                        count = Integer.valueOf(map1.get("count"));
                        if (null == count) {
                            count = new Integer(1);
                        } else {
                            count = new Integer(count.intValue() + 1);
                        }
                        map1.put("count", String.valueOf(count));
                    }
                }
            }
            Set<String> set = new HashSet<>();
            for (int i = 0; list != null && i < list.size(); i++) {
                set.add(list.get(i).get("logId"));
            }
            //若是没有logId就添加 或者不包含此次传进来的id就添加
            if (!set.contains(logId)) {
                Map<String, String> map = new HashedMap();
                map.put("logId", logId);
                map.put("count", "1");
                list.add(map);
            }
            context.setAttribute("list", list);
        }
        return result;
    }
}
