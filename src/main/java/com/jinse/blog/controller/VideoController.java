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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Video;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.VideoService;
import com.jinse.blog.utils.SavePicture;
import com.jinse.blog.utils.SpringUtil;

@Controller
public class VideoController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private BlogService blogService;
	@Autowired
	private VideoService videoService;

	@RequestMapping(value = "/uploadVedioUrl", method = RequestMethod.POST)
	@ResponseBody
	public Integer uploadPicture(Model model, HttpServletRequest request,
			@RequestParam("file-video") MultipartFile videoFile) throws Exception {
		logger.info("add视频开始" + videoFile);
		Blog blog = new Blog();

		blog.setUserId(SpringUtil.getCurrentUser().getUserId());
		blogService.saveBlogAndReturnId(blog);
		int blogId = blog.getBlogId();
		logger.info("blogId为" + blogId);
		
		

		// 保存vedio
		Video video = new Video();
		video.setBlogId(blogId);
		video.setPass("N");
		videoService.saveVideoAndReturnId(video);

		// 上传到七牛一年
		SavePicture.savaVideo(video, videoFile);
		// 更新url
		int count = videoService.updateUrlByVideoId(video);
		return count == 1 ? 1 : null;
	}

	
}