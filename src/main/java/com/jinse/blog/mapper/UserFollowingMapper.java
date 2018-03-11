package com.jinse.blog.mapper;

import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserClasses;
import com.jinse.blog.pojo.UserFollowing;
import com.jinse.blog.pojo.UserFollowingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFollowingMapper {
    int countByExample(UserFollowingExample example);

    int deleteByExample(UserFollowingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFollowing record);

    int insertSelective(UserFollowing record);

    List<UserFollowing> selectByExample(UserFollowingExample example);

    UserFollowing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFollowing record, @Param("example") UserFollowingExample example);

    int updateByExample(@Param("record") UserFollowing record, @Param("example") UserFollowingExample example);

    int updateByPrimaryKeySelective(UserFollowing record);

    int updateByPrimaryKey(UserFollowing record);

    int findFollowingByFollowingId(UserFollowing userFollowing);

	int findAllFollowingCount(Integer userId);

	int deleteFollowing(UserFollowing userFollowing);

	Integer findFollowingByUserIdAndFollowingId(UserFollowing userFollowing);

}