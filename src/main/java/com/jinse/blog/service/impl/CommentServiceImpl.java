package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.CommentMapper;
import com.jinse.blog.pojo.Comment;
import com.jinse.blog.service.CommentService;

public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	
	@Override
	public int addComment(Comment comment) {
		return commentMapper.insertComment(comment);
	}


	@Override
	public List<Comment> findCommentByBlogId(Integer blogId) {
		return commentMapper.findCommentByBlogId(blogId);
	}


	@Override
	public int deleteCommentByCommentId(Integer commentId) {
		return commentMapper.deleteByPrimaryKey(commentId);
	}

}
