package com.jinse.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogAndLike;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.PictureService;
import com.jinse.blog.utils.BlogUtil;
import com.jinse.blog.utils.SpringUtil;
import com.jinse.blog.vos.BlogVO;

@Controller
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;
	@Autowired
	private PictureService pictureService;
	

	@RequestMapping(value = "/transaction/allpicture")
	public String findIndex(Model model, HttpServletRequest request) throws Exception {
		logger.info("进入交易界面");
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		List<Blog> blogList = blogService.findBuyPhotoListByUserId(userId);
		model.addAttribute("blogList",blogList);
		return "buy/allpicture";
	}
	
	@RequestMapping(value = "/picture/updatePrice", method = RequestMethod.POST)
	@ResponseBody
	public Integer updatePrice(Model model, HttpServletRequest request, Picture picture) {
		logger.info("修改图片价格");
		int count = pictureService.updatePicturePriceById(picture);
		return count == 1 ? 1 : 0;
	}
	
	@RequestMapping(value = "/picture/ifcanBuy", method = RequestMethod.POST)
	@ResponseBody
	public Blog ifcanBuy(Model model, HttpServletRequest request,@RequestParam Integer blogId) {
		logger.info("修改图片价格");
		Blog blog = pictureService.findPictureIfCanBuyByBlogId(blogId);
		if(blog == null) {
			return blog;
		}
		return blog;
	}
	
	
	//跳转到购买界面
	@RequestMapping(value = "/user/buyPicture/{blogId}")
	public String photoInfor(@PathVariable("blogId") Integer blogId, Model model, HttpServletRequest request)
			throws Exception {
		logger.info("跳转到购买界面");
		Blog blog = blogService.findBlogByBlogId(blogId);

		model.addAttribute("blog",blog);
		
		 return "alipay/alipayindex";
	}
}