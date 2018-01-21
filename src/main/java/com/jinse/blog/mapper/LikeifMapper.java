package com.jinse.blog.mapper;

import com.jinse.blog.pojo.Likeif;
import com.jinse.blog.pojo.LikeifExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikeifMapper {
    int countByExample(LikeifExample example);

    int deleteByExample(LikeifExample example);

    int deleteByPrimaryKey(Integer likeifId);

    int insert(Likeif record);

    int insertSelective(Likeif record);

    List<Likeif> selectByExample(LikeifExample example);

    Likeif selectByPrimaryKey(Integer likeifId);

    int updateByExampleSelective(@Param("record") Likeif record, @Param("example") LikeifExample example);

    int updateByExample(@Param("record") Likeif record, @Param("example") LikeifExample example);

    int updateByPrimaryKeySelective(Likeif record);

    int updateByPrimaryKey(Likeif record);
}