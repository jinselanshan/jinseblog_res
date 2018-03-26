package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.Video;

public interface VideoService {

	int saveVideoAndReturnId(Video video);

	int updateUrlByVideoId(Video video);

	List<Blog> findAllVideoList();

	User findAllVideoByUserId(Integer userId);

}
