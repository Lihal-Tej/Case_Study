$(document).ready(function(){

	
	$('#regBtn').click(function(){
		
	
	var loginId=$('#loginId').val();
	var emailId=$("#emailId").val();
	var address = $("#address").val();
	var pass=$('#pass').val();
	var cPass = $("#cPass").val();

	if(loginId === '' || emailId ==='' || pass==='' || cPass ==='' || address ==='')
	{
		
	alert('All Feilds are Manditory');
	}else{
		if( pass === cPass){
			
			var map = new Object();
			map['userName'] = loginId;
			map['address'] = address;
			map['userEmail'] = emailId;
			map['password'] = pass;
			map['userNum'] = $("#userNo").val();
			
			var userRequestJsonData = JSON.stringify(map);
			 
			$.ajax({url: applicationUrl+"/register",
				 type:  'post',
				 data: { user: userRequestJsonData },
				 dataType: 'json',
				 success: function(result){
					
					 alert('Your User Id is   '+result);
				 		
				 }});
			
		}else{
			alert("Password and Confirm Password Should be Same");
		}
	
	}
	
	
	
	
	
	
	
	
	
	});



});