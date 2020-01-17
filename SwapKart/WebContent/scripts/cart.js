$(document).ready(function(){
	
	
	
	 $.ajax({
		 
		 url : 'http://localhost:8080/SwapKart/cartProducts',
			type : 'get',
			dataType : 'json',
			data :  {'userId' :'101'},
			success : function(result){
				
				var availableProducts =[];
				
		
				if(result.length > 0){

					
					document.getElementById("mainImage").src="http://localhost:8080/SwapKart/Images/"+result[0].productImage+".jpeg";
					document.getElementById("productName").innerHTML = result[0].productName;
					document.getElementById("sellar").innerHTML = 'Sellar : '+result[0].productSellar;
					document.getElementById("0quantity").value =result[0].productQunatity ;
					
					
					
					if(result[0].isActive == '0' || result[0].totalQuantity < 2){
						
						
						$(".left").css("pointer-events",'none');
						$(".left").css("backdrop-filterr",'blur(2px);');
						$("#123").css("display",'block');
					}else{
						availableProducts.push(result[0]);
					}
					
		 			$("#price").text("$"+result[0].productPrice);
		 		
					
		 			
		 			var totalPrice = (+result[0].productPrice);
					for(var i=1;i<(result.length);i++){
						
						
						totalPrice = totalPrice+(+result[i].productPrice); 
						
						if(i>1){
							
							
						
							var cloneObject =  $("#clone1").clone().appendTo("#clone");
							cloneObject.find("#mainImage").attr("src","http://localhost:8080/SwapKart/Images/"+result[i].productImage+".jpeg");
							cloneObject.find("#productName").text(result[i].productName);
							cloneObject.find("#sellar").text('Sellar : '+result[i].productSellar);
							cloneObject.find("#price").text("$"+result[i].productPrice);
							cloneObject.find("#0min").attr('id',i+'min');
							cloneObject.find("#0min").attr('id',i+'min');
							var cloneQuantity = i-1;
							var newId = i+'quantity';
							console.log(cloneQuantity + "  "+newId );
							cloneObject.find("#"+cloneQuantity+"quantity").attr('id',newId);
							
							cloneObject.find("#"+i+"quantity").val(result[i].productQunatity);
							cloneObject.find("#quantity").attr('id',result[i].productId+'quantity');
							cloneObject.find("#"+result[i].productId+"quantity").val(result[i].productQunatity);
							cloneObject.find("#0max").attr("id",i+'max');
							cloneObject.find("#"+(i-1)+"product").attr("id",i+'product');
							cloneObject.find("#remove").attr("id",i+''+result[i].productId+'remove');
						
							if(result[i].isActive == '0' || result[i].totalQuantity < 2){
								
								
								cloneObject.find(".left").css("pointer-events",'none');
								cloneObject.find(".left").css("backdrop-filterr",'blur(2px);');
								cloneObject.find("#123").css("display",'block');
							}else{
								availableProducts.push(result[i]);
							}

							
						}else{
							
							
							var cloneObject =$("#0product").clone().appendTo("#clone");
							cloneObject.find("#mainImage").attr("src","http://localhost:8080/SwapKart/Images/"+result[i].productImage+".jpeg");
							cloneObject.find("#productName").text(result[i].productName);
							console.log("Product Name"+result[i].productName);
							cloneObject.find("#sellar").text('Sellar : '+result[i].productSellar);
							cloneObject.find("#price").text("$"+result[i].productPrice);
							cloneObject.find("#0min").attr('id',i+'min');
							cloneObject.find("#0quantity").attr('id',i+'quantity');
							cloneObject.find("#1quantity").val(result[i].productQunatity);
							console.log("O th product Quantity "+result[i].productQunatity);
							cloneObject.find("#quantity").attr('id',result[i].productId+'quantity');
							cloneObject.find("#"+result[i].productId+"quantity").val(result[i].productQunatity);
							cloneObject.find("#0max").attr("id",i+'max');
							$("#clone").find("#0product").attr("id",i+'product');
							cloneObject.find("#remove").attr("id",i+''+result[i].productId+'remove');
							if(result[i].isActive == '0' || result[i].totalQuantity < 2){
								
								
								cloneObject.find(".left").css("pointer-events",'none');
								cloneObject.find(".left").css(" -webkit-filter",'blur(2px);');
								cloneObject.find("#123").css("display",'block');
							}else{
								availableProducts.push(result[i]);
							}
							
						}
						
						
						
					}
					$("#quantity").attr("id",result[0].productId+'quantity');
					$("#remove").attr("id",'0'+result[0].productId+'remove');
					
					 $("#placeOrder").click(function(){
							
						 for(var i=0;i<availableProducts.length;i++){
							 
							 availableProducts[i].productQunatity = $("#"+availableProducts[i].productId+"quantity").val();
							 alert(availableProducts[i].productQunatity);
							 
						 }
						 
						 var productString = JSON.stringify(availableProducts);
						 
						 $.ajax({
							 
							 url : 'http://localhost:8080/SwapKart/placeOrder',
								type : 'post',
								dataType : 'json',
								data :  {'products' :productString},
								success: function(result){
									
									alert(result);
								
								}
								});
						 
						 
					 });
					 
					 $("body").on("click",".max",function(){
						 var id = this.id;
						 var position = id.charAt(0);
						 var presentValue = (+$("#"+position+'quantity').val());
						 var productId = result[position].productId;
						 var quantity = +1 + presentValue;
						 var map =new Object(); 
						 map["userId"] = '101';
						 map["productId"] = productId;
						 map["quantity"] =quantity;
						 
						 var jsonString = JSON.stringify(map);
							 
						 $.ajax({
							
							 url:'http://localhost:8080/SwapKart/Increament',
							 type:'post',
							 dataType:'json',
							 data:{'inc':jsonString},
							 success:function(result){
							
								 alert(result);
								 if(result == '1'){
									 $("#"+position+'quantity').val((+1 + presentValue));
									 $('#'+productId+'quantity').val((+1 + presentValue));

								 }
								 
							 }
						 });
						 
						 
						
						
					 });
					 
					
					 
					 
					
					$("#totalPrice").text("$"+totalPrice+'.00');
					$("#finalPrice").text("$"+totalPrice+'.00');
					
					
					
					
				}else{
					$("#0product").css("display","none");
					$("#placeOrder").css("display","none");
					$("#continueShopping").val("Add Products to Cart");
				}
				
			}
		 
		 
	 });
	 
	 
	 $("body").on("click",".remove",function(){
		 var id = this.id;
		 var position = id.substring(1, 5);
		 var pos = id.charAt(0);
		 var m = new Object(); 
		 m['userId'] = '101';
		 m['productId'] = position;
		 
		 var stringMap = JSON.stringify(m);
		 
		 $.ajax({
			 
		 url:'http://localhost:8080/SwapKart/removeCartProduct',
		 type :'post',
		 dataType : 'json',
		 data : {map : stringMap},
		 success : function(result){
			 
			if(result == '1'){
				
			
				$("#"+pos+'product').css({'display':'none'});
			}
		 }
		 
		 });
		 
		
	 });
	 
	 
	 $("#continueShopping").click(function(){
		 
		 window.location.href="http://localhost:8080/SwapKart/homescreen.jsp";
	 
	 });
	 
	 
	

	 
	
	 
	 $("body").on("click",".min",function(){
		 var id = this.id;
		 var position = id.charAt(0);
		 var presentValue  = ($("#"+position+'quantity').val());
		 if(presentValue === '1'){
			 
			var modal =  document.getElementById('myModal');
			modal.style.display = "block";
			var span = document.getElementsByClassName("close")[0];
			
			span.onclick = function() {
				  modal.style.display = "none";
				};
				
				window.onclick = function(event) {
					  if (event.target == modal) {
					    modal.style.display = "none";
					  }
					};

			 
		 }else{
			
			 $("#"+position+'quantity').val((presentValue - 1));
				
		 }
	 });
	 
	 
	 
	 $("body").on("click","#removeProductYes",function(){
		 
	 
	 alert('Product Removed Successfully');
	 var modal =  document.getElementById('myModal');
	 modal.style.display = "none";
	 
	 });
	 $("body").on("click","#removeProductCancel",function(){
		 
		 var modal =  document.getElementById('myModal');
		 modal.style.display = "none";
		 
	});
	 
	 
});


