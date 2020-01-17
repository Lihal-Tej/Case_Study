<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	

<link rel="stylesheet" type="text/css" href = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href= "https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" />
<link rel="stylesheet" type="text/css" href= "https://cdn.datatables.net/buttons/1.5.6/css/buttons.bootstrap4.min.css" />

<link rel="stylesheet" type="text/class" href="https://cdn.datatables.net/select/1.3.0/css/select.dataTables.min.css"/>

<link rel ="stylesheet" type="text/class"  href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
    
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    

<script src = "https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src = "https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<script src =  "https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
<script src =  "https://cdn.datatables.net/buttons/1.5.6/js/buttons.bootstrap4.min.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src = "https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>
<script src =  "https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js"></script>
<script  src ="https://cdn.datatables.net/buttons/1.5.6/js/buttons.colVis.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

 <script src="scripts/clientsearch.js"> </script>
 
   <script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
	
	 <link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"/>
	
<c:if test="${ empty user }">
	<c:redirect url= 'login.jsp' />
	
</c:if>
<title>Client Search</title>

<style>

.thead{
width:100%;
height:35px;
border:2px;
border-color:#5d4da8;
border-style:solid;
font-size: 14px;
padding-left:5px;
font-family: sans-serif;
text-align:intial;
}

.jumbotron p {

    margin-bottom: 15px;
    font-size: 21px;
    font-weight: 200;
}



.jumbotron h1{

margin-bottom:5px;
font-size:63px;
}
.mainSearch{

padding:0px;
}
.mainSearchBody{

background-image:
		url("http://hrportal-env.icixrbvia3.us-east-2.elasticbeanstalk.com/Images/hr_client_search_bg.jpg");
	
}


.form_main{

background:rgba(0,0,0,.5);
}


 .navbar {
   	border-radius: 0;
      margin-bottom:0px;
    }
    
    .nav-block{
    
    padding:0px;
    font-size:18px;
    }
    
    
    .dropdown_placeholder{
color:grey;
font-family:sans-serif;
font-size:14px;
padding-left:5px;
}

.dropdown_selected{
color:black;
font-family:sans-serif;
font-size:13px;
padding-left:5px;
}


    .form_cand{

height:40px;
width:100%;
font-size:13px;
color:black;
font-family: sans-serif;
margin-bottom:15px;
}

  
    .labelHeader{
    font-size:13px;
    color:black;
font-family: sans-serif;
    	
    }


body{
    overflow-x: hidden;
}

.modal_cutsom_width{

width:1020px;
max-width:1020px;

}

</style>


</head>
<body>

<div><jsp:include page="header.jsp" /></div>

<div class="mainSearchBody" style="width:100%;height:280px">

<div class ="container" style="height:60px;">
</div>

<div class="container form_main" style="margin-top:00px;height:50px;">

</div>
<div class="container form_main" style="height:100px;">
<div class="row" style="margin-left:10px;margin-right:10px">
<div class ="col-sm-4 mainSearch">

<input id="skill" type="text" class="thead" value="" placeholder="search by skill"/>
</div>

<div class ="col-sm-3 mainSearch">
<input id="companyName" type="text" class="thead" value="" placeholder ="search by company" />

</div>

<div class ="col-sm-3 mainSearch">
<input id='experiance' type="text" class="thead skill"  value="" placeholder="Experaince" style="display:none"/>
			<select id="city" class="city thead skill_dummy skill" >
                                        <option value="0" selected>All Snippets</option>
                                        <option value="1">Featured</option>
                                        <option value="2">Most popular</option>
                                        <option value="3">Top rated</option>
                                        <option value="4">Most commented</option>
                                    </select>

</div>

<div class ="col-sm-2 mainSearch" style="background-color:#5d4da8">
<button id = 'clientSearch' class="btn btn_primary thead" value="Type" style="border-color:#5d4da8;color:white;background-color:#5d4da8" >Search</button>

</div>

</div>
</div>


</div>



<!--  -------------------------------------------------------------------------------------------      -->

<diV class="container dataTableMain" style="margin-top:40px;margin-bottom:50px">



