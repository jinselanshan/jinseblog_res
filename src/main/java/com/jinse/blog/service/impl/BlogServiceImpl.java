package com.jinse.blog.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.ArticleMapper;
import com.jinse.blog.mapper.BlogMapper;
import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.mapper.BlogTagMapper;
import com.jinse.blog.mapper.LikeifMapper;
import com.jinse.blog.mapper.PictureMapper;
import com.jinse.blog.mapper.VideoMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogAndLike;
import com.jinse.blog.pojo.BlogTag;
import com.jinse.blog.pojo.BlogTagExample;
import com.jinse.blog.pojo.Likeif;
import com.jinse.blog.pojo.LikeifExample;
import com.jinse.blog.pojo.PictureExample;
import com.jinse.blog.pojo.Tag;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserClasses;
import com.jinse.blog.pojo.PictureExample.Criteria;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.LikeifService;
import com.jinse.blog.utils.BlogUtil;
import com.jinse.blog.utils.DeletePicture;
import com.jinse.blog.vos.BlogVO;

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
	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private LikeifMapper likeifMapper;
	@Autowired
	private LikeifService likeifService;

	@Override
	public int saveBlog(Blog blog) {
		return blogPictureMapper.insertBlog(blog);
	}

	@Override
	public Blog findBlogByBlogId(Integer blogId) {
		Blog blog = blogPictureMapper.findBlogAndPictureByBlogId(blogId);
		setTagListByBlog(blog);
		return blog;
	}

	//关注的博客李彪
	@Override
	public List<BlogAndLike> findPhotoListByUserIdAndType(BlogVO blogVO) {
		List<Blog> blogList = blogPictureMapper.findPhotoListByUserIdAndType(blogVO);
		
		Integer userId = blogVO.getUserId();
		List<BlogAndLike> blogAndLikeList = blogToBlogAndLike(blogList, userId);

		return blogAndLikeList;
	}

	//发现自己的博客列表
	@Override
	public List<BlogAndLike> findPhotoListByUserId(Integer userId) {
		List<Blog> blogList = blogPictureMapper.findPhotoListByUserId(userId);
		List<BlogAndLike> blogAndLikeList = blogToBlogAndLike(blogList, userId);

		return blogAndLikeList;
	}
	//发现自己的出售作品列表
	@Override
	public List<Blog> findBuyPhotoListByUserId(Integer userId) {
		List<Blog> blogList = blogPictureMapper.findBuyPhotoListByUserId(userId);
	
		return blogList;
	}

	private List<BlogAndLike> blogToBlogAndLike(List<Blog> blogList, Integer userId) {
		if (blogList == null) {
			throw new RuntimeException("博客不存在");
		}

		// 设置标签,遍历blog
		for (int i = 0; i < blogList.size(); i++) {
			Blog blog = blogList.get(i);
			setTagListByBlog(blog);
		}
		List<BlogAndLike> blogAndLikeList = new ArrayList<BlogAndLike>();
		if (blogList != null && blogList.size() > 0) {
			for (Blog blogres : blogList) {
				BlogAndLike blogAndLike = new BlogAndLike();
				try {
					BeanUtils.copyProperties(blogAndLike, blogres);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				Likeif likeif = new Likeif();
				likeif.setBlogId(blogres.getBlogId());
				likeif.setUserId(userId);
				int count = likeifService.findLikeifByBlogIdAndUserId(likeif);
				blogAndLike.setLikeif(count);
				blogAndLikeList.add(blogAndLike);
			}
		}
		return blogAndLikeList;
	}

	private void setTagListByBlog(Blog blog) {
		String tagStr = blog.getTag();
		if (tagStr != null && !tagStr.equals("")) {
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
		// delete qiniuyun
		Blog blogRes = blogPictureMapper.findBlogAndPictureByBlogId(blogId);
		if(blogRes.getPicture().getUrl().indexOf("500px") == -1) {
			DeletePicture.deletePic(blogRes.getPicture());
		}
		
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
		// delete likeif
		LikeifExample likeifExample = new LikeifExample();
		com.jinse.blog.pojo.LikeifExample.Criteria criteriaLikeif = likeifExample.createCriteria();
		criteriaLikeif.andBlogIdEqualTo(blogId);
		likeifMapper.deleteByExample(likeifExample);
		// delete blog
		int count = blogMapper.deleteByPrimaryKey(blogId);
		return count;
	}

	@Override
	public int saveBlogAndReturnId(Blog blog) {
		return blogMapper.saveBlogAndReturnId(blog);
	}

	@Override
	public List<Blog> findPictureListByTitle(String title) {
		return blogPictureMapper.findPictureListByTitle(title);
	}

	@Override
	public List<Blog> findBlogListByTitle(String title, String type) {
		return blogPictureMapper.findBlogListByTitle(title, type);
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

	@Override
	public List<Blog> findVideoListByTitle(String content) {
		return videoMapper.findVideoListByTitle(content);
	}

	@Override
	public List<User> findArticleListByUserAndTitle(String content) {
		return articleMapper.findArticleListByUserAndTitle(content);
	}

	@Override
	public List<Blog> findPictureListByTag(String content) {
		return blogPictureMapper.findPictureListByTag(content);
	}

}
