package com.jinse.blog.pojo;

import java.util.Date;

public class Blog {
    private Integer blogId;

    private String title;

    private String description;

    private String tag;

    private Double score;

    private Integer likeNumber;

    private String url;

    private Integer userId;

    private Date createat;

    private Integer hot;

    private String deleted;

    private Picture picture;
    
    public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", title=" + title + ", description=" + description + ", tag=" + tag
				+ ", score=" + score + ", likeNumber=" + likeNumber + ", url=" + url + ", userId=" + userId
				+ ", createat=" + createat + ", hot=" + hot + ", deleted=" + deleted + ", picture=" + picture + "]";
	}


    
}