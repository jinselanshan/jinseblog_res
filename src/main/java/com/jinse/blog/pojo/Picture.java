package com.jinse.blog.pojo;

public class Picture {
    private Integer pictureId;

    private Integer blogId;

    private String type;

    private Integer price;

    private String buy;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy == null ? null : buy.trim();
    }

	@Override
	public String toString() {
		return "Picture [pictureId=" + pictureId + ", blogId=" + blogId + ", type=" + type + ", price=" + price
				+ ", buy=" + buy + "]";
	}
    
}