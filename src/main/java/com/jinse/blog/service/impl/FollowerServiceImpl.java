package com.jinse.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.UserFollowerMapper;
import com.jinse.blog.pojo.UserFollower;
import com.jinse.blog.service.FollowerService;

public class FollowerServiceImpl implements FollowerService{
	@Autowired
	UserFollowerMapper userFollowerMapper;
	@Override
	public int findAllFollower(Integer userId) {
		return userFollowerMapper.findAllFollower(userId);
	}
	@Override
	public int savaFollower(Integer userId, Integer followerId) {
		UserFollower userFollower = new UserFollower();
		userFollower.setFollowerId(followerId);
		userFollower.setUserId(userId);
		return userFollowerMapper.insert(userFollower);
	}
	@Override
	public int deleteFollower(UserFollower userFollower) {
		return userFollowerMapper.deleteFollower(userFollower);
	}
}
