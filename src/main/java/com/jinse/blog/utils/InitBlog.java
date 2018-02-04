package com.jinse.blog.utils;

import java.util.Date;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;

public class InitBlog {
	public static Picture initPicture(Picture picture) {
		if (picture != null) {

		}
		return picture;
	}

	public static Blog initBlog(Blog blog, Integer userId) {
		if (blog != null) {
			blog.setUserId(userId);
			blog.setCreateAt(new Date());
			blog.setScore(0.0);
			blog.setHot(0);
			blog.setLikeNumber(0);
			blog.setDeleted("N");
		}
		return blog;
	}
}
