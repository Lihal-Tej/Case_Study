<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testlabs/DashBoard</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="scripts/dashboard.js"> </script>
    <script>
    
    
    

    //-----------------------------------------------------------------------------------------------
  
    //------------------------------------------------------------------------------------------------------
   
    //------------------------------------------------------------------------------------------------------------
    
    google.charts.load('current', {'packages':['bar']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Year', 'Selected', 'Rejected', 'Pending'],
        ['2014', 1000, 400, 200],
        ['2015', 1170, 460, 250],
        ['2016', 660, 1120, 300],
        ['2017', 1030, 540, 350]
      ]);

      var options = {
        chart: {
          title: 'Company Performance',
          subtitle: 'Sales, Expenses, and Profit: 2014-2017',
        },
        bars: 'horizontal' // Required for Material Bar Charts.
      };

      var chart = new google.charts.Bar(document.getElementById('barchart_material'));

      chart.draw(data, google.charts.Bar.convertOptions(options));
    }

    
    </script>
    
    <style>
    
    html,body
{
    width: 100%;
    margin: 0px;
    padding: 0px;
   
  	
}
    
    
    body{
     overflow-x: hidden;
    }
    
.thead{
width:100%;
height:35px;
border:2px;
border-color:#5d4da8;
border-style:solid;
font-size: 16px;
font-family: serif;
text-align:intial;
}

.jumbotron p {

    margin-bottom: 15px;
    font-size: 21px;
    font-weight: 200;
}



.jumbotron h1{

margin-bottom:5px;
font-size:63px;
}
    
    
    </style>
    
</head>
<body>


<div style="margin-bottom:20px"><jsp:include page="header.jsp" /></div>



<div class="row" style="margin-left:10px">

<div class="col-sm-6">
  <div id="columnchart_material" style="width: 100%; height: 500px;"></div>
  <script>
  google.charts.load('current', {'packages':['bar']});
  google.charts.setOnLoadCallback(drawChart);

  function drawChart() {
    var data = google.visualization.arrayToDataTable([
      ['Year', 'Selected', 'Rejected', 'Pending'],
      ['2014', 1000, 400, 200],
      ['2015', 1170, 460, 250],
      ['2016', 660, 1120, 300],
      ['2017', 1030, 540, 350]
    ]);

    var options = {
      chart: {
        title: 'Company Performance',
        subtitle: 'Sales, Expenses, and Profit: 2014-2017',
      }
    };

    var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

    chart.draw(data, google.charts.Bar.convertOptions(options));
  }
  
  </script>

</div>
<div class="col-sm-6">

 <div id="piechart" style="width: 100%; height: 500px;"></div>
 <script>
 
 
 google.charts.load('current', {'packages':['corechart']});
 google.charts.setOnLoadCallback(drawChart);

 function drawChart() {

   var data = google.visualization.arrayToDataTable([
     ['Task', 'Hours per Day'],
     ['Selected',     11],
     ['Rejected',      2],
     ['Pedning',  2],
     ['Tech Interview Rejected', 2],
     ['HR Round Rejected',    7]
   ]);

   var options = {
     title: 'My Daily Activities',
     is3D: true
   };

   var chart = new google.visualization.PieChart(document.getElementById('piechart'));

   chart.draw(data, options);
 }

 </script>
 
</div>

</div>


<div class="row">

<div class="col-sm-6">
<div id="donutchart" style="width: 100%; height: 500px;"></div>
<script>

google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['Selected',     11],
    ['Rejected',      2],
    ['pending',  2],
    ['Tech Interview Rejected', 2],
    ['HR Round Rejected',    7]
  ]);

  var options = {
    title: 'My Daily Activities',
    pieHole: 0.4,
  };

  var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
  chart.draw(data, options);
}

</script>

</div>
<div class="col-sm-5">
<div id="barchart_material"  style="width: 100%; height: 500px;"></div>
</div>

<div class="col-sm-1"></div>


</div>


</body>
</html>