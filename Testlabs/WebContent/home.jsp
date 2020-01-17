<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Candidate Client Details</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>   
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script src="scripts/home.js"> </script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   
    
   
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheethref="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"crossorigin="anonymous">
	<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
			
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
	
	
	<c:if test="${ empty user }">
		<c:redirect url= 'login.jsp' />
		
	</c:if>

  
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

.item h4 {
  font-size: 19px;
  line-height: 1.375em;
  font-weight: 400;
  font-style: italic;
  margin: 70px 0;
}

.item span {
  font-style: normal;
}

.label_headers{

	color: #f4511e;
    font-size: 13px;
    font-family: sans-serif;
    vertical-align: bottom;
    margin-top: 10px;

}

.form_cand{

height:40px;
width:100%;
font-size:13px;
font-family: sans-serif;
margin-bottom:15px;
}

* entire container, keeps perspective */
.card-container {
	  -webkit-perspective: 800px;
   -moz-perspective: 800px;
     -o-perspective: 800px;
        perspective: 800px;
        margin-bottom: 30px;
}
/* flip the pane when hovered */
.card-container:not(.manual-flip):hover .card,
.card-container.hover.manual-flip .card{
	-webkit-transform: rotateY( 180deg );
-moz-transform: rotateY( 180deg );
 -o-transform: rotateY( 180deg );
    transform: rotateY( 180deg );
}


.card-container.static:hover .card,
.card-container.static.hover .card {
	-webkit-transform: none;
-moz-transform: none;
 -o-transform: none;
    transform: none;
}
/* flip speed goes here */
.card {
	 -webkit-transition: -webkit-transform .5s;
   -moz-transition: -moz-transform .5s;
     -o-transition: -o-transform .5s;
        transition: transform .5s;
-webkit-transform-style: preserve-3d;
   -moz-transform-style: preserve-3d;
     -o-transform-style: preserve-3d;
        transform-style: preserve-3d;
	position: relative;
}

/* hide back of pane during swap */
.front, .back {
	-webkit-backface-visibility: hidden;
   -moz-backface-visibility: hidden;
     -o-backface-visibility: hidden;
        backface-visibility: hidden;
	position: absolute;
	top: 0;
	left: 0;
	background-color: #FFF;
    box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.14);
}

/* front pane, placed above back */
.front {
	z-index: 2;
}

/* back, initially hidden pane */
.back {
		-webkit-transform: rotateY( 180deg );
   -moz-transform: rotateY( 180deg );
     -o-transform: rotateY( 180deg );
        transform: rotateY( 180deg );
        z-index: 3;
}

.back .btn-simple{
    position: absolute;
   
}
/*        Style       */


.card{
    background: none repeat scroll 0 0 #FFFFFF;
    border-radius: 4px;
    color: #444444;
}
.card-container, .front, .back {
	width: 100%;

	border-radius: 4px;
	-webkit-box-shadow: 0px 0px 19px 0px rgba(0,0,0,0.16);
-moz-box-shadow: 0px 0px 19px 0px rgba(0,0,0,0.16);
box-shadow: 0px 0px 19px 0px rgba(0,0,0,0.16);
}
.card .cover{
   
    overflow: hidden;
    border-radius: 4px 4px 0 0;
}
.card .cover img{
    width: 100%;
}
.card .user{
    border-radius: 50%;
    display: block;
    height: 120px;
    margin: -55px auto 0;
    overflow: hidden;
    width: 120px;
}

.theader{

padding:0px;
margin:0px;
}
.skillsheader{
margin-right:0px;
margin-left:0px;

}

.thead{
width:100%;
height:35px;
border:2px;
border-color:#383838;
border-style:solid;
font-size: 16px;
    text-align: center;
    font-family: sans-serif;
}

.my-bg{
background-color:#303030;
}

.headers{

font-family:sans-serif;font-style:unset
}

  </style>
  
  <script>
  


  /*
  $('.datepicker').pickadate({
	format: 'dd mmm, yyyy',
	formatSubmit: 'mm/dd/yyyy',
	hiddenPrefix: 'prefix__',
	hiddenSuffix: '__suffix'
	});*/
  
  </script>
  
