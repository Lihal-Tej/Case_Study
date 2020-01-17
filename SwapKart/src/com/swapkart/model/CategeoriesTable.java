package com.swapkart.model;

import java.sql.Date;

public class CategeoriesTable {
	
	private int catgId;
	private String catgName;
	private String catgDesc;
	private int isActive;
	private Date insertedDate;
	private Date updatedDate;
	private String insertedBy;
	public int getCatgId() {
		return catgId;
	}
	public void setCatgId(int catgId) {
		this.catgId = catgId;
	}
	public String getCatgName() {
		return catgName;
	}
	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}
	public String getCatgDesc() {
		return catgDesc;
	}
	public void setCatgDesc(String catgDesc) {
		this.catgDesc = catgDesc;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public Date getInsertedDate() {
		return insertedDate;
	}
	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getInsertedBy() {
		return insertedBy;
	}
	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	
	
	
	

}
