package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Tag;

public interface TagService {

	Tag findTagByTagName(String tagName);

	int addTagAndReturnId(Tag tag);

	List<Tag> findTagListByCount(String type);

	Tag findTagByTagId(Integer tagId);

	List<Tag> findTagListByUserIdAndType(Integer userId, String type);


}
