package com.swapkart.model;

import java.util.Date;

public class SubCategeoriesTable {

	private int subCatgId;
	private String subCatgName;
	private String subCatgdesc;
	private int catgId;
	private int offerId;
	private Date insertedDate;
	private Date updatedDate;
	private String updatedBy;
	public int getSubCatgId() {
		return subCatgId;
	}
	public void setSubCatgId(int subCatgId) {
		this.subCatgId = subCatgId;
	}
	public String getSubCatgName() {
		return subCatgName;
	}
	public void setSubCatgName(String subCatgName) {
		this.subCatgName = subCatgName;
	}
	public String getSubCatgdesc() {
		return subCatgdesc;
	}
	public void setSubCatgdesc(String subCatgdesc) {
		this.subCatgdesc = subCatgdesc;
	}
	public int getCatgId() {
		return catgId;
	}
	public void setCatgId(int catgId) {
		this.catgId = catgId;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
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
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
