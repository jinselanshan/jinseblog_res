package com.jinse.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.mapper.PictureMapper;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.service.PictureService;

public class PictureServiceImpl implements PictureService{
	@Autowired
	private BlogPictureMapper blogPictureMapper;
	@Autowired
	private PictureMapper pictureMapper;
	
	@Override
	public void updatePicture(Picture picture) {
		pictureMapper.updateByPrimaryKey(picture);
	}

	@Override
	public int savePicture(Picture picture) {
		return pictureMapper.insert(picture);
	}

	@Override
	public int updateUrlByPictureId(Picture picture) {
		return blogPictureMapper.updateByPictureId(picture);
	}
}
