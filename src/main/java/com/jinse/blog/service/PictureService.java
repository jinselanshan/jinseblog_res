package com.jinse.blog.service;

import com.jinse.blog.pojo.Picture;

public interface PictureService {

	void updatePicture(Picture picture);

	int savePicture(Picture picture);

	int updateUrlByPictureId(Picture picture);

}
