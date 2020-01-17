<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SwapKart/Cart</title>
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

<script src="http://localhost:8080/SwapKart/scripts/cart.js"></script>


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

#cartHeader{


    border: solid;
    border-color:white;
    margin-top:15px;
background-color:white;
padding-left:25px;
padding-top:16px;
padding-right:31px;
margin-bottom:1px;


}


.cart{

    font-family: Roboto,Arial,sans-serif;
    letter-spacing: 0;
    text-transform: uppercase;
    color: #212121;
    font-size: 18px;
    font-weight: 500;
    line-height: 1.4;

}

.productMain{

background-color:white;
padding-left:25px;
padding-top:16px;
padding-right:31px;

}

.pincode{

	width: 250px;
   
    border-bottom-color: blue;
    border-bottom-width: 3px;
    border-radius: 0px;
    border-left: gone;
    border-left-width: 0px;
    border-right-width: 0px;
    border-top-width: 0px;
    background-color: white;
    
    font-size: 18px;
    border-color: blue;
    -webkit-box-shadow: none;
    box-shadow: none;

}

input[class=pincode]:active {
      font-size: 18px;
    border-color: blue;
    -webkit-box-shadow: none;
    box-shadow: none;
}

.change{
	 border-color: blue;
    -webkit-box-shadow: none;
    box-shadow: none;
    font-weight: 500;
    cursor: pointer;
    font-size: 14px;
    color: #2874f0;
    margin-left: auto;
    position: relative;
    
    }
    
  a:focus, a:hover {
    color: blue;
    text-decoration:none;
    
}

.pincodeUl{

width:310px;
font-size:16px;
}

#productMain{

margin:0px;
}

.minus{

    display: inline-block;
    width: 30px;
    height: 30px;
    border-radius: 20px;
    background-color: white;
    border: 2px solid grey;
    font-size: 18px;


}

.quantity{

width:50px;
margin-left:8px;
margin-right:8px;
padding:5px;

}

.productUl{

    list-style: none;
    color: grey;
    padding: 0px;
    margin-top: 10px;

}

.productButton{

    background-color: white;
    color: black;
    border: 0px;
    font-size: 15px;
    text-transform: uppercase;
    font-style: bold;
    padding: 0px;
    font-weight: 590;
    font-family: Roboto,Arial,sans-serif;
    letter-spacing: 0;
    margin-right: 10px;


}

.row{

margin-left:0px;
margin-right:0px;
}



#priceDet{

    color: grey;
    text-transform: uppercase;
    font-weight: 500;
    font-size: 18px;
    font-family: Roboto,Arial,sans-serif;
    letter-spacing: 0;
    margin: 0px;
	padding-top:16px;padding-left:25px;padding-right:15px
}

.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width: 35%; /* Could be more or less, depending on screen size */
}

/* The Close Button */
.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

.modal-header {
  padding: 0px;
  color: black;
}



</style>
</head>
<body>

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



	<!--   ------------------------------------->
	
	<div class= "row">
	
	<div class="col-sm-8">
	
	<div class ="row">
	
	<div class ="col-sm-2">
	</div>
	
	<div id ="cartHeader" class="col-sm-10" >
	
	
	<span class="cart">My Cart(2)</span>
	
	
	<div class=" btn-group" style="float:right">
	
    <input id='address'  class=" pincode"  placeholder="56001" type="text" style="pointer-events:none">
    
    <a class="  dropdown-toggle change" data-toggle="dropdown" href="#">
        <span class="">Change</span>
    </a>
    
  
    
    <ul class="dropdown-menu pincodeUl">
        <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
        <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
        <li><a href="#"><i class="icon-ban-circle"></i> Ban</a></li>
      
        <li><a href="#"><i class="i"></i> Make admin</a></li>
    </ul>
	</div>

	
	</div>

	<div id="productStarts">
	<div id='productMain' class = "row">
	<div class="col-sm-2"></div>
	
	<div id='0product' class="col-sm-10"  style="background-color:white;padding:25px;margin-bottom:1px">
	
	
	<div  id="productBody" class = "row productBody">
	
	<div class="col-sm-2 left">
	<img id='mainImage' class="mainImg" style="width:120px;height:90px;object-fit: scale-down;" src ="https://rukminim1.flixcart.com/image/100/100/jc6jl3k0/sandal/6/m/b/ogd-0823110-43-woodland-camel-original-imaffdbz7s2bcbsp.jpeg?q=90"/>
	
	
	
	<div class="input-group" style="margin-top:65px;display: inline-flex;">
 	 <input id='0min' type="button" value="-" class="button-minus minus min " data-field="quantity">
 	  <input id ='0quantity' style="text-align:center" type="text" value="1" class="button-minus quantity" data-field="quantity">
 	    <input id ='quantity' style="text-align:center;display:none" type="text" value="1" class="button-minus quantity" data-field="quantity">
  	<input id='0max'  type="button" value="+" class="button-minus minus max" data-field="quantity">
  	
  	
  	<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
   <span class="close">&times;</span>
  <div class="modal-header">
    
    <h4>Delete Product</h4>
  </div>
   
    <p style="margin-top:15px;margin-bottom:15px">Are you sure You want to Remove Product ?</p>
    <div class="modal-footer">
    <div>
    <input id='removeProductCancel' type="button" class="btn btn-primary" style="dislplay:inline-block" value="Cancel"/>
    <input id='removeProductYes' type="button" class="btn btn-danger" style="dislplay:inline-block" value="Yes"/>
    </div>
  </div>
  </div>

