package com.jinse.blog.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.jinse.blog.controller.IndexController;
import com.jinse.blog.pojo.Picture;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class SavePicture {
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	private static final String ACCESS_KEY = "nTSLsMLfwOyWd2kS52WpeUXvAD6roFzsmKFCb_JA";
	private static final String SECRET_KEY = "5Z1Hn4nqC8ELDit0RZz7vqLGC9nxBlKOKgGSsGZy";

	// 要上传的空间
	private static final String bucketname = "jinselanshan/image/jpg/"; // 对应要上传到七牛上 的那个路径（自己建文件夹 注意设置公开）
	// 密钥配置
	private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	// 构造一个带指定Zone对象的配置类
	private static final Configuration cfg = new Configuration(Zone.zone0());
	// 创建上传对象
	private static final UploadManager uploadManager = new UploadManager(cfg);

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public static String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	public static Picture savaPic(Picture picture, MultipartFile pictureFile) {
		if (picture != null) {
			try {
				// 上传到七牛后保存的文件名
				String key = "image/jpg/photo/" + picture.getPictureId();
				Response res = uploadManager.put(pictureFile.getInputStream(), key, getUpToken(), null, null);
				// 打印返回的信息
				System.out.println(res.bodyString());
				DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
				System.out.println(putRet.key);
				picture.setUrl("http://p1vkce34m.bkt.clouddn.com/" + putRet.key);
			} catch (QiniuException e) {
				Response r = e.response;
				// 请求失败时打印的异常的信息
				System.out.println(r.toString());
				try {
					// 响应的文本信息
					System.out.println(r.bodyString());
				} catch (QiniuException e1) {
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return picture;
	}
}
