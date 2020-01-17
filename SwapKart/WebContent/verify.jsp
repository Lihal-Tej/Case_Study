<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#tslshow {
position:absolute;
left:0;
width:1200px;

}

#leftArrow {

width:40px;
height:40px;
background:#ff0000; 
position:absolute;
left:0px;
}

#rightArrow {

width:40px;
height:40px;
background:#ff0000; 
position:absolute;
right:0px;
}

#viewContainer {
width:360px;
height:100%;
background:#00ff00;
position:absolute;
left:50%;
margin-left:-180px;
overflow:hidden; 
}
</style>
</head>
<body>
<div class="bstimeslider">
    <div id="rightArrow"></div>
        <div id="viewContainer">
            <div id="tslshow">
                <div class="bktibx"> 12:00   </div>
                <div class="bktibx"> 12:30   </div>
                <div class="bktibx"> 13:00   </div>
                <div class="bktibx"> 13:30   </div>
                <div class="bktibx"> 14:00   </div>
                <div class="bktibx"> 14:30   </div>
                <div class="bktibx"> 15:00   </div>
                <div class="bktibx"> 15:30   </div>
                <div class="bktibx"> 16:00   </div>
                <div class="bktibx"> 16:30   </div>
                <div class="bktibx"> 17:00   </div>
                <div class="bktibx"> 17:30   </div>
             </div>
        </div>
        <div id="leftArrow"></div>
</div>
</body>
</html>