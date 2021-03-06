package com.jinse.blog.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserQueryVo;

import com.jinse.blog.vos.BlogVO;

public interface BlogPictureMapper {

	int updateUrlByPictureId(Picture picture);

	int insertPicture(Picture picture);

	int insertBlog(Blog blog);

	User findAllPictureByUserId(Integer userid);

	Blog findBlogAndPictureByBlogId(Integer blogId);

	int commentNumberAdd(Blog blog);

	int commentNumberMinus(Blog blog);

	List<Blog> findPhotoListByUserIdAndType(BlogVO blogVO);

	List<Blog> findPhotoListByUserId(Integer userId);

	List<Blog> findPictureListByTitle(String content);

	List<Blog> findBlogListByTitle(@Param("title")String title, @Param("type")String type);
	
	List<Blog> findAllPictureByUserIdAndType(@Param("userId")Integer userId, @Param("type")String type);

	List<Blog> findAllLikePictureByUserId(Integer userId);

	List<Blog> findBuyPhotoListByUserId(Integer userId);

	int updatePicturePriceById(Picture picture);

	Blog findPictureIfCanBuyByBlogId(Integer blogId);

	List<Blog> findPictureListByTag(String tag);

  
}