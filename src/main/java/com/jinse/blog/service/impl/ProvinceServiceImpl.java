package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.ProvinceMapper;
import com.jinse.blog.pojo.Province;
import com.jinse.blog.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {


	@Autowired
	private ProvinceMapper provinceMapper;

	@Override
	public List<Province> findAddressByParentIdAndMyColums(String parentId, String myColums) {
		Province province= new Province();
		province.setParentId(parentId);
		province.setMyColums(myColums);
		return provinceMapper.findAddressByParentIdAndMyColums(province);
	}

	@Override
	public Province findProIdList(String cityId) {
		return provinceMapper.selectProIdList(cityId);
	}

}
