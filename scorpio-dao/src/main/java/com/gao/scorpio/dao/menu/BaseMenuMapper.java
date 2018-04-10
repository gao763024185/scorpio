package com.gao.scorpio.dao.menu;

import com.gao.scorpio.entity.BaseMenu;
import com.gao.scorpio.entity.BaseMenuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseMenuMapper {
    int countByExample(BaseMenuExample example);

    int deleteByExample(BaseMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(BaseMenu record);

    int insertSelective(BaseMenu record);

    List<BaseMenu> selectByExample(BaseMenuExample example);

    BaseMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") BaseMenu record, @Param("example") BaseMenuExample example);

    int updateByExample(@Param("record") BaseMenu record, @Param("example") BaseMenuExample example);

    int updateByPrimaryKeySelective(BaseMenu record);

    int updateByPrimaryKey(BaseMenu record);

    /**
     * 自定义
     * @return
     */
    List<BaseMenu> findAll();
}