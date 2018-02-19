package com.jinse.blog.pojo;

import java.util.Date;
import java.util.List;

public class Blog {
    private Integer blogId;

    private String title;

    private String description;

    private String tag;

    private Double score;

    private Integer likeNumber;

    private Integer userId;

    private Date createAt;

    private Integer hot;

    private String deleted;

    private Picture picture;
    
    private User user;
    
    private List<Tag> tagList;
    
    public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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
				+ ", score=" + score + ", likeNumber=" + likeNumber + ", userId=" + userId + ", createAt=" + createAt
				+ ", hot=" + hot + ", deleted=" + deleted + ", picture=" + picture + ", user=" + user + ", tagList="
				+ tagList + "]";
	}

	
    
    
}