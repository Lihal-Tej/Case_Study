package com.swapkart.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration

public class Constant {

	@Value("${dao_connectionClassName}")
	public String dao_connectionClassName;

	@Value("${dao_conectionName}")
	public String dao_conectionName;

	@Value("${dao_connectionID}")
	public String dao_connectionID;

	@Value("${dao_connectionPassword}")
	public String dao_connectionPassword;

	// --------------------------------------------------------------------

	@Value("${dao_selectQuery_mainBanners}")
	public String dao_selectQuery_mainBanners;

	@Value("${dao_col_bannerId}")
	public String dao_col_bannerId;

	@Value("${dao_col_banner_name}")
	public String dao_col_banner_name;

	@Value("${dao_col_banner_active}")
	public String dao_col_banner_active;

	@Value("${dao_col_inserted_date}")
	public String dao_col_inserted_date;

	@Value("${dao_col_updated_date}")
	public String dao_col_updated_date;

	@Value("${dao_col_updated_by}")
	public String dao_col_updated_by;
	
	@Value("${dao_col_imageName}")
	public String dao_col_imageName;
	
	
	// --------------------------------------------------------------------
	
	
	
	
	@Value("${dao_selectQuery_subBannerMainScreen}")
	public String dao_selectQuery_subBannerMainScreen;
	
	@Value("${dao_subBanner_bannerid}")
	public String dao_subBanner_bannerid;
	
	@Value("${dao_subBanner_bannerName}")
	public String dao_subBanner_bannerName;
	
	@Value("${dao_subBanner_imageId}")
	public String dao_subBanner_imageId;
	
	@Value("${dao_subBanner_insertedDate}")
	public String dao_subBanner_insertedDate;
	
	@Value("${dao_subBanner_updatedDate}")
	public String dao_subBanner_updatedDate;
	
	@Value("${dao_subBanner_updatedBy}")
	public String dao_subBanner_updatedBy;
	
	@Value("${dao_subBanner_isActive}")
	public String dao_subBanner_isActive;

	@Value("${dao_subBanner_imageName}")
	public String dao_subBanner_imageName;
	
	
	// --------------------------------------------------------------------

	@Value("${dao_selectQuery_subCategeoriesList}")
	public String dao_selectQuery_subCategeoriesList;

	@Value("${dao_catgId}")
	public String catgId;

	@Value("${dao_insertedDate}")
	public String insertedDate;

	@Value("${dao_subCatgDesc}")
	public String subCatgDesc;

	@Value("${dao_subCatgId}")
	public String subCatgId;

	@Value("${dao_subCatgName}")
	public String subCatgName;

	@Value("${dao_updatedBy}")
	public String updatedBy;

	@Value("${dao_updatedDate}")
	public String updatedDate;

	// --------------------------------------------------------------------

	@Value("${dao_selectQuery_sliderList1}")
	public String dao_selectQuery_sliderList1;
	


	@Value("${dao_slider1_insertedDate}")
	public String dao_slider1_insertedDate;

	@Value("${dao_slider1_isActive}")
	public String dao_slider1_isActive;

	@Value("${dao_slider1_productId}")
	public String dao_slider1_productId;

	@Value("${dao_slider1_productMnfg}")
	public String dao_slider1_productMnfg;

	@Value("${dao_slider1_productName}")
	public String dao_slider1_productName;

	@Value("${dao_slider1_productPrice}")
	public String dao_slider1_productPrice;

	@Value("${dao_slider1_productQuantity}")
	public String dao_slider1_productQuantity;

	@Value("${dao_slider1_productRating}")
	public String dao_slider1_productRating;

	@Value("${dao_slider1_prdouctSellar}")
	public String dao_slider1_prdouctSellar;

	@Value("${dao_slider1_productSpecs}")
	public String dao_slider1_productSpecs;

	@Value("${dao_slider1_subCatgId}")
	public String dao_slider1_subCatgId;

	@Value("${dao_slider1_updatedBy}")
	public String dao_slider1_updatedBy;

	@Value("${dao_slider1_updatedDate}")
	public String dao_slider1_updatedDate;
	
	@Value("${dao_slider1_imageName}")
	public String dao_slider1_imageName;

	// --------------------------------------------------------------------
	
	
	@Value("${dao_searchResult_selectQuery}")
	public String dao_searchResult_selectQuery; 
	
	
	// --------------------------------------------------------------------

	@Value("${dao_filterResult_searchQuery}")
	public String dao_filterResult_searchQuery;
	
	
	
	// --------------------------------------------------------------------

	@Value("${dao_productDetail_searchQuery}")
	public String dao_productDetail_searchQuery;
	
	@Value("${dao_productDeatail_specification}")
	public String dao_productDeatail_specification;
	
	@Value("${dao_productDetail_modelNumber}")
	public String dao_productDetail_modelNumber;
	
	@Value("${dao_productDetail_review_selectQuery}")
	public String dao_productDetail_review_selectQuery;
	
