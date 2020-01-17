package com.swapkart.model;

import java.util.List;

public class SearchResultBean {
	
	private List<List<SubCategeoriesTable>> subCategList;
	private List<ProductBean> productList;
	public List<List<SubCategeoriesTable>> getSubCategList() {
		return subCategList;
	}
	public void setSubCategList(List<List<SubCategeoriesTable>> subCategList) {
		this.subCategList = subCategList;
	}
	public List<ProductBean> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductBean> productList) {
		this.productList = productList;
	}

	
	
}
