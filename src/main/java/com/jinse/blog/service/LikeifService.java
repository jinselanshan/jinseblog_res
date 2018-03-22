package com.jinse.blog.service;

import com.jinse.blog.pojo.Likeif;

public interface LikeifService {

	int findLikeifByBlogIdAndUserId(Likeif likeif);

	int saveLikeif(Likeif likeif);

	int deleteLikeif(Likeif likeif);

}
