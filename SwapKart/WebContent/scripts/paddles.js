


$(document).ready(function(){
	
	
	
	//function loadHomeScreenData(){
	
	$(".content-6").mThumbnailScroller({
		type:"click-50",
	});
		
		$.ajax({
			url : 'http://localhost:8080/SwapKart/homepage',
			type : 'get',
			dataType : 'json',
			success : function(result){

				$('#carouselImage1').attr('src', 'http://localhost:8080/SwapKart/Images/'+result.mainBannerList[0].imageName+'.jpg');
				 $('#carouselImage2').attr('src', 'http://localhost:8080/SwapKart/Images/'+result.mainBannerList[1].imageName+'.jpg');
				 $('#carouselImage3').attr('src', 'http://localhost:8080/SwapKart/Images/'+result.mainBannerList[2].imageName+'.jpg');
				 
				 var z =1;
				 for(var i=0;i<result.mainSubBannerList.length;i++){
					
					
					 $('#sBanner'+z).attr('src', 'http://localhost:8080/SwapKart/Images/'+result.mainSubBannerList[i].imageName+'.jpg');
					 z = z+1;
				 }
				 
				 for(var o =0;o<result.slidersList[0].length;o++){
					 var sliderList = result.slidersList[1];
					
				 }
				 
				
				loadSlider(result.slidersList[0],'rowSlider1','0');
				
				loadSlider(result.slidersList[1],'rs2','1');
				loadSlider(result.slidersList[0],'rowSlider3','2');
				
//				

			}
			
		});
		
	//}
	

	
	
	
	
//	 $("body").on("click",".sliderLi",function(){
//		
//		var productId = this.id;
//		var hiddenLi = $("#"+productId).find(".HiddenLi").prop('id')
//		var x = hiddenLi.substring(3,8);
//		
//		location.assign("http://localhost:8080/SwapKart/search.jsp?SubCateg="+x);
//	
////		$.ajax({
////			
////			url:applicationUrl +'search.jsp',
////			type: 'get',
////			dataType:'json',
////			data : {'SubCateg':x},
////			success :function(result){
////				
////				
////			}
////		});
//		
//		
//	});
	

	
	for(var i=0;i<15;i++){
		
		 
		 $("#panel21").clone().appendTo("#rowSlider21");
		 $("#panel22").clone().appendTo("#rowSlider22");
		 $("#panel23").clone().appendTo("#rowSlider23");
	}
	
	function loadSlider(sliderList,id,p){
		
		
		console.log("Slider ID :"+id);
		for(var i=0;i<sliderList.length;i++)
		{
			
		var li = document.createElement('li');
		li.id ='li'+p+sliderList[i].productId;
		li.className= 'sliderLi';
		
		
		 document.querySelector('[sliderName='+id+']').appendChild(li);
		
		var hiddenLi = document.createElement('li');
		hiddenLi.id = 'li'+p+sliderList[i].subCategId; 
		hiddenLi.className = 'HiddenLi';
		
		
		$('#li'+p+sliderList[i].productId).append(hiddenLi);
		$('#li'+p+sliderList[i].subCategId).css("display","none");
		
		var mainPannel = document.createElement('div');
		mainPannel.id='panel'+p+sliderList[i].productId;
		//mainPannel.className = 'panel panel-default sliderPanel ';
		
		document.getElementById('li'+p+sliderList[i].productId).appendChild(mainPannel);
		var pannelBody = document.createElement('div');
		pannelBody.className = 'panel-body  pbod ';
		pannelBody.id = 'pbod'+p+sliderList[i].productId;
		document.getElementById('panel'+p+sliderList[i].productId).appendChild(pannelBody);
		var srcc ='http://localhost:8080/SwapKart/Images/'+sliderList[i].productImage+'.jpeg';
		$('#pbod'+p+sliderList[i].productId).append('<a  class="sliderBody" href="http://localhost:8080/SwapKart/search.jsp?SubCateg='+sliderList[i].subCategId+'"><img id="theImg" class="sliderBody" src="'+srcc+'" /></a>');
		var productDeatils = document.createElement('ul');
		productDeatils.id = 'pd'+p+sliderList[i].productId; 
		productDeatils.className ="sliderPannelBottom";
		document.getElementById('pbod'+p+sliderList[i].productId).appendChild(productDeatils);
		$('#pd'+p+sliderList[i].productId).append('<li>'+sliderList[i].productName+'</li>');
		$('#pd'+p+sliderList[i].productId).append('<li>'+sliderList[i].productMnfg+'</li>');

		}
		
		
	}

	
	
	

	

});

//
//function loadSubCateg(womensList,women,id){
//	 
//	women = [];
//	for(var i=0;i<womensList.length;i++){
//		
//		 women[i] = womensList[i].subCatgName;
//	}
//	
//	
//	for(var i=0;i<women.length;i++){
//		
//		  var node = document.createElement("li");
//		  console.log(womensList[i].subCatgId);
//		  var link = document.createElement("a");
//		  link.setAttribute('href', '#');
//		  link.innerHTML = women[i];
//		  node.appendChild(link);
//		 $(id).append(node);
//		
//	}
//	 
//	return women
//	}





