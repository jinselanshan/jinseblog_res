package com.jinse.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.TagMapper;
import com.jinse.blog.pojo.Tag;
import com.jinse.blog.service.TagService;

public class TagServiceImpl implements TagService{

	@Autowired
	private TagMapper tagMapper;
	
	@Override
	public Tag findTagByTagName(String tagName) {
		return tagMapper.findTagByTagName(tagName);
	}

	@Override
	public int addTagAndReturnId(Tag tag) {
		if(tag.getType() == null) {
			tag.setType("1");
		}
		return tagMapper.insertTag(tag);
	}

	@Override
	public List<Tag> findTagListByCount(String type) {
		return tagMapper.findTagListByCount(type);
	}

	@Override
	public Tag findTagByTagId(Integer tagId) {
		return tagMapper.selectByPrimaryKey(tagId);
	}

	@Override
	public List<Tag> findTagListByUserIdAndType(Integer userId, String type) {
		Map<String,String> map= new HashMap<String,String>();
		map.put("userId", String.valueOf(userId));
		map.put("type", type);
		return tagMapper.findTagListByUserIdAndType(map);
	}

}
