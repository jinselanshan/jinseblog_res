package com.jinse.blog.pojo;

import java.util.Date;
import java.util.List;

public class User {
	private Integer userId;

	private String username;

	private String password;

	private Integer followingNumber;

	private Integer followerNumber;

	private String email;

	private Date birthday;

	private Integer money;

	private Date createAt;

	private String phone;

	private String gender;

	private String signatur;

	private String address;

	private Integer roleId;

	private String avatarUrl;

	private String cityId;

	private String villageId;

	private String provinceId;

	private String city;
	 
	private Blog blog;

	private List<Blog> blogList;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getFollowingNumber() {
		return followingNumber;
	}

	public void setFollowingNumber(Integer followingNumber) {
		this.followingNumber = followingNumber;
	}

	public Integer getFollowerNumber() {
		return followerNumber;
	}

	public void setFollowerNumber(Integer followerNumber) {
		this.followerNumber = followerNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public String getSignatur() {
		return signatur;
	}

	public void setSignatur(String signatur) {
		this.signatur = signatur == null ? null : signatur.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId == null ? null : cityId.trim();
	}

	public String getVillageId() {
		return villageId;
	}

	public void setVillageId(String villageId) {
		this.villageId = villageId == null ? null : villageId.trim();
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId == null ? null : provinceId.trim();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", followingNumber="
				+ followingNumber + ", followerNumber=" + followerNumber + ", email=" + email + ", birthday=" + birthday
				+ ", money=" + money + ", createAt=" + createAt + ", phone=" + phone + ", gender=" + gender
				+ ", signatur=" + signatur + ", address=" + address + ", roleId=" + roleId + ", avatarUrl=" + avatarUrl
				+ ", cityId=" + cityId + ", villageId=" + villageId + ", provinceId=" + provinceId + ", city=" + city
				+ ", blog=" + blog + ", blogList=" + blogList + "]";
	}

	
}