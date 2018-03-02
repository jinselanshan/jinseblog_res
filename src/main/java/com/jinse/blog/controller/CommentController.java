package com.jinse.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinse.blog.pojo.Comment;
import com.jinse.blog.service.CommentService;
import com.jinse.blog.utils.SpringUtil;

@Controller()
@RequestMapping(value = "/blog")
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(FollowerController.class);

	@Autowired
	private CommentService commentService;

	// 主页
	@RequestMapping(value = "/addComment")
	@ResponseBody
	public Comment addComment(Model model, HttpServletRequest request, @RequestBody Comment comment) throws Exception {
		logger.info("add comment");

		Integer userId = SpringUtil.getCurrentUser().getUserId();
		comment.setUserId(userId);
		int count = commentService.addComment(comment);
		if (count != 1) {
			return null;
		}
		return comment;
	}
	@RequestMapping(value = "/deleteComment")
	@ResponseBody
	public Comment deleteComment(Model model, HttpServletRequest request, @RequestBody Comment comment) throws Exception {
		logger.info("add comment");
		
		
		int count = commentService.deleteCommentByCommentId(comment);
		if (count != 1) {
			return null;
		}
		Integer blogId = comment.getBlogId();
		List<Comment> commentList = commentService.findCommentByBlogId(blogId);
		model.addAttribute("commentList", commentList);
		return comment;
	}
}
