package com.jinse.blog.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.pojo.Picture;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class PictureServiceTest {
	
	@Autowired
	private BlogPictureMapper blogPictureMapper;

	private static final Logger logger = LoggerFactory.getLogger(PictureServiceTest.class);
	
	@Test
	public void update(){
		Picture picture = new Picture();
		picture.setPictureId(100);
		picture.setUrl("urk");
		blogPictureMapper.updateByPictureId(picture);
	}
	
}
