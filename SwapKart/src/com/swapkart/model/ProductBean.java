package com.swapkart.model;

import java.util.Date;

public class ProductBean {
	
	private int productId;
	private String productSellar;
	private String productMnfg;
	private int productPrice;
	private int offerId;
	private float productRating;
	private String productSpecs;
	private int colorId;
	private int sizeId;
	private Date insertedDate;
	private Date updatedDate;
	private String updatedBy;
	private int isActive;
	private int subCategId;
	private int productQunatity;
	private String productName;
	private String productImage;
	private String specification;
	private String modelNumber;
	private String totalQuantity;
	
	
	
	
	
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductSellar() {
		return productSellar;
	}
	public void setProductSellar(String productSellar) {
		this.productSellar = productSellar;
	}
	public String getProductMnfg() {
		return productMnfg;
	}
	public void setProductMnfg(String productMnfg) {
		this.productMnfg = productMnfg;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public float getProductRating() {
		return productRating;
	}
	public void setProductRating(float productRating) {
		this.productRating = productRating;
	}
	public String getProductSpecs() {
		return productSpecs;
	}
	public void setProductSpecs(String productSpecs) {
		this.productSpecs = productSpecs;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
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
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getSubCategId() {
		return subCategId;
	}
	public void setSubCategId(int subCategId) {
		this.subCategId = subCategId;
	}
	public int getProductQunatity() {
		return productQunatity;
	}
	public void setProductQunatity(int productQunatity) {
		this.productQunatity = productQunatity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
