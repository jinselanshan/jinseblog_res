package com.jinse.blog.controller;

import java.io.File;

import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		String pathName = "C:\\Users\\Administrator\\Desktop\\Matteo Zanvettor";
		String userName = pathName.substring(pathName.lastIndexOf("\\") + 1);
		File dirFile = new File(pathName);
		String[] fileList = dirFile.list();
		User user = userService.findUserByUsername(userName);
		for (int i = 0; i < fileList.length; i++) {
			System.out.println(fileList[i]);
			Blog blog = new Blog();
			String title = "BST00" + i;
			blog.setCreateAt(new Date());
			blog.setUserId(116);
			blog.setTitle(title);
			blog.setScore(0.0);
			blog.setLikeNumber(0);
			blog.setCommentNumber(0);
			blog.setDeleted("N");
			blog.setTag("风光 山川 大河 尼康 佳能 河流 夜景 自然 旅行 旅游 雪 山峰 森林 草地 动物 自拍");
			
			blogPictureMapper.insertBlog(blog);
			Integer blogId = blog.getBlogId();
			insertTagMapper("风光 山川 大河 尼康 佳能 河流 夜景 自然 旅行 旅游 雪 山峰 森林 草地 动物 自拍","1",blogId,user.getUserId());
			
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
