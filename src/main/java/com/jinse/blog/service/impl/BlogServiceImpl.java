package com.jinse.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.ArticleMapper;
import com.jinse.blog.mapper.BlogMapper;
import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.mapper.BlogTagMapper;
import com.jinse.blog.mapper.PictureMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogTag;
import com.jinse.blog.pojo.BlogTagExample;
import com.jinse.blog.pojo.PictureExample;
import com.jinse.blog.pojo.Tag;
import com.jinse.blog.pojo.PictureExample.Criteria;
import com.jinse.blog.service.BlogService;

public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogPictureMapper blogPictureMapper;
	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private PictureMapper pictureMapper;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private BlogTagMapper blogTagMapper;

	@Override
	public int saveBlog(Blog blog) {
		return blogPictureMapper.insertBlog(blog);
	}

	@Override
	public Blog findBlogByBlogId(Integer blogId) {
		Blog blog =  blogPictureMapper.findBlogAndPictureByBlogId(blogId);
		setTagListByBlog(blog);
		return blog;
	}

	@Override
	public List<Blog> findPhotoListByUserId(Integer userId) {

		List<Blog> blogList = blogPictureMapper.findPhotoListByUserId(userId);
	
		// 设置标签,遍历blog
		for (int i = 0; i < blogList.size(); i++) {
			Blog blog = blogList.get(i);
			setTagListByBlog(blog);
		}
		return blogList;
	}

	private void setTagListByBlog(Blog blog) {
		String tagStr = blog.getTag();
		if(tagStr != null && !tagStr.equals("")){
			String[] tagArray = tagStr.trim().split(" ");
			List<Tag> tagList = new ArrayList<Tag>();
			// 遍历tag
			for (String tagName : tagArray) {
				Tag tag = new Tag();
				tag.setTagName(tagName);
				tagList.add(tag);
			}
			blog.setTagList(tagList);
		}
	}

	@Override
	public int deleteBlogByBlogId(Blog blog) {
		Integer blogId = blog.getBlogId();
		// delete picture
		PictureExample example = new PictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogIdEqualTo(blogId);
		pictureMapper.deleteByExample(example);
		// delete tag_mappper
		BlogTagExample blogTagExample = new BlogTagExample();
		com.jinse.blog.pojo.BlogTagExample.Criteria criteriaTag = blogTagExample.createCriteria();
		criteriaTag.andBlogIdEqualTo(blogId);
		blogTagMapper.deleteByExample(blogTagExample);
		// delete blog
		int count = blogMapper.deleteByPrimaryKey(blogId);
		return count;
	}

	@Override
	public int saveBlogAndReturnId(Blog blog) {
		return blogMapper.saveBlogAndReturnId(blog);
	}

	@Override
	public List<Blog> findPhotoListByTitle(String title) {
		return blogPictureMapper.findPhotoListByTitle(title);
	}

	@Override
	public List<Blog> findBlogListByTitle(String title,String type) {
		return blogPictureMapper.findBlogListByTitle(title,type);
	}

	@Override
	public List<Blog> findArticleListByTitle(String title) {
		return articleMapper.findArticleListByTitle(title);
	}

	@Override
	public int updateBlogByBlogId(Blog blog) {
		return blogMapper.updateByPrimaryKey(blog);
	}

	@Override
	public Blog findBlogArticleByBlogId(Integer blogId) {
		return articleMapper.findBlogArticleByBlogId(blogId);
	}

}
