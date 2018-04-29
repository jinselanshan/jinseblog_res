package com.jinse.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jinse.blog.pojo.Article;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogAndLike;
import com.jinse.blog.pojo.BlogTag;
import com.jinse.blog.pojo.Comment;
import com.jinse.blog.pojo.Likeif;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.Tag;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserAndInfor;
import com.jinse.blog.pojo.UserClasses;
import com.jinse.blog.service.ArticleService;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.BlogTagService;
import com.jinse.blog.service.CommentService;
import com.jinse.blog.service.LikeifService;
import com.jinse.blog.service.PictureService;
import com.jinse.blog.service.ProvinceService;
import com.jinse.blog.service.TagService;
import com.jinse.blog.service.UserService;
import com.jinse.blog.utils.BlogUtil;
import com.jinse.blog.utils.ConstantsUtil;
import com.jinse.blog.utils.InitBlog;
import com.jinse.blog.utils.SavePicture;
import com.jinse.blog.utils.SpringUtil;
import com.jinse.blog.utils.UserUtil;
import com.jinse.blog.vos.UserResultVO;

@Controller
public class BlogController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView findIndex(@RequestParam("selectType") String selectType,
			@RequestParam("content") String content, Model model, HttpServletRequest request) throws Exception {
		logger.info("进入搜索");
		ModelAndView modelAndView = new ModelAndView();

		List<Blog> blogList = new ArrayList<Blog>();
		if (content != null && content.length() > 0) {
			content = new String(content.getBytes("iso-8859-1"), "utf-8");
		}

		if (selectType != null && !selectType.equals("")) {
			modelAndView.addObject("selectType", selectType);
			switch (selectType) {
			case "photo":
				blogList = blogService.findBlogListByTitle(content, "1");
				modelAndView.setViewName("search/photolist");
				break;
			case "painting":
				blogList = blogService.findBlogListByTitle(content, "2");
				modelAndView.setViewName("search/photolist");
				break;
			case "video":
				blogList = blogService.findVideoListByTitle(content);
				modelAndView.setViewName("search/articlelist");
				break;
			case "article":
				// blogList = blogService.findArticleListByTitle(content);
				List<User> userAndArticleList = blogService.findArticleListByUserAndTitle(content);
				modelAndView.addObject("userList", userAndArticleList);
				modelAndView.setViewName("search/articlelist");
				return modelAndView;
			case "username":
				List<UserClasses> userList = userService.findUserListByUsername(content);
				modelAndView.addObject("userList", userList);
				modelAndView.setViewName("search/userlist");
				return modelAndView;
			case "tag":
				blogList = blogService.findPictureListByTag(content);
				modelAndView.setViewName("search/photolist");
				break;
			}
		}
		if (blogList != null) {
			modelAndView.addObject("blogList", blogList);
		}

		return modelAndView;
	}

	/*
	 * if (selectType.equals("photo")) { blogList =
	 * blogService.findBlogListByTitle(content, "1");
	 * modelAndView.setViewName("search/photolist");
	 * 
	 * } else if (selectType.equals("painting")) { blogList =
	 * blogService.findBlogListByTitle(content, "2");
	 * modelAndView.setViewName("search/photolist"); } else if
	 * (selectType.equals("video")) { blogList =
	 * blogService.findVideoListByTitle(content);
	 * modelAndView.setViewName("search/articlelist"); }
	 * 
	 * else if (selectType.equals("article")) { // blogList =
	 * blogService.findArticleListByTitle(content); List<User> userList =
	 * blogService.findArticleListByUserAndTitle(content);
	 * modelAndView.addObject("userList", userList);
	 * modelAndView.setViewName("search/articlelist"); return modelAndView;
	 * 
	 * } else if (selectType.equals("username")) { List<UserClasses> userList =
	 * userService.findUserListByUsername(content);
	 * modelAndView.addObject("userList", userList);
	 * modelAndView.setViewName("search/userlist"); return modelAndView;
	 * 
	 * } else if(selectType.equals("tag")){
	 * 
	 * } else { modelAndView.setViewName("photo/photoInfor"); }
	 */
}