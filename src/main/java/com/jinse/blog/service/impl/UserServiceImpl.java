package com.jinse.blog.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.UserFollowingMapper;
import com.jinse.blog.mapper.UserMapper;
import com.jinse.blog.mapper.UsersTagMapper;
import com.jinse.blog.pojo.Tag;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserClasses;
import com.jinse.blog.pojo.UserExample;
import com.jinse.blog.pojo.UserExample.Criteria;
import com.jinse.blog.pojo.UserFollowing;
import com.jinse.blog.pojo.UsersTag;
import com.jinse.blog.service.FollowingService;
import com.jinse.blog.service.TagService;
import com.jinse.blog.service.UserService;
import com.jinse.blog.service.UsersTagService;
import com.jinse.blog.utils.SpringUtil;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserFollowingMapper userFollowingMapper;
	@Autowired
	private FollowingService followingService;
	@Autowired
	private UsersTagService usersTagService;
	@Autowired
	private TagService tagService;

	@Override
	public int saveUserAndReturnId(User user) {
		// 注册的时候就关注自己
		int count = userMapper.insertUser(user);
		// 关注自己
		Integer userId = user.getUserId();
		UserFollowing userFollowing = new UserFollowing();
		userFollowing.setUserId(userId);
		userFollowing.setFollowingId(userId);
		Integer number = userFollowingMapper.findFollowingByUserIdAndFollowingId(userFollowing);
		if (number == 0) {
			userFollowingMapper.insert(userFollowing);
		}

		return count;
	}

	@Override
	public UserClasses findByUser(User user) {
		User userRes = userMapper.findByUser(user);
		UserClasses userClasses = userToUserClasses(userRes);
		return userClasses;
	}

	//USER转USERCLASSES
	private UserClasses userToUserClasses(User userRes) {
		UserClasses userClasses = new UserClasses();
		try {
			BeanUtils.copyProperties(userClasses, userRes);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		List<UsersTag> usersTagList = usersTagService.findMaxTenUsersTagMapperByUserId(userRes.getUserId());
		//返回标签在“用户常用标签”中显示
		if (usersTagList != null && usersTagList.size() > 0) {
			List<Tag> tagList = new ArrayList<Tag>();
			for (UsersTag usersTag : usersTagList) {
				Tag tag = tagService.findTagByTagId(usersTag.getTagId());
				tagList.add(tag);
			}
			userClasses.setTagList(tagList);
		}
		return userClasses;
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
		Criteria criteria = userExample.createCriteria();
		criteria.andUserIdEqualTo(user.getUserId());

		int count = userMapper.updateByExampleSelective(user, userExample);

		return count;
	}

	// 查询用户
	@Override
	public List<UserClasses> findUserListByUsername(String username) {
		List<User> userList = userMapper.findUserListByUsername(username);

		if (userList == null) {
			throw new RuntimeException("用户不存在");
		}
		List<UserClasses> userClassesList = new ArrayList<UserClasses>();

		for (User user : userList) {

			try {
				UserClasses userClasses = new UserClasses();
				BeanUtils.copyProperties(userClasses, user);
				userClassesList.add(userClasses);

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}

		for (UserClasses user : userClassesList) {
			UserFollowing userFollowing = new UserFollowing();
			userFollowing.setUserId(SpringUtil.getCurrentUser().getUserId());
			userFollowing.setFollowingId(user.getUserId());
			int count = followingService.findFollowingByFollowingId(userFollowing);
			if (count == 1) {
				user.setIsfollowing(1);
			}
		}

		return userClassesList;
	}
}
