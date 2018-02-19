package com.jinse.blog.controller;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinse.blog.mapper.BlogPictureMapper;
import com.jinse.blog.pojo.Picture;
import com.jinse.blog.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-dao.xml"})
public class PictureServiceTest {
	private SqlSessionFactory sqlSessionFactory;

	/*@Before
	public void setUp() throws Exception {
		String resource = "spring/applicationContext-dao.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFcatory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
*/
	@Autowired
	private BlogPictureMapper blogPictureMapper;

	@Test
	public void TestFindOrdersUserResultMap() {
	/*	SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		BlogPictureMapper oc = sqlSession.getMapper(BlogPictureMapper.class);
		// 调用mapper的方法
*/
		User user = blogPictureMapper.findAllPictureByUserId(100);
		System.out.println();	System.out.println();		System.out.println();
		System.out.println();
		System.out.println(user);

	}

	private static final Logger logger = LoggerFactory.getLogger(PictureServiceTest.class);
/*
	@Test
	public void update() {
		Picture picture = new Picture();
		picture.setPictureId(100);
		picture.setUrl("urk");
		blogPictureMapper.updateByPictureId(picture);
	}
*/
}
