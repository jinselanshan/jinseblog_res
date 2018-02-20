package com.jinse.blog.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.controller.FollowerController;
import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.mapper.CommentMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Comment;
import com.jinse.blog.service.CommentService;

public class CommentServiceImpl implements CommentService {
	private static final Logger logger = LoggerFactory.getLogger(FollowerController.class);

	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private BlogPictureMapper blogPictureMapper;
	
	@Override
	public int addComment(Comment comment) {
		Blog blog = new Blog();
		blog.setBlogId(comment.getBlogId());
		int countBlog = blogPictureMapper.commentNumberAdd(blog);
		
		return commentMapper.insertComment(comment);
	}


	@Override
	public List<Comment> findCommentByBlogId(Integer blogId) {
		return commentMapper.findCommentByBlogId(blogId);
	}


	@Override
	public int deleteCommentByCommentId(Comment comment) {
		Integer commentId = comment.getCommentId();
		Blog blog = new Blog();
		blog.setBlogId(comment.getBlogId());
		int countBlog = blogPictureMapper.commentNumberMinus(blog);
		if(countBlog == 1) {
			logger.info("减少评论" + countBlog);
		}
		return commentMapper.deleteByPrimaryKey(commentId);
	}

}
