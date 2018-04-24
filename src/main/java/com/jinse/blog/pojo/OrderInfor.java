package com.jinse.blog.pojo;

import java.util.Date;

public class OrderInfor {
	private Integer orderId;

	private Integer sellerId;

	private Integer blogId;

	private Integer pictureId;

	private Integer videoId;

	private String tradeNo;

	private String outTradeNo;

	private Double totalAmount;

	private Double price;

	private Integer year;

	private Integer buyerId;

	private String message;

	private String title;

	private String orderState;

	private Date payedAt;

	private String sellerDeleted;

	private String buyerDeleted;

	private Blog blog;

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Integer getPictureId() {
		return pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo == null ? null : tradeNo.trim();
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState == null ? null : orderState.trim();
	}

	public Date getPayedAt() {
		return payedAt;
	}

	public void setPayedAt(Date payedAt) {
		this.payedAt = payedAt;
	}

	public String getSellerDeleted() {
		return sellerDeleted;
	}

	public void setSellerDeleted(String sellerDeleted) {
		this.sellerDeleted = sellerDeleted == null ? null : sellerDeleted.trim();
	}

	public String getBuyerDeleted() {
		return buyerDeleted;
	}

	public void setBuyerDeleted(String buyerDeleted) {
		this.buyerDeleted = buyerDeleted == null ? null : buyerDeleted.trim();
	}
}