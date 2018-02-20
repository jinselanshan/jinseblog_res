package com.jinse.blog.mapper;

import java.util.List;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserQueryVo;

public interface BlogPictureMapper {

	int updateByPictureId(Picture picture);

	int insertPicture(Picture picture);

	int insertBlog(Blog blog);

	User findAllPictureByUserId(Integer userid);

	Blog findBlogAndPictureByBlogId(Integer blogId);

	int commentNumberAdd(Blog blog);

	int commentNumberMinus(Blog blog);

	List<Blog> findPhotoListByUserId(Integer userId);
  
}