package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.User;

public interface BlogService {

	int saveBlog(Blog blog);

	Blog findBlogByBlogId(Integer blogId);

	List<Blog> findPhotoListByUserId(Integer userId,String type);

	int deleteBlogByBlogId(Blog blog);

	int saveBlogAndReturnId(Blog blog);

	List<Blog> findPhotoListByTitle(String title);

	List<Blog> findBlogListByTitle(String title, String type);

	List<Blog> findArticleListByTitle(String title);

	int updateBlogByBlogId(Blog blog);

	Blog findBlogArticleByBlogId(Integer blogId);

	List<Blog> findVideoListByTitle(String content);

	List<User> findArticleListByUserAndTitle(String content);


}
