package com.jinse.blog.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/home")
    public String home(Model model) {
      
        return "aa";
    }

    @RequestMapping("/indexPicture")
    public String bb(Model model) {
        return "photo";
    }

    @RequestMapping("/uploadPictureIndex")
    public String uploadPicture(Model model) {
    	logger.info("进入上传图片界面");
        return "upload/picture";
    }
}