package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.User;

public interface UserService {

	int save(User user);

	List<User> findByUser(User user);

	User findUserByUsername(String username);

}
