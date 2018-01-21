package com.jinse.blog.pojo;

public class Likeif {
    private Integer likeifId;

    private Integer userId;

    private Integer blogId;

    private String likeif;

    public Integer getLikeifId() {
        return likeifId;
    }

    public void setLikeifId(Integer likeifId) {
        this.likeifId = likeifId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getLikeif() {
        return likeif;
    }

    public void setLikeif(String likeif) {
        this.likeif = likeif == null ? null : likeif.trim();
    }
}