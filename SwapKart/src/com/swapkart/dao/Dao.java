package com.swapkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.number.PercentFormatter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter;
import com.swapkart.constants.AppConfiguration;
import com.swapkart.constants.Constant;
import com.swapkart.model.Address;
import com.swapkart.model.MainScreenBanner;
import com.swapkart.model.ProductBean;
import com.swapkart.model.ProductDetailBrief;
import com.swapkart.model.QueryBean;
import com.swapkart.model.Review;
import com.swapkart.model.SimilarProducts;
import com.swapkart.model.SubBannerMain;
import com.swapkart.model.SubCategeoriesTable;
import com.swapkart.model.user;

@Component

public class Dao {

	@Autowired
	Constant constant;



	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("swapkart-servlet.xml");
		Dao dao = (Dao) context.getBean("Dao");
		List<List<SubCategeoriesTable>> list = dao.subCategeories();

		System.out.println(list.get(0).get(0).getSubCatgName());
	}

	
	
	
	
	public Connection getConnection() {
		Connection connection = null;
		try {

			

			Class.forName(constant.dao_connectionClassName);

			connection = DriverManager.getConnection(constant.dao_conectionName, constant.dao_connectionID,
					constant.dao_connectionPassword);
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
		}
		return connection;

	}
	
	
	
	
	
	
	

	public List<MainScreenBanner> mainBanners() {

		Connection connection = null;
		ResultSet resultSet = null;
		List<MainScreenBanner> mainBannerList = new ArrayList<>();

		try {

			connection = getConnection();
			// dao_selectQuery_mainBanners
			String sqlQuery = constant.dao_selectQuery_mainBanners;

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				MainScreenBanner mainScreenBanner = new MainScreenBanner();
				mainScreenBanner.setBannerId(resultSet.getInt(constant.dao_col_bannerId));
				mainScreenBanner.setBannerName(resultSet.getString(constant.dao_col_banner_name));
				mainScreenBanner.setInsertedDate(resultSet.getDate(constant.dao_col_inserted_date));
				mainScreenBanner.setIsActive(resultSet.getInt(constant.dao_col_banner_active));
				mainScreenBanner.setUpdatedDate(resultSet.getDate(constant.dao_col_updated_date));
				mainScreenBanner.setImageName(resultSet.getString(constant.dao_col_imageName));

				mainBannerList.add(mainScreenBanner);
			}
			
			preparedStatement.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return mainBannerList;

	}
	
	
	
	
	
	
	
	public List<List<SubCategeoriesTable>> subCategeories() {
		
		Connection connection = null;
		ResultSet resultSet = null;
		List<SubCategeoriesTable> subCategeoriesList= new ArrayList<>();
		List<List<SubCategeoriesTable>> list = new ArrayList<>();
		List<SubCategeoriesTable> electronicsList = new ArrayList<>();
		List<SubCategeoriesTable> menList = new ArrayList<>();
		List<SubCategeoriesTable> houseHoldList = new ArrayList<>();
		List<SubCategeoriesTable> womenList = new ArrayList<>();
		
		
		try {
		
			connection = getConnection();
			String sqlQuery = constant.dao_selectQuery_subCategeoriesList;
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				SubCategeoriesTable subCategeoriesTable = new SubCategeoriesTable();
				
				subCategeoriesTable.setCatgId(resultSet.getInt(constant.catgId));
				subCategeoriesTable.setInsertedDate(resultSet.getDate(constant.insertedDate));
				subCategeoriesTable.setSubCatgdesc(resultSet.getString(constant.subCatgDesc));
				subCategeoriesTable.setSubCatgId(resultSet.getInt(constant.subCatgId));
				subCategeoriesTable.setSubCatgName(resultSet.getString(constant.subCatgName));
				subCategeoriesTable.setUpdatedBy(resultSet.getString(constant.updatedBy));
				subCategeoriesTable.setUpdatedDate(resultSet.getDate(constant.updatedDate));
				
				
				subCategeoriesList.add(subCategeoriesTable);
				
				
			}
			
			for(int i=0;i<subCategeoriesList.size();i++) {
				
				if(subCategeoriesList.get(i).getCatgId() == 1000) {
					
					electronicsList.add(subCategeoriesList.get(i));
				}else if(subCategeoriesList.get(i).getCatgId() == 1001) {
					
					menList.add(subCategeoriesList.get(i));
				}else if(subCategeoriesList.get(i).getCatgId() == 1002) {
					houseHoldList.add(subCategeoriesList.get(i));
				}else if(subCategeoriesList.get(i).getCatgId() == 1003) {
					
					womenList.add(subCategeoriesList.get(i));
					
				}
			
				
			}
			
			list.add(womenList);
			list.add(menList);
			list.add(houseHoldList);
			list.add(electronicsList);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	public List<ProductBean> mainScreenSlider(int subCatgId) {
		
		Connection connection = null;
		ResultSet resultSet = null;
		List<ProductBean> list= new ArrayList<>();
		
		String sqlQuery = "";
		
		try {
			
				connection = getConnection();
				 sqlQuery = constant.dao_selectQuery_sliderList1;
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
				preparedStatement.setInt(1, subCatgId);
				
				resultSet = preparedStatement.executeQuery();
				
				
				while(resultSet.next()) {
					
					ProductBean productBean = new ProductBean();
					
					productBean.setInsertedDate(resultSet.getDate(constant.dao_slider1_insertedDate));
					productBean.setIsActive(resultSet.getInt(constant.dao_slider1_isActive));
					productBean.setProductId(resultSet.getInt(constant.dao_slider1_productId));
					productBean.setProductMnfg(resultSet.getString(constant.dao_slider1_productMnfg));
					productBean.setProductName(resultSet.getString(constant.dao_slider1_productName));
					productBean.setProductPrice(resultSet.getInt(constant.dao_slider1_productPrice));
					productBean.setProductQunatity(resultSet.getInt(constant.dao_slider1_productQuantity));
					productBean.setProductRating(resultSet.getFloat(constant.dao_slider1_productRating));
					productBean.setProductSellar(resultSet.getString(constant.dao_slider1_prdouctSellar));
					productBean.setProductSpecs(resultSet.getString(constant.dao_slider1_productSpecs));
					productBean.setSubCategId(resultSet.getInt(constant.dao_slider1_subCatgId));
					
					productBean.setUpdatedBy(resultSet.getString(constant.dao_slider1_updatedBy));
					productBean.setUpdatedDate(resultSet.getDate(constant.dao_slider1_updatedDate));
					productBean.setProductImage(resultSet.getString(constant.dao_slider1_imageName));
					
					list.add(productBean);
					
				}
				
				
				
				
				
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	
	
		
	public List<SubBannerMain> mainScreenBanners() {
		
		Connection connection = null;
		ResultSet resultSet = null;
		List<SubBannerMain> subBannersList = new ArrayList<>();
		
		try {
			connection = getConnection();
			String sql =constant.dao_selectQuery_subBannerMainScreen;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				SubBannerMain subBannerMain = new SubBannerMain();
				subBannerMain.setBannerId(resultSet.getInt(constant.dao_subBanner_bannerid));
				subBannerMain.setBannerName(resultSet.getString(constant.dao_subBanner_bannerName));
				subBannerMain.setImageId(resultSet.getInt(constant.dao_subBanner_imageId));
				subBannerMain.setInsertedBy(resultSet.getString(constant.dao_subBanner_updatedBy));
				subBannerMain.setInsertedDate(resultSet.getDate(constant.dao_subBanner_insertedDate));
				subBannerMain.setIsActive(resultSet.getInt(constant.dao_subBanner_isActive));
				subBannerMain.setUpdatedDate(resultSet.getDate(constant.dao_subBanner_updatedDate));
				subBannerMain.setImageName(resultSet.getString(constant.dao_subBanner_imageName));
				
				subBannersList.add(subBannerMain);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return subBannersList;
	}
	
	
	public List<ProductBean> searchProducts(int subcategId){
		
		List<ProductBean> productsList = new ArrayList<ProductBean>();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sqlQuery = constant.dao_searchResult_selectQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			
			preparedStatement.setInt(1, subcategId);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				ProductBean productBean = new ProductBean();
				productBean.setInsertedDate(resultSet.getDate(constant.dao_slider1_insertedDate));
				productBean.setIsActive(resultSet.getInt(constant.dao_slider1_isActive));
				productBean.setProductId(resultSet.getInt(constant.dao_slider1_productId));
				productBean.setProductImage(resultSet.getString(constant.dao_slider1_imageName));
				productBean.setProductMnfg(resultSet.getString(constant.dao_slider1_productMnfg));
				productBean.setProductName(resultSet.getString(constant.dao_slider1_productName));
				productBean.setProductPrice(resultSet.getInt(constant.dao_slider1_productPrice));
				productBean.setProductQunatity(resultSet.getInt(constant.dao_slider1_productQuantity));
				productBean.setProductRating(resultSet.getInt(constant.dao_slider1_productRating));
				productBean.setProductSellar(resultSet.getString(constant.dao_slider1_prdouctSellar));
				productBean.setProductSpecs(resultSet.getString(constant.dao_slider1_productSpecs));
				productBean.setSubCategId(resultSet.getInt(constant.dao_slider1_subCatgId));
				productBean.setUpdatedBy(resultSet.getString(constant.dao_slider1_updatedBy));
				productBean.setUpdatedDate(resultSet.getDate(constant.dao_slider1_updatedDate));
				
				
				productsList.add(productBean);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return productsList;
	}
	
	
	
	
	public List<ProductBean> filterProducts(List<QueryBean> queryBeans,int subcategId){
		
		List<ProductBean> productList = new ArrayList<>();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			

			
			String sql = constant.dao_filterResult_searchQuery;
			QueryBuilder queryBuilder = new QueryBuilder();
			
			
			sql = sql+queryBuilder.queryGen(queryBeans);
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, subcategId);
			
			System.out.println(preparedStatement);
			
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				ProductBean productBean = new ProductBean();
				
				productBean.setInsertedDate(resultSet.getDate(constant.dao_slider1_insertedDate));
				productBean.setIsActive(resultSet.getInt(constant.dao_slider1_isActive));
				productBean.setProductId(resultSet.getInt(constant.dao_slider1_productId));
				productBean.setProductImage(resultSet.getString(constant.dao_slider1_imageName));
				productBean.setProductMnfg(resultSet.getString(constant.dao_slider1_productMnfg));
				productBean.setProductName(resultSet.getString(constant.dao_slider1_productName));
				productBean.setProductPrice(resultSet.getInt(constant.dao_slider1_productPrice));
				productBean.setProductQunatity(resultSet.getInt(constant.dao_slider1_productQuantity));
				productBean.setProductRating(resultSet.getInt(constant.dao_slider1_productRating));
				productBean.setProductSellar(resultSet.getString(constant.dao_slider1_prdouctSellar));
				productBean.setProductSpecs(resultSet.getString(constant.dao_slider1_productSpecs));
				productBean.setSubCategId(resultSet.getInt(constant.dao_slider1_subCatgId));
				productBean.setUpdatedBy(resultSet.getString(constant.dao_slider1_updatedBy));
				productBean.setUpdatedDate(resultSet.getDate(constant.dao_slider1_updatedDate));
			
				productList.add(productBean);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return productList;
		
	}
	
	
	public ProductDetailBrief productDetail(int productId) {
		
		Connection connection = null;
		ResultSet resultSet = null;
		List<ProductBean> productlist  = new ArrayList<>();
		List<Review> reviewList  = new ArrayList<>();
		ProductDetailBrief productDetailBrief = new ProductDetailBrief();
		
		try {
			
			String sql =constant.dao_productDetail_searchQuery;
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				ProductBean productBean = new ProductBean();
				
				productBean.setInsertedDate(resultSet.getDate(constant.dao_slider1_insertedDate));
				productBean.setIsActive(resultSet.getInt(constant.dao_slider1_isActive));
				productBean.setProductId(resultSet.getInt(constant.dao_slider1_productId));
				productBean.setProductImage(resultSet.getString(constant.dao_slider1_imageName));
				productBean.setProductMnfg(resultSet.getString(constant.dao_slider1_productMnfg));
				productBean.setProductName(resultSet.getString(constant.dao_slider1_productName));
				productBean.setProductPrice(resultSet.getInt(constant.dao_slider1_productPrice));
				productBean.setProductQunatity(resultSet.getInt(constant.dao_slider1_productQuantity));
				productBean.setProductRating(resultSet.getInt(constant.dao_slider1_productRating));
				productBean.setProductSellar(resultSet.getString(constant.dao_slider1_prdouctSellar));
				productBean.setProductSpecs(resultSet.getString(constant.dao_slider1_productSpecs));
				productBean.setSubCategId(resultSet.getInt(constant.dao_slider1_subCatgId));
				productBean.setUpdatedBy(resultSet.getString(constant.dao_slider1_updatedBy));
				productBean.setUpdatedDate(resultSet.getDate(constant.dao_slider1_updatedDate));
				productBean.setSpecification(resultSet.getString(constant.dao_productDeatail_specification));
				productBean.setModelNumber(resultSet.getString(constant.dao_productDetail_modelNumber));
				
				
				productlist.add(productBean);
			}
			
			productDetailBrief.setProductBean(productlist);
			
			String sql2 = constant.dao_productDetail_review_selectQuery;
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setInt(1, productId);
		
			resultSet = preparedStatement2.executeQuery();
			
			while(resultSet.next()) {
				
				Review review = new Review();
				
				review.setDate(resultSet.getDate(constant.dao_productDetail_review_date));
				review.setDislikes(resultSet.getInt(constant.dao_productDetail_review_dislikes));
				review.setLikes(resultSet.getInt(constant.dao_productDetail_review_likes));
				review.setProductId(resultSet.getInt(constant.dao_productDeatail_review_productId));
				review.setRatings(resultSet.getInt(constant.dao_productDetail_ratings));
				review.setReviewDesc(resultSet.getString(constant.dao_productDetail_reviewDesc));
				review.setReviewId(resultSet.getInt(constant.dao_productDetail_reviewId));
				review.setReviewTitle(resultSet.getString(constant.dao_productDetail_reviewTitle));
				review.setUserName(resultSet.getString(constant.dao_productDetail_userName));

				reviewList.add(review);
				
			}
			
			productDetailBrief.setReview(reviewList);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return productDetailBrief;
		
	}
	
	
	public List<SimilarProducts> similarItems(String modelNumber){
		
		List<SimilarProducts> list = new ArrayList<>();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_similarProducts_selectQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,modelNumber);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				SimilarProducts similarProducts= new SimilarProducts();
				similarProducts.setColor(resultSet.getString(constant.dao_similarProducts_colorValue));
				similarProducts.setProductId(resultSet.getInt(constant.dao_similarProducts_productId));
				similarProducts.setSizeValue(resultSet.getString(constant.dao_similarProducts_sizeValue));
				list.add(similarProducts);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	
	public String updateLikes(HashMap<String, String>map) {
		
		
		String result = "";
		Connection connection = null;
		ResultSet resultSet = null;
		int likeType = 0;
		String reviewId =" ";
		String reviewValue = " ";
		int dislike=0;
		int userId = 0;
		
		try {
			
			connection = getConnection();
			likeType = Integer.parseInt(map.get("like"));
			reviewId = map.get("reviewId");
			dislike = Integer.parseInt(map.get("dislike"));
			userId = Integer.parseInt(map.get("user_id"));
			
			String sql = constant.dao_likes_updateQueery;
			
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, 500);
			preparedStatement.setInt(2, Integer.parseInt(reviewId));
			preparedStatement.setInt(3, likeType);
			preparedStatement.setInt(4, dislike);
			preparedStatement.setInt(5, userId);
			
			
			preparedStatement.setInt(6, likeType);
			preparedStatement.setInt(7, dislike);
			
			
			int res = preparedStatement.executeUpdate();
			if(res > 0) {
				result = "Success";
			}else {
				result = "Failure";
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "Failure";
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	
	}
	
	
	public String newRev(Review review) {
		
		String result = "";
		Connection connection =null;
		ResultSet resultSet = null;
		
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_newReview_insertQuery;
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(new Date());
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, review.getReviewDesc());
			preparedStatement.setInt(2, review.getProductId());
			preparedStatement.setString(3,currentTime);
			preparedStatement.setString(4, review.getUserName());
			preparedStatement.setString(5, review.getReviewTitle());
			preparedStatement.setInt(6, review.getRatings());
			preparedStatement.setInt(7, review.getLikes());
			preparedStatement.setInt(8, review.getDislikes());
			
			int res = preparedStatement.executeUpdate();
			if(res > 1) {
				result = "Success";
			}else {
				result = "Failure";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public List<ProductBean> cartProducts(int userId){
		
		List<ProductBean> productBeans = new ArrayList<>();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_cartProduct_selectQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			System.out.println(userId);
			preparedStatement.setInt(1, userId);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				ProductBean productBean = new ProductBean();
				productBean.setProductId(resultSet.getInt(constant.dao_slider1_productId));
				productBean.setProductImage(resultSet.getString(constant.dao_slider1_imageName));
				productBean.setProductName(resultSet.getString(constant.dao_slider1_productName));
				productBean.setProductPrice(resultSet.getInt(constant.dao_slider1_productPrice));
				productBean.setProductSellar(resultSet.getString(constant.dao_slider1_prdouctSellar));
				productBean .setIsActive(resultSet.getInt(constant.dao_slider1_isActive));
				productBean.setProductQunatity(resultSet.getInt(constant.dao_cart_productQuantity));
				productBean.setTotalQuantity(resultSet.getString(constant.dao_slider1_productQuantity));
				System.out.println("In looping the result set : "+resultSet.getString(constant.dao_slider1_productName));
				
				productBeans.add(productBean);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		for(ProductBean pb : productBeans) {
			System.out.println(pb.getProductName());
		}
		
		return productBeans;
		
	}
	
	
	public Long  orderTransaction(List<ProductBean> productsList) {
		
		
		ResultSet resultSet = null;
		Connection connection =null;
		final AtomicLong  invoice_id= new AtomicLong(System.currentTimeMillis()*100000);
		final AtomicLong  order_id= new AtomicLong(System.currentTimeMillis()*100000);
		String tax = constant.dao_inovice_tax;
		try {
			
			connection =  getConnection();
			
			connection.setAutoCommit(false);
			
			int count = 0;
			
			for(int i=0;i<productsList.size();i++) {
				
				String sql = constant.dao_invoice_insertQery;
				
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
			
				preparedStatement.setLong(1, Long.parseLong(invoice_id.toString()));
				preparedStatement.setInt(2, productsList.get(i).getProductQunatity());
				preparedStatement.setInt(3, Integer.parseInt(tax));
				preparedStatement.setInt(4, Integer.parseInt(tax));
				preparedStatement.setInt(5, Integer.parseInt(tax));
				preparedStatement.setInt(6, productsList.get(i).getProductQunatity());
				preparedStatement.setInt(7, productsList.get(i).getProductId());
				preparedStatement.setInt(8, productsList.get(i).getProductQunatity());
				preparedStatement.setInt(9, productsList.get(i).getProductId());
				System.out.println("1"+preparedStatement);
				count = count + preparedStatement.executeUpdate();
				
			}
			
			System.out.println("Invoice Count : "+count);

			if(count == productsList.size()) {
				
				java.util.Date dt = new java.util.Date();

				java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String currentTime = sdf.format(new Date());
				
				String sql2 =constant.dao_order_insertQuery;
				
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				preparedStatement2.setLong(1, Long.parseLong(order_id.toString()));
				
				preparedStatement2.setString(2, currentTime);
				preparedStatement2.setLong(3, Long.parseLong(invoice_id.toString()));
				preparedStatement2.setInt(4, 101);
				preparedStatement2.setLong(5, Long.parseLong(invoice_id.toString()));
				preparedStatement2.setInt(6,666);
				preparedStatement2.setInt(7, 1);
				int res = preparedStatement2.executeUpdate();
				
			
					String sql3 = constant.dao_cart_deleteQuery;
					
					PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
					preparedStatement3.setInt(1, 101);
					preparedStatement3.setLong(2, Long.parseLong(invoice_id.toString()));
					System.out.println("3"+preparedStatement3);
					int r = preparedStatement3.executeUpdate();
					
					
					String sql4 =constant.dao_productTable_UpdateQuery;
					PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
					preparedStatement4.setLong(1, Long.parseLong(invoice_id.toString()));
					System.out.println("4"+preparedStatement4);
					int finalResult = preparedStatement4.executeUpdate();
					
					
					connection.commit();
				
			}
			
			
		}catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return Long.parseLong(order_id.toString());
		
		
		
		
	}
	
	
	public int removeProduct(int userId,int productId) {
		
		int result =0;
		Connection connection = null;
		ResultSet resultSet= null;
		try {
			connection = getConnection();
			String sql =constant.dao_removeProduct_deleteQuery;
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, productId);
			
			result = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public List<Address> getAddress(int userId){
		
		List<Address> addressList = new ArrayList<>();
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_address_selectQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Address address = new Address();
				
				address.setActive(resultSet.getInt(constant.dao_address_isActive));
				address.setAddress(resultSet.getString(constant.dao_address_address));
				address.setAddressId(resultSet.getInt(constant.dao_address_addressId));
				address.setInsertedDate(resultSet.getDate(constant.dao_address_inseredDate));
				address.setUpdatedDate(resultSet.getDate(constant.dao_address_updatedDate));
				address.setUserId(resultSet.getInt(constant.dao_address_userId));
				
				addressList.add(address);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return addressList;
	}
	
	
	public int increaseProductQuantity(int userId,int productId,int quantity) {
		
		int result = 0;
		Connection connection= null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sql =constant.dao_increaseCartProductQuantity_updateQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setInt(4, productId);
			preparedStatement.setInt(5, userId);
			
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		 return result;
				
	}
	
	
	
	public int addToCart(int userId,int productId) {
		
		int result =0;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_addToCart_selectQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			preparedStatement.setInt(2, 1);
			preparedStatement.setInt(3, userId);
			
			result = preparedStatement.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	
	public int verifyUser(int userId,String password) {
		
		int result = 0;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_login_selectQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			
			
			
		
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				result = resultSet.getInt(constant.dao_login_userId);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	
	public int addUser(user user) {
		
		int result =0;
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			
			connection = getConnection();
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(new Date());
			String sql = constant.dao_newUser_insertQuery;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserEmail());
			preparedStatement.setString(3, user.getUserNum());
			preparedStatement.setString(4, currentTime);
			preparedStatement.setString(5, currentTime);
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setInt(7, 1);
			
			int res = preparedStatement.executeUpdate();
			
			int userId =0;
			int addressId =0;
			
			if(res>0) {
				
				String sql2 = constant.dao_newUser_selectQuery;
				
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				
				resultSet = preparedStatement2.executeQuery();
				
				while(resultSet.next()) {
					
					userId = resultSet.getInt(constant.dao_newUser_userId);
					addressId = resultSet.getInt(constant.dao_newUser_addressId);
				}
				
			String sql3 = constant.dao_newAddress_insertQuery;
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, addressId);
			preparedStatement3.setInt(2, userId);
			preparedStatement3.setString(3, user.getAddress());
			preparedStatement3.setString(4, currentTime);
			preparedStatement3.setString(5, currentTime);
			preparedStatement3.setInt(6, 1);
			
			int finalRes = preparedStatement3.executeUpdate();
			if(finalRes >0) {
				
				result = userId;
				
			}
			
			}
			
			System.out.println(result);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
