$(document).ready(function(){
	
	
	$.urlParam = function (name) {
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)')
	                      .exec(window.location.search);

	    return (results !== null) ? results[1] || 0 : false;
	}

	const urlParams = new URLSearchParams(window.location.search);
	const subCategId = urlParams.get('SubCateg');

	
	var subCatgId_fromURL = $.urlParam('SubCateg');
	
	$.ajax({
		
	
		url : applicationUrl+'/search',
		type : 'get',
		dataType : 'json',
		data:{'subCatgId':subCatgId_fromURL},
		success : function(result){
			
			searchResult(result.productList);
			var womenList = result.subCategList[0];
			var menList = result.subCategList[1];
			var houseHoldList = result.subCategList[2];
			var electrnoicsList = result.subCategList[3];
			var womens = loadSubCateg(womenList,womens,'#ulDrop3');
			var mens = loadSubCateg(menList,mens,'#ulDrop2');
			var houseHolds = loadSubCateg(houseHoldList,houseHolds,'#ulDrop4');
			var electronics = loadSubCateg(electrnoicsList,electronics,'#ulDrop1');
			document.getElementById('osRow').style.display = 'none';
			var arrBrands = [];
			for(var i=0;i<result.productList.length;i++){
			arrBrands[i] = result.productList[i].productMnfg;
			}
			
			var brands = [];
			$.each(arrBrands, function(i, el){
			    if($.inArray(el, brands) === -1) brands.push(el);
			});
			
			for(var i=0;i<brands.length;i++){
			
			var div = document.createElement('div');
			div.className ='checkbox';
			div.id = 'brand'+i;
			document.getElementById('brandForm').appendChild(div);
			var label = document.createElement('label');
			label.id = 'label'+i; 
			label.innerText  = brands[i];
			document.getElementById('brand'+i).appendChild(label);
			var $input = $('<input type="checkbox">').attr({value: brands[i], name: 'brand',style :"margin-left :0px"});
			$input.insertBefore('#label'+i);
			}
			
		}
		
	});
	
	
	$("#applyFilter").click(function(){
		
	var maps =[];
	var obj = {};
		
		var minPrice = $("#minPrice").val();
		
		var maxPrice = $("#maxPrice").val();
		
		var price = [];
		price[0] = minPrice;
		price[1] = maxPrice;
		if(minPrice != 0 || maxPrice != 0){
	
			var minPriceMap =({operator:">=",columnName:"product_price",dataType:"int",intColumnValue:minPrice});
			var maxPriceMap =({operator:"<=",columnName:"product_price",dataType:"int",intColumnValue:maxPrice});
			
			
			setMap("product_price",price);
			
			maps.push(minPriceMap);
			maps.push(maxPriceMap);
		}
	
		
		var brand = $.map($('input[name="brand"]:checked'), function(c){
			return c.value;
			
		});
		
		if(brand.length > 0){
			
			var brandList = new Array();
			
			for(var i=0;i<brandList.length;i++){
				brandList.push(brand[i]);
			}
			
			var brandMap =({operator:"In",columnName:"product_mnfg",dataType:"String",listStringColumnValue:brand});
			console.log(brandMap);
			maps.push(brandMap);
			
				 setMap('product_mnfg',brand);
		}
		
		
		var rating = $.map($('input[name="rating"]:checked'), function(c){return c.value; });
		
		if(rating.length > 0){
			var arr = rating;
			var minRating = [];
			var min = Math.min.apply(Math, arr);
			minRating[0] = min;
		
			var ratingMap =({operator:">=",columnName:"product_rating",dataType:"int",intColumnValue:min});
			
			maps.push(ratingMap);
		
				setMap("product_rating",minRating);
		}
		
		var os = $.map($('input[name="os"]:checked'), function(c){return c.value; });
		
		if(os.length > 0){
				setMap("product_os",os);
		
		}
		
		
		  
		function setMap(key,val){
			
			obj[key] = val;
		}
		
		
		

		console.log(JSON.parse(JSON.stringify(maps)));
		
		var stringObj = JSON.stringify(maps); 
		
		
		  
		if(maps.length > 0){
			
			$.ajax({
				
				url : applicationUrl+'/filterSearch',
				type : 'post',
				data :{ maps :stringObj,subCategId : subCatgId_fromURL},
				dataType : 'json',
				success : function(result){
					$("#productSection").html("");
					console.log("SubCategId"+subCatgId_fromURL);
					searchResult(result);
				}
			
			});
			
		}else{
			
			alert('Please Select atleast one filter');
		}
	
		
	
	
	
	});
	

});


function searchResult(productList){
	
	for(var i=0;i<productList.length;i++){
		
		
		var panel = document.createElement('div');
		panel.id = 'pannel'+i;
		panel.className  ='panel panel-primary';
		var hre = document.createElement('a');
		hre.id = 'product'+i;
		hre.href = 'http://localhost:8080/SwapKart/productDetails.jsp?productId ='+productList[i].productId+'';
		document.getElementById('productSection').appendChild(panel);
		document.getElementById('pannel'+i).appendChild(hre);
		
		var panelBody = document.createElement('div');
		panelBody.id = 'pannelBody'+i;
		panelBody.className  ='panel-body row';
		document.getElementById('product'+i).appendChild(panelBody);
		
		var leftDiv = document.createElement('div');
		leftDiv.id = 'leftDiv'+i;
		leftDiv.className = 'col-sm-3';
		document.getElementById('pannelBody'+i).appendChild(leftDiv);
		var srcc ='http://localhost:8080/SwapKart/Images/'+productList[i].productImage+'.jpeg';
		$('#leftDiv'+i).append('<img class="productImage" id="theImg" class="sliderBody" src="'+srcc+'" />')
		
		
		var centerDiv = document.createElement('div');
		centerDiv.id ='centerDiv'+i;
		centerDiv.className ='col-sm-6';
		document.getElementById('pannelBody'+i).appendChild(centerDiv);
		document.getElementById("centerDiv"+i).style["padding-left"] = "0px";
		
		var ulHeading = document.createElement('ul');
		ulHeading.id = 'ulHeading'+i;
		document.getElementById('centerDiv'+i).appendChild(ulHeading);
		document.getElementById("ulHeading"+i).style["list-style"] = "none";
		$('#ulHeading'+i).append('<li class="productName">'+productList[i].productName+'</li>');
		$('#ulHeading'+i).append('<li class="ratings">'+productList[i].productRating+'.0<span class="fa fa-star checked"></span></li>');
		
		var ulHeadingBody = document.createElement('ul');
		ulHeadingBody.id = 'ulHeadingBody'+i;
		document.getElementById('centerDiv'+i).appendChild(ulHeadingBody);
		
		var jsonObject = productList[i].productSpecs;
		//alert(jsonObject);
		var specsList = JSON.parse(jsonObject);

		
		for(var o=0;o<specsList.length;o++){
		$('#ulHeadingBody'+i).append('<li>'+specsList[o]+'</li>');
		}
		

		var rightDiv = document.createElement('div');
		rightDiv.id = 'rightDiv'+i;
		rightDiv.className ='col-sm-3';
		document.getElementById('pannelBody'+i).appendChild(rightDiv);
		var productPriceUl = document.createElement('ul');
		productPriceUl.id = 'productPriceUl'+i;
		document.getElementById('rightDiv'+i).appendChild(productPriceUl);
		document.getElementById("productPriceUl"+i).style["list-style"] = "none";
		$('#productPriceUl'+i).append('<li style="font-size:28px">$ '+productList[i].productPrice+'</li>');
		$('#productPriceUl'+i).append('<li>EMI starting from $ 50/month</li>');
		
		
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



