package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Article;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.User;

public interface ArticleService {

	int saveArticle(Article article);

	List<Article> findAllArticle();

	List<String> findAllArticleContent();
	
	User findAllArticleByUserId(Integer userId);

	List<Blog> findAllArticleList();

}
