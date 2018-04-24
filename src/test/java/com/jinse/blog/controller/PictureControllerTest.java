package com.jinse.blog.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.pojo.User;
import com.jinse.blog.utils.SavePicture;


public class PictureControllerTest {

	@Autowired
	private BlogPictureMapper blogPictureMapper;

	@Test
	public void uploadPictureFromPath() {
		String filePathLocal = "C:\\Users\\Administrator\\Desktop\\Matteo Zanvettor";
		
	}
}