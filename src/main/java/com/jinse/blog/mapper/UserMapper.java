package com.jinse.blog.mapper;

import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User findByUser(User user);

	User findUserByUsername(String username);

	int updateAvatarUrlByUserId(User user);

	User findHomeUserByUserId(Integer userId);

	int addUserFollowingByUserId(User user);

	int minusUserFollowingByUserId(User user);
}