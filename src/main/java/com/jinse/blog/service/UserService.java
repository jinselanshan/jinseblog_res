package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.User;

public interface UserService {

	int save(User user);

	User findByUser(User user);

	User findUserByUsername(String username);

	User findUserByUserId(Integer userId);

	int updateAvatarUrlByUserId(User user);

	int updateUserByUserId(User user);

}