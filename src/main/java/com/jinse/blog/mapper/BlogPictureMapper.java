package com.jinse.blog.mapper;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;

public interface BlogPictureMapper {

	int updateByPictureId(Picture picture);

	int insertPicture(Picture picture);

	int insertBlog(Blog blog);
  
}