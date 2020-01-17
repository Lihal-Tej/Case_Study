$(document).ready(function(){
	

	
	$("#loginButton").click(function(){
		
		if($("#loginId").val() == ""){
			
			alert("please enter user name");
		}else if($("#password").val() == ""){
			alert("please enter password");
		}else{
			$.ajax({
				
				url:'LoginMain',
				type:'post',
				dataType:'json',
				data:{'userName':$("#loginId").val(),'password':$("#password").val()},
				success:function(result){
					
					var user = result;
					alert(user);
					console.log(user);
					if(user.user_id != null && user.user_name != null && user.user_email_id != null && user.user_number != null){
						
						location.replace("main_home.jsp");
						alert('Hi.. '+user.user_name);
						
					}else{
						
						alert('Incorrect Credentials');
					}
				}
				
			});
		}

		
	});
	
});