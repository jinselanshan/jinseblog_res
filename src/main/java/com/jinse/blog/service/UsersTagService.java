package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.UsersTag;

public interface UsersTagService {

	int addUsersTag(UsersTag usersTag);

	List<UsersTag> findUsersTagMapperByUserId(Integer userId);

	List<UsersTag> findMaxTenUsersTagMapperByUserId(Integer userId);

}
