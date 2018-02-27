package com.jinse.blog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.jinse.blog.controller.IndexController;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.Video;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

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

	public static Video savaVideo(Video video, MultipartFile videoFile) {

		if (video != null) {
			try {
				// 上传到七牛后保存的文件名
				String key = "origin/video/" + video.getBlogId();

				// 设置转码操作参数
				String fops = "avthumb/mp4/ab/128k/ar/44100/acodec/libfaac";
				// 设置转码的队列
				String pipeline = "video";
				// 可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
				String urlbase64 = UrlSafeBase64.encodeToString("jinselanshan/video/:video/mp4-" + video.getBlogId());
				String pfops = fops + "|saveas/" + urlbase64;
				
				String taken = auth.uploadToken("jinselanshan/video/", null, 3600,
						new StringMap().putNotEmpty("persistentOps", pfops).putNotEmpty("persistentPipeline", pipeline),
						true);

				Response res = uploadManager.put(videoFile.getInputStream(), key, taken, null, null);
				// 打印返回的信息
				System.out.println(res.bodyString());
				DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
				System.out.println(putRet.key);
				video.setUrl("http://p1vkce34m.bkt.clouddn.com/video/mp4-" + video.getBlogId());
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
		return video;
	}

	public static String savaAvatar(String outFilePath) {
		String avatarUrl = "http://p1vkce34m.bkt.clouddn.com/image/jpg/avatar/timg.jpg";
		try {
			File file = new File(outFilePath);
			InputStream inputStream = new FileInputStream(file);
			// 上传到七牛后保存的文件名
			String key = "image/jpg/avatar/" + String.valueOf(System.currentTimeMillis());
			Response res = uploadManager.put(inputStream, key, getUpToken(), null, null);
			/*
			 * // 上传到七牛后保存的文件名 String key = "image/jpg/avatar/" + avatar.getAvatarId();
			 * String token = getUpTokenOverride(key);//获取 token Response res =
			 * uploadManager.put(inputStream, key, token, null, null);
			 */
			// 打印返回的信息
			// System.out.println(res.bodyString());
			DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
			System.out.println(putRet.key);
			avatarUrl = "http://p1vkce34m.bkt.clouddn.com/" + putRet.key;
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
		return avatarUrl;
	}

	/**
	 * 覆盖上传 获取凭证
	 * 
	 * @param bucketName
	 *            空间名称
	 * @return
	 */
	public static String getUpTokenOverride(String key) {
		// insertOnly 如果希望只能上传指定key的文件，并且不允许修改，那么可以将下面的 insertOnly 属性值设为 1
		return auth.uploadToken(bucketname, key, 3600, new StringMap().put("insertOnly", 0));
	}
}
