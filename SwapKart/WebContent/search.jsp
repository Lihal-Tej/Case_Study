<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SwapKart/Search</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <script>var applicationUrl = '<c:url value = '/'   />';   </script>
<script src="http://localhost:8080/SwapKart/scripts/search.js"></script>



<style>
body {
	background-color: #e6e6e6;
}

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

.productsSection {
	padding-left: 0px;
	padding-right: 0px;
	margin-top: 5px;
}

.row {
	margin: 0px;
}

.panel {
	margin-bottom: 1px;
	border: 0px;
}

.productName {
	padding-left: 0px;
	color: blue;
	font-size: 18px;
}

.productImage {

	width:300px;
	height: 280px;
	object-fit: scale-down;
	padding-right: 45px;
	padding-left: 0px;
	padding-top: 25px;
	padding-bottom: 25px;
}

.ratings {
	background-color: green;
	color: white;
	width: fit-content;
}

.filterSection {
	padding-right: 8px;
	padding-left: 8px;
}

.filterMain {
	background-color: white;
	height: 690px;
	margin-top: 5px;
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


.rs {
	margin: 0px;
}
</style>

</head>
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
			<div class="col-sm-4"></div>
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
					<button class="btn btn-primary dropdown-toggle dropbtn" 
						data-toggle="dropdown" style="background-color:white;color:black;border:0px">
						Electronics<span class="caret" style="color:grey"></span>
					</button>
					<ul id="ulDrop1" class="dropdown-menu">
						
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
	<!--   ------------------------------------->
	<div>
		<jsp:include page="header.jsp" />
	</div>
	<!--   ------------------------------------->

	<!--   ------------------------------------->

	<div class="row"></div>

	<div class="row">

		<div class="col-sm-2 row filterSection">

			<div class="col-cm-11 filterMain">

			<div id='priceRow' class="row">
			<ul style="list-style: none;margin-left:5px; font-size: 24px; padding-left: 0px;">
					<li>Price</li>
				</ul>
				<div class="row" style="margin-top:30px;">

					<div class="col-sm-2" style="padding-left:0px;margin-left:5px">
					<input id="minPrice" type="text" style="width:40px" id="minPriceFilter" value="0" maxlength ="4">
					
					</div>
					<div class="col-sm-6" style="padding-right: 0px;margin-left : 2px">
					
					<label style="font-size : 10px">Select the Price Range</label>
					</div>
					<div class="col-sm-2" style="padding-left : 0px;">
					<input id="maxPrice" type="text" style="width:40px" id="minPriceFilter" value="0" maxlength ="4">
					
					</div>
					

			</div>
			</div>

			<div id='brandRow' class="row" style="margin-left: 5px">

				<ul style="list-style: none; font-size: 24px; padding-left: 0px;margin-top:20px">
					<li>Brands</li>
				</ul>
				<form id ='brandForm'>
					
				</form>
			</div>


			<div id='ratingRow' class="row" style="margin-left: 5px">

				<ul style="list-style: none; font-size: 24px; padding-left: 0px;margin-top:20px">
					<li>Ratings</li>
				</ul>
				<form>
					<div class="checkbox">
						<label><input name ="rating" type="checkbox" value="5">5 Star</label>
					</div>
					<div class="checkbox">
						<label><input name ="rating" type="checkbox" value="4">4 Star</label>
					</div>
					<div class="checkbox ">
						<label><input name = "rating" type="checkbox" value="3">3 Star</label>
					</div>
					<div class="checkbox">
						<label><input name ="rating" type="checkbox" value="2">2 Star</label>
					</div>
					<div class="checkbox">
						<label><input name ="rating" type="checkbox" value="1">1 Star</label>
					</div>
				</form>
			</div>



			<div id='osRow' class="row" style="margin-left: 5px">

				<ul style="list-style: none; font-size: 24px; padding-left: 0px;margin-top:20px">
					<li>OS</li>
				</ul>
				<form>
					<div class="checkbox">
						<label><input name ="os" type="checkbox" value="IOS">IOS</label>
					</div>
					<div class="checkbox">
						<label><input name ="os" type="checkbox" value="Android">Android</label>
					</div>
					<div class="checkbox ">
						<label><input name ="os" type="checkbox" value="BBM">BBM</label>
					</div>
					<div class="checkbox">
						<label><input name ="os" type="checkbox" value="Windows">Windows</label>
					</div>

				</form>
			</div>

			<div style="align: center" class="form">

				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-4" style="margin-top:20px;">
					
					<input id ='applyFilter' type="button" class="btn btn-success" value="Apply">
					</div>
					<div class="col-sm-4"></div>
				
				</div>


			</div>





		</div>

	</div>

	<div id= 'productSection' class="col-sm-10 productsSection">

		


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




</body>
</html>