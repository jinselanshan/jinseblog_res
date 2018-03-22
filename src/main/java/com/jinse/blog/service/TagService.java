package com.jinse.blog.service;

import java.util.List;

import com.jinse.blog.pojo.Tag;
import com.jinse.blog.vos.TagType;

public interface TagService {

	Tag findTagByTagName(String tagName);

	int addTagAndReturnId(Tag tag);

	List<Tag> findTagListByCount(String type);

	Tag findTagByTagId(Integer tagId);

	List<TagType> findTableTagList();


}
