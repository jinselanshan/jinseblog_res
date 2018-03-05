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
	private UserService userService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private TagService tagService;
	@Autowired
	private BlogTagService blogTagService;
	@Autowired
	private ArticleService articleService;
	
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
	
	
	@RequestMapping(value = "/uploadArticle")
	public String uploadArticle(Model model, HttpServletRequest request, String content,Integer blogId) throws Exception {

		Article article = new Article();
		article.setBlogId(blogId);
		article.setContent(content);
		articleService.saveArticle(article);
		
		return "redirect:indexArticle";
	}
	
	@RequestMapping(value = "/indexArticle")
	public String indexArticle(Model model, HttpServletRequest request, String content,Integer blogId) throws Exception {

		List<Article> articleList = articleService.findAllArticle();
		
		model.addAttribute("articleList",articleList);
		return "article/indexArticle";
	}
	

}