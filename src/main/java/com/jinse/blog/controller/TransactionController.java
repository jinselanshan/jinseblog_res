package com.jinse.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jinse.blog.pojo.BlogAndLike;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.utils.BlogUtil;
import com.jinse.blog.utils.SpringUtil;
import com.jinse.blog.vos.BlogVO;

@Controller
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/transaction/allpicture")
	public String findIndex(Model model, HttpServletRequest request) throws Exception {
		logger.info("进入交易界面");
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		List<BlogAndLike> blogAndLikeList = blogService.findBuyPhotoListByUserId(userId);
		model.addAttribute("blogList",blogAndLikeList);
		return "buy/allpicture";
	}

}