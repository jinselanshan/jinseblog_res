package com.jinse.blog.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.UserFollowerMapper;
import com.jinse.blog.mapper.UserFollowingMapper;
import com.jinse.blog.mapper.UserMapper;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserClasses;
import com.jinse.blog.pojo.UserFollowing;
import com.jinse.blog.service.FollowingService;
import com.jinse.blog.utils.SpringUtil;

public class FollowingServiceImpl implements FollowingService {

	@Autowired
	private UserFollowingMapper userFollowingMapper;
	@Autowired
	private UserFollowerMapper userFollowerMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FollowingService followingService;
	
	// 加关注
	@Override
	public int saveFollowing(UserFollowing userFollowing) {
		// user关注following user 加关注，following加粉丝
		// 关注加1，粉丝加1
		int countUser = userFollowingAdd(userFollowing);
		int count = 0;
		if (countUser == 2) {
			count = userFollowingMapper.insert(userFollowing);
		}
		return count;
	}

	private int userFollowingAdd(UserFollowing userFollowing) {
		int followingnumber = userMapper.addUserFollowingByUserId(userFollowing.getUserId());
		int followernumber = userMapper.addUserFollowerByUserId(userFollowing.getFollowingId());
		return followingnumber + followernumber;
	}

	// 减关注
	@Override
	public int deleteFollowing(UserFollowing userFollowing) {
		int countUser = userFollowingMinus(userFollowing);
		int count = 0;
		if (countUser == 2) {
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
	public int findAllFollowingCount(Integer userId) {
		return userFollowingMapper.findAllFollowingCount(userId);
	}

	@Override
	public List<User> findAllFollowing(Integer userId) {
		return userMapper.findAllFollowingByUserId(userId);
	}

	@Override
	public List<UserClasses> findAllFollowingByUserId(Integer userId) {
		List<User> userList = userMapper.findAllFollowingByUserId(userId);
		if (userList == null) {
			throw new RuntimeException("用户不存在");
		}
		List<UserClasses> userClassesList = userListToUserClassesList(userList);
		for (UserClasses user : userClassesList) {
			user.setIsfollowing(1);
		}
		return userClassesList;
	}

	private List<UserClasses> userListToUserClassesList(List<User> userList) {
		List<UserClasses> userClassesList = new ArrayList<UserClasses>();

		for (User user : userList) {

			try {
				UserClasses UserClasses = new UserClasses();
				BeanUtils.copyProperties(UserClasses, user);
				userClassesList.add(UserClasses);

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		
		return userClassesList;
	}

	@Override
	public List<UserClasses> findAllFollowerByUserId(Integer userId) {
		List<User> userList = userMapper.findAllFollowerByUserId(userId);
		if (userList == null) {
			throw new RuntimeException("用户不存在");
		}
		List<UserClasses> userClassesList = userListToUserClassesList(userList);
		
		for (UserClasses user : userClassesList) {
			UserFollowing userFollowing = new UserFollowing();
			userFollowing.setUserId(SpringUtil.getCurrentUser().getUserId());
			userFollowing.setFollowingId(user.getUserId());
			int count = followingService.findFollowingByFollowingId(userFollowing);
			if(count == 1) {
				user.setIsfollowing(1);
			}
		}
		return userClassesList;

	}
}
