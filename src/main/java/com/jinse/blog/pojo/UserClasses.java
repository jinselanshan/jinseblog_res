package com.jinse.blog.pojo;

import java.util.List;

public class UserClasses extends User{

	private Integer isfollowing;

	private List<Tag> tagList;
	
	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public Integer getIsfollowing() {
		return isfollowing;
	}

	public void setIsfollowing(Integer isfollowing) {
		this.isfollowing = isfollowing;
	}
	
	
}
