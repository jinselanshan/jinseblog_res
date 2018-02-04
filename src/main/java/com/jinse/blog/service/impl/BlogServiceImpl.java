package com.jinse.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.BlogMapper;
import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.service.BlogService;

public class BlogServiceImpl implements BlogService{
	@Autowired
	private BlogPictureMapper blogPictureMapper;
	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	public int saveBlog(Blog blog) {
		return  blogPictureMapper.insertBlog(blog);
	}

}