	@Value("${dao_productDetail_review_date}")
	public String dao_productDetail_review_date;
	
	@Value("${dao_productDetail_review_dislikes}")
	public String dao_productDetail_review_dislikes;
	
	@Value("${dao_productDetail_review_likes}")
	public String dao_productDetail_review_likes;
	
	@Value("${dao_productDeatail_review_productId}")
	public String dao_productDeatail_review_productId;
	
	@Value("${dao_productDetail_ratings}")
	public String dao_productDetail_ratings;
	
	@Value("${dao_productDetail_reviewDesc}")
	public String dao_productDetail_reviewDesc;
	
	@Value("${dao_productDetail_reviewId}")
	public String dao_productDetail_reviewId;
	
	@Value("${dao_productDetail_reviewTitle}")
	public String dao_productDetail_reviewTitle;
	
	@Value("${dao_productDetail_userName}")
	public String dao_productDetail_userName;
	
	
	//----------------------------------------------------------------------
	
	
	@Value("${dao_similarProducts_selectQuery}")
	public String dao_similarProducts_selectQuery;
	
	
	@Value("${dao_similarProducts_productId}")
	public String dao_similarProducts_productId;
	
	@Value("${dao_similarProducts_sizeValue}")
	public String dao_similarProducts_sizeValue;
	
	@Value("${dao_similarProducts_colorValue}")
	public String dao_similarProducts_colorValue;
	

	//----------------------------------------------------------------------
	
	@Value("${dao_likes_selectQueryPart1}")
	public String dao_likes_selectQueryPart1;
	
	@Value("${dao_likes_likeCondition}")
	public String dao_likes_likeCondition;
	
	@Value("${dao_likes_disLikecondition}")
	public String dao_likes_disLikecondition;

	@Value("${dao_likes_selectQueryPart2}")
	public String dao_likes_selectQueryPart2;
	
	@Value("${dao_likes_increase}")
	public String dao_likes_increase;

	@Value("${dao_likes_decrease}")
	public String dao_likes_decrease;
	
	@Value("${dao_likes_updateQueery}")
	public String dao_likes_updateQueery;
	
	//----------------------------------------------------------------------
	
	
	@Value("${dao_newReview_insertQuery}")
	public String dao_newReview_insertQuery;
	

	//----------------------------------------------------------------------
	
	
	
	@Value("${dao_cartProduct_selectQuery}")
	public String dao_cartProduct_selectQuery;
	
	@Value("${dao_cart_productQuantity}")
	public String dao_cart_productQuantity;
	

	
	

	//----------------------------------------------------------------------
	
	@Value("${dao_inovice_tax}")
	public String dao_inovice_tax;
	
	@Value("${dao_invoice_insertQery}")
	public String dao_invoice_insertQery;
	
	@Value("${dao_order_insertQuery}")
	public String dao_order_insertQuery;
	
	@Value("${dao_cart_deleteQuery}")
	public String dao_cart_deleteQuery;
	
	@Value("${dao_productTable_UpdateQuery}")
	public String dao_productTable_UpdateQuery;
	
	
	//----------------------------------------------------------------------
	
	@Value("${dao_removeProduct_deleteQuery}")
	public String dao_removeProduct_deleteQuery;
	
	
	//----------------------------------------------------------------------
	
	@Value("${dao_address_selectQuery}")
	public String dao_address_selectQuery;
	
	@Value("${dao_address_userId}")
	public String dao_address_userId;
	
	@Value("${dao_address_addressId}")
	public String dao_address_addressId;
	
	@Value("${dao_address_address}")
	public String dao_address_address;

	@Value("${dao_address_inseredDate}")
	public String dao_address_inseredDate;
	
	@Value("${dao_address_updatedDate}")
	public String dao_address_updatedDate;
	
	@Value("${dao_address_isActive}")
	public String dao_address_isActive;
	
	

	//----------------------------------------------------------------------
	
	@Value("${dao_increaseCartProductQuantity_updateQuery}")
	public String dao_increaseCartProductQuantity_updateQuery;
	
	

	//----------------------------------------------------------------------
	
	@Value("${dao_addToCart_selectQuery}")
	public String dao_addToCart_selectQuery;
	

	//----------------------------------------------------------------------
	
	@Value("${dao_login_selectQuery}")
	public String dao_login_selectQuery;
	
	@Value("${dao_login_userId}")
	public String dao_login_userId;
	
	
	//----------------------------------------------------------------------
	
	@Value("${dao_newUser_insertQuery}")
	public String dao_newUser_insertQuery;
	
	@Value("${dao_newUser_selectQuery}")
	public String dao_newUser_selectQuery;
	
	@Value("${dao_newAddress_insertQuery}")
	public String dao_newAddress_insertQuery;
	
	@Value("${dao_newUser_userId}")
	public String dao_newUser_userId;
	
	@Value("${dao_newUser_addressId}")
	public String dao_newUser_addressId;
	
	

	//----------------------------------------------------------------------
	
}
