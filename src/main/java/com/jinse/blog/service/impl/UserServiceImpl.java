package com.jinse.blog.service.impl;

import java.util.List;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.PictureMapper;
import com.jinse.blog.mapper.UserMapper;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserExample;
import com.jinse.blog.pojo.UserExample.Criteria;
import com.jinse.blog.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public int save(User user) {
		return userMapper.insert(user);
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
		return userMapper.updateByExampleSelective(user, userExample);
	}
}
