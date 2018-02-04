package com.jinse.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinse.blog.pojo.PhotoIn;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/homepage")
	public String homepage(Model model) throws Exception {
		return "home/homepage";
	}
	
	@RequestMapping("/signup")
	public String signupIndex(Model model) throws Exception {
		return "user/signup";
	}

	@RequestMapping("/signin")
	public String signinIndex(Model model) throws Exception {
		return "user/signin";
	}

	@RequestMapping(value = "/savaUser", method = RequestMethod.POST)
	public String savaUser(Model model, HttpServletRequest request, User user) throws Exception {
		logger.info("用户注册" + user);
		userService.save(user);
		return "user/signin";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(Model model, HttpServletRequest request, User user) throws Exception {
		List<User> userList = userService.findByUser(user);
		if (userList == null || userList.size() == 0) {
			return "user/signin";
		}
		request.getSession().setAttribute("username", user.getUsername());
		List<PhotoIn> photoInList = new ArrayList<PhotoIn>();
		PhotoIn photoIn1= new PhotoIn();
		PhotoIn photoIn2= new PhotoIn();
		PhotoIn photoIn3= new PhotoIn();
		
		User user1 = new User();
		user1.setEmail("1");
		User user2 = new User();
		user2.setEmail("2");
		User user3= new User();
		user3.setEmail("3");
		Picture picture1 = new Picture();
		picture1.setPrice(11);
		Picture picture2 = new Picture();
		picture2.setPrice(22);
		
		
		photoIn1.setUser(user1);
		photoIn1.setPicture(picture1);
		photoIn2.setUser(user2);
		photoIn2.setPicture(picture2);
		photoIn3.setUser(user3);
		photoInList.add(photoIn1);
		photoInList.add(photoIn2);
		photoInList.add(photoIn3);
		model.addAttribute("photoInList", photoInList);
		return "photo";
	}
}
