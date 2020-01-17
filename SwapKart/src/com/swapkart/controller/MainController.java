package com.swapkart.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.swapkart.dao.Dao;
import com.swapkart.model.Address;
import com.swapkart.model.MainScreenBanner;
import com.swapkart.model.MainScreenData;
import com.swapkart.model.ProductBean;
import com.swapkart.model.ProductDetailBrief;
import com.swapkart.model.QueryBean;
import com.swapkart.model.Review;
import com.swapkart.model.SearchResultBean;
import com.swapkart.model.Sess;
import com.swapkart.model.SimilarProducts;
import com.swapkart.model.SubBannerMain;
import com.swapkart.model.SubCategeoriesTable;

@Controller
@SessionAttributes("userId")
public class MainController {

	@Autowired
	Dao dao;
	
	@RequestMapping(value="/homepage",method =RequestMethod.GET)
	@ResponseBody
	public String homepage(@ModelAttribute("userId") String   model) {
		
		String json = "";
		try {
			
			System.out.println(model);
			
		List<MainScreenBanner> mainBannerList = dao.mainBanners();
		List<SubBannerMain> mainSubBannerList = dao.mainScreenBanners();
		List<List<SubCategeoriesTable>> subCategeoriesList = dao.subCategeories();
		List<List<ProductBean>> productList = new ArrayList<>();
		List<ProductBean> list = dao.mainScreenSlider(1000);
		List<ProductBean> list1 = dao.mainScreenSlider(1001);
		productList.add(list);
		productList.add(list1);
		MainScreenData mainScreenData = new MainScreenData();
		mainScreenData.setSlidersList(productList);
		mainScreenData.setMainBannerList(mainBannerList);
		mainScreenData.setMainSubBannerList(mainSubBannerList);
		mainScreenData.setSubCategeiroesList(subCategeoriesList);
		
		Gson gson = new Gson();
		
	
		 json =  gson.toJson(mainScreenData);	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return json;
		}
		
	}
	
	
	
