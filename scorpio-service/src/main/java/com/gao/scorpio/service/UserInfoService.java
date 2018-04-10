package com.gao.scorpio.service;



import com.gao.scorpio.entity.BaseUser;

import java.util.List;

/**
 * Created by gaobh on 2016/12/14.
 */
public interface UserInfoService {
    /**
     * 验证用户登录
     *
     * @param user
     * @return
     */
    BaseUser loginValid(BaseUser user);

    /**
     * 输出所有用户（哈哈 就我一人儿）
     *
     * @return
     */
    List<BaseUser> findAll();

    int updateByPrimaryKeySelective(BaseUser user);

    BaseUser selectByPrimaryKey(Integer id);
}
