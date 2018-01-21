package com.jinse.blog.mapper;

import com.jinse.blog.pojo.Picture;

public interface BlogPictureMapper {

	int insertAndGetId(Picture picture);
    
}