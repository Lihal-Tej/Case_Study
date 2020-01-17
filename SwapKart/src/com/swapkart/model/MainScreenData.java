package com.swapkart.model;

import java.util.List;

public class MainScreenData {

	List<MainScreenBanner> mainBannerList;
	List<SubBannerMain> mainSubBannerList;
	List<List<SubCategeoriesTable>> subCategeiroesList;
	List<List<ProductBean>> slidersList;
	
	
	public List<MainScreenBanner> getMainBannerList() {
		return mainBannerList;
	}
	public void setMainBannerList(List<MainScreenBanner> mainBannerList) {
		this.mainBannerList = mainBannerList;
	}
	public List<SubBannerMain> getMainSubBannerList() {
		return mainSubBannerList;
	}
	public void setMainSubBannerList(List<SubBannerMain> mainSubBannerList) {
		this.mainSubBannerList = mainSubBannerList;
	}
	public List<List<SubCategeoriesTable>> getSubCategeiroesList() {
		return subCategeiroesList;
	}
	public void setSubCategeiroesList(List<List<SubCategeoriesTable>> subCategeiroesList) {
		this.subCategeiroesList = subCategeiroesList;
	}
	public List<List<ProductBean>> getSlidersList() {
		return slidersList;
	}
	public void setSlidersList(List<List<ProductBean>> slidersList) {
		this.slidersList = slidersList;
	}
	
	
}
