package com.jinse.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinse.blog.pojo.TagType;
import com.jinse.blog.service.TagTypeService;

@Controller
public class TagTypeController {
	private static final Logger logger = LoggerFactory.getLogger(TagTypeController.class);
	@Autowired
	private TagTypeService tagTypeService;

	@RequestMapping(value = "/indexTag")
	public String indexTag(Model model, HttpServletRequest request) {
		logger.info("进入标签列表页面");
		List<TagType> tagTypeList = tagTypeService.findTableTagTypeList();
		model.addAttribute("tagTypeList",tagTypeList);
		return "tag/indexTag";
	}

}