	@RequestMapping(value="/search",method =RequestMethod.GET)
	@ResponseBody
	public String searchResults(@RequestParam String subCatgId) {
		
		String result ="";
		
		try {
			
			List<List<SubCategeoriesTable>> subCategList = dao.subCategeories();
			List<ProductBean> productList = dao.searchProducts(Integer.parseInt(subCatgId));
			
			Gson gson = new Gson();
			SearchResultBean searchResultBean = new SearchResultBean();
			
			searchResultBean.setSubCategList(subCategList);
			searchResultBean.setProductList(productList);
			
			result = gson.toJson(searchResultBean);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			return result;
		}
	}
	
	
	@RequestMapping(value = "/filterSearch",method = RequestMethod.POST)
	@ResponseBody
	public String filterResults(@RequestParam String maps , @RequestParam String subCategId) {
		
		String result ="";
		
		try {
			
			List<QueryBean> queryBeanList = null;
			Gson gson = new Gson();
		
			queryBeanList = gson.fromJson(maps,new  TypeToken<List<QueryBean>>(){}.getType());
			
			
			List<ProductBean> productList = dao.filterProducts(queryBeanList,Integer.parseInt(subCategId));
			
			for(int i=1;i<queryBeanList.size();i++) {
				
				System.out.println(queryBeanList.get(i));
			}
			
			//List<ProductBean> productList = dao.filterProducts(hashMap);
			
			result = gson.toJson(productList);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
	}
	
	@RequestMapping(value = "/productDetails",method = RequestMethod.GET)
	@ResponseBody
	public String productDeatails(@RequestParam String productId) {
		
		String result ="";
		try {
			
			ProductDetailBrief productDetailBrief = dao.productDetail(Integer.parseInt(productId));
			
			Gson gson = new Gson();
			result = gson.toJson(productDetailBrief);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "/similarProducts",method = RequestMethod.GET)
	@ResponseBody
	public String similarProdcs(@RequestParam String modelNumber) {
		
		String result = "";
		try {
			
			List<SimilarProducts> similarList = new ArrayList<>();
			similarList = dao.similarItems(modelNumber);
			Gson gson = new Gson();
			result = gson.toJson(similarList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	

	@RequestMapping(value = "/Like",method = RequestMethod.GET)
	@ResponseBody
	public String updateLikes(@RequestParam String likeType,@ModelAttribute("userId") String   model) {
		
		String result ="";
		try {
			
		
		System.out.println(likeType);
			Gson gson = new Gson();
			HashMap<String, String> map = new HashMap<>();
			map = gson.fromJson(likeType, new TypeToken<HashMap<String, String>>() {}.getType());
			map.put("user_id", model);
			result = dao.updateLikes(map);
					
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/newReview",method = RequestMethod.POST)
	@ResponseBody
	public String newReview(@RequestParam String rev) {
		
		String result = "";
		
		try {
		
		
			Gson gson = new Gson();
			Review review = gson.fromJson(rev, new TypeToken<Review>() {}.getType());
			
			review.setLikes(0);
			review.setDislikes(0);
			
			result = dao.newRev(review);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "/cartProducts",method = RequestMethod.GET)
	@ResponseBody
	public String cartProducts(@RequestParam String userId,@ModelAttribute("userId") String   model) {
		
		String result = "";
		try {
			
			List<ProductBean> productList = new ArrayList<>();
			productList = dao.cartProducts(Integer.parseInt(model));
			
			Gson gson = new Gson();
			
			result = gson.toJson(productList);
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping(value = "/placeOrder",method = RequestMethod.POST)
	@ResponseBody
	public String orderTransaction(@RequestParam String products) {
		
		String result = "0";
		try {
			
			Gson  gson = new Gson();
			System.out.println(products);
			List<ProductBean> productList  = new ArrayList<>();
			
			productList = gson.fromJson(products, new TypeToken<List<ProductBean>>() {}.getType());
			
			Long res = dao.orderTransaction(productList);
			
			result = res.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping(value = "/removeCartProduct",method = RequestMethod.POST)
	@ResponseBody
	public int removeCartProduct(@RequestParam String map,@ModelAttribute("userId") String   model) {
		
		int result =0;
		
		try {
			
			Gson gson = new Gson();
			HashMap<String, String> productMap = new HashMap<>();
			productMap = gson.fromJson(map, new TypeToken<HashMap<String, String>>() {}.getType());
			String userId = model;
			String productId = productMap.get("productId");
			
			result = dao.removeProduct(Integer.parseInt(userId), Integer.parseInt(productId));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "/userAddress",method = RequestMethod.GET)
	@ResponseBody
	public String  userAddress(@RequestParam String userId) {
		
		String result ="";
		
		try {
			
			int user = Integer.parseInt(userId);
			List<Address> addressList = dao.getAddress(user);
			Gson gson = new Gson();
			
			result = gson.toJson(addressList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "/Increament",method = RequestMethod.POST)
	@ResponseBody
	public String increaseCartQuantity(@RequestParam String inc,ModelMap model) {
		
		String result ="0";
		
		try {
			Gson gson = new Gson();
			HashMap<String , String> map =gson.fromJson(inc, new TypeToken<HashMap<String, String>>() {}.getType());
			int userId = Integer.parseInt(model.get("userId").toString());
			int productId = Integer.parseInt(map.get("productId"));
			int quantity = Integer.parseInt(map.get("quantity"));
			
			int res = dao.increaseProductQuantity(userId, productId, quantity);
			
			result = String.valueOf(res);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "/cart",method = RequestMethod.POST)
	@ResponseBody
	public String addCart(@RequestParam String produtcDet,@ModelAttribute("userId") String   model) {
		
		String result = "0";
		
		try {
			
			Gson gson = new Gson();
			if(model != null && model != "") {
				System.out.println("In MAin Controller"+model);
				HashMap<String , String>  map = gson.fromJson(produtcDet, new TypeToken<HashMap<String, String>>() {}.getType());
				result = String.valueOf(dao.addToCart(Integer.parseInt(model), Integer.parseInt(map.get("productId"))));
				
			}else {
				result = "Please login to SwapKart to add the products into cart";
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	
}
