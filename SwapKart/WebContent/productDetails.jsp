<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SwapKart/productDetails</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	
	

	<link rel="stylesheet" href="styles/jquery.mThumbnailScroller.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="scripts/jquery-1.11.0.min.js"><\/script>')</script>
	



	<script src="scripts/jquery.mThumbnailScroller.js"></script>
	

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <script src="http://localhost:8080/SwapKart/scripts/productDet.js">
	
</script>



	

<script type="text/javascript">

function textCounter(field,field2,maxlimit)
{
 var countfield = document.getElementById(field2);
 if ( field.value.length > maxlimit ) {
  field.value = field.value.substring( 0, maxlimit );
  return false;
 } else {
  countfield.value = maxlimit - field.value.length;
 }
}


</script>
  
  <style>
  .jumbotron {
	height: 65px;
	margin: 0px;
	width: 100%;
	background-color: #2873F0;
	border: solid;
	border-color: #2874F0;
}

.navbar {
	background-color: white;
	border: solid;
	border-color: white;
	margin-bottom: 0px;
}

#navbarAnchor {
	color: black;
}


.imageGallery{

    object-fit: scale-down;
    width: 70px;
    height: 70px;
    margin-bottom :10px;
    border :2px;
    border-style : groove;
} 

.mainImage{

    object-fit: scale-down;
    width: 400px;
    height: 440px;

}

.liPrice{

display : inline;
} 

.addressDropDown{

width:450px;
color:black;
font-size:17px;
background-color:white;
font-family:inherit;
text-align : left;

}

.liSize{

display:inline;
margin-right :15px;
font-family: sans-serif;
  
    border-style: dotted;
    font-size: 25px;

}

.aSize{

color:black;
}  
.row-flex, .row-flex>div[class*='col-'] {
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	flex: 1 1 auto;
	width: 100%;
}

.rowSlider {
	top: 0;
	
	height: 300px;
	overflow-x: hidden;
	white-space: nowrap;
	margin-bottom: 8px;
	margin-left: 0px;
}

.sliderPanel {
	height: 300px;
	margin-bottom: 0px;
	border: 0px;
}

.sliderBody {
	width: 150px;
	height: 200px;
	    object-fit: scale-down;
}

.sliderPannelBottom {
	background-color: #ffffff;
	text-align: center;
	padding-left: 0px;
	margin-top: 5px;
	font-size: 14px;
	list-style-type: none;
	width:180px;
}
.sliderFluid {
	width: 100%;
	margin-right: 0px;
	margin-left: 0px;
	padding-left: 0px;
	padding-right: 0px;
	background-color: #e6e6e6;
}

#sliderHeadUi {
	margin-bottom: 0px;
	height: 100%;
}

#sliderHeadLi {
	height: 100%;
	font-size: x-large;
	font-style: bold;
}

.sliderHead {
	height: 50px;
	border: 2px;
	background-color: white;
	border-style: solid;
	border-top-color: white;
	border-left-color: white;
	border-right-color: white;
	border-bottom-color: black;
}

.vl {
	border-left: 1px solid #89857e;
	margin-top: 50px;
	height: 230px;
}


.footUl {
	margin-top: 50px;
	list-style-type: none;
	text-align: justify;
}

#footHeadLi {
	color: #89857e;
	font-size: 13px;
}

#footBodyLi {
	color: white;
	font-size: 12px;
}

.foot {
	height: 350px;
	background: #172437;
}

.reviewRating{

font-size:20px;
background-color:green;
color:white;
width:45px;
text-align;center;
margin-bottom:29px;
dsiplay:inline;
height:25px;

}

.reviewTitle{

dsiplay:inline;
font-size:18px;
}

.reviewDesc{
font-size:14px;
}

.reviewWritter{

font-size:12px;
color:grey;
}

.revieww{

list-style:none;
margin:0px;
padding-left:0px

}

#advanceSpecs{

display : none;
}

#readMore{

 border-color: gainsboro;
}

#secondRev{

display : none;
margin-bottom:20px;

}

#showMore{

margin-bottom:40px;
 border-color: gainsboro;
}

#writeMore{

margin-bottom:40px;
 border-color: gainsboro;
}

.gal{

    position: sticky;
    top: 0px;
    bottom: 0px;
    z-index: 2;

}

.zoom {

  transition: transform .2s;
  
}

