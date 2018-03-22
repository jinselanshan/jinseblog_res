package com.jinse.blog.vos;

import java.util.List;

import com.jinse.blog.pojo.Tag;

public class TagType{
	private String type;
	
	private List<Tag> tagList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	
	
}
