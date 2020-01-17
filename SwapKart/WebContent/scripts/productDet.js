$(document).ready(function(){
	
	$("#content-6").mThumbnailScroller({
		type:"click-50",
	});
	
	
	$.urlParam = function (name) {
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)')
	                      .exec(window.location.search);

	    return (results !== null) ? results[1] || 0 : 0;
	}

	
	var prodId = $.urlParam('productId%20');

var modelNumber = '';
	

	
	$("#readMore").click(function(){
		
		
		if($("#readMore").val() == 'Read More'){
			
			$('#advanceSpecs').css('display', 'block');
			$("#readMore").prop('value', 'Read Less');
			
		}else{
			$('#advanceSpecs').css('display', 'none');
			$("#readMore").prop('value', 'Read More');
		}
		

	});
	
	
	
	
	
	
	$(".ratingStar").click(function(){
	
		for(var i=1;i<= this.id;i++){
			
			document.getElementById(i).className = "fa fa-star checked sel";
		}
		var diff = this.id;var k=1;
		for(var i=+diff + +k;i<=5;i++){
			
			document.getElementById(i).className = "fa fa-star";
			
		}
	
	
	});
	
	$("#showMore").click(function(){
		
		
		if($("#showMore").val() == 'Show More'){
			
			$('#secondRev').css('display', 'block');
			$("#showMore").prop('value', 'Show Less');
			
		}else{
			$('#secondRev').css('display', 'none');
			$("#showMore").prop('value', 'Show More');
		}
		

	});
	
	
	$("body").on("click",".like",function(){
		
		
		
		var likeMap = ({like:"1",reviewId:this.parentNode.getAttribute("data_reviewId"),dislike:"0",user_id : "103"});
		
		var stringJsonMap = JSON.stringify(likeMap);
		
		var id = this;
		var z =1;
		var num = this.innerHTML;
		var x = +num + +z;
		
		var liked = id.style.color;
		if(liked == 'blue'){
			
		}else{
			$.ajax({
				url:"http://localhost:8080/SwapKart/Like",
				type:"get",
				dataType:'json',
				data:{likeType :stringJsonMap},
				complete :function(data){
					
					var res = data.responseText;

					if(res == 'Success'){
						
						
						id.style.color= "blue";
							id.textContent=x;
						
				}
				}
				
			});
		}
		
		
		
	});
	
	$("body").on("click",".addToCart",function(){
		
		var product = this.id.substring(0,4);
		var urId = '101';
		var m = new Object(); 
		m["userId"]= '101';
		m["productId"] = product;
		
		var jsonString = JSON.stringify(m);
		
		$.ajax({
			
			url:'http://localhost:8080/SwapKart/cart',
			type:'post',
			dataType:'json',
			data:{'produtcDet':jsonString},
			success:function(result){
				
				if(result == '1'){
					
					alert('Product Added To Cart Successfully');
				}else{
					alert('Failed to Add Product To Cart ');
				}
			}
			
		})

		
		
	});
	
	
	$("body").on("click",".dislike",function(){
		
		
		var likeMap = ({like:"0",reviewId:this.parentNode.getAttribute("data_reviewId"),dislike:"1",user_id:"103"});
		
		var stringJsonMap = JSON.stringify(likeMap);
		
		var id = this;
		var z =1;
		var num = this.innerHTML;
		var x = +num + +z;
		
		var liked = id.style.color;
		if(liked == 'blue'){
			
		}else{
			
			$.ajax({
				url:"http://localhost:8080/SwapKart/Like",
				type:"get",
				dataType:'json',
				data:{likeType :stringJsonMap},
				complete :function(data){
					
					var res = data.responseText;

					if(res == 'Success'){
						
						
						id.style.color= "blue";
							id.textContent=x;
					}
				}
				
			});
			
			
		}
		
		
		
		
		
		
		
	});
	
	$(".dropdown-menu li ").click(function(){
		  var selText = $(this).text();
		  $(this).parents('.btn-group').find('.dropdown-toggle').html('<span id="newRevRating">'+selText+'</span>'+'<span class="fa fa-star checked" style="color:orange;mrgin-right:3px"> <span class="caret"></span>');
		});
	
	$("#newRevSave").click(function(){
		
		
		console.log($("#newRevUser").val()+"   UserName");
		var ratings = $("#newRevRating").text();
		console.log(ratings.charAt(0)+"   Ratings  "+ratings);
		
		console.log($("#newRevHeader").val()+"   Header");
		

		var arr = document.getElementsByClassName("sel");

		var reviewMap =({reviewDesc:$("#newRevBody").val(),productId:prodId,userName:$("#newRevUser").val(),reviewTitle:$("#newRevHeader").val(),ratings:arr.length});
		var jsonStringObj = JSON.stringify(reviewMap);
		
		
		$.ajax({
			url : 'http://localhost:8080/SwapKart/newReview',
			type : 'post',
			dataType : 'json',
			data :{ rev :jsonStringObj},
			success:function(result){
				
				
				alert(result);
			}
		
		
		});
		
		
		$("#newRevUser").val("");
		$("#newRevHeader").val("");
		$("#newRevBody").val("");
		
		rev.reviewDesc = $("#newRevBody").val();
		console.log(rev.reviewDesc+"   Body");
		$("#newRevDiscard").click();
		alert("Your Comment is Stored...!!");
	});
	
	
	
	
	


	
	
	
	
	$.ajax({
		url:'http://localhost:8080/SwapKart/productDetails?productId='+prodId ,
		type:'get',
		dataType :'json',
		success : function(result){
		
			document.getElementById("galleryImg1").src="http://localhost:8080/SwapKart/Images/"+result.productBean[0].productImage+".jpeg";
			document.getElementById("galleryImg2").src="http://localhost:8080/SwapKart/Images/"+result.productBean[1].productImage+".jpeg";
			document.getElementById("galleryImg3").src="http://localhost:8080/SwapKart/Images/"+result.productBean[2].productImage+".jpeg";
			document.getElementById("myimage").src="http://localhost:8080/SwapKart/Images/"+result.productBean[0].productImage+".jpeg";
			
			
			var cart = document.getElementById("cart");
			cart.id = result.productBean[0].productId+'cart';
			
		
			$('#galleryImg1').click(function(){
				
				document.getElementById("myimage").src="http://localhost:8080/SwapKart/Images/"+result.productBean[0].productImage+".jpeg";

			});

			$('#galleryImg2').click(function(){
				
				
				
				document.getElementById("myimage").src="http://localhost:8080/SwapKart/Images/"+result.productBean[1].productImage+".jpeg";

			});

			$('#galleryImg3').click(function(){
				
				document.getElementById("myimage").src="http://localhost:8080/SwapKart/Images/"+result.productBean[2].productImage+".jpeg";

				
			});
			
		
			$("#productMnfg").html(result.productBean[0].productMnfg);
			$("#productName").html(result.productBean[0].productName);
			$("#productPrice").html("$"+result.productBean[0].productPrice);
			$("#productRating").html(result.productBean[0].productRating+".0<span class='fa fa-star checked' style='color:white'></span>");
			$("#sellar").html(result.productBean[0].productSellar);
			
			
			for(var i=0;i<result.review.length;i++){
				
				var cloneObject = $("#blankReview").clone();
				cloneObject.attr('id', 'blankReview'+i);
				if(i > 2){
					
					cloneObject.appendTo("#secondRev");
				}else{
				cloneObject.appendTo("#rev");
				}
				cloneObject.find(".revRating").text(result.review[i].ratings+'.0');
				cloneObject.find(".reviewTitle").text(result.review[i].reviewTitle);
				cloneObject.find(".reviewDesc").text(result.review[i].reviewDesc);
				cloneObject.find(".userName").text(result.review[i].userName);
				cloneObject.find(".date").text(result.review[i].date);
				cloneObject.find(".reviewId").attr('data_reviewId',result.review[i].reviewId);
				cloneObject.find(".like").text(result.review[i].likes);
				cloneObject.find(".dislike").text(result.review[i].dislikes);
				
				
			}
			
			
			
	
			var js = result.productBean[0].specification;
		
			  
			
			var maps = new Map();
		
			maps= JSON.parse(js);

			
			for(var i=0;i<Object.keys(maps).length;i++){
				
				if(i==0){
					var h4 = document.createElement('h4');
					h4.innerHTML = (Object.keys(maps)[i]);
					$("#deepSpecs").append(h4);
					var table = document.createElement('table');
					table.id =Object.keys(maps)[i].replace(/\s/g, "");
					
					$("#deepSpecs").append(table);
					deepSpecs(table.id,maps[Object.keys(maps)[i]]);
					var hr = document.createElement('hr');
					$("#deepSpecs").append(hr);
				}else{
					var h4 = document.createElement('h4');
					h4.innerHTML = (Object.keys(maps)[i]);
					$("#advanceSpecs").append(h4);
					var table = document.createElement('table');
					table.id =Object.keys(maps)[i].replace(/\s/g, "");
					
					$("#advanceSpecs").append(table);
					deepSpecs(table.id,maps[Object.keys(maps)[i]]);
					var hr = document.createElement('hr');
					$("#advanceSpecs").append(hr);
				}
				
			}
			

			

			var jsonObject = result.productBean[0].productSpecs;
			
			var specsList = JSON.parse(jsonObject);

			
			for(var o=0;o<specsList.length;o++){
			$('#productDetails').append('<li>'+specsList[o]+'</li>');
			}

			
			var modelNumber = result.productBean[0].modelNumber;
			
			similar(modelNumber);
			
			
			$.ajax({
				url : 'http://localhost:8080/SwapKart/search',
				type : 'get',
				dataType : 'json',
				data:{'subCatgId':result.productBean[0].subCategId},
				success : function(result){
					
				
					
//					var womenList = result.subCategeiroesList[0];
//					var menList = result.subCategeiroesList[1];
//					var houseHoldList = result.subCategeiroesList[2];
//					var electrnoicsList = result.subCategeiroesList[3];
//					var womens = loadSubCateg(womenList,womens,'#ulDrop3');
//					var mens = loadSubCateg(menList,mens,'#ulDrop2');
//					var houseHolds = loadSubCateg(houseHoldList,houseHolds,'#ulDrop4');
//					var electronics = loadSubCateg(electrnoicsList,electronics,'#ulDrop1');
//					
//
//					 
//					
//					 
					 for(var o =0;o<result.productList.length;o++){
						 var sliderList = result.productList[1];
						
					 }
					 
					
					loadSlider(result.productList,'rowSlider1','0');
					loadSlider(result.productList,'rowSlider1','1');
					
					

				}
				
			});
			
			
		
			
		}
	});
	

	function loadSlider(sliderList,id,p){
		
		

		for(var i=0;i<sliderList.length;i++)
		{
			
		
			
		var li = document.createElement('li');
		li.id ='li'+p+i;
		li.className= 'sliderLi';
	
		 document.querySelector('[sliderName='+id+']').appendChild(li);
		 
			var hiddenLi = document.createElement('li');
			hiddenLi.id = 'li'+p+sliderList[i].subCategId; 
			hiddenLi.className = 'HiddenLi';
			
			
			$('#li'+p+sliderList[i].productId).append(hiddenLi);
			$('#li'+p+sliderList[i].subCategId).css("display","none");
		 
		 
		var mainPannel = document.createElement('div');
		mainPannel.id='panel'+p+i;
		//mainPannel.className = 'panel panel-default sliderPanel ';
		
		document.getElementById('li'+p+i).appendChild(mainPannel);
		var pannelBody = document.createElement('div');
		pannelBody.className = 'panel-body  pbod ';
		pannelBody.id = 'pbod'+p+i;
		document.getElementById('panel'+p+i).appendChild(pannelBody);
		var srcc ='http://localhost:8080/SwapKart/Images/'+sliderList[i].productImage+'.jpeg';
		$('#pbod'+p+i).append('<img id="theImg" class="sliderBody" src="'+srcc+'" />')
		var productDeatils = document.createElement('ul');
		productDeatils.id = 'pd'+p+i; 
		productDeatils.className ="sliderPannelBottom";
		document.getElementById('pbod'+p+i).appendChild(productDeatils);
		$('#pd'+p+i).append('<li>'+sliderList[i].productName+'</li>');
		$('#pd'+p+i).append('<li>'+sliderList[i].productMnfg+'</li>');

		}
		
		
		
		
	}

	
	


});


