<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if IE 8 ]><html lang="en" class="ie8"><![endif]-->
<!--[if IE 9 ]><html lang="en" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>jQuery thumbnail/image scroller demo</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	
	<link rel="stylesheet" href="styles/style.css">

	<link rel="stylesheet" href="styles/jquery.mThumbnailScroller.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="scripts/jquery-1.11.0.min.js"><\/script>')</script>
	

	<script src="scripts/jquery.mThumbnailScroller.js"></script>
	
	<style>
	
	body{
	background-color: white;
	
	}
		.content{
			overflow: auto;
			position: relative;
			padding: 10px;
			background-color: white;
			margin: 00px;
			width: 100%;
			height: auto;
			float: left;
		}
		.content li{
			
			overflow: hidden;
			margin:4px;
			width:220px;
		}
		.content li a{
			display: inline-block;
			
		}
		.content.light, .content.light .mTSButton{ background-color: #c2beb2; }
		.content.light li a{ border: 7px solid rgba(255,255,255,.4); }
	
		
		#content-6{ background-color: transparent; }
		#content-6 .mTSButton{
			background-color: rgba(0,0,0,.7);
			-moz-border-radius: 48px; -webkit-border-radius: 48px; border-radius: 48px;
		}
		#content-6 .mTSButtonLeft{ left: 5px; }
		#content-6 .mTSButtonRight{ right: 5px; }
		
	
	</style>
	
</head>

<body>
	
	
	<div id="demo">
		<section id="examples">
			
			
			<!-- demo content -->
			<div id="content-6" class="content">
				
				<ul id ='ul'>
					<li id = 'myLi' class = "imageFrame"><div>
					
					
					<div id='panel21' class="panel panel-default sliderPanel ">

				<div class="panel-body  pbod">
					<img class="sliderBody"
						src="https://rukminim1.flixcart.com/image/300/300/j8rnpu80/watch/d/5/y/b172-casio-original-imaeymgrxhfmnw6f.jpeg?q=70">
					<ul class="sliderPannelBottom" style="list-style-type: none;">
						<li>Fastrack,Addidas,Titan</li>
						<li>offers upto 30% discount</li>
						<li>Watches</li>
					</ul>

					</div>

					</div>
						
					
					</div></li>
					
				</ul>
			</div>
			<!-- -//- -->
			
		</section>
	</div>
	
	
	

	
	<script>
		(function($){
			$(window).load(function(){
				
			
				$("#content-6").mThumbnailScroller({
					type:"click-100",
				});
				
				for(var i=0;i<10;i++){
					
					//$("#myLi").clone.appenTo("#ul");
					 $("#myLi").clone().appendTo("#mTS_1_container");
					 
					 alert('CLone'+i);
					
				}
				
			});
		})(jQuery);
	</script>
</body>
</html>