$(document).ready(function(){
	
	
	
	$("#loginButton").click(function(){
		


		var id = $('#loginId').val();
		var password = $('#password').val();
		
		var map = new Object();
		map["userId"] = id;
		map["password"] = password;
		
		var jsonString = JSON.stringify(map);

		if (id === '') {
			alert('Enter Login Id');
		} else if (password === '') {
			alert('Enter Password');
		} else {
			if (isNaN(id)) {
				alert('LoginId Should be a Integer');
			} else {
				
				$.ajax({
					
					url:'http://localhost:8080/SwapKart/login',
					type:'post',
					dataType:'json',
					data:{'loginDeatails':jsonString},
					success:function(result){
						
						console.log(result);
					
						if(result == '0'){
							
							alert('Incorrect Login Details');
						}else{
						
							location.replace("http://localhost:8080/SwapKart/homescreen.jsp");

						}
						
					}
					
				});
				
			}
		}
		
	});
	
	function verifyUser() {

		if (!(result === null)) {
			if (result === "0") {
				alert("Incorrect Credentials");
			}

		}

		
		if (invalidUsage !== null) {
			alert("You Must Login to View That Page");
		}

	}
	
	window.onload = verifyUser;

});


		