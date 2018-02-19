package com.jinse.blog.service;

import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserQueryVo;

public interface PictureService {

	void updatePicture(Picture picture);

	int savePicture(Picture picture);

	int updateUrlByPictureId(Picture picture);

	User findAllPictureByUserId(Integer userid);

}
