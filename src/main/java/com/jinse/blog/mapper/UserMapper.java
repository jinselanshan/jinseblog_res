package com.jinse.blog.mapper;

import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserClasses;
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

	int addUserFollowingByUserId(Integer userId);

	int addUserFollowerByUserId(Integer followingId);

	int minusUserFollowingByUserId(Integer userId);
	
	int minusUserFollowerByUserId(Integer followingId);

	int insertUser(User user);

	List<User> findAllFollowing(Integer userId);

	List<User> findUserListByUsername(String username);

}