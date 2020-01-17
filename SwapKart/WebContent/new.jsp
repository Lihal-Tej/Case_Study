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




.container{
margin-left:0px;
margin-right:0px;

}



.o{

width:1600px;
height:300px;
 overflow-x : hidden;
   white-space: nowrap;

}
	$('#o').scrollLeft($('#o').scrollLeft()+300);

.paddle {
	position: absolute;
	top: 0;
	bottom: 0;
	width: 3em;
}
.left-paddle {
	margin-top:75px;
	height:150px;
	background-color : #ffffff;
	color:#000;
	
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
</style>


</head>
<body>


<div id="container" class="container">
<div id='s' class = "section">

<div id='pd' class="paddles"> 
<button id='lp' class="left-paddle paddle hidden " value='<'>
		
		</button>
  <div id='o' class="row row-flex  o" >
  

		
		
  
  

  	  <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>

    
      <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       
         <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       
       
       
         <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       
       
         <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
    
    
    
    
	
    

  	  <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>



		  	  <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
         	  <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
         	  <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
         	  <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       
       <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       
       <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       
       <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       
       <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
       
       
       
       <div class="panel panel-default ">
       <div class="panel-heading">Title flex-col</div>
       <div class="panel-body  ">Content here -- div with . </div>
       <div class="panel-footer">Footer</div>
       </div>
    
    <button id='rightPaddle' class="right-paddle paddle">
			>
		</button>
		
	
    
  	
  </div><!--/row-->
  
  </div>
  </div><!-- Section -->
  
  
  
</div><!--/container-->

</body>


</html>