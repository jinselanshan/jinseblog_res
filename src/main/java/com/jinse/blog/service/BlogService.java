package com.jinse.blog.service;

import com.jinse.blog.pojo.Blog;

public interface BlogService {

	int saveBlog(Blog blog);

	Blog findBlogByBlogId(Integer blogId);

}
