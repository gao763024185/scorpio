package com.gao.scorpio.dao.user;

import com.gao.scorpio.entity.BaseUser;
import com.gao.scorpio.entity.BaseUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BaseUserMapper {

    int countByExample(BaseUserExample example);

    int deleteByExample(BaseUserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    List<BaseUser> selectByExample(BaseUserExample example);

    BaseUser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") BaseUser record, @Param("example") BaseUserExample example);

    int updateByExample(@Param("record") BaseUser record, @Param("example") BaseUserExample example);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    /**
     * 登陆验证
     * @param user
     * @return
     */
    BaseUser loginValid(BaseUser user);

    /**
     * 查出所有的登陆列表
     * @return
     */
    List<BaseUser> findAll();
}