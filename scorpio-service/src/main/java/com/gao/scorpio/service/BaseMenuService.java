package com.gao.scorpio.service;


import com.gao.scorpio.entity.BaseMenu;
import com.gao.scorpio.entity.BaseMenuExample;

import java.util.List;

/**
 * Created by 高保红 on 2017/4/26.
 */
public interface BaseMenuService {

    List<BaseMenu> selectByExample(BaseMenuExample example);
    List<BaseMenu> findAll();
}
