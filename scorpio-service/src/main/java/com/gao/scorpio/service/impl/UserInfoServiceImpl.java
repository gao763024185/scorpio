package com.gao.scorpio.service.impl;

import com.gao.scorpio.dao.user.BaseUserMapper;
import com.gao.scorpio.entity.BaseUser;
import com.gao.scorpio.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaobh on 2016/12/14.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private BaseUserMapper baseUserMapper;

    @Override
    public BaseUser loginValid(BaseUser user){
        return baseUserMapper.loginValid(user);
    }
    @Override
    public List<BaseUser> findAll(){ return baseUserMapper.findAll();}
    @Override
    public  int updateByPrimaryKeySelective(BaseUser user){return baseUserMapper.updateByPrimaryKeySelective(user);}
    @Override
    public  BaseUser selectByPrimaryKey(Integer id){return baseUserMapper.selectByPrimaryKey(id);}
}
