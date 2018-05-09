package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Comment;
import com.jinse.blog.pojo.CommentAndDe;

public interface CommentService {

	int addComment(Comment comment);

	List<CommentAndDe> findCommentByBlogId(Integer blogId);

	int deleteCommentByCommentId(Comment comment);

	Comment findCommentByCommentId(Integer commentId);

}
