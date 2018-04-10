package com.gao.scorpio.service.impl;

import com.gao.scorpio.dao.menu.BaseMenuMapper;
import com.gao.scorpio.entity.BaseMenu;
import com.gao.scorpio.entity.BaseMenuExample;
import com.gao.scorpio.service.BaseMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description 管理员service
 * @author: gaobh
 * @date: 2017/4/26
 * @version: v1.0
 */
@Service
public class BaseMenuServiceImpl implements BaseMenuService {

    @Resource
    private BaseMenuMapper baseMenuMapper;

    @Override
    public List<BaseMenu> selectByExample(BaseMenuExample example) {
        return baseMenuMapper.selectByExample(example);
    }

    @Override
    public List<BaseMenu> findAll() {
        return baseMenuMapper.findAll();
    }
}
