package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogAndLike;
import com.jinse.blog.pojo.User;
import com.jinse.blog.vos.BlogVO;

public interface BlogService {

	int saveBlog(Blog blog);

	Blog findBlogByBlogId(Integer blogId);

	List<BlogAndLike> findPhotoListByUserIdAndType(BlogVO blogVO);

	List<BlogAndLike> findPhotoListByUserId(Integer userId);

	int deleteBlogByBlogId(Blog blog);

	int saveBlogAndReturnId(Blog blog);

	List<Blog> findPhotoListByTitle(String title);

	List<Blog> findBlogListByTitle(String title, String type);

	List<Blog> findArticleListByTitle(String title);

	int updateBlogByBlogId(Blog blog);

	Blog findBlogArticleByBlogId(Integer blogId);

	List<Blog> findVideoListByTitle(String content);

	List<User> findArticleListByUserAndTitle(String content);

	List<BlogAndLike> findBuyPhotoListByUserId(Integer userId);

}
