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
	@Autowired
	private LikeifService likeifService;
	@Autowired
	private ProvinceService provinceService;
	
	@RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
	public String uploadPicture(Model model, HttpServletRequest request, Blog blog,String type,
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
		picture.setType(type);
		pictureService.savePicture(picture);

		// 上传到七牛云
		SavePicture.savaPic(picture, pictureFile);
		// 更新url
		pictureService.updateUrlByPictureId(picture);
		return "redirect:indexPhoto/" + type;
	}

	@RequestMapping(value = "/indexPhoto/{type}")
	public String indexPhoto(Model model, HttpServletRequest request, Blog blog,@PathVariable("type") String type) throws Exception {
		logger.info("关注列表");
		Integer userId = SpringUtil.getCurrentUser().getUserId();

		type = type.equals("photo") ? "1":"2";
		//发现我关注的摄影blog列表
		List<Blog> blogList = blogService.findPhotoListByUserId(userId,type);

		List<BlogAndLike> blogAndLikeList = new ArrayList<BlogAndLike>();
		if(blogList != null && blogList.size() > 0 ) {
			for (Blog blogres : blogList) {
				BlogAndLike blogAndLike = BlogUtil.blogToBlogAndLike(blogres);
				Likeif likeif = new Likeif();
				likeif.setBlogId(blogres.getBlogId());
				likeif.setUserId(userId);
				int count = likeifService.findLikeifByBlogIdAndUserId(likeif);
				blogAndLike.setLikeif(count);
				blogAndLikeList.add(blogAndLike);
			}
		}
		model.addAttribute("blogList", blogAndLikeList);
		if(type.equals("1")) {
			return "photo/indexPhoto";
		}
		return "photo/indexPhoto";
		
	}

	// 主页
	@RequestMapping(value = "/myPhotoes")
	public String myPhotoes(Model model, HttpServletRequest request, User user) throws Exception {
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		user = pictureService.findAllPictureByUserId(userId);
		
		model.addAttribute("user", user);
		SpringUtil.setSession(ConstantsUtil.STRING_CURRENT_USER, user);
		return "home/userpage";
	}
	
	//其他人主页
	@RequestMapping(value = "/otherPhotoes/{userId}")
	public String otherPhotoes(@PathVariable("userId") Integer userId, Model model, HttpServletRequest request, User user) throws Exception {
		user = pictureService.findAllPictureByUserId(userId);

		model.addAttribute("user", user);
		return "home/userpage";
	}

	// 
	@RequestMapping(value = "/blog/{blogId}")
	public String photoInfor(@PathVariable("blogId") Integer blogId, Model model, HttpServletRequest request, User user)
			throws Exception {
		logger.info("获取详情页");
		//find blog and picture
		Blog blog = blogService.findBlogByBlogId(blogId);
		
		BlogAndLike blogAndLike = BlogUtil.blogToBlogAndLike(blog);
		Likeif likeif = new Likeif();
		likeif.setBlogId(blog.getBlogId());
		likeif.setUserId(blog.getUserId());
		int count = likeifService.findLikeifByBlogIdAndUserId(likeif);
		blogAndLike.setLikeif(count);
		
		List<Comment> commentList = commentService.findCommentByBlogId(blogId);
		model.addAttribute("commentList", commentList);
		model.addAttribute("blog", blogAndLike);
		model.addAttribute("user", blog.getUser());
		return "photo/photoInfor";
	}

	@RequestMapping(value = "/user/deleteBlog/{blogId}")
	public String photoInfor(@PathVariable("blogId") Integer blogId, Model model, HttpServletRequest request, Blog blog) throws Exception {
		logger.info("删除blog");
		//delete picture then delete blog
		if(blogId != null) {
			blog.setBlogId(blogId);
			int count = blogService.deleteBlogByBlogId(blog);
			if(count == 1) {
				logger.info("删除成功");
			}
		}
		return "redirect:/myPhotoes";
	}
}