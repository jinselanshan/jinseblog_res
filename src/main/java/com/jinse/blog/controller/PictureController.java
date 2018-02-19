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
import org.springframework.web.multipart.MultipartFile;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogTag;
import com.jinse.blog.pojo.Comment;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.Tag;
import com.jinse.blog.pojo.User;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.BlogTagService;
import com.jinse.blog.service.CommentService;
import com.jinse.blog.service.PictureService;
import com.jinse.blog.service.TagService;
import com.jinse.blog.service.UserService;
import com.jinse.blog.utils.ConstantsUtil;
import com.jinse.blog.utils.InitBlog;
import com.jinse.blog.utils.SavePicture;
import com.jinse.blog.utils.SpringUtil;

@Controller
public class PictureController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;
	@Autowired
	private PictureService pictureService;
/*	@Autowired
	private UserService userService;*/
	@Autowired
	private CommentService commentService;
	@Autowired
	private TagService tagService;
	@Autowired
	private BlogTagService blogTagService;
	
	@RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
	public String uploadPicture(Model model, HttpServletRequest request, Blog blog,
			@RequestParam("file-zh[]") MultipartFile pictureFile,String tagStr) throws Exception {
		logger.info("add图片开始" + pictureFile);
		System.out.println(blog);
		// 原始名称
		// String originalFilename = pic.getOriginalFilename();

	/*	String username = (String) request.getSession().getAttribute("username");
		User user = userService.findUserByUsername(username);
		InitBlog.initBlog(blog, user.getUserId());
*/

		
		if(tagStr != null && !tagStr.trim().equals("")) {
			blog.setTag(tagStr);
		}
		InitBlog.initBlog(blog, SpringUtil.getCurrentUser().getUserId());
		blogService.saveBlog(blog);
		int blogId = blog.getBlogId();
		System.out.println(blogId);
		
		//处理tag
		if(tagStr != null && !tagStr.trim().equals("")) {
			String[] tagArray = tagStr.trim().split(" ");
			for (String tagName : tagArray) {
				Tag tag = tagService.findTagByTagName(tagName);
				if(tag == null) {
					tag = new Tag();
					tag.setTagName(tagName);
					int count = tagService.addTagAndReturnId(tag);
					logger.info("插入标签数" + count);
				}
				//无论是否有标签生成，将所有标签插入关系表
				Integer tagId = tag.getTagId();
				BlogTag blogTag = new BlogTag();
				blogTag.setBlogId(blogId);
				blogTag.setTagId(tagId);
				int count = blogTagService.addBlogTag(blogTag);
				logger.info("插入关系数" + count);
			}
		}

		// 保存picture
		Picture picture = blog.getPicture();
		picture.setBlogId(blogId);
		picture.setType("1");
		pictureService.savePicture(picture);

		// 上传到七牛一年
		SavePicture.savaPic(picture, pictureFile);
		// 更新url
		pictureService.updateUrlByPictureId(picture);
		return "redirect:findPicture";
	}

	@RequestMapping(value = "/findPicture")
	public String findPicture(Model model, HttpServletRequest request, Blog blog) throws Exception {

		return "photo";
	}

	// 主页
	@RequestMapping(value = "/myPhotoes")
	public String myPhotoes(Model model, HttpServletRequest request, User user) throws Exception {
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		user = pictureService.findAllPictureByUserId(userId);
		model.addAttribute("user", user);
		SpringUtil.setSession(ConstantsUtil.STRING_CURRENT_USER, user);
		return "home/homepage";
	}

	// 
	@RequestMapping(value = "/blog/{blogId}")
	public String photoInfor(@PathVariable("blogId") Integer blogId, Model model, HttpServletRequest request, User user)
			throws Exception {
		logger.info("获取详情页");
		//find blog and picture
		Blog blog = blogService.findBlogByBlogId(blogId);
		List<Comment> commentList = commentService.findCommentByBlogId(blogId);
		model.addAttribute("commentList", commentList);
		model.addAttribute("blog", blog);
		model.addAttribute("user", blog.getUser());
		return "photo/photoInfor";
	}

}