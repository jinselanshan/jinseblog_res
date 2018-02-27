package com.jinse.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.BlogMapper;
import com.jinse.blog.mapper.LikeifMapper;
import com.jinse.blog.mapper.UserFollowingMapper;
import com.jinse.blog.pojo.Likeif;
import com.jinse.blog.service.LikeifService;

public class LikeifServiceImpl implements LikeifService {
	@Autowired
	LikeifMapper likeifMapper;
	
	@Autowired
	BlogMapper blogMapper;
	
	@Override
	public int findLikeifByBlogIdAndUserId(Likeif likeif) {
		return likeifMapper.findLikeifByBlogIdAndUserId(likeif);
	}

	@Override
	public int saveLikeif(Likeif likeif) {
		// TODO Auto-generated method stub
		blogMapper.addLikeNumberByBlogId(likeif.getBlogId());
		int count = likeifMapper.insert(likeif);
		return count;
	}
	
	@Override
	public int deleteLikeif(Likeif likeif) {
		// TODO Auto-generated method stub
		blogMapper.minusLikeNumberByBlogId(likeif.getBlogId());
		int count = likeifMapper.deleteLikeif(likeif);
		return count;
	}

}
