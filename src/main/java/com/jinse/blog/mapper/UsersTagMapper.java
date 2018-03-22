package com.jinse.blog.mapper;

import com.jinse.blog.pojo.UsersTag;
import com.jinse.blog.pojo.UsersTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersTagMapper {
    int countByExample(UsersTagExample example);

    int deleteByExample(UsersTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UsersTag record);

    int insertSelective(UsersTag record);

    List<UsersTag> selectByExample(UsersTagExample example);

    UsersTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UsersTag record, @Param("example") UsersTagExample example);

    int updateByExample(@Param("record") UsersTag record, @Param("example") UsersTagExample example);

    int updateByPrimaryKeySelective(UsersTag record);

    int updateByPrimaryKey(UsersTag record);

	List<UsersTag> findMaxTenUsersTagMapperByUserId(Integer userId);
}