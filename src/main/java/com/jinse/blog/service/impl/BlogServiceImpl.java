package com.jinse.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.BlogMapper;
import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.mapper.PictureMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogTag;
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

	@Override
	public int deleteBlogByBlogId(Blog blog) {
		// delete picture
		PictureExample example = new PictureExample();
		Criteria criteria = example.createCriteria();
		criteria.andBlogIdEqualTo(blog.getBlogId());
		pictureMapper.deleteByExample(example);
		// delete blog
		int count = blogMapper.deleteByPrimaryKey(blog.getBlogId());
		return count;
	}

}
