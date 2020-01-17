

	<script src="http://localhost:8080/SwapKart/scripts/header.js">
	
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
</style>



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
								<li id='logout' style="margin:7px"><a  href="logout" style="padding:5px"><i class='fas fa-power-off' style='font-size:14px;color:#2873F0;margin-right:3px'></i>   Sign Out</a></li>
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


	<!--   ------------------------------------->


	<nav class="navbar navbar-inverse">
		<div class="row">
			<div class="navbar-header col-sm-4"></div>
			
			
			
			<div class="collapse navbar-collapse col-sm-4 " id="myNavbar">
			
			
			<div class="row">
				
				
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


	<!--   ------------------------------------->


