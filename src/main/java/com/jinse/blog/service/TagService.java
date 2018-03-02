package com.jinse.blog.service;

import com.jinse.blog.pojo.Tag;

public interface TagService {

	Tag findTagByTagName(String tagName);

	int addTagAndReturnId(Tag tag);


}
