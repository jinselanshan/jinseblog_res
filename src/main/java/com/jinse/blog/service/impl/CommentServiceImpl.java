package com.jinse.blog.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.controller.FollowerController;
import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.mapper.CommentMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogAndLike;
import com.jinse.blog.pojo.Comment;
import com.jinse.blog.pojo.CommentAndDe;
import com.jinse.blog.pojo.Likeif;
import com.jinse.blog.service.CommentService;
import com.jinse.blog.utils.SpringUtil;

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
	public List<CommentAndDe> findCommentByBlogId(Integer blogId) {
		List<Comment> commentList = commentMapper.findCommentByBlogId(blogId);
		
		List<CommentAndDe> commentAndDeList = new ArrayList<CommentAndDe>();
		
		if (commentList != null && commentList.size() > 0) {
			for (Comment comment : commentList) {
				CommentAndDe commentAndDe = new CommentAndDe();
				try {
					BeanUtils.copyProperties(commentAndDe, comment);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				Blog blog = blogPictureMapper.findBlogAndPictureByBlogId(blogId);
				//博客作者
				Integer blogUserId = blog.getUserId();
				//评论作者
				Integer commentUserId = comment.getUserId();
				Integer currentUserId =  SpringUtil.getCurrentUser().getUserId();
				if(commentUserId == currentUserId || blogUserId == currentUserId) {
					commentAndDe.setDeleteIf(1);
				}
				commentAndDeList.add(commentAndDe);
			}
		}
		return commentAndDeList;
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


	@Override
	public Comment findCommentByCommentId(Integer commentId) {
		return commentMapper.findCommentByCommentId(commentId);
	}

}