<table id="example" class="table table-striped table-bordered table-hover	" aria-controls ="example" tabindex = "0" style="width:100%">
        <thead>
<tr>
    <th>Client Name</th>
    <th>Position</th>
    <th>Location</th>
    <th>Skills</th>
    <th>Salary</th>
    <th>Select</th>
</tr>
</thead>
        
		<tbody>
		
            
            
		</tbody>
		
		
</table>		
</diV>

<div class="container">
<div class="row">

<div class="col-sm-4">
</div>
<div class="col-sm-3">

<button id='edit_client' class='btn btn-secondary'  data-toggle="modal" data-target="#myModal" style="width:100%;margin:15px;display:none">
Edit
</button>
</div>

<div class="col-sm-4">
</div>

</div>
</div>

<script>



  
   
   $('#example').DataTable( {
       columnDefs: [ {
           orderable: false,
           className:'select-checkbox check',
           targets:   5,
           render: function(){
	            var checkbox = $("<input/>",{
	            		 "type": "button",
		                "class" : "btn btn-sm btn-info tButton",
		                "value" : "Edit"
	            });
	        
	            return checkbox.prop("outerHTML")
	        }
       } ],
       select: {
           style:    'os',
           selector: 'td:first-child'
       },
       order: [[ 1, 'asc' ]]
       });
   
   

</script>


<!-- ------------------------------------------------------------------------- -->

	 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal_cutsom_width  modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
                 <h4 class="modal-title" style="color:#2873F0;width:100%;text-align:center">Client  Data</h4>
        
          <button style="margin:0px;padding:0px" type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        
        
        <div class="modal-body">
        <div class='row'>
        
        <div class="col-sm-6">
        
         
  <div class="form-group">
    <div class="col-sm-12"> 
    
    <div class="row">
    <div class="col-sm-4">      <label class = " labelHeader font-size:12px">Client Name </label></div>
    <div class="col-sm-8">
    <input type="text" class="form-control form_cand" id="client_name" placeholder="Client Name">
		<input type="text" class="form-control form_cand" id="client_id" style="display:none" placeholder="ClientId">
    </div>
    </div>
          
    
    </div>
  </div>
  
  
  <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Mandatory Skills </label></div>
    <div class="col-sm-8"><input type="text" class="form-control form_cand" id="mandatory_skills" placeholder="Mandatory Skills"></div>
    </div>
                
      
    </div>
  </div>
  
   <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Additional Skills </label></div>
    <div class="col-sm-8"><input type="text" class="form-control form_cand" id="additional_skills" placeholder="Additional Skills"></div>
    </div>
                
      
    </div>
  </div>
  
  <div class="form-group" >
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Total Positions </label></div>
    <div class="col-sm-8"><input type="text"  data-role="tagsinput" class="form-control form_cand"  id="total_positions" placeholder="Total Positions"></div>
    </div>
    	
      
    </div>
  </div>
  
  
  
  <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Sourcing Rate </label></div>
    <div class="col-sm-8"><input  class="form-control form_cand"    id="sourcing_rate" placeholder="Sourcing Rate"></div>
    </div>
    		
      
      
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Type </label></div>
    <div class="col-sm-8"><input  class="form-control form_cand"    id="type" placeholder="Type"></div>
    </div>
    	
      
      
    </div>
  </div>
  
   <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Profiles Shared </label></div>
    <div class="col-sm-8"><input  class="form-control form_cand"    id="profiles_shared" placeholder="Profiles Shared"></div>
    </div>
    	
      
      
    </div>
  </div>
  
  <div class="form-group" style="display:none">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Additional Skills </label></div>
    <div class="col-sm-8"><input type="text"  data-role="tagsinput" class="form-control form_cand" id="pwd" placeholder="Addtional Skills"></div>
    
    </div>
    	
      
    </div>
  </div>
  
  
   <div class="form-group" style="display:none">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Total Positions </label></div>
    <div class="col-sm-8"><input type="text" class="form-control form_cand" id="total_positions" placeholder="Total Positions"></div>
    </div>
    		
      
    </div>
  </div>
        
        
        </div>
        
        <div class="col-sm-6">
        
         <div class="form-group ">
    <div class="col-sm-12">
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Screen Reject  </label></div>
    <div class="col-sm-8"><input type="text" class="form-control form_cand" id="screen_reject" placeholder="Screen Reject"></div>
    </div>
    	
      
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Tech Interview </label></div>
    <div class="col-sm-8"><input type="text" class="form-control form_cand" id="tech_interview" placeholder="Tech Interview"></div>
    </div>
    	
      
    </div>
  </div>
  
   <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Tech Rejects </label></div>
    <div class="col-sm-8"><input type="text" class="form-control form_cand" id="tech_rejects" placeholder="Tech Rejects"></div>
    </div>
    	
      
    </div>
  </div>
  
   <div class="form-group">
    <div class="col-sm-12">
    <div class="row">
    <div class="col-sm-4"><label class = "font-size:12px">Final Select </label></div>
    <div class="col-sm-8"><input type="text" class="form-control form_cand" id="final_select" placeholder="Final Select">  </div>
    </div>
    		 
      
    </div>
  </div>
  
   <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Experience </label></div>
    <div class="col-sm-8"><input  class="form-control form_cand"    id="client_candidate_state" placeholder="Candidate State"></div>
    </div>
    		
      
      
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-12"> 
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Joining Date </label></div>
    <div class="col-sm-8"><input  class="form-control form_cand datepicker"    id="joining_date" placeholder="Joining Date"></div>
    </div>
    
      
      
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-12">
    <div class="row">
    <div class="col-sm-4"><label class = "labelHeader font-size:12px">Location </label></div>
    <div class="col-sm-8"><input  class="form-control form_cand"    id="location_client" placeholder="Location"></div>
    
    </div>
    	 
      
      
    </div>
  </div>
  <!-- 
  <div class="form-group">
    <div class="col-sm-12">
    	<label class = "font-size:12px">Client Rate:</label> 
      <input  class="form-control form_cand"    id="client_rate" placeholder="Client Rate">
      
    </div>
  </div>
  -->       
        
        </div>
     	
     	</div>
        </div>
        
        
        
        <div class="modal-footer">
        <label  style="color: grey; width:100%;font-size: 13px;padding: 3px;float:left">Note: Discard Will not update your changes</label>
          <button id='newRevDiscard' type="button" style="Width:70px" class="btn btn-danger" data-dismiss="modal">Discard</button>
          <button id='updatedClientDetails' type="button"  style="Width:70px" class="btn btn-success" >Save</button>
        </div>
      </div>
      
    </div>
  </div>




