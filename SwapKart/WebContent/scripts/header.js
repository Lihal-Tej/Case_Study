$(document).ready(function(){
	
	$.ajax({
		url :'http://localhost:8080/SwapKart/homepage',
		type : 'get',
		dataType : 'json',
		success : function(result){
			
			var womenList = result.subCategeiroesList[0];
			var menList = result.subCategeiroesList[1];
			var houseHoldList = result.subCategeiroesList[2];
			var electrnoicsList = result.subCategeiroesList[3];
			var womens = loadSubCateg(womenList,womens,'#ulDrop3');
			var mens = loadSubCateg(menList,mens,'#ulDrop2');
			var houseHolds = loadSubCateg(houseHoldList,houseHolds,'#ulDrop4');
			var electronics = loadSubCateg(electrnoicsList,electronics,'#ulDrop1');
			
		}
	});
	
	$("#logout").click(function(){
		
		alert("Arre you sure ? You want to logout");
		logout();
	});
	
})


function logout(){
	
	
//	$.ajax({
//		
//		url:'logout',
//		type : 'get',
//		dataType : 'json',
//		success :function(result){
//		
//			
//			if(result == 1){
//				
//				location.replace("http://localhost:8080/SwapKart/login.jsp");
//				
//			}else{
//				alert("We are facing some problem please try again , later");
//			}
//			
//		}
//	});
}

function loadSubCateg(womensList,women,id){
	 
	women = [];
	for(var i=0;i<womensList.length;i++){
		
		 women[i] = womensList[i].subCatgName;
	}
	
	
	for(var i=0;i<women.length;i++){
		
		  var node = document.createElement("li");
		  console.log();
		  
		  node.id = womensList[i].subCatgId;
		  node.className ='subCategHomeScreen';
		  
		  var link = document.createElement("a");
		  link.setAttribute('href', 'http://localhost:8080/SwapKart/search.jsp?SubCateg='+womensList[i].subCatgId);
		  link.innerHTML = women[i];
		  node.appendChild(link);
		 $(id).append(node);
		
	}
	 
	return women
	}
