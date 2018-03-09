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
import com.jinse.blog.utils.HtmlUtil;
import com.jinse.blog.utils.InitBlog;
import com.jinse.blog.utils.SavePicture;
import com.jinse.blog.utils.SpringUtil;
import com.jinse.blog.utils.UserUtil;
import com.jinse.blog.vos.ArticleResultVO;

@Controller
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private TagService tagService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "article/blog/{blogId}")
	public String photoInfor(@PathVariable("blogId") Integer blogId, Model model, HttpServletRequest request, User user)
			throws Exception {
		logger.info("获取article详情页");
		//find blog and picture
		Blog blog = blogService.findBlogArticleByBlogId(blogId);
		
		List<Comment> commentList = commentService.findCommentByBlogId(blogId);
		model.addAttribute("commentList", commentList);
		model.addAttribute("blog", blog);
		model.addAttribute("user", blog.getUser());
		return "article/articleInfor";
	}
	@RequestMapping(value = "/indexArticle")
	public String indexArticle(Model model, HttpServletRequest request, String content,Integer blogId) throws Exception {

		List<Blog> blogList = articleService.findAllArticleList();
		
		for (int i = 0; i < blogList.size(); i++) {
			Article article = blogList.get(i).getArticle();
			String newContent = HtmlUtil.getContent(article.getContent(), 50, true);
			article.setContent(newContent);
		}
		
		model.addAttribute("blogList",blogList);
		return "article/indexArticle";
	}
	@RequestMapping(value = "/uploadArticle")
	public String uploadArticle(Model model, HttpServletRequest request, Blog blog, Article article) throws Exception {

		Integer userId = SpringUtil.getCurrentUser().getUserId();
		InitBlog.initBlog(blog, userId);
		Integer blogId = blog.getBlogId();
		if(blogId != null && blogId != 0){
			blogService.updateBlogByBlogId(blog);
		}else{
			blogService.saveBlogAndReturnId(blog);
			blogId = blog.getBlogId();
		}
		article.setBlogId(blogId);
	    articleService.saveArticle(article);
		return "redirect:indexArticle";
	}

	
	@RequestMapping(value = "/myArticle")
	public String myPhotoes(Model model, HttpServletRequest request, User user) throws Exception {
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		user = articleService.findAllArticleByUserId(userId);

		for (int i = 0; i < user.getBlogList().size(); i++) {
			Article article = user.getBlogList().get(i).getArticle();
			String newContent = HtmlUtil.getContent(article.getContent(), 50, true);
			article.setContent(newContent);
		}
		model.addAttribute("user", user);
		SpringUtil.setSession(ConstantsUtil.STRING_CURRENT_USER, user);
		return "home/articlepage";
	}
	
	
	
	
	
 	@RequestMapping(value = "/article/uploadPicture", method = RequestMethod.POST)
	@ResponseBody
	public ArticleResultVO uploadPicture(Model model, HttpServletRequest request,Blog blog, Integer blogId,
			@RequestParam(value = "editormd-image-file", required = false) MultipartFile pictureFile) throws Exception {
		logger.info("add图片开始" + pictureFile);
		ArticleResultVO articleResultVO = new ArticleResultVO();
	
		try {
			if(blogId != null && blogId != 0) {
				blog = blogService.findBlogByBlogId(blogId);
			}
			else {
				InitBlog.initBlog(blog, SpringUtil.getCurrentUser().getUserId());
				blogService.saveBlog(blog);
				blogId = blog.getBlogId();
				System.out.println(blogId);
			}
			
			// 保存picture
			Picture picture = new Picture();
			picture.setBlogId(blogId);
			pictureService.savePicture(picture);

			// 上传到七牛云
			SavePicture.savaPic(picture, pictureFile);
			// 更新url
			int count = pictureService.updateUrlByPictureId(picture);
			if(count == 1) {
				articleResultVO.setUrl(picture.getUrl());
				articleResultVO.setSuccess(1);
				articleResultVO.setMessage("上传图片成功");
				articleResultVO.setBlogId(blogId);
			}
		} catch (Exception e) {
			articleResultVO.setSuccess(0);
			articleResultVO.setMessage("上传图片失败");
		}
		return articleResultVO;
	}
	
	/*
	@RequestMapping(value = "/uploadArticle")
	public String uploadArticle(Model model, HttpServletRequest request, String content,Integer blogId) throws Exception {

		Article article = new Article();
		article.setBlogId(blogId);
		article.setContent(content);
		articleService.saveArticle(article);
		
		return "redirect:indexArticle";
	}*/
	

	

}