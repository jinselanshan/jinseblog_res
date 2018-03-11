package com.jinse.blog.service.impl;

import java.util.List;

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

}
