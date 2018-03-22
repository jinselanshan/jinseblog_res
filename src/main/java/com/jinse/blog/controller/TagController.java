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
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinse.blog.pojo.Likeif;
import com.jinse.blog.pojo.PhotoQuertVo;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.service.FollowingService;
import com.jinse.blog.service.LikeifService;
import com.jinse.blog.service.TagService;
import com.jinse.blog.service.UserService;
import com.jinse.blog.utils.SpringUtil;
import com.jinse.blog.vos.TagType;

@Controller
public class TagController {
	private static final Logger logger = LoggerFactory.getLogger(TagController.class);
	@Autowired
	private TagService tagService;

	@RequestMapping(value = "/tag/findTableTagList", method = RequestMethod.POST)
	public String findTableTagList(Model model, HttpServletRequest request) {
	
		List<TagType> tagTypeList = tagService.findTableTagList();
		return "tag/indexTag";
	}
	

}
