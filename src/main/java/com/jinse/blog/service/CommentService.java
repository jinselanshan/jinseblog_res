package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Comment;

public interface CommentService {

	int addComment(Comment comment);

	List<Comment> findCommentByBlogId(Integer blogId);

	int deleteCommentByCommentId(Integer commentId);

}
