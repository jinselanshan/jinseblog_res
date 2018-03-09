package com.jinse.blog.mapper;

import com.jinse.blog.pojo.Article;
import com.jinse.blog.pojo.ArticleExample;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer articleId);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

	List<Article> findAllArticle();

	List<String> findAllArticleContent();

	User findAllArticleByUserId(Integer userId);

	List<Blog> findArticleListByTitle(String title);
	
	List<Blog> findAllArticleList();

	Blog findBlogArticleByBlogId(Integer blogId);

}