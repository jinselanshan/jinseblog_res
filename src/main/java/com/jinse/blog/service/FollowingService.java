package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserFollowing;

public interface FollowingService {

	int deleteFollowing(UserFollowing userFollowing);

	int findFollowingByFollowingId(UserFollowing userFollowing);

	int findAllFollowingCount(Integer userId);
	
	int saveFollowing(UserFollowing userFollowing);

	List<User> findAllFollowing(Integer userId);
}
