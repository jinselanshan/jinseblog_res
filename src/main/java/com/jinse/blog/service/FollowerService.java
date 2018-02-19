package com.jinse.blog.service;

import com.jinse.blog.pojo.UserFollower;

public interface FollowerService {
	
	int findAllFollower(Integer userId);
	
	int savaFollower(Integer userId, Integer followerId);
	
	int deleteFollower(UserFollower userFollower);

}