.zoom:hover {
  -ms-transform: scale(1.5); /* IE 9 */
  -webkit-transform: scale(1.5); /* Safari 3-8 */
  transform: scale(1.2); 
}

.colorBox{

margin-right:10px;
background-color:green;
width:30px;
height:15px;

}

.checked {
  color: orange;
}

#blankReview{

display: none;

}  

.content{
			overflow: auto;
			position: relative;
			
			background-color: white;
			
			width:100%;
			height: auto;
			
			float: left;
			rgba(0,0,0,.7);
			
			left: 5px;
			right: 5px;
			
		}
		.sliderLi{
			
			overflow: hidden;
			margin:4px;
		}
		
		.content.light, .content.light .mTSButton{ background-color: #c2beb2; }
		
				#content-6{ background-color: transparent; }
		#content-6 .mTSButton{
			background-color: rgba(0,0,0,.7);
			-moz-border-radius: 48px; -webkit-border-radius: 48px; border-radius: 48px;
		}
		#content-6 .mTSButtonLeft{ left: 5px; }
		#content-6 .mTSButtonRight{ right: 5px; }
		
		.sec{
		
		width :100%;
		padding:0px;
		background-color:white;
		
		}
		
  
  </style>
  
</head>
<body style="background:#e6e6e6">


<!--
	<div class="jumbotron">
		<div class="row">
			<div class="col-sm-2">
				<img src="">
			</div>
			<div class="col-sm-6">


				<form class="form-inline">
					<input type="email" class="form-control" size="50"
						placeholder="Search for products, brands and more">
					<button type="button" class="btn btn-primary">Search</button>
				</form>




			</div>
			<div class="col-sm-4"></div>
		</div>

	</div>

  -->
	<!--   ------------------------------------->

