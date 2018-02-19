package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Province;

public interface ProvinceService {

	List<Province> findAddressByParentIdAndMyColums(String parentId, String myColums);

	Province findProIdList(String cityId);

}