</head>
<body>


	<div>
		<jsp:include page="header.jsp" />
	</div>
	
  
  <!-- ----------------------------Main Fomr------------------------------------------- -->
  
		<div style="height:15px;width:100%;backgorund-color:white">
			
		<span></span>
	</div>
	<!-- ----------------------------Main Fomr------------------------------------------- -->

    <div class="card-container manual-flip">
<div id="card1"  class = "card my-bg" style="margin-left:150px;margin-right:150px">

	
	<div id="front" class="face front my-bg">
	
	<div>
		<h2 id='login' style="text-align: center;color: #f4511e;margin-bottom:50px;margin-top:35px;font-family:sans-serif">Add New Candidate</h2>
	</div>
	
	<!-- <form commandName="product" action="save-product" method="post" enctype="multipart/form-data">  -->
	<div class="row my-bg" style="margin-bottom:50px;margin-left: 5px;margin-right: 5px;">
	

	<div class= "col-sm-6">
	
	<div class="row">
	<div class="col-sm-2">
	</div>
	
	
 
	<div class="col-sm-8">
	

	
  <div class="form-group">
  
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Candidate Name</label>
    <div class="col-sm-8"> 
  		<input type="text" class="form-control form_cand " id="cand_name" placeholder="Candidate Name">
    </div>
  </div>
  
  <div class="form-group">
  
  	<label for="inputPassword" class="col-sm-4 control-label label_headers">Candidate Number</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="cand_number" placeholder="Candidate Number">
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Candidate Email</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="cand_email_id" placeholder="Candidate Eamil Id">
    </div>
  </div>
  
   <div class="form-group">
   
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Account Name</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="cand_account_name" placeholder="Candidate Account Name">
    </div>
  </div>
  
  <div class="form-group">
  
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Expected Joining</label>
    <div class="col-sm-8"> 
      <input class="form-control form_cand datepicker"  type="text"  data-date-format="MM/DD/YYYY" id="cand_expcted_joining" placeholder="Expected Joining">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">OnBoard Status</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="cand_on_board_status" placeholder="On Board Status">
      
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Upload Resume</label>
    <div class="col-sm-8"> 
    
     <form  id='resume_form' action="uploadResume" method="post" enctype="multipart/form-data">
      <input type = "file" class="form-control form_cand" name = "file"    id="cand_experiance_skills" placeholder="Experiance Skills">
      
      <input type = "text" id="cand_id" name = "candidateId"  class="form-control form_cand"  style="display : none"   placeholder="Experiance Skills">
      <input type = "submit" class="btn btn-primary" style="display:none">
      </form>
      
    </div>
  </div>
  
     <div class="form-group">
     <label for="inputPassword" class="col-sm-4 control-label label_headers">Additional Skills</label>
    <div class="col-sm-8"> 
      <input type="text"  data-role="tagsinput" class="form-control form_cand" id="cand_additional_skills" placeholder="Addtional Skills">
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Billing start Date</label>
    <div class="col-sm-8"> 
      <input   data-role="tagsinput" type="text" class="form-control form_cand datepicker" id="cand_billing_start_date" placeholder="Billing Start Date">
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Billing End Date</label>
    <div class="col-sm-8"> 
      <input   data-role="tagsinput" type="text" class="form-control form_cand datepicker" id="cand_billing_end_date" placeholder="Billing End Date">
    </div>
  </div>
  

  
  

	</div>
	<div class="col-sm-2">
	</div>
	</div>
	
	
	
	</div>
	
	<div class= "col-sm-6">
	
	
	<div class="row">
		<div class="col-sm-2">
	</div>
	
	<div class="col-sm-8">

  <div class="form-group ">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Location Preference</label>
    <div class="col-sm-8">
      <input type="text" class="form-control form_cand" id="cand_location_preference" placeholder="Location Preference">
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Location</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="cand_location" placeholder="Location">
    </div>
  </div>
  
   <div class="form-group">
   
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Duration</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="cand_duration" placeholder="Duration">
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Notice Period</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="cand_notice_period" placeholder="Notice Period">
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Current Company</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="cand_current_company" placeholder="Current Company">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Candidate Salary</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="cand_current_salary" placeholder="Current Salary">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Expected Salary</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="cand_expected_salary" placeholder="Expected  Salary">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Candidate Status</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="cand_candidate_status" placeholder="Candidate Status">
      
    </div>
  </div>
  
  <div class="form-group">
  
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Invoice Start Date</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand datepicker"    id="cand_inovice_start_date" placeholder="Invoice Start Date">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Client Salary</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="cand_client_salary" placeholder="Client Salary">
      
    </div>
  </div>

  
  
 

	</div>
	<div class="col-sm-2">
	
	  
 <button class="btn btn-simple btn-primary" type="button" rel="tooltip"  title = "Go to Client Details" onclick="rotateCard(this)" style="background-color: #f4511e;color: white;border-color: #f4511e;font-size: 14px;">
  <i class="glyphicon glyphicon-share-alt"></i> Client Details
 </button> 
	
	
	</div>
	
	</div>
	
	</div>
	
	
	</div>
	<!-- </form> -->
	
			<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
	
	
	<button id ='add_Skill' style="margin-bottom:20px;font-size:13px;font-family:sans-serif" class="btn btn-secondary" style="float:right" value="+ Add New Skill">+Add  Skill</button>
		<button id ='new_skill' style="margin-bottom:20px;font-size:13px;font-family:sans-serif" class="btn btn-secondary" style="float:right" value="+ Add New Skill">New Skill</button>
	
	
	
	
	<div class="add_skill">
	
	<div class="row">
	<div class="col-sm-8">
	<input id="skill_name" type="text" class="thead" style="display:none" value="" placeholder ="Enter New Skill" />
	</div>
	<div class="col-sm-4">
	<button id = 'skill_save' class="btn btn_primary thead" value="Type"   style="border-color:#5d4da8;color:white;background-color:#5d4da8;display:none" >Save</button>
	</div>
	</div>
	
	</div>
	
	
	 
	
		
	<div id="skill_main" class="main" style="margin-top:20px">
		
		<div id="skillsheader" class="row skillsheader" >
			<div class="col-sm-4 theader">
			<input type="text" class="thead"  value="Skill" readonly/>
			
			</div>
			<div class="col-sm-4 theader">
			<input type="text" class="thead" value ="Duration" readonly/>
			</div>
			<div class="col-sm-4 theader">
			<input type="text" class="thead" value="Type" readonly/>
			</div>
		
		</div>
	
		<div id='row1' class="row skillbody skillsheader" >
		<div class="col-sm-4 theader">
			<input id='row1_skill' type="text" class="thead skill"  value="" placeholder="Skill Name" style="display:none"/>
			<select id="city" class="city thead skill_dummy skill" >
                                        <option value="0" selected>All Snippets</option>
                                        <option value="1">Featured</option>
                                        <option value="2">Most popular</option>
                                        <option value="3">Top rated</option>
                                        <option value="4">Most commented</option>
                                    </select>
			</div>
			<div class="col-sm-4 theader">
			<input id='row1_duration' type="text" class="thead duration" value ="" placeholder ="Duration" />
			</div>
			<div class="col-sm-4 theader">
			<input id='row1_type' type="text" class="thead type" value="" placeholder ="Primary/Secondary" />
			</div>
		</div>
		
		<div id='rowDummy' class="row  skillsheader" style="display:none">
		<div class="col-sm-4 theader">
			<input  type="text" class="thead skill_dummy skill" style="display:none"  value="" placeholder="Skill Name"/>
			<select class="city thead skill_dummy skill">
                                        <option value="0" selected>All Snippets</option>
                                        <option value="1">Featured</option>
                                        <option value="2">Most popular</option>
                                        <option value="3">Top rated</option>
                                        <option value="4">Most commented</option>
                                    </select>
			
			</div>
			<div class="col-sm-4 theader">
			<input  type="text" class="thead duration_dummy duration" value ="" placeholder ="Duration" />
			</div>
			<div class="col-sm-4 theader">
			<input  type="text" class="thead type_dummy type" value="" placeholder ="Primary/Secondary" />
			</div>
		</div>
	 </div>
	 
	 
	 
	 
	 <button id="cand_save"  type="button" class="btn btn-secondary" style="text-align: center;width:100%;height:40px;font-size:18px;margin-top:50px;margin-bottom:40px">Save </button>
	
	 </div>
	 <div class="col-sm-2"></div>
	</div>
	
	
	</div>
	
	<div id="back" class= "face back my-bg">
	<div>
		<h2 id='login' style="text-align: center;color: #f4511e;margin-bottom:50px;margin-top:35px;font-family:sans-serif">Add New Client</h2>
	</div>
	
	<div class="row my-bg" style="margin-bottom:50px;margin-left:5px;margin-right:5px">
	

	<div class= "col-sm-6">
	
	<div class="row">
	<div class="col-sm-2">
	
	
	
	<button class="btn btn-simple btn-primary" rel="tooltip" style="background-color: #f4511e;color: white;border-color: #f4511e;font-size: 14px;margin-left:-30px" title="Go to Candidate Details" onclick="rotateCard(this)">
                                <i class="fa fa-reply"></i> Candidate Details