<!-- 
	<nav class="navbar navbar-inverse" style="margin-bottom:2px">
		<div class="row">
			<div class="navbar-header col-sm-4"></div>
			<div class="collapse navbar-collapse col-sm-4 " id="myNavbar">
			<div class="row"></div>
				<div class="dropdown col-sm-3">
					<button class="btn btn-primary dropdown-toggle dropbtn " 
						data-toggle="dropdown" style="background-color:white;color:black;border:0px">
						Electronics<span class="caret" style="color:grey"></span>
					</button>
					<ul id="ulDrop1" class="dropdown-menu dropdown-content">
						
					</ul>
						
				</div>
				
				<div class="dropdown col-sm-3">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown" style="background-color:white;color:black;border:0px">
						Mens<span class="caret" style="color:grey"></span>
					</button>
					<ul id="ulDrop2"  class="dropdown-menu">
						
					</ul>
						
				</div>
				
				
				<div class="dropdown col-sm-3">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown" style="background-color:white;color:black;border:0px">
						Womens<span class="caret" style="color:grey"></span>
					</button>
					<ul id="ulDrop3"  class="dropdown-menu">
						
					</ul>
						
				</div>
				
				<div class="dropdown col-sm-3">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown" style="background-color:white;color:black;border:0px">
						HouseHolds<span class="caret" style="color:grey"></span>
					</button>
					<ul id="ulDrop4" class="dropdown-menu">
						
					</ul>
						
				</div>
				
				</div>
				

			</div>
			<div class="col-sm-4"></div>
		
	</nav>

 -->
  <!--   ----------------------------------- -->
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<!--   ------------------------------------->
	<!--   ------------------------------------->
	
	<div style="background-color:white;margin-left:30px;margin-right:30px;margin-top:1px">
	<div class = "row" >
	
	<div class=" row col-sm-6  gal">
	<div class="col-sm-3" style="height :480px;padding-left : 50px;padding-top:15px">
	
	<div style="height:350px">
	<img id='galleryImg1' class ="imageGallery"  src="http://localhost:8080/SwapKart/Images/2007_1.jpeg">
	<br>
	<img id='galleryImg2' class ="imageGallery" src="http://localhost:8080/SwapKart/Images/2007_2.jpeg">
	<br>
	<img id='galleryImg3' class ="imageGallery" src="http://localhost:8080/SwapKart/Images/2007_3.jpeg">
	</div>
	</div>
	<div class="col-sm-9" style="height :480px;padding-top:15px">
	
	<div>
	
	<img id="myimage" class="mainImage zoom" src ="http://localhost:8080/SwapKart/Images/2007_1.jpeg"/>
	</div>
	
	
	</div>
	<div class = "row">
	<div  class ="col-sm-6">
	<button id='cart' class = "btn addToCart" style="margin-left:20px;margin-bottom:20px;background-color:#ff9f00;height:50px;padding:15px;width:100%;color:white" value="Buy Now">Add To Cart</button>
	
	</div>
	
	<div  class ="col-sm-6">
	<button id="buyNow" class ="btn" style="padding:15px;background-color:#fb641b;width:100%;height:50px;color:white">Buy Now</button>
	
	</div>
	
	</div>
	</div>
	
	<div class="col-sm-6">
	 
	<div>
	<ul style="list-style:none;padding:0px">
	<li id="productMnfg" style="color:grey;font-style:bold">Samsung</li>
	<li id="productName" style="font-size:23px;margin-bottom:6px">Samsung s9 6gb RAM Black && 64gb ROM 12MP  </li>
	
	<li style="color:green;margin-bottom:9px">Special Price </li>
	
	<li id="productPrice" class="liPrice" style="font-size:30px;margin-bottom:6px">$125 </li><li class="liPrice" style="color:green;font-size:18px;margin-left:10px">45% off</li>
	<li id="productRating" style ="font-size:16px;background-color:green;color:white;width:50px;text-align:center;margin-bottom:29px">4.5<span class="fa fa-star checked" style="color:white"></span></li>
	<li id ="modelNumber" style="display:none"></li>
	<li style="margin-bottom:6px"><img style="width:18px;heigth:18px" src="https://rukminim1.flixcart.com/www/36/36/promos/06/09/2016/c22c9fc4-0555-4460-8401-bf5c28d7ba29.png?q=90">   Buy More, Save MoreBuy worth $200-299 save $20; Buy worth $300 save $40See all productsT&C</li>
	<li style="margin-bottom:6px"><img style="width:18px;heigth:18px" src="https://rukminim1.flixcart.com/www/36/36/promos/06/09/2016/c22c9fc4-0555-4460-8401-bf5c28d7ba29.png?q=90">   Bank OfferExtra 5% off* with Axis Bank Buzz Credit CardT&C</li>
	</ul>
	
	<div class="dropdown" style="margin-bottom:40px">
    <button class="btn btn-default dropdown-toggle addressDropDown" type="button" data-toggle="dropdown">Delivery Address
    <span class="caret" style="margin-left:250px"></span></button>
    <ul class="dropdown-menu" style="width:450px;margin-left:45px">
      <li><a href="#">HTML</a></li>
      <li><a href="#">CSS</a></li>
      <li><a href="#">JavaScript</a></li>
    </ul>
  	</div>
  	
  	<div style="margin-bottom:20px;margin-left:0px" class= "row">
  	<div class="col-sm-2" style="padding:0px;color:grey">
  	<b id ='sizeHeader'> Size-INDIA/UK : </b>
  	</div>
  	<div class ="col-sm-10">
  	<ul id='size' style="list-style:none;">
  	
  	</ul>
  	</div>
  	</div>
  	
  	<div class='row'  style="margin-bottom:20px;margin-left:0px">
  		<div class="col-sm-2" style="padding:0px;color:grey">
  	<b id ='colorHeader'> Color : </b>
  	</div>
  		<div class ="col-sm-10">
  	<ul id='color' style="list-style:none;display: -webkit-inline-box;">
  	
  	</ul>
  	</div>
  	</div>
  	
  	
	<div class = "row" style="margin-left:0px" >
	<div class="col-sm-2" style="color:grey;padding:0px">
	<b>Sellar :</b>
	</div>
	<div class="col-sm-10" style="color:blue">
	<b  id="sellar">Retail.Net</b>
	</div>

	
	</div>
	
	
	<div style="margin:30px">
	
	<img style="width:420px;height:180px;margin-left:0px" src="https://rukminim1.flixcart.com/lockin/774/325/images/Coins-banner-PP__1533290309.png?q=50">
	</div>
	<hr>
	<div class= "row" style="margin:0px">
	<h3 style="font-style: inherit;">Product Details</h3>
	<ul id="productDetails" style="padding:10px;margin-left:5px">
	
	</ul>
	<hr>
	
	<div>
	<h3 style="font-style: inherit;">Specifications</h3>
	
	<div id ='deepSpecs' >
	
	
	
	
	</div>
	
	<div id ='advanceSpecs' >
	
	</div>
	<div>
	<input id='readMore' type="button" class="btn btn-light" style="color:blue;background:white" value="Read More"></input>
	</div>
	
	
	
	</div>
	
	<h3 style="font-style: inherit;">Reviews</h3>
	
	<div id=rev>
		
	<ul  id='blankReview' class="revieww cloneReview"  style="margin-bottom:10px;">

		<li  class="reviewRating" style ="margin-bottom :5px"><span class ='revRating' style="font-size:18px">      </span><span class="fa fa-star checked" style="color:white"></span></li>

		<li  class="reviewTitle"></li>

		<li  class="reviewDesc"></li>

		<li class="reviewWritter"><span class='userName'></span>          <span class="date"></span>  <span class="reviewId" data_reviewId="" style ="float:right;margin-right:15px">   <span id='upp' class="upp glyphicon glyphicon-thumbs-up like" style="font-size:15px;color:grey;margin-right:5px"> </span> <span  class="glyphicon glyphicon-thumbs-down down dislike" style="font-size:15px;color:grey">  </span>   </span>   </li>

		</ul>
		<hr>
		
	
	</div>
	<div id= 'secondRev'>
	
	</div>
	<div>
	<input id='showMore' type="button" class="btn btn-light" style="color:blue;background:white;" value="Show More"></input>
	<input id='writeMore' type="button" class="btn btn-light" style="color:blue;background:white" value="Write Review" data-toggle="modal" data-target="#myModal"></input>
	</div>
	
	</div>
	
	 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title" style="color:#2873F0">Write Review</h4>
          <div class='row' style="margin-top:15px">
         <div class="col-sm-6">
         
          <input id='newRevUser' class='form-control'style="margin-right:10px;padding:5px" type='text' placeholder='UserName'/>
				
         
         </div>						
        <div class="btn-group col-sm-6" >
			<!--  
            <button class="btn dropdown-toggle" style="width:100%;color:orange;background-color:slategrey" name="recordinput" data-toggle="dropdown">
            
            <span id='newRevRating'>Ratings
            </span>
            
            <span class="fa fa-star checked" style="color:orange"></span>
            <span class="caret"></span>
            
            
            </button>
            <ul style="color:orange" class="dropdown-menu">
                  <li style="margin:5px;padding:5px">5<span class="fa fa-star checked" style="color:orange"></span></li>
                  <li style="margin:5px;padding:5px">4<span class="fa fa-star checked" style="color:orange"></span></li>
                  <li style="margin:5px;padding:5px">3<span class="fa fa-star checked" style="color:orange"></span></li>
                  <li style="margin:5px;padding:5px">2<span class="fa fa-star checked" style="color:orange"></span></li>
                  <li style="margin:5px;padding:5px">1<span class="fa fa-star checked" style="color:orange"></span></li>
            </ul>
            
            -->
            
            <div id='ratingStars'>
          
          
            <span id='1' class="fa fa-star ratingStar"></span>
			<span id='2' class="fa fa-star ratingStar"></span>
			<span id='3' class="fa fa-star ratingStar"></span>
			<span id='4' class="fa fa-star ratingStar"></span>
			<span id='5'  class="fa fa-star ratingStar"></span>
			
            
            </div>
       
        </div>
  

		</div>
     	
     	
     
        </div>
        <div class="modal-body">
        <div>
     	<input id='newRevHeader' style="width:100%"  class="form-control" type="text" placeholder="Review Title"/>
     	<div class="md-form">
  			<textarea id='newRevBody' maxlength="500" onkeyup="textCounter(this,'counter',500);" style="margin-top:10px;width:100%;height:250px;overflow:hidden" class="md-textarea form-control" rows="3" placeholder="Review Description"></textarea>
  			<div>
  			<label for="form7" style="color: grey; font-size: 13px;padding: 3px;">* Minimum 150 characters Required</label>
  			<label style="color: grey;float:right; font-size: 13px;padding: 3px;">Charecters Left : <input disabled    value="500" id="counter"  style="font-size:13px;background-color:white;color:grey;border:0px">
  			</label>
  			</div>
		</div>
     	
     	</div>
        </div>
        <div class="modal-footer">
        <label  style="color: grey; font-size: 13px;padding: 3px;float:left" >Note: Discard Will remove all your Details</label>
          <button id='newRevDiscard' type="button" style="Width:70px" class="btn btn-danger" data-dismiss="modal">Discard</button>
          <button id='newRevSave' type="button"  style="Width:70px" class="btn btn-success" >Save</button>
        </div>
      </div>
      
    </div>
  </div>
	
	
	</div>
	
	</div>
	
	
	
	
	</div>
	</div>
	
	<!-- ---------------------------------------------------------------------------------------------------------------------------------- -->
	
	
	
	<div id='sliderFluid' class="container fluid  sliderFluid" style="margin-top:50px">



		<div class="sliderHead">
			<ul id="sliderHeadUl" style="list-style-type: none;">
				<li id="sliderHeadLi">Similar Products</li>
			</ul>
		</div>
		<div id ="sliderRow1"  class="row row-flex  rowSlider">
		<section id='examples' class = "sec">
		<div id='content-6' class='content mThumbnailScroller _mTS_1 mTS-none'>
		
		<ul id='rowSlider1' style ="width :500px"  sliderName="rowSlider1">
		
		</ul>
		
		</div>
		</section>
		
		</div>
		
	


	</div>
	
	<!--   ------------------------------------------------------------------------------ -->


	<footer class="container-fluid text-center  foot"
		style="background: #232F3F">

		<div class="row">

			<div class="col-sm-8">
				<div class="col-sm-3">
					<ul class="footUl">
						<li id='footHeadLi'>ABOUT</li>
						<br>
						<li id='footBodyLi'><a class="anchor" href="#">About Us</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">Contact Us</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">SwapKart
								Stores</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">Press</a></li>

					</ul>
				</div>


				<div class="col-sm-3">
					<ul class="footUl">
						<li id='footHeadLi'>HELP</li>
						<br>
						<li id='footBodyLi'><a class="anchor" href="#">Payments</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">Shipping</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">Cancellation
								& Returns</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">FAQ</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">Reports</a></li>
					</ul>
				</div>


				<div class="col-sm-3">
					<ul class="footUl">
						<li id='footHeadLi'>POLICY</li>
						<br>
						<li id='footBodyLi'><a class="anchor" href="#">Return
								Policy</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">Terms of
								Use</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">Security</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">Privacy</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">SiteMaps</a></li>
						<li id='footBodyLi'><a class="anchor" href="#">EPR
								Compilance</a></li>
					</ul>
				</div>



				<div class="col-sm-3 row">
					<div class="col-sm-9">

						<ul class="footUl">
							<li id='footHeadLi'>SOCIAL</li>
							<br>
							<li id='footBodyLi'><a class="anchor" href="#">Facebook</a></li>
							<li id='footBodyLi'><a class="anchor" href="#">Twitter</a></li>
							<li id='footBodyLi'><a class="anchor" href="#">Youtube</a></li>
							<li id='footBodyLi'><a class="anchor" href="#">Google
									Plus</a></li>

						</ul>
					</div>

					<div class="col-sm-3 vl" ></div>
				</div>

			</div>

			<div class="col-sm-4">
				<div class="col-sm-6">
					<ul class="footUl" style="padding-left: 0px;list-style:none;color:white">
						<li id="footHeadLi">Mail Us:</li>
						<li id="footBodyLi">SwapKart Internet Pvt Ltd Block B
							(Begonia), Ground Floor, Prestige Tech Park, Outer Ring Road,
							Whitefield, Varthur Main Road, Bengaluru East Taluk, Bengaluru
							District, Karnataka, India, 560103.</li>
					</ul>
				</div>
				<div class="col-sm-6">
					<ul class="footUl" style="padding-left: 0px;list-style:none;color:white">
						<li id="footHeadLi">Registered Office Address:</li>
						<li id="footBodyLi">SwapKart Internet Pvt Ltd Block B
							(Begonia), Ground Floor, Prestige Tech Park, Outer Ring Road,
							Whitefield, Varthur Main Road, Bengaluru East Taluk, Bengaluru
							District, Karnataka, India, 560103.</li>
					</ul>


				</div>

			</div>


		</div>


		<div class="row">
		
		<h4 style="color:wheat;margin-bottom :5px">All Rights are Reserved by Lihal Tej.Kopparapu</h4>
		</div>
		

	</footer>



	

</body>
</html>