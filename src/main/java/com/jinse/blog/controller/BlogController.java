package com.jinse.blog.controller;

import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

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

@Controller
public class BlogController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;
	@Autowired
	private PictureService pictureService;
    @Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private TagService tagService;
	@Autowired
	private BlogTagService blogTagService;
	@Autowired
	private LikeifService likeifService;
	@Autowired
	private ProvinceService provinceService;
	


	// 
	@RequestMapping(value = "/search")
	public String findIndex(@RequestParam("selectType") String selectType,@RequestParam("content") String content, Model model, HttpServletRequest request)
			throws Exception {
		logger.info("进入搜索");
	
		if(selectType != null && content != null && !content.equals("")){
			if(selectType.equals("photo")){
				List<Blog> blogList = blogService.findBlogListByTitle(content,"1");
				model.addAttribute("blogList",blogList);
				return "search/photolist";
			}else if(selectType.equals("painting")){
				List<Blog> blogList = blogService.findBlogListByTitle(content,"2");
				model.addAttribute("blogList",blogList);
				return "search/paintinglist";
			}else if(selectType.equals("article")){
				List<Blog> blogList = blogService.findArticleListByTitle(content);
				model.addAttribute("blogList",blogList);
				return "search/articlelist";
			}else if(selectType.equals("video")){
				List<Blog> blogList = blogService.findBlogListByTitle(content,"4");
				model.addAttribute("blogList",blogList);
				return "search/articlelist";
			}else if(selectType.equals("username")){
				List<User> userList = userService.findUserListByUsername(content);
				model.addAttribute("userList",userList);
				return "search/userlist";
			}/*else if(selectType.equals("tag")){
				
			}*/
			
		}
	
		model.addAttribute("");
		return "photo/photoInfor";
	}


}