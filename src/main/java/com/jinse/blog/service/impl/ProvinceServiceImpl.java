package com.jinse.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.mapper.ProvinceMapper;
import com.jinse.blog.pojo.Province;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserAndInfor;
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

	@Override
	public String findCityNameById(String id) {
		return provinceMapper.selectCityNameById(id);
	}

	@Override
	public String setCityById(User user, UserAndInfor userAndInfor) {
		String provinceName = provinceMapper.selectCityNameById(user.getProvinceId());
		String cityName = provinceMapper.selectCityNameById(user.getCityId());
		String villageName = provinceMapper.selectCityNameById(user.getVillageId());
		String city = provinceName + "-" + cityName + "-" + villageName;
		userAndInfor.setCity(city);
		return "success";
	}
	
	@Override
	public String setCityByUserId(User user) {
		String provinceName = "";
		String cityName = "";
		String villageName = "";
		if(user.getProvinceId() != null) {
			provinceName = provinceMapper.selectCityNameById(user.getProvinceId());
		}
		if(user.getCityId() != null) {
			cityName = provinceMapper.selectCityNameById(user.getCityId());

		}
		if(user.getVillageId() != null) {
			villageName = provinceMapper.selectCityNameById(user.getVillageId());
		}
		cityName = (cityName.length() == 0) ? "": ("-" + cityName);
		villageName = (villageName.length() == 0) ? "": ("-" + villageName);
		String city = provinceName + cityName + villageName;
		user.setCity(city);
		return "success";
	}

}
