package com.jinse.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinse.blog.pojo.Likeif;
import com.jinse.blog.service.LikeifService;
import com.jinse.blog.utils.SpringUtil;

@Controller
public class LikeifController {
	private static final Logger logger = LoggerFactory.getLogger(FollowerController.class);
	@Autowired
	private LikeifService likeifService;

	@RequestMapping(value = "/user/isLike", method = RequestMethod.POST)
	@ResponseBody
	public String isLike(Model model, HttpServletRequest request, Likeif likeif) {
		logger.info("judge is like");
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		likeif.setUserId(userId);
		int count = likeifService.findLikeifByBlogIdAndUserId(likeif);
		if(count == 1) {
			return "success";
		}
		return "dislike";
	}
	
	
	@RequestMapping(value = "/user/saveLike", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveLike(Model model, HttpServletRequest request, Likeif likeif) {
		logger.info("save like");
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		likeif.setUserId(userId);
		int count = likeifService.saveLikeif(likeif);
		return count == 1 ? 1 : null;

	}
	
	@RequestMapping(value = "/user/deleteLike", method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteLike(Model model, HttpServletRequest request, Likeif likeif) {
		logger.info("save like");
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		likeif.setUserId(userId);
		int count = likeifService.deleteLikeif(likeif);
		return count == 1 ? 1 : null;

	}
}
