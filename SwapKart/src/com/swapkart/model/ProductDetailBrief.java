package com.swapkart.model;

import java.util.List;

public class ProductDetailBrief {
	
	List<ProductBean> productBean;
	List<Review> review;
	
	
	public List<ProductBean> getProductBean() {
		return productBean;
	}
	public void setProductBean(List<ProductBean> productBean) {
		this.productBean = productBean;
	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	
	
	

}
