package com.jinse.blog.mapper;

import com.jinse.blog.pojo.Avatar;
import com.jinse.blog.pojo.AvatarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AvatarMapper {
    int countByExample(AvatarExample example);

    int deleteByExample(AvatarExample example);

    int deleteByPrimaryKey(Integer avatarId);

    int insert(Avatar record);

    int insertSelective(Avatar record);

    List<Avatar> selectByExample(AvatarExample example);

    Avatar selectByPrimaryKey(Integer avatarId);

    int updateByExampleSelective(@Param("record") Avatar record, @Param("example") AvatarExample example);

    int updateByExample(@Param("record") Avatar record, @Param("example") AvatarExample example);

    int updateByPrimaryKeySelective(Avatar record);

    int updateByPrimaryKey(Avatar record);
}