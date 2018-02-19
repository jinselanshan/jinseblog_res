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

import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserFollowing;
import com.jinse.blog.service.FollowingService;
import com.jinse.blog.service.UserService;
import com.jinse.blog.utils.ConstantsUtil;
import com.jinse.blog.utils.SpringUtil;

@Controller
public class FollowingController {
	private static final Logger logger = LoggerFactory.getLogger(FollowingController.class);

	@Autowired
	private FollowingService followingService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/isFollowing", method = RequestMethod.POST)
	@ResponseBody
	public Integer isFollowing(Model model, HttpServletRequest request, UserFollowing userFollowing) {
		logger.info("judge is following");
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		userFollowing.setUserId(userId);
		// find 数据库 是否有记录
		int count = followingService.findFollowingByFollowingId(userFollowing);
		return count == 1 ? 1 : 0;

	}

	
	@RequestMapping(value = "/user/saveFollowing", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveFollowing(Model model, HttpServletRequest request, UserFollowing userFollowing) {
		logger.info("进行关注");
		int count = followingService.saveFollowing(userFollowing);
		User user = userService.findUserByUserId(userFollowing.getUserId());
		model.addAttribute("user",user);
		SpringUtil.setSession(ConstantsUtil.STRING_CURRENT_USER, user);
		return count == 1 ? 1 : null;
	}

	@RequestMapping(value = "/user/deleteFollowing", method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteFollowing(Model model, HttpServletRequest request, UserFollowing userFollowing) {
		logger.info("取消关注");
		int count = followingService.deleteFollowing(userFollowing);
		User user = userService.findUserByUserId(userFollowing.getUserId());
		model.addAttribute("user",user);
		SpringUtil.setSession(ConstantsUtil.STRING_CURRENT_USER, user);
		return count == 1 ? 1 : null;
	}

	/*
	 * public String findAllFollowing() { logger.info("获取关注数"); Integer userId = 0;
	 * 
	 * int countNumber = followingService.findAllFollowing(userId); return
	 * "success";
	 * 
	 * }
	 */
}
