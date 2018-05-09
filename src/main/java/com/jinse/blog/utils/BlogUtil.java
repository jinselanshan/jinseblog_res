package com.jinse.blog.utils;

import java.util.ArrayList;
import java.util.List;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogAndLike;
import com.jinse.blog.vos.BlogVO;

public class BlogUtil {

	public static BlogAndLike blogToBlogAndLike(Blog blog) {
		BlogAndLike blogAndLike = new BlogAndLike();
		blogAndLike.setBlogId(blog.getBlogId());
		blogAndLike.setCommentNumber(blog.getCommentNumber());
		blogAndLike.setCreateAt(blog.getCreateAt());
		blogAndLike.setDeleted(blog.getDeleted());
		blogAndLike.setDescription(blog.getDescription());
		blogAndLike.setLikeNumber(blog.getLikeNumber());
		blogAndLike.setPicture(blog.getPicture());
		blogAndLike.setScore(blog.getScore());
		blogAndLike.setTag(blog.getTag());
		blogAndLike.setTagList(blog.getTagList());
		blogAndLike.setTitle(blog.getTitle());
		blogAndLike.setUser(blog.getUser());
		blogAndLike.setUserId(blog.getUserId());
		return blogAndLike;
	}

	public static BlogVO initBlogVO(Integer userId, String type, String title, String tag) {
		BlogVO blogVO = new BlogVO();
		if (type != null) {
			blogVO.setType(type);
		}

		if (userId != null) {
			blogVO.setUserId(userId);
		}

		blogVO.setStart(0);
		blogVO.setLength(9);
		if (title == null) {
			title = "";
		}
		if (tag != null) {
			blogVO.setTag(tag);
		}
		blogVO.setTitle(title);
		blogVO.setOwnerId(null);
		return blogVO;
	}

}
