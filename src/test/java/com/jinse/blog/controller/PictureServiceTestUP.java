package com.jinse.blog.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.mapper.PictureMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-dao.xml" })
public class PictureServiceTestUP {


	@Autowired
	private BlogPictureMapper blogPictureMapper;
	@Autowired
	private PictureMapper pictureMapper;
	

	public List<String> readToString(String fileName) {
		List<String> urlList = new ArrayList<String>();
		File file = new File(fileName);
		try {
			FileReader in = new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	
                System.out.println(s);
                urlList.add(s);
            }
            br.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlList;
	}

	@Test
	public void testLoadPicture() {
		List<String> urlList = readToString("C:\\Users\\Administrator\\Desktop\\photo.201804105_2004803.txt");
		for (int i = 0; i < urlList.size(); i++) {
			
			
			Blog blog = new Blog();
			String title = "BST00" + i;
			blog.setCreateAt(new Date());
			blog.setUserId(116);
			blog.setTitle(title);
			int blogId = blogPictureMapper.insertBlog(blog);
			
			Picture picture = new Picture();
			picture.setType("1");
			picture.setUrl(urlList.get(i));
			picture.setBlogId(blog.getBlogId());
			blogPictureMapper.insertPicture(picture);
			
		}

	}

}
