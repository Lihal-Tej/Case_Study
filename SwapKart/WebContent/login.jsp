
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SwapKart Login</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
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
<script src="scripts/login.js">
	
</script>

</head>

<body class="by">

	<div class="fromDiv">
		<h3 class="text-center border border-secondary">Login</h3>
		
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<form action="login" method="post">

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
							onclick=" window.open('<c:url value="/register.jsp"/>','_self')">

					</div>
				</form>
			</div>
			<div class="col-sm-1"></div>

		</div>

	</div>
	<script type="text/javascript">
		var result =
	<%=(String) request.getAttribute("Failed")%>
		var invalidUsage =
	<%=(String) request.getAttribute("InvalidUsage")%>
		
	</script>
</body>
</html>