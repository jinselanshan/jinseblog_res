package com.jinse.blog.pojo;

public class Province {
    private String id;

    private String myTexts;

    private String parentId;

    private String myTables;

    private String myColums;

    private String sort;

    private String remark;

    private String createAt;

    private String createBy;

    private String updateAt;

    private String updateBy;

    private Province parent;
    
	public Province getParent() {
		return parent;
	}

	public void setParent(Province parent) {
		this.parent = parent;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMyTexts() {
        return myTexts;
    }

    public void setMyTexts(String myTexts) {
        this.myTexts = myTexts == null ? null : myTexts.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getMyTables() {
        return myTables;
    }

    public void setMyTables(String myTables) {
        this.myTables = myTables == null ? null : myTables.trim();
    }

    public String getMyColums() {
        return myColums;
    }

    public void setMyColums(String myColums) {
        this.myColums = myColums == null ? null : myColums.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt == null ? null : createAt.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt == null ? null : updateAt.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}