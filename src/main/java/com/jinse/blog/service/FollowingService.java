package com.jinse.blog.service;

import com.jinse.blog.pojo.UserFollowing;

public interface FollowingService {

	int deleteFollowing(UserFollowing userFollowing);

	int findFollowingByFollowingId(UserFollowing userFollowing);

	int findAllFollowing(Integer userId);
	
	int saveFollowing(UserFollowing userFollowing);
}
