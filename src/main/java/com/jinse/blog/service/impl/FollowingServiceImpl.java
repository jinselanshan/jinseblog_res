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
		//关注加1，粉丝加1
		int countUser = userFollowingAdd(userFollowing);
		int count = 0;
		if(countUser == 2) {
			count = userFollowingMapper.insert(userFollowing);
		}
		return count;
	}

	private int userFollowingAdd(UserFollowing userFollowing) {
		int followingnumber = userMapper.addUserFollowingByUserId(userFollowing.getUserId());
		int followernumber = userMapper.addUserFollowerByUserId(userFollowing.getFollowingId());
		return followingnumber + followernumber;
	}

	//减关注
	@Override
	public int deleteFollowing(UserFollowing userFollowing) {
		int countUser = userFollowingMinus(userFollowing);
		int count = 0;
		if(countUser == 2) {
			count = userFollowingMapper.deleteFollowing(userFollowing);
		}
		return count;
	}

	private int userFollowingMinus(UserFollowing userFollowing) {
		int followingnumber = userMapper.minusUserFollowingByUserId(userFollowing.getUserId());
		int followernumber = userMapper.minusUserFollowerByUserId(userFollowing.getFollowingId());
		return followingnumber + followernumber;
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
