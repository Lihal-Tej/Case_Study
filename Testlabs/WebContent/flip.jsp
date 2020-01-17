<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://cdn.rawgit.com/nnattawat/flip/master/dist/jquery.flip.min.js"></script>
<script src="jquery-2.1.4.min.js"></script>
<script src="jquery.flip.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="card"> 
  <div class="front" style="width:150px;height:150px;background-color:green"> 

  </div> 
  <div class="back" style="width:150px;height:150px;background-color:red">
    Back content
  </div> 
</div>









<!-- ---------------------------------------------------------------------------------------------------------------------------------------------- -->



<script>
$("#card").flip();

</script>
</body>
</html>