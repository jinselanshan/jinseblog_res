package com.jinse.blog.service;

import com.jinse.blog.pojo.Video;

public interface VideoService {

	int saveVideoAndReturnId(Video video);

	int updateUrlByVideoId(Video video);

}
