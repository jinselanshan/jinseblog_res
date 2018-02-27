package com.jinse.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.VideoMapper;
import com.jinse.blog.pojo.Video;
import com.jinse.blog.service.VideoService;

public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoMapper videoMapper;

	@Override
	public int saveVideoAndReturnId(Video video) {
		return videoMapper.saveVideoAndReturnId(video);
	}

	@Override
	public int updateUrlByVideoId(Video video) {
		return videoMapper.updateUrlByVideoId(video);
	}

}
