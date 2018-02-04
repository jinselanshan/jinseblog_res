package com.jinse.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.PictureService;
import com.jinse.blog.service.UserService;
import com.jinse.blog.utils.InitBlog;
import com.jinse.blog.utils.SavePicture;


@Controller
public class PictureController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
	public String uploadPicture(Model model, HttpServletRequest request, Blog blog,
			@RequestParam("file-zh[]") MultipartFile pictureFile) throws Exception {
		logger.info("add图片开始" + pictureFile);
		System.out.println(blog);
		// 原始名称
		// String originalFilename = pic.getOriginalFilename();
		
		String username = (String) request.getSession().getAttribute("username");
		User user = userService.findUserByUsername(username);
		InitBlog.initBlog(blog,user.getUserId());

		blogService.saveBlog(blog);
		int blogId = blog.getBlogId();
		System.out.println(blogId);
		
		//保存picture
		Picture picture = blog.getPicture();
		picture.setBlogId(blogId);
		picture.setType("1");
		pictureService.savePicture(picture);

		//上传到七牛一年
		SavePicture.savaPic(picture, pictureFile);
		//更新url
		pictureService.updateUrlByPictureId(picture);
		return "redirect:/findPicture";
	}

	@RequestMapping(value = "/findPicture")
	public String findPicture(Model model, HttpServletRequest request, Blog blog) throws Exception {
		request.getSession().getAttribute("username");
		return "photo";
	}

}