<!-- ------------------------------------------------------------------------- -->


<!-- Footer -->
<footer class="page-footer font-small special-color-dark pt-4" style="background-color:#263238;">

  <!-- Footer Elements -->
	

    <!--Grid row-->
    <div class="row">

      <!--Grid column-->
      <div class="col-md-6">

        <!-- Form
        <form class="form-inline">
          <input class="form-control form-control-sm mr-3 w-75" type="text" placeholder="Search"
            aria-label="Search">
          <i class="fas fa-search" aria-hidden="true"></i>
        </form>
        Form -->
        
        <p style="margin-left:20px;color:wheat;font-size:16px">Powered by</p>

      </div>
      <!--Grid column-->

      <!--Grid column-->
      <div class="col-md-6 ">
			
		<!--  
        <form class="input-group">
          <input type="text" class="form-control form-control-sm" placeholder="Your email"
            aria-label="Your email" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-sm btn-outline-white my-0" type="button">Sign up</button>
          </div>
        </form>
		-->
		<p style="text-align:right;margin-right:20px;color:wheat;font-size:16px">All rights are reserved by Testlabs.inc</p>
      </div>
      <!--Grid column-->

    </div>
    <!--Grid row-->


  <!-- Footer Elements -->

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3" style="background:rgba(0,0,0,.2);color:white;font-size:16px">Developed by Lihal Tej	
    <a href="https://mdbootstrap.com/education/bootstrap/"></a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->
</body>
</html>