package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserQueryVo;

public interface PictureService {

	void updatePicture(Picture picture);

	int savePicture(Picture picture);

	int updateUrlByPictureId(Picture picture);

	User findAllPictureByUserId(Integer userid);

	List<Blog> findAllPictureByUserIdAndType(Integer userId, String type);

	List<Blog> findAllLikePictureByUserId(Integer userId);

	int updatePicturePriceById(Picture picture);
	
	Blog findPictureIfCanBuyByBlogId(Integer blogId);

}
