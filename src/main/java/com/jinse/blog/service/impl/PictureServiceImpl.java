package com.jinse.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.mapper.PictureMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserQueryVo;
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
		return blogPictureMapper.insertPicture(picture);
	}

	@Override
	public int updateUrlByPictureId(Picture picture) {
		return blogPictureMapper.updateByPictureId(picture);
	}
	//找到某用户的所有图片
	@Override
	public User findAllPictureByUserId(Integer userid) {
		return blogPictureMapper.findAllPictureByUserId(userid);
	}

	//找到某用户的所有图片
	@Override
	public List<Blog> findAllPictureByUserIdAndType(Integer userId, String type) {
		return blogPictureMapper.findAllPictureByUserIdAndType(userId,type);
	}

	@Override
	public List<Blog> findAllLikePictureByUserId(Integer userId) {
		return blogPictureMapper.findAllLikePictureByUserId(userId);
	}
}
