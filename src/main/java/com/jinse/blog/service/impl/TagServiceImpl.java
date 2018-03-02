package com.jinse.blog.service.impl;

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
		tag.setType("1");
		return tagMapper.insertTag(tag);
	}

}
