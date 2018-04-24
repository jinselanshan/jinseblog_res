package com.jinse.blog.service;

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
import com.jinse.blog.mapper.TagMapper;
import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-dao.xml" })
public class TagServiceTest {


	@Autowired
	private TagMapper tagMapper;
	

	@Test
	public void saveTag() {
	    List<String> tagList = new ArrayList<>();
		tagList.add("北京");
		tagList.add("广州");
		tagList.add("上海");
		tagList.add("重庆");
		tagList.add("成都");
		tagList.add("武汉");
		tagList.add("南京");
		tagList.add("杭州");
		tagList.add("深圳");
		tagList.add("云南");
		tagList.add("西安");
		tagList.add("日本");
		tagList.add("中国");
		
		tagList.add("青岛");
		tagList.add("厦门");
		tagList.add("四川");
		tagList.add("大连");
		tagList.add("西藏");
		tagList.add("新疆");
		
		tagList.add("吴哥");
		tagList.add("苏州");
		tagList.add("长沙");
		tagList.add("香港");
		tagList.add("郑州");
		
		for (int i = 0; i < tagList.size(); i++) {
			Tag tag = new Tag();
			tag.setTagName(tagList.get(i));
			tag.setTagTypeId(103);
			tag.setType("1");
			tagMapper.insert(tag);
		}
		
		
	}


}
