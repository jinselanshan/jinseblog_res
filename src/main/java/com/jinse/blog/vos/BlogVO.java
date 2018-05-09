package com.jinse.blog.vos;

import java.util.HashMap;
import java.util.List;

public class BlogVO {
	//
	private String draw;
	// 
	private int start;
	//
	private int length;
	// 
	private Integer userId;
	
	private String type;
	
	private String title;
	
	private String tag;
	
	private Integer ownerId;
		
	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	private HashMap<String,Object> search;
	
	private HashMap<String,Object> platform;
	private List<HashMap<String,Object>> order;
	
	public int getPage() {
		return length == 0 ? 0 : start/length;
	}

	public HashMap<String, Object> getPlatform() {
		return platform;
	}

	public void setPlatform(HashMap<String, Object> platform) {
		this.platform = platform;
	}

	public String getDraw() {
		return draw;
	}


	public void setDraw(String draw) {
		this.draw = draw;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public HashMap<String,Object> getSearch() {
		return search;
	}


	public void setSearch(HashMap<String,Object> search) {
		this.search = search;
	}

 	public List<HashMap<String,Object>> getOrder() {
 		return order;
 	}

	public void setOrder(List<HashMap<String,Object>> order) {
		this.order = order;
	}
	
}
