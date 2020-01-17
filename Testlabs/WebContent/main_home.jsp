<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>   
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script src="scripts/mainhome.js"> </script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   
    
   
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheethref="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"crossorigin="anonymous">
	<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
			
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
	
	
	<c:if test="${ empty user }">
		<c:redirect url= 'login.jsp' />
		
	</c:if>

<title>Home</title>

<style>
body{
    overflow-x: hidden;
}
  

    .carousel-control.right, .carousel-control.left {
  background-image: none;
  color: #f4511e;
}

.carousel-indicators li {
  border-color: #f4511e;
}

.jumbotron{

padding-left:32px;
padding-right:32px;
padding-top:64px;
padding-bottom:64px;

}

.carousel-indicators li.active {
  background-color: #f4511e;
}


</style>

</head>
<body>



<div>
		<jsp:include page="menu.jsp" />
	</div>
		
  <div id="myCarousel" class="carousel slide text-center" data-ride="carousel" style="background-color: #f6f6f6;height:240px">
    <!-- Indicators -->
  
   <h2 style="text-align:center;background-color: #f6f6f6;padding-top:20px" style="background-color: #f6f6f6;font-family:sans-serif">Urgent Requirements</h2>

    <!-- Wrapper for slides -->
    <div id="mainBanner" class="carousel-inner" role="listbox" style="margin-top:45px">
     
     <!-- <div class="item active">
        <h4 id ="first_h" style="font-family:sans-serif;font-style:unset">Infosys</h4>
      </div>
      <div class="item">
        <h4 style="font-family:sans-serif;font-style:unset">Cognizant</h4>
      </div>
      <div class="item">
        <h4 style="font-family:sans-serif;font-style:unset">Unilever</h4>
      </div>
      
      -->
      
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</body>
</html>