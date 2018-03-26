package com.jinse.blog.mapper;

import com.jinse.blog.pojo.TagType;
import com.jinse.blog.pojo.TagTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagTypeMapper {
    int countByExample(TagTypeExample example);

    int deleteByExample(TagTypeExample example);

    int deleteByPrimaryKey(Integer tagTypeId);

    int insert(TagType record);

    int insertSelective(TagType record);

    List<TagType> selectByExample(TagTypeExample example);

    TagType selectByPrimaryKey(Integer tagTypeId);

    int updateByExampleSelective(@Param("record") TagType record, @Param("example") TagTypeExample example);

    int updateByExample(@Param("record") TagType record, @Param("example") TagTypeExample example);

    int updateByPrimaryKeySelective(TagType record);

    int updateByPrimaryKey(TagType record);
}