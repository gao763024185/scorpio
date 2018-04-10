package com.gao.scorpio.dao.feed;


import com.gao.scorpio.entity.Feed;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Feed record);

    int insertSelective(Feed record);

    Feed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feed record);

    int updateByPrimaryKey(Feed record);
}