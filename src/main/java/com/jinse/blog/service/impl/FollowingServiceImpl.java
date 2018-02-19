package com.jinse.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.UserFollowerMapper;
import com.jinse.blog.mapper.UserFollowingMapper;
import com.jinse.blog.mapper.UserMapper;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserFollowing;
import com.jinse.blog.service.FollowingService;

public class FollowingServiceImpl implements FollowingService {

	@Autowired
	UserFollowingMapper userFollowingMapper;
	@Autowired
	UserFollowerMapper userFollowerMapper;
	@Autowired
	UserMapper userMapper;
	
	//加关注
	@Override
	public int saveFollowing(UserFollowing userFollowing) {
		// user关注following user 加关注，following加粉丝
		int countUser = userFollowingAdd(userFollowing);
		int count = 0;
		if(countUser == 1) {
			count = userFollowingMapper.insert(userFollowing);
		}
		return count;
	}

	private int userFollowingAdd(UserFollowing userFollowing) {
		User user = new User();
		user.setUserId(userFollowing.getUserId());
		return userMapper.addUserFollowingByUserId(user);
	}

	//减关注
	@Override
	public int deleteFollowing(UserFollowing userFollowing) {
		int countUser = userFollowingMinus(userFollowing);
		int count = 0;
		if(countUser == 1) {
			count = userFollowingMapper.deleteFollowing(userFollowing);
		}
		return count;
	}

	private int userFollowingMinus(UserFollowing userFollowing) {
		User user = new User();
		user.setUserId(userFollowing.getUserId());
		return userMapper.minusUserFollowingByUserId(user);
	}

	@Override
	public int findFollowingByFollowingId(UserFollowing userFollowing) {
		return userFollowingMapper.findFollowingByFollowingId(userFollowing);
	}

	@Override
	public int findAllFollowing(Integer userId) {
		return userFollowingMapper.findAllFollowing(userId);
	}
}