</button>
	
	</div>
	<div class="col-sm-8">
	

 
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Client Name</label>
    <div class="col-sm-8"> 
		<input type="text" class="form-control form_cand" id="client_name" placeholder="Client Name">
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Mandatory Skills</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="mandatory_skills" placeholder="Mandatory Skills">
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Additional Skills</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="additional_skills" placeholder="Additional Skills">
    </div>
  </div>
  
  <div class="form-group" >
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Total Positions</label>
    <div class="col-sm-8"> 
      <input type="text"  data-role="tagsinput" class="form-control form_cand"  id="total_positions" placeholder="Total Positions">
    </div>
  </div>
  
  
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Sourcing rate</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="sourcing_rate" placeholder="Sourcing Rate">
      
    </div>
  </div>
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Type</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="type" placeholder="Type">
      
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Profiles Shared</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="profiles_shared" placeholder="Profiles Shared">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Hierarchy</label>
    <div class="col-sm-8"> 
      <!-- <input type="text"  data-role="tagsinput" class="form-control form_cand" id="pwd" placeholder="Addtional Skills"> -->
  <select class="form-control" id="imp">
        <option name="1" title="Faster">High</option>
        <option name ="2">Medium</option>
        <option name ="3">Light</option>
      </select>
      
    </div>
  </div>
  
  
   <div class="form-group" style="display:none">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Total Positions</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="total_positions" placeholder="Total Positions">
    </div>
  </div>


	</div>
	<div class="col-sm-2">
	</div>
	</div>
	
	
	
	</div>
	
	<div class= "col-sm-6">
	
	
	<div class="row">
		<div class="col-sm-2">
	</div>
	
	<div class="col-sm-8">

  <div class="form-group ">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Screen Reject</label>
    <div class="col-sm-8">
      <input type="text" class="form-control form_cand" id="screen_reject" placeholder="Screen Reject">
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Tech Interview</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="tech_interview" placeholder="Tech Interview">
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Tech Rejects</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="tech_rejects" placeholder="Tech Rejects">
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Final Select</label>
    <div class="col-sm-8"> 
      <input type="text" class="form-control form_cand" id="final_select" placeholder="Final Select">
    </div>
  </div>
  
   <div class="form-group">
   <label for="inputPassword" class="col-sm-4 control-label label_headers">Experience</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand" type ="text"    id="client_candidate_state" placeholder="Experience">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Joining Date</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand datepicker" type ="text"    id="joining_date" placeholder="Joining Date">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Location</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="location_client" placeholder="Location">
      
    </div>
  </div>
  
  <div class="form-group">
  <label for="inputPassword" class="col-sm-4 control-label label_headers">Client Rate</label>
    <div class="col-sm-8"> 
      <input  class="form-control form_cand"    id="client_rate" placeholder="Client Rate">
      
    </div>
  </div>
  
  
  
  

  
  
 

	</div>
	<div class="col-sm-2">
	</div>
	
	</div>
	
	</div>
	
	
	</div>
	
	<div class="row">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
	 <button id="client_save"  type="button" class="btn btn-secondary" style="text-align: center;width:100%;height:40px;font-size:18px;margin-top:50px;margin-bottom:40px">Save </button>
	
	 </div>
	 <div class="col-sm-2"></div>
	</div>
	
	
	
	
</div>
<div class="col-sm-4">
</div>
	
	</div>







<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">



</div>




</div>


	
 </div> <!-- end card-container -->
   

<!-- -------------------------------------------------------------------- -->


	 

<!-- ----------------------------Main Completed------------------------------------------- -->
	
	

</body>
</html>
