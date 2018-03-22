package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.UsersTagMapper;
import com.jinse.blog.pojo.UserExample;
import com.jinse.blog.pojo.UsersTag;
import com.jinse.blog.pojo.UsersTagExample;
import com.jinse.blog.pojo.UsersTagExample.Criteria;
import com.jinse.blog.service.UsersTagService;

public class UsersTagServiceImpl implements UsersTagService {
	@Autowired
	private UsersTagMapper usersTagMapper;
	@Override
	public int addUsersTag(UsersTag usersTag) {
		return usersTagMapper.insert(usersTag);
	}
	@Override
	public List<UsersTag> findUsersTagMapperByUserId(Integer userId) {
		UsersTagExample usersTagExample = new UsersTagExample();
		Criteria  criteria = usersTagExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		
		List<UsersTag> usersTagList = usersTagMapper.selectByExample(usersTagExample);
		return usersTagList;
	}
	@Override
	public List<UsersTag> findMaxTenUsersTagMapperByUserId(Integer userId) {
		List<UsersTag> usersTagList = usersTagMapper.findMaxTenUsersTagMapperByUserId(userId);
		return usersTagList;
	}

}
