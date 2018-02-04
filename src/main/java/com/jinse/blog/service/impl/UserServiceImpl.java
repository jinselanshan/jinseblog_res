package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.PictureMapper;
import com.jinse.blog.mapper.UserMapper;
import com.jinse.blog.pojo.User;
import com.jinse.blog.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public int save(User user) {
		return userMapper.insert(user);
	}
	@Override
	public List<User> findByUser(User user) {
		return userMapper.findByUser(user);
	}
	@Override
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

}
