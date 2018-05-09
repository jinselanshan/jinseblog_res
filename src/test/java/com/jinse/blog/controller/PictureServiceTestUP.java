package com.jinse.blog.controller;

import java.io.File;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.jsonpath.internal.function.text.Length;
import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.BlogTag;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.Tag;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UsersTag;
import com.jinse.blog.service.BlogTagService;
import com.jinse.blog.service.TagService;
import com.jinse.blog.service.UserService;
import com.jinse.blog.service.UsersTagService;
import com.jinse.blog.utils.SavePicture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext-dao.xml","classpath*:/spring/applicationContext-service.xml"})
public class PictureServiceTestUP {

	@Autowired
	private BlogPictureMapper blogPictureMapper;
	@Autowired
	private TagService tagService;
	@Autowired
	private BlogTagService blogTagService;
	@Autowired
	private UsersTagService usersTagService;
	@Autowired
	private UserService userService;

	@Test
	public void testLoadPicture() {
		// List<String> urlList =
		// readToString("C:\\Users\\Administrator\\Desktop\\Matteo Zanvettor");
		String pathName = "C:\\Users\\Administrator\\Desktop\\kieed @一日目東と23a";
		String userName = pathName.substring(pathName.lastIndexOf("\\") + 1);
		File dirFile = new File(pathName);
		String[] fileList = dirFile.list();
		User user = userService.findUserByUsername(userName);
		for (int i = 0; i < fileList.length; i++) {
			System.out.println(fileList[i]);
			Blog blog = new Blog();
			String title = userName.substring(0,3) + "00" + i;
			blog.setCreateAt(new Date());
			blog.setUserId(116);
			blog.setTitle(title);
			blog.setScore(0.0);
			blog.setLikeNumber(0);
			blog.setCommentNumber(0);
			blog.setDeleted("N");
			//blog.setTag("风光 山川 大河 尼康 佳能 河流 夜景 自然 旅行 旅游 雪 山峰 森林 草地 动物 自拍");
			String tagList = "星空 木之本桜 水鏡 海 漢服 砂の惑星 碧蓝航线 空中城市 纪念碑谷 美女と竜 背景 興趣使然的英雄 金髪 雪 2017 魔卡少女樱 帽子 黄昏 黒 女の子 初音ミク 風景 插畫 漫画 競泳水着 学校 鶯丸 夏目友人帳 直死の魔眼 落書き 落書き 落書き 美少年 創作 蝶々 宝石";

			//String tagList = "人像 蓝调 情绪 意境 欧洲 锐利 胶片 数码 尼康 佳能 俄罗斯 芬兰 蓝色 85mm 50mm 35mm 135mm 美女 性感 索尼 长焦 复古 创意 写真 后期 灯光 光影 生活 黑白";
			//String tagList = "风光 山川 大河 尼康 佳能 河流 夜景 自然 旅行 旅游 雪 山峰 森林 草地 动物 自拍 色彩 春天 动物 夜景 光影 花卉 静物 情绪 微距 后期 复古 创意 唯美 索尼 宾得 广角 野外 荒野 日落 星空 远景 风云 云朵 暴雨 狂风";
			String[] tagArray = tagList.split(" ");
			Set<String> setString = new HashSet<>();
			String finalTag = "";
			int Min = 5;
			int Max = 10;
			int lengthLong = Min + (int)(Math.random() * ((Max - Min) + 1));
			for(int j = 0 ; j < lengthLong ; j++) {
				int index= (int) (Math.random() * tagArray.length);
				if(!setString.contains(tagArray[index])) {
					setString.add(tagArray[index]);
					finalTag = finalTag + tagArray[index] + " ";
				}
			}
			String tag = finalTag.substring(0,finalTag.length() - 1);
			blog.setTag(tag);
			blog.setUserId(user.getUserId());
			blogPictureMapper.insertBlog(blog);
			Integer blogId = blog.getBlogId();
			insertTagMapper(tag,"1",blogId,user.getUserId());
			
			Picture picture = new Picture();
			picture.setType("1");
			picture.setBlogId(blogId);
			SavePicture.savaPicFromLocal(picture, pathName + "\\" + fileList[i],userName,fileList[i]);
			blogPictureMapper.insertPicture(picture);

		}

	}

	private void insertTagMapper(String tagStr, String type, int blogId, Integer userId) {
		if (tagStr != null && !tagStr.trim().equals("")) {
			String[] tagArray = tagStr.trim().split(" ");
			for (String tagName : tagArray) {
				Tag tag = tagService.findTagByTagName(tagName);
				if (tag == null) {
					tag = new Tag();
					tag.setTagName(tagName);
					tag.setType(type);
					tagService.addTagAndReturnId(tag);
				
				}
				// 无论是否有标签生成，将所有标签插入关系表
				Integer tagId = tag.getTagId();
				BlogTag blogTag = new BlogTag();
				blogTag.setBlogId(blogId);
				blogTag.setTagId(tagId);
				blogTagService.addBlogTag(blogTag);

				UsersTag usersTag = new UsersTag();
				usersTag.setTagId(tagId);
				usersTag.setUserId(userId);
			    usersTagService.addUsersTag(usersTag);

			}
		}
	}

}
