package com.jinse.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;


import com.jinse.blog.mapper.BlogTagMapper;
import com.jinse.blog.pojo.BlogTag;
import com.jinse.blog.service.BlogTagService;

public class BlogTagServiceImpl implements BlogTagService {

	@Autowired
	private BlogTagMapper blogTagMapper;
	
	
	@Override
	public int addBlogTag(BlogTag blogTag) {
		return blogTagMapper.insert(blogTag);
	}

}
