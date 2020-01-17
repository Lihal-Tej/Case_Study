$(document).ready(function(){
	
	 
	  $.ajax({
		  url:'impClients',
		  type:'get',
		  dataType:'json',
		  success:function(result){
			  
			 for(var i=0;i<result.length;i++){
				 
				 if(i==0){
					 var div = document.createElement("div");
					  
					  div.className="item active";
					
						  var header = document.createElement("h4");
					  header.className = "headers";
					  header.innerHTML= result[i].clientName +"<br>" +result[i].mandatorySkills;
					  
					  div.append(header);
					  
					  document.getElementById("mainBanner").append(div);
				 }else{
					 var div = document.createElement("div");
					  
					  div.className="item";
					
						  var header = document.createElement("h4");
					  header.className = "headers";
					  header.innerHTML= result[i].clientName +"<br>" +result[i].mandatorySkills;
					  
					  div.append(header);
					  
					  document.getElementById("mainBanner").append(div);
				 }
			 }
		  }
		  
	  });

});