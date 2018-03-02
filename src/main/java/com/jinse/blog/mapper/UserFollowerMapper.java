package com.jinse.blog.mapper;

import com.jinse.blog.pojo.UserFollower;
import com.jinse.blog.pojo.UserFollowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFollowerMapper {
    int countByExample(UserFollowerExample example);

    int deleteByExample(UserFollowerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFollower record);

    int insertSelective(UserFollower record);

    List<UserFollower> selectByExample(UserFollowerExample example);

    UserFollower selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFollower record, @Param("example") UserFollowerExample example);

    int updateByExample(@Param("record") UserFollower record, @Param("example") UserFollowerExample example);

    int updateByPrimaryKeySelective(UserFollower record);

    int updateByPrimaryKey(UserFollower record);

	int findAllFollower(Integer userId);

	int deleteFollower(UserFollower userFollower);
}