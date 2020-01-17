package com.swapkart.testing;

import java.security.ProtectionDomain;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.swapkart.model.CategeoriesTable;
import com.swapkart.model.MainScreenBanner;
import com.swapkart.model.OnLoadBanner;
import com.swapkart.model.ProductBean;
import com.swapkart.model.SlidersBean;
import com.swapkart.model.SubBannerMain;
import com.swapkart.model.SubCategeoriesTable;

public class Test {
	
	public static void main(String[] args) {
		
		List<CategeoriesTable> catgList = new ArrayList<>();
		
		CategeoriesTable ct = new CategeoriesTable();
		ct.setCatgId(41);
		ct.setCatgDesc("rufh");
		ct.setCatgName("jfiwe");
		ct.setInsertedBy("Lihal");ct.setInsertedDate(new Date(18, 05, 15));
		ct.setUpdatedDate(new Date(05, 05, 15));
		ct.setIsActive(1);
		catgList.add(ct);
		
		
		List<SubCategeoriesTable> subCatgList = new ArrayList<>();
		
		SubCategeoriesTable subcateg = new SubCategeoriesTable();
		subcateg.setCatgId(12);
		subcateg.setInsertedDate(new Date(05, 05, 15));
		subcateg.setOfferId(25);
		subcateg.setSubCatgdesc("sdhuo");
		subcateg.setSubCatgId(36);
		subcateg.setSubCatgName("fjojfd");
		subcateg.setUpdatedBy("rfgio");
		subcateg.setUpdatedDate(new Date(05, 05, 15));
		subCatgList.add(subcateg);
		
		
		List<MainScreenBanner> mainBannerList = new ArrayList<>();
		MainScreenBanner msb = new MainScreenBanner();
		msb.setBannerId(10);
		msb.setBannerName("sdfbi");
		msb.setImageId(25);
		msb.setInsertedBy("dfjuhi");
		msb.setInsertedDate(new Date(05, 05, 15));
		msb.setIsActive(0);
		msb.setUpdatedDate(new Date(05, 05, 15));
		mainBannerList.add(msb);
		
		
		
		List<SubBannerMain> subBannerMain = new ArrayList<>();
		SubBannerMain sbm = new SubBannerMain();
		sbm.setBannerId(25);
		sbm.setBannerName("dlfigh");
		sbm.setImageId(63);
		sbm.setInsertedBy("sjfoi");
		sbm.setInsertedDate(new Date(05, 05, 15));
		sbm.setIsActive(0);sbm.setUpdatedDate(new Date(05, 05, 15));
		subBannerMain.add(sbm);
		
		
		OnLoadBanner ol = new OnLoadBanner();
		ol.setCategList(catgList);
		ol.setMsbList(mainBannerList);
		ol.setSbmList(subBannerMain);
		ol.setSubCatgeList(subCatgList);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(ol);
		System.out.println(jsonString);
		
		
		List<ProductBean> offerList = new ArrayList<>();
		
		ProductBean productBean = new ProductBean();
		productBean.setColorId(25);
		productBean.setInsertedDate(new Date(05, 05, 15));
		productBean.setIsActive(0);
		productBean.setOfferId(23);
		productBean.setProductId(10);
		productBean.setProductMnfg("Apple");
		productBean.setProductName("Iphone XS");
		productBean.setProductPrice(256);
		productBean.setProductQunatity(20);
		productBean.setProductRating(2.3f);
		productBean.setProductSellar("ReatilNet");
		productBean.setProductSpecs("udifshoaidsfu");
		productBean.setSizeId(23);
		productBean.setSubCategId(102);
		productBean.setUpdatedBy("Lihal");
		productBean.setUpdatedDate(new Date(05, 05, 15));
		
		offerList.add(productBean);
		
		List<ProductBean> trendingList = new ArrayList<ProductBean>();
		trendingList.add(productBean);
		
		List<ProductBean> fashionList = new ArrayList<>();
		fashionList.add(productBean);
		
		List<ProductBean> electronicsList = new ArrayList<>();
		electronicsList.add(productBean);
		List<ProductBean> likedList = new ArrayList<>();
		likedList.add(productBean);
		
		List<ProductBean> houseHoldList = new ArrayList<>();
		houseHoldList.add(productBean);
		
		
		SlidersBean sb = new SlidersBean();
		sb.setElectronicsList(electronicsList);
		sb.setFashionList(fashionList);
		sb.setHouseHoldList(houseHoldList);
		sb.setLikedList(likedList);
		sb.setOfferList(offerList);
		sb.setTrendingList(trendingList);
		
		
		String jsonString2 = gson.toJson(sb);
		System.out.println(jsonString2);
		
		
		
		
	}

}
