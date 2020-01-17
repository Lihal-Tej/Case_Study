<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
 <script type="text/javascript">
 
 function authenticate(){
	 
	
	
	var userType = '${userDetails.userAccess}';
	
	
	if(userType ==='A'){
		$("#userHomeLi").hide();
		$("#userSearchLi").hide();
		
	}else{
		$("#liAddBook").hide();
		$("#liAdminSearch").hide();
		$("#liViewChecked").hide();
		$("#liSystem").hide();
		$("#liUsers").hide();
	
	}
		
 }
 
 window.onload=authenticate;
 
 </script>   

  
<div class="jumbotron">
	<div class="row">
		<div class="col-sm-5">
				<i class="fas fa-apple-alt pull-left" style="color : #f2f2f2; font-size: 60px;" ></i>
		</div>
		<div class="col-sm-7">
		<h1 style="color : white">Apple Library</h1>
		
		</div>
	</div>
</div>

<nav class="navbar navbar-expand-sm  navbar-dark sticky-top">
 
  <ul class="navbar-nav mr-auto">
 
 <li id="liAddBook"  class="nav-item"><a class="nav-link" id="adminAddBook" href="adminAddBookk">Add Resource Data</a></li>
  <li id="liAdminSearch" class="nav-item"><a class="nav-link" id="adminSearch" href="adminSearch.jsp">Add Requirement Data</a></li>
   <li id="liViewChecked" class="nav-item"><a class="nav-link" id="viewCheckOut" href="viewCheckOut.jsp">Resource Search</a></li>
    <li id="liSystem" class="nav-item"><a class="nav-link" id="systemSettings" href="systemSettings.jsp">Requirement Search</a></li>
 <!-- 	<li id="liUsers" class="nav-item"><a  class="nav-link" id="adminAccept" href="adminAccept.jsp">Users Approval</a></li>
 	  <li id="userHomeLi" class="nav-item"><a class="nav-link" id="userHome" href="userHome.jsp">User Home</a></li>
  <li  id ="userSearchLi" class="nav-item"><a class="nav-link" id="userSearch" href="adminSearch.jsp">User Search</a></li>
   -->

    </ul>
  <ul class="navbar-nav" style="text-align:right">
  	 <li class="nav-item"><a class="nav-link"  href="<c:url value='/Logout'/>">Logout999</a></li>
  </ul>
</nav>




<div>
<ul style ="z-index:999;padding:5px;background-color : #555; width:100% ; height:35px;bottom:0;position : fixed ;margin-bottom:0px">
 <li style=" float:right ;color:#f1f1f1; margin-right:35px;padding :5px"> All Rights Reserved by Testlabs.inc</li>
 </ul>
</div>


