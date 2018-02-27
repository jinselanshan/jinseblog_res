package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Province;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserAndInfor;

public interface ProvinceService {

	List<Province> findAddressByParentIdAndMyColums(String parentId, String myColums);

	Province findProIdList(String cityId);

	String findCityNameById(String id);

	String setCityById(User user, UserAndInfor userAndInfor);

	String setCityByUserId(User user);

}
