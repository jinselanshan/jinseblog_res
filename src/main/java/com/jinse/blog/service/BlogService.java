package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Blog;

public interface BlogService {

	int saveBlog(Blog blog);

	Blog findBlogByBlogId(Integer blogId);

	List<Blog> findPhotoListByUserId(Integer userId);

	int deleteBlogByBlogId(Blog blog);

}
