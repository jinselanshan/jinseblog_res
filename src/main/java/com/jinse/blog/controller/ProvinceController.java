package com.jinse.blog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinse.blog.pojo.Province;
import com.jinse.blog.service.ProvinceService;

@Controller
public class ProvinceController {
	private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);

	@Autowired
	private ProvinceService provinceService;

	@RequestMapping(value = "/home/getAddress", method = RequestMethod.POST)
	@ResponseBody
	public List<Province> findAddress(String parentId, String myColums) {
		logger.info("更新省市县");
		List<Province> provinceList = provinceService.findAddressByParentIdAndMyColums(parentId,myColums);
		if(provinceList == null || provinceList.size()==0) {
			return null;
		}
		return provinceList;
	}
}
