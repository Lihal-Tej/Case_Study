<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Testlabs Hr Out Sourcing</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" type="text/css" href="styles/main.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="scripts/login.js"></script>
 
 <!-- 
  <script var applicationUrl = '<c:url value = '/'   />'>   </script> 
	 -->
  <style>
  
    
body{
    overflow-x: hidden;
    overflow-y: hidden;
}
  
  </style>
  	
  	

</head>
<body class ='bg'>

<div class = 'row'>
<div class="col-sm-2">
</div>
<div class="col-sm-10">
</div>
</div>

<div class="fromDiv">
	
		
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
			
				<h3 class="text-center border border-secondary">Login</h3>
				<form action="/home.jsp" method="get">

					<div class="form-group">
						<label style="padding: 10px">Enter User Name :</label> <input
							style="padding: 10px" id="loginId" class="form-control"
							type="text" name="user" placeholder="Enter LoginId">
					</div>
					<div class="form-group">


						<label style="padding: 10px">Enter Password : </label> <input
							style="padding: 10px" id="password" class="form-control"
							type="password" name="pass" placeholder="Enter Password"/>

					</div>
					<div class="form-group">
						<a class="anchor" href="#">Forgetten Password ?.</a>
					</div>
					<div class="form-group text-center">
						<input id="loginButton" class="btn btn-primary btn-block "
							type="button" value="Login">
					</div>
					<div class="form-group text-center">
						<input class="btn btn-primary btn-block" type="button"
							value="Register"
							onclick="">

					</div>
				</form>
			</div>
			<div class="col-sm-1"></div>

		</div>
		
		

	</div>
</body>
</html>