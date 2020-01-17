
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet"
	
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/main.css">
  <script>var applicationUrl = '<c:url value = '/'   />';   </script>

<script src="scripts/register.js">

</script>


</head>

<body class="by">

<div class="fromDiv">
	<h3 class="text-center border border-secondary">Register</h3>
	<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
<form id="form0" action="NewUser" method="post">

<div class="form-group">
<input id="loginId"  class="form-control" type="text" name="loginId" placeholder="Enter Your Name">
</div>

<div class="form-group">
<input  id="emailId" class="form-control" type="text" name="emailId" placeholder="Enter EmailId">
</div>
<div class="form-group">
<input id="address"  class="form-control" type="text" name="address" placeholder="Enter Address">
</div>
<div class="form-group">
<input id="userNo"  class="form-control" type="text" name="userNo" placeholder="Contact Number">
</div>
<div class="form-group">
<input  class="form-control" id="pass" type="password" name="password" placeholder="Enter Password">
</div>
<div class="form-group">
<input  class="form-control" id="cPass" type="password" name="confrimPassword" placeholder="Confrim Password">
</div>
<div class="form-group text-center">
<input id= "regBtn" style="margin-top:10px"class ="btn btn-primary" type="button" value="Register" >
</div>
</form>
</div>
<div class="col-sm-1"></div>
</div>
 </div>
</body>
</html>