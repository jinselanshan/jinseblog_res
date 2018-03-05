package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.ArticleMapper;
import com.jinse.blog.pojo.Article;
import com.jinse.blog.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	@Override
	public int saveArticle(Article article) {
		return articleMapper.insert(article);
	}
	@Override
	public List<Article> findAllArticle() {
		return articleMapper.findAllArticle();
	}
	@Override
	public List<String> findAllArticleContent() {
		return articleMapper.findAllArticleContent();
	}

}
