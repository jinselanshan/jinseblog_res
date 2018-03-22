package com.jinse.blog.vos;

import java.util.List;
import java.util.Map;

import com.jinse.blog.pojo.User;

public class UserResultVO {
	
	private User user;
	
	private Integer isFollowing;
	
	private List<User> userList;
	
	private String code;//code:VALIDATION_ERROR

	private String message;
	
	private String formId;
	
	private Map<String,String> fieldErrors;

	private Object data;
	//add by felix
	private String json;
	
	//add end
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public String getJson() {
		return json;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getIsFollowing() {
		return isFollowing;
	}

	public void setIsFollowing(Integer isFollowing) {
		this.isFollowing = isFollowing;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public Map<String, String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(Map<String, String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}
