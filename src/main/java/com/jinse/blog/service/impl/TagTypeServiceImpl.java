package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.TagTypeMapper;
import com.jinse.blog.pojo.TagType;
import com.jinse.blog.service.TagTypeService;

public class TagTypeServiceImpl implements TagTypeService{

	@Autowired
	private TagTypeMapper tagTypeMapper;
	
	@Override
	public List<TagType> findTableTagTypeList() {
		return tagTypeMapper.findTableTagTypeList();
	}

}
