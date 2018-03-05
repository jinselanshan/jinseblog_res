package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Article;

public interface ArticleService {

	int saveArticle(Article article);

	List<Article> findAllArticle();

	List<String> findAllArticleContent();

}