</div>
  
  

	</div>
	</div>
	<!-- -------------------------------------------------------------Product Left Part -->
	<div class ="col-sm-6 middle">
	
	
	
	<h4 id="productName" style="margin:0px">Woodland Men Tan Sports Sandals</h4>
	<h4 id="123" style="margin:0px;display:none;color:darkred;">Oooopss Product is not Available...!!</h4>
	<ul class="productUl">
	
	<li>Size:8</li>
	<li id='sellar' style="margin-top:15px">Seller: RetailNet<img id='fAssured' src ="//img1a.flixcart.com/www/linchpin/fk-cp-zion/img/fa_8b4b59.png" style="width:55px;height:15px;margin-left:10px"/></li>
	</ul>
	
	<ul id='productPriceUl' style="list-style:none;padding:0px;margin-top:25px">
	
	<li id = 'price' style="font-size:22px;display:inline-block">$253</li>
	
	<li style="color:grey;display:inline-block;margin-left:5px;font-size:18px"><strike>$310</strike></li>
	
	<li style="color:green;display:inline-block;margin-left:5px;font-size:18px">35% off  <a style="color:green" src="#">2 Offers  Available <i class="fa fa-info-circle"></i> </a></li>
	
	
	</ul>
	
	<div id= 'bottomButtons' style="display:inline-block">
	
	<input id='saveForLater' class= "productButton" type="button" class="btn btn-primary" value="Save for Later">
	
	<input id='remove' class= "productButton remove" type="button" class="btn btn-primary" value="Remove">
	
	</div>
	
	</div>
	
	<!-- -------------------------------------------------------------Product Middle Part -->
	
	<div class="col-sm-4  right">
	
	<h4 style="margin:0px;font-size:16px;display:inline-block">Delivery by, Sat Jul 6 |<a style="color:green">Free </a><strike id='deliverySAvings'>$5</strike></h4>
	
	
	
	</div>
	
	</div>
	
	
	
	

	</div>
	
	
	
	
	
	
	</div><!-- ProductMain -->
	
	<div id='clone1' class="row">
	
	<div  class="col-sm-2">
	</div>
	
	<div id="clone">
	
	
	
	</div>
	
	
	</div>
	
	<div class="row">
	<div class="col-sm-2">
	</div>
	<div class="col-sm-10" style="background-color:white;height:90px">
	
	<div class="row">

	
	
	<input id='continueShopping' class="btn btn-primary" value="Continue Shopping" type="button" style="width:250px;background-color:white;border-radius:2px;height:55px;font-size:18px;border-color:blue;color:black;margin-left:50px;margin-top:15px"/>
	
	<input id ='placeOrder' class="btn btn-primary" value="Place Order" type="button" style="width:250px;background-color:#fb641b;height:55px;border-radius:2px;font-size:18px;border-color:#fb641b;color:white;margin-left:75px;margin-top:15px"/>
	
	
	</div>
	
	
	</div>
	</div>
	
	</div><!-- Product Starts -->
		
	
	
	
	</div>
	
	
	
	
	</div>
	
	
	
	
	
	
	
	<div class = "col-sm-4" style="padding:0px" >
	
	
	<div class="row">
	<div class="col-sm-8" style="background-color:white;height:310px;margin-top:15px;padding:0px">
	
	<h4 id="priceDet" style="color:grey">Price Details</h4>
	<hr>
	
	<ul style="list-style:none;padding-left: 25px;font-size: 16px;">
	<li style="display:inline-block">Price(2 items)</li>
	<li id='totalPrice' style="float:right;margin-right:25px">$506.00</li>
	
	</ul>
	<ul style="list-style:none;padding-left: 25px;font-size: 16px;margin-top:20px;margin-bottom:30px;">
	<li style="display:inline-block">Delivery Charges</li>
	<li style="float:right;margin-right:25px">FREE</li>
	
	</ul>
	
	<div style="margin-left:25px;margin-right:25px;">
	
	<hr style="border-top: dotted 1px;" />
	
	</div>
	
	<ul style="list-style:none;padding-left: 25px;font-size: 16px;margin-top:20px;margin-bottom:30px;">
	<li style="display:inline-block">Amount Payable</li>
	<li id='finalPrice' style="float:right;margin-right:25px">$506.00</li>
	
	</ul>
	
	<hr>
	
	<div>
	<h4 style="padding-left:25px;    justify-content: space-between;
    border-radius: 2px;color: #388e3c;font-weight: 500;font-family: Roboto,Arial,sans-serif;letter-spacing: 0;line-height: 1.4;">You total Saving on this order $25</h4>
	</div>
	</div>
	

	
	</div>
	
	<div class="row" style="padding:0px">
	<div class="col-sm-8" style="margin-left:25px;margin-top:25px;padding:0px;display:inline-flex">
		<img src="//img1a.flixcart.com/www/linchpin/fk-cp-zion/img/shield_a7ea6b.png" style="width:40px;height:40px">
		<div style="margin-left:15px">
		<a style="color:grey;">Safe and Secure Payments. Easy returns. 100% Authentic products.</a>
		</div>
	
	</div>
	
	
	</div>
	
	
	</div>
	
	
	
	
	
	
	</div>
	
	





</body>

<script type="text/javascript">
  $('#confirmDelete').on('show.bs.modal', function (e) {
      $message = $(e.relatedTarget).attr('data-message');
      $(this).find('.modal-body p').text($message);
      $title = $(e.relatedTarget).attr('data-title');
      $(this).find('.modal-title').text($title);
 
      // Pass form reference to modal for submission on yes/ok
      var form = $(e.relatedTarget).closest('form');
      $(this).find('.modal-footer #confirm').data('form', form);
  });
 
  <!-- Form confirm (yes/ok) handler, submits form -->
  $('#confirmDelete').find('.modal-footer #confirm').on('click', function(){
      $(this).data('form').submit();
  });
</script>

</html>