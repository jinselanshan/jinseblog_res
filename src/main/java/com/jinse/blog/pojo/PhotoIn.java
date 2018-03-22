package com.jinse.blog.pojo;

import java.util.List;

public class PhotoIn {
	private User user;
	private Blog blog;
	private Picture picture;
	private List<Blog> blogList;
	private List<Picture> pictureList;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public List<Blog> getBlogList() {
		return blogList;
	}
	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}
	public List<Picture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}
	

}
