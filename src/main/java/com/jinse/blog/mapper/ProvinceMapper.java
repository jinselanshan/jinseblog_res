package com.jinse.blog.mapper;

import com.jinse.blog.pojo.Province;
import com.jinse.blog.pojo.ProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvinceMapper {
    int countByExample(ProvinceExample example);

    int deleteByExample(ProvinceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectByExample(ProvinceExample example);

    Province selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByExample(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

	List<Province> findAddressByParentIdAndMyColums(Province province);

	Province selectProIdList(String cityId);

	String selectCityNameById(String id);

}