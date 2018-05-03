package com.gao.scorpio.service.dubbo.impl;

import com.gao.scorpio.service.dubbo.DubboProviderService;
import org.springframework.stereotype.Service;

/**
 * @description dubbo 提供服务的service实现类
 * @author: gaobh
 * @date: 2018/5/2 10:27
 * @version: v1.0
 */
@Service
public class DubboProviderServiceImpl implements DubboProviderService {
    @Override
    public String helloWorld(String str) {
        System.out.println("dubbo提供服务的helloWorld：hello world !" + str);
        return "hello world !" + str;
    }
}
