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
	public int addPictureAndGetId(Picture picture) {
		int i = blogPictureMapper.insertAndGetId(picture);
		return i;
	}

	@Override
	public void updatePicture(Picture picture) {
		pictureMapper.updateByPrimaryKey(picture);
	}

	@Override
	public void addPicture(Picture picture) {
		// TODO Auto-generated method stub
		
	}


}