function deepSpecs (id,os){
	
	for(var i=0;i<Object.keys(os).length;i++){
		
		$("#"+id).append('<tr><td style="color:grey;width:250px">'+Object.keys(os)[i]+'</td><td>'+os[Object.keys(os)[i]]+'</td></tr>');
		
		
	}
	
}






function loadSubCateg(womensList,women,id){
	 
	women = [];
	for(var i=0;i<womensList.length;i++){
		
		 women[i] = womensList[i].subCatgName;
	}
	
	
	for(var i=0;i<women.length;i++){
		
		  var node = document.createElement("li");
		  var link = document.createElement("a");
		  link.setAttribute('href', '#');
		  link.innerHTML = women[i];
		  node.appendChild(link);
		 $(id).append(node);
		
	}
	 
	return women
	}


function similar(modelNumber){
	
	$.ajax({

		
		url : 'http://localhost:8080/SwapKart/similarProducts?modelNumber='+modelNumber,
		type : 'get',
		dataType : 'json',
		success : function(result){
		
			var sizeCount =0;
			 var colorCount = 0;
		for(var i=0;i<result.length;i++){
			
	
			 if(result[i].sizeValue != null){
				 var size = document.createElement('li');
			 size.id =result[i].productId+'size';
			 size.className = 'liSize';
			 size.value = '6';
			 size.style.border = 'solid';
			 $("#size").append(size);
			
			 var a = document.createElement('a');
			 a.className = 'aSize';
			 a.text = result[i].sizeValue;
			 a.href='#';
			 alert( result[i].productId+'size');
			 $("#"+result[i].productId+'size').append(a);
			 
			 sizeCount = sizeCount + 1;
			 }
			 
			 if(sizeCount == 0){
				 $("#sizeHeader").css('display','none');
			 }
			 
		
			 if(result[i].color !=  null){
				 
				 var liColor = document.createElement('li');
				 liColor.id = result[i].color+'color';
				 liColor.className ='colorBox';
				 liColor.style.backgroundColor = result[i].color;
				 $('#color').append(liColor);
				 colorCount =colorCount +1;
			 }
			 
		}
		
		 if(sizeCount == 0){
			 $("#sizeHeader").css('display','none');
		 }
		 
		 if(colorCount == 0){
			 $("#colorHeader").css('display','none');
		 }
		
		
		
		}
		
	});
}




