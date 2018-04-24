package com.jinse.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinse.blog.service.TagService;


@Controller
public class TagController {
	private static final Logger logger = LoggerFactory.getLogger(TagController.class);
	@Autowired
	private TagService tagService;

	@RequestMapping(value = "/tag/findTableTagList", method = RequestMethod.POST)
	public String findTableTagList(Model model, HttpServletRequest request) {
	
		return "tag/indexTag";
	}

}
