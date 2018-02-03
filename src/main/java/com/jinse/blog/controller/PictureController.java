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

import com.google.gson.Gson;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.service.BlogService;
import com.jinse.blog.service.PictureService;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

@Controller
public class PictureController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	private static final String ACCESS_KEY = "nTSLsMLfwOyWd2kS52WpeUXvAD6roFzsmKFCb_JA";

	private static final String SECRET_KEY = "5Z1Hn4nqC8ELDit0RZz7vqLGC9nxBlKOKgGSsGZy";
	// 要上传的空间
	private static final String bucketname = "jinselanshan/image/jpg/"; // 对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）
	// 密钥配置
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	//构造一个带指定Zone对象的配置类
	Configuration cfg = new Configuration(Zone.zone0());
	// 创建上传对象
	UploadManager uploadManager = new UploadManager(cfg);
	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	@Autowired
	private BlogService blogService;
	@Autowired
	private PictureService pictureService;

	@RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
	public String uploadPicture(Model model, HttpServletRequest request, Blog blog,
			@RequestParam("file-zh[]") MultipartFile pic) throws Exception {
		logger.info("add图片开始" + pic);
		System.out.println(blog);
		// 原始名称
		String originalFilename = pic.getOriginalFilename();
		Picture picture = blog.getPicture();
		int blogId = blogService.saveBlog(blog);
		System.out.println(blogId);
		picture.setBlogId(blogId);
		picture.setType("1");
		int pictureId = pictureService.savePicture(picture);
		picture.setBlogId(blog.getBlogId());
		
		if (picture != null && originalFilename != null && originalFilename.length() > 0) {
			try {
				// 上传到七牛后保存的文件名
				String key = "image/jpg/"+pictureId;
				// 上传文件的路径
				String FilePath = originalFilename;
				Response res = uploadManager.put(pic.getInputStream(), key, getUpToken(), null, null);
				// 打印返回的信息
				System.out.println(res.bodyString());
				DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
				System.out.println(putRet.key);
				picture.setUrl("http://p1vkce34m.bkt.clouddn.com/image/jpg/picture" + putRet.key);
			    picture.setPictureId(pictureId);
				pictureService.updateUrlByPictureId(picture);
				
			} catch (QiniuException e) {
				Response r = e.response;
				// 请求失败时打印的异常的信息
				System.out.println(r.toString());
				try {
					// 响应的文本信息
					System.out.println(r.bodyString());
				} catch (QiniuException e1) {
				}
			}
		}
		return "photo";
	}
}