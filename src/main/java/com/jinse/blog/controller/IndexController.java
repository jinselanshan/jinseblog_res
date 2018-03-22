package com.jinse.blog.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinse.blog.pojo.Tag;
import com.jinse.blog.service.TagService;
import com.jinse.blog.utils.SpringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private TagService tagService;
	
    @RequestMapping("/home")
    public String home(Model model) {
      
        return "aa";
    }

    @RequestMapping("/indexPicture")
    public String bb(Model model) {
        return "photo";
    }

    @RequestMapping("/uploadPhotoIndex")
    public String uploadPhoto(Model model) {
    	logger.info("进入上传照片界面");
    	Integer userId = SpringUtil.getCurrentUser().getUserId();
    	List<Tag> tagList = tagService.findTagListByUserIdAndType(userId,"1");
    	model.addAttribute("tagList", tagList);
    	model.addAttribute("type", "1");
        return "upload/picture";
    }
    @RequestMapping("/uploadPaintingIndex")
    public String uploadPainting(Model model) {
    	logger.info("进入上传绘画界面");
     	Integer userId = SpringUtil.getCurrentUser().getUserId();
    	List<Tag> tagList = tagService.findTagListByUserIdAndType(userId,"2");
    	model.addAttribute("tagList", tagList);
    	model.addAttribute("type", "2");
        return "upload/picture";
    }
    @RequestMapping("/uploadArticleIndex")
    public String uploadArticle(Model model) {
    	logger.info("进入上传文章界面");
        return "upload/article";
    }
    @RequestMapping("/uploadVideoIndex")
    public String uploadVedio(Model model) {
    	logger.info("进入上传视频界面");
        return "upload/video";
    }
}