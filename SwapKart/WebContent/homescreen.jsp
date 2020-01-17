<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">
<title>SwapKart/HomeScreen</title>
<!-- Latest compiled and minified CSS
 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
	
	

	<link rel="stylesheet" href="styles/jquery.mThumbnailScroller.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	  <script>window.jQuery || document.write('<script src="scripts/jquery-1.11.0.min.js"><\/script>')</script>

	<script src="scripts/jquery.mThumbnailScroller.js"></script>
	

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <script>var applicationUrl = '<c:url value = '/'   />';   </script>
<script src="http://localhost:8080/SwapKart/scripts/paddles.js">
	
</script>






</head>
<style>
.jumbotron {
	height: 65px;
	margin: 0px;
	width: 100%;
	background-color: #2873F0;
	border: solid;
	border-color: #2874F0;
}

#mainSearch {
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

.foot {
	height: 350px;
	background: #172437;
}

body {
	background-color: #e6e6e6;
}

.caros {
	height: 300px;
}

.carosImg {
	height: 600px;
}

.cont {
	width: 100%;
	margin-left: 0px;
	margin-right: 0px;
	background-color: #e6e6e6;
}

.fooRights {
	bottom: 0;
	position: fixed;
	/* text-align: end; */
	width: 100%;
	margin-top: 0px;
	margin-right: 150px;
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
	margin-bottom: 20px;
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

.pbod {
	padding: 10px;
}

.sliderFluid {
	width: 100%;
	margin-right: 0px;
	margin-left: 0px;
	padding-left: 0px;
	padding-right: 0px;
	background-color: #e6e6e6;
}

.paddle {
	position: fixed;
	top: 0;
	bottom: 0;
	width: 3em;
}

.left-paddle {
	margin-top: 75px;
	height: 150px;
	background-color: #ffffff;
	color: #000;
	visibility: hidden;
	left: 0;
}

.right-paddle {
	margin-top: 75px;
	height: 130px;
	background-color: #ffffff;
	color: #000;
	right: 0;
	border: 2px, solid;
}

.anchor {
	color: 337ab7;;
}

.mpbod {
	padding: 0px
}

.subBanner{
padding-right:0px;
padding-left:5px;
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

.sliderUl{

list-style:none;
margin:0px;
padding:0px

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

.panel-heading {
	text-align: center;
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

.vl {
	border-left: 1px solid #89857e;
	margin-top: 50px;
	height: 230px;
}


.sliderBody:hover {
  -ms-transform: scale(1.5); /* IE 9 */
  -webkit-transform: scale(1.5); /* Safari 3-8 */
  transform: scale(1.1); 
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
		
				
		#content-6 .mTSButton{
			background-color: rgba(0,0,0,.7);
			-moz-border-radius: 48px; -webkit-border-radius: 48px; border-radius: 48px;
		}
		#content-6 .mTSButtonLeft{ left: 5px; }
		#content-6 .mTSButtonRight{ right: 5px; }
		
		.sec{
		
		width :100%;
		padding:0px;
		
		}
		


</style>
<body>



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
			<div class="col-sm-4">
			<div class = "row">
			
			<div class="col-sm-4">


						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button" style="background-color:#2873F0;color:white;font-size:18px;border:0px"
								data-toggle="dropdown">
								 My Account <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li style="margin:7px"><a href="#" style="padding:5px"><i class='fas fa-user' style='font-size:14px;color:#2873F0;margin-right:3px'></i>  My Profile</a></li>
								<li class="divider"></li>
								<li style="margin:7px"><a href="#" style="padding:5px"><i class='fas fa-box' style='font-size:14px;color:#2873F0;margin-right:3px'></i>   Orders</a></li>
								<li class="divider"></li>
								<li  style="margin:7px"><a href="#" style="padding:5px"><i class='fas fa-heart' style='font-size:14px;color:#2873F0;margin-right:3px'></i>   WhisList</a></li>
								<li class="divider"></li>
								<li  style="margin:7px"><a href="#" style="padding:5px"><i class='fas fa-info-circle' style='font-size:18px;color:#2873F0;margin-right:3px'></i>   About Us</a></li>
								<li class="divider"></li>
								<li style="margin:7px"><a href="#" style="padding:5px"><i class='fas fa-power-off' style='font-size:14px;color:#2873F0;margin-right:3px'></i>   Sign Out</a></li>
							</ul>
						</div>



					</div>
			<div class="col-sm-4">
			
			
			
			<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button" style="background-color:#2873F0;color:white;font-size:18px;border:0px"
								data-toggle="dropdown">
								 More <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li style="margin:7px"><a href="#" style="padding:5px"><i class='fas fa-bell' style='font-size:14px;color:#2873F0;margin-right:3px'></i>  Notifications</a></li>
								<li class="divider"></li>
								<li style="margin:7px"><a href="#" style="padding:5px"><i class='fas fa-user-secret' style='font-size:14px;color:#2873F0;margin-right:3px'></i>   24/7 Customer Care</a></li>
								
							</ul>
						</div>
			
			
			</div>
			<div class="col-sm-4" style="padding:8px">
			<a style="text-decoration-line: none;" href='http://localhost:8080/SwapKart/cart.jsp'>
			<i class='fas fa-dolly' style='font-size:18px;color:white;display:inine-block'></i>
			<span style="display:inine-block;font-size:18px;margin-left:4px;color:white">Cart</span>
			</a>
			</div>
			
			
			</div>
			</div>
		</div>

	</div>

 -->
	<!--   ------------------------------------->

<!-- 
	<nav class="navbar navbar-inverse">
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
		</div>
	</nav>

 -->
	<!--   ------------------------------------->
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<!--   ------------------------------------->

	<div id="myCarousel" class="carousel slide  caros" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img style= "width:100%" id='carouselImage1' class="carosImg"
					
					alt="Los Angeles">
			</div>

			<div class="item">
				<img style= "width:100%" id="carouselImage2" class="carosImg"
				 alt="Chicago">
			</div>

			<div class="item">
				<img style= "width:100%" id = "carouselImage3" class="carosImg"
					 alt="New York">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<!--   ------------------------------------->



	<div class="container cont">
		<div class="row">
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">
						<img id='sBanner1' 
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>

				</div>
			</div>
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">
						<img id='sBanner2' 
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>

				</div>
			</div>
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">
						<img id='sBanner3' 
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>

				</div>

			</div>
		</div>
	</div>





	<div class="container cont">
		<div class="row">
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary ">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">
						<img id='sBanner4'
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>

				</div>
			</div>
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">
						<img   id='sBanner5'
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>
				</div>
			</div>
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">
						<img id='sBanner6'
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>

				</div>
			</div>
		</div>
	</div>

<!--   ------------------------------------->


	<div id='sliderFluid' class="container fluid  sliderFluid">



		<div class="sliderHead">
			<ul id="sliderHeadUl" style="list-style-type: none;">
				<li id="sliderHeadLi">SwapKart Electronics</li>
			</ul>
		</div>
		<div id ="sliderRow1"  class="row row-flex  rowSlider">
		<section id='examples' class = "sec">
		<div id='content-6' class='content mThumbnailScroller _mTS_1 mTS-none content-6'>
		
		<ul id='rowSlider1' style ="width :500px"  sliderName="rowSlider1">
		
		</ul>
		
		</div>
		</section>
		
		</div>

		<div class="sliderHead">
			<ul id='sliderHeadUl' style="list-style-type: none;">
				<li id='sliderHeadLi'>Fashion Accessories</li>
			</ul>
		</div>
		<div id='rowSlider2' class="row row-flex  rowSlider">
		
		<section id='examples' class = "sec">
		<div id='content-6' class='content mThumbnailScroller _mTS_1 mTS-none content-6'>
		<ul id='rs2'   class="row row-flex  rowSlider sliderUl"  sliderName="rs2">
		
		
		</ul>	
		</div>	
		</section>	
		</div>
		<!--/row-->

		<div class="sliderHead">
			<ul id="sliderHeadUl" style="list-style-type: none;">
				<li id="sliderHeadLi">Households Products</li>
			</ul>

		</div>
		<div id='sliderRow3' class="row row-flex  rowSlider">

		<section id='examples' class = "sec">
		<div id='content-6' class='content mThumbnailScroller _mTS_1 mTS-none content-6'>
		<ul id='rowSlider3'   class="row row-flex  rowSlider sliderUl"  sliderName="rowSlider3">
		
		</ul>
		</div>
		</section>

		</div>
		<!--/row-->



	</div>

<!--   ------------------------------------->

	<div class="container cont">
		<div class="row">
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">

						<img id="sBanner7"
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>

				</div>
			</div>
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">
						<img id="sBanner8"
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>

				</div>
			</div>
			<div class="col-sm-4 subBanner">
				<div class="panel panel-primary">
					<div class="panel-heading">SWAPKAT</div>
					<div class="panel-body mpbod">
						<img id="sBanner9"
							class="img-responsive" style="width: 100%; height: 250px"
							alt="Image">
					</div>

				</div>

			</div>
		</div>
	</div>



	<div id='sliderFluid' class="container fluid  sliderFluid">

		<!-- 
	 <div id='pd' class="paddles"> 
<button id='lp' class="left-paddle paddle" >
		<
		</button>
		 -->
		<div class="sliderHead">
			<ul id="sliderHeadUl" style="list-style-type: none;">
				<li id="sliderHeadLi">Fashion Accessories</li>
			</ul>
		</div>
		<div id='rowSlider21' class="row row-flex  rowSlider">


			<div id='panel21' class="panel panel-default sliderPanel ">

				<div class="panel-body  pbod">
					<img class="sliderBody"
						src="https://rukminim1.flixcart.com/image/312/312/jo1s8sw0/shoe/g/u/5/fb-804-o-7-nivia-orange-original-imafah7ywhxhzypp.jpeg?q=70">
					<ul class="sliderPannelBottom" style="list-style-type: none;">
						<li>Fastrack,Addidas,Titan</li>
						<li>offers upto 30% discount</li>
						<li>Watches</li>
					</ul>

				</div>

			</div>

		</div>
		<!--/row-->
		<!-- 
        <button id='rightPaddle' class="right-paddle paddle">
			>
		</button>
</div>
  -->
		<div class="sliderHead">
			<ul id="sliderHeadUl" style="list-style-type: none;">
				<li id="sliderHeadLi">SwapKart Electronics</li>
			</ul>
		</div>
		<div id='rowSlider22' class="row row-flex  rowSlider">


			<div id='panel22' class="panel panel-default sliderPanel ">

				<div class="panel-body pbod ">
					<img class="sliderBody"
						src="https://rukminim1.flixcart.com/image/832/832/jw9ke4w0/headphone/v/w/d/boat-rockerz-on-ear-510-original-imafgzh9gzcccuzy.jpeg?q=70">
					<ul class="sliderPannelBottom" style="list-style-type: none;">
						<li>Bluetooth Sound bars</li>
						<li>offers upto 10% discount</li>
						<li>Watches</li>
					</ul>

				</div>

			</div>

		</div>
		<!--/row-->
		<div class="sliderHead">
			<ul id="sliderHeadUl" style="list-style-type: none;">
				<li id="sliderHeadLi">Household Products</li>
			</ul>
		</div>
		<div id='rowSlider23' class="row row-flex  rowSlider">


			<div id='panel23' class="panel panel-default sliderPanel ">

				<div class="panel-body pbod  ">
					<img class="sliderBody"
						src="https://rukminim1.flixcart.com/image/832/832/j9d3bm80/mobile/f/y/v/apple-iphone-x-mqa92hn-a-original-imaeyysgqbg8qmhn.jpeg?q=70">
					<ul class="sliderPannelBottom" style="list-style-type: none;">
						<li>Kitchen Conatiners</li>
						<li>offers upto 50% discount</li>
						<li>Watches</li>
					</ul>

				</div>

			</div>

		</div>
		<!--/row-->



	</div>





	<!-- ----------------------------------------------------------------------------------- -->

	
	<div>
		<jsp:include page="footer.jsp" />
	</div>
	
	
	<!-- 
	
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

					<div class="col-sm-3 vl"></div>
				</div>

			</div>

			<div class="col-sm-4">
				<div class="col-sm-6">
					<ul class="footUl" style="padding-left: 0px">
						<li id="footHeadLi">Mail Us:</li>
						<li id="footBodyLi">SwapKart Internet Pvt Ltd Block B
							(Begonia), Ground Floor, Prestige Tech Park, Outer Ring Road,
							Whitefield, Varthur Main Road, Bengaluru East Taluk, Bengaluru
							District, Karnataka, India, 560103.</li>
					</ul>
				</div>
				<div class="col-sm-6">
					<ul class="footUl" style="padding-left: 0px">
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
		
		<h4 style="color:wheat;margin-bottom :5px;margin-top:15px">All Rights are Reserved by Lihal Tej.Kopparapu</h4>
		</div>
		

			

	</footer>
	
	
	
	
	 -->

<script>

//window.onload = loadHomeScreenData;
</script>


</body>
</html>