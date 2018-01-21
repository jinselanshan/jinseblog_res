package com.jinse.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.BlogMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.service.BlogService;

public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	public void addBlog(Blog blog) {
		int i = blogMapper.insert(blog);
	}

}