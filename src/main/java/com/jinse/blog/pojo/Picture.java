package com.jinse.blog.pojo;

public class Picture {
    private Integer pictureId;

    private Integer blogId;

    private String type;

    private Double price;

    private String buy;

    private String url;

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

    public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy == null ? null : buy.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

	@Override
	public String toString() {
		return "Picture [pictureId=" + pictureId + ", blogId=" + blogId + ", type=" + type + ", price=" + price
				+ ", buy=" + buy + ", url=" + url + "]";
	}
    
    
}