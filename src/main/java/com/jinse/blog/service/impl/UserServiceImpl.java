package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.UserFollowingMapper;
import com.jinse.blog.mapper.UserMapper;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserExample;
import com.jinse.blog.pojo.UserExample.Criteria;
import com.jinse.blog.pojo.UserFollowing;
import com.jinse.blog.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserFollowingMapper userFollowingMapper;
	
	@Override
	public int saveUserAndReturnId(User user) {
		//注册的时候就关注自己
		int count = userMapper.insertUser(user);
		//关注自己
		Integer userId = user.getUserId();
		UserFollowing userFollowing = new UserFollowing();
		userFollowing.setUserId(userId);
		userFollowing.setFollowingId(userId);
		Integer number = userFollowingMapper.findFollowingByUserIdAndFollowingId(userFollowing);
		if(number == 0) {
			userFollowingMapper.insert(userFollowing);
		}
		
		return count;
	}
	@Override
	public User findByUser(User user) {
		return userMapper.findByUser(user);
	}
	@Override
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
	@Override
	public User findUserByUserId(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	@Override
	public int updateAvatarUrlByUserId(User user) {
		return userMapper.updateAvatarUrlByUserId(user);
	}
	@Override
	public int updateUserByUserId(User user) {
		UserExample userExample = new UserExample();
		Criteria  criteria = userExample.createCriteria();
		criteria.andUserIdEqualTo(user.getUserId());
		
		int count = userMapper.updateByExampleSelective(user, userExample);
		
		return count;
	}
	@Override
	public List<User> findUserListByUsername(String username) {
		return userMapper.findUserListByUsername(username);
	}
}
