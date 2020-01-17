<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  
	  
	  
	  <script src="http://localhost:8080/SwapKart/scripts/paddles.js">
	</script>
	  
<style>

.row-flex, .row-flex > div[class*='col-'] {  
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    flex:1 1 auto;
    width:100%;
}


.o{
top: 0;
width:1600px;
height:300px;
 overflow-x : hidden;
   white-space: nowrap;

}

.p{
    height: 300px;
    margin-bottom: 0px;
border : 2px,solid;

}

.bod{


height:200px;

}

.paddle {
	
	top: 0;
	bottom: 0;
	width: 3em;
}
.left-paddle {
	margin-top:75px;
	height:150px;
	background-color : #ffffff;
	color:#000;
	visibility : hidden;
	left: 0;
}
.right-paddle {

	margin-top:75px;
	height:130px;
	background-color : #ffffff;
	color:#000;
	right: 0;
	border :2px,solid;
	}
	
.pf{
background : #ffffff;
}	


</style>

</head>
<body>

<!--  
  <div id='pd' class="paddles"> 
<button id='lp' class="left-paddle paddle" >
		<
		</button>
		
-->
 <div id='o' class="row row-flex  o" >


	  <div class="panel panel-default p ">
       
       <div class="panel-body  ">
       <img class="bod" src="https://rukminim1.flixcart.com/image/300/300/j8rnpu80/watch/d/5/y/b172-casio-original-imaeymgrxhfmnw6f.jpeg?q=70">
       </div>
       <div class="panel-footer pf">
       <ul  style="list-style-type:none;">
       <li>Fastrack,Addidas,Titan</li>
       <li>offers upto 30% discount </li>
       </ul>
       </div>
       </div>
       
       <div class="panel panel-default p">
       
       <div class="panel-body  ">
       <img class="bod" src="https://rukminim1.flixcart.com/image/300/300/j8rnpu80/watch/d/5/y/b172-casio-original-imaeymgrxhfmnw6f.jpeg?q=70">
       </div>
       <div class="panel-footer pf">
       <ul  style="list-style-type:none;">
       <li>Fastrack,Addidas,Titan</li>
       <li>offers upto 30% discount </li>
       </ul>
       </div>
       </div>
       
       
       <div class="panel panel-default p">
       
       <div class="panel-body  ">
       <img class="bod" src="https://rukminim1.flixcart.com/image/300/300/j8rnpu80/watch/d/5/y/b172-casio-original-imaeymgrxhfmnw6f.jpeg?q=70">
       </div>
       <div class="panel-footer pf">
       <ul  style="list-style-type:none;">
       <li>Fastrack,Addidas,Titan</li>
       <li>offers upto 30% discount </li>
       </ul>
       </div>
       </div>
       
       
  
 

	
    
  	
  </div><!--/row-->
  
  <!-- 
  <div id='pd' class="paddles"> 
   <button id='rightPaddle' class="right-paddle paddle">
			>
		</button>
</div>
  -->   


</body>
</html>