package com.jinse.blog.service;

import com.jinse.blog.pojo.Picture;

public interface PictureService {

	int addPictureAndGetId(Picture picture);

	void updatePicture(Picture picture);

	void addPicture(Picture picture);

}
