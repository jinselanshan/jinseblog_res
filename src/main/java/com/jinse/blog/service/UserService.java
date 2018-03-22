package com.jinse.blog.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserClasses;

public interface UserService {

	int saveUserAndReturnId(User user);

	User findByUser(User user);

	User findUserByUsername(String username);

	User findUserByUserId(Integer userId);

	int updateAvatarUrlByUserId(User user);

	int updateUserByUserId(User user);

	List<UserClasses> findUserListByUsername(String username) throws IllegalAccessException, InvocationTargetException;

}
