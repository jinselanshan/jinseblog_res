package com.jinse.blog.mapper;

import com.jinse.blog.pojo.Blog;
import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.Video;
import com.jinse.blog.pojo.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer videoId);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	int saveVideoAndReturnId(Video video);

	int updateUrlByVideoId(Video video);

	List<Blog> findAllVideoList();

	List<Blog> findVideoListByTitle(String content);

	User findAllVideoByUserId(Integer userId);
}