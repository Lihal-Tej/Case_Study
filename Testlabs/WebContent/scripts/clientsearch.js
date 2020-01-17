$(document).ready(function(){
	
	$('#searchClient').addClass('active');
	
	$( ".city" ).change(function() {
		if( $("#city").val() == "search by experiance"){
			$("#city").addClass("dropdown_placeholder");
			$("#city").removeClass("dropdown_selected");
		}else{
			$("#city").addClass("dropdown_selected");
			$("#city").removeClass("dropdown_placeholder");
		}
		});
	
	
	  $('.datepicker').datepicker({
		 
		  formatSubmit: 'mm/dd/yyyy',
		  format: 'mm/dd/yyyy'

		});	
	
	var clients = [];
	var USA = [
	{display: "1 Year" , value: "1"},
	{display: "2 Years", value: "2"},
	{display: "3 Years",value: "3"},
	{display: "4 Years",value: "4"},
	{display: "5 Years",value: "5"},
	{display: "6 Years",value: "6"},
	{display: "7 Years",value: "7"},
	{display: "8 Years",value: "8"},
	{display: "9 Years",value: "9"},
	{display: "10 Years",value: "10"}
	];
	
	$(".city").empty(); 
	$(".city").append("<option>search by experiance</option>");
	$(USA).each(function(i) { //to list cities
	$(".city").append("<option value="+ USA[i].value+">" + USA[i].display+ "</option>")
	
	
	if( $(".city").val() == "search by experiance"){
		$("#city").addClass("dropdown_placeholder");
		$("#city").removeClass("dropdown_selected");
	}else{
		$("#city").addClass("dropdown_selected");
		$("#city").removeClass("dropdown_placeholder");
	}
	});
	

	
	
	
	
	
	
	$("#clientSearch").click(function(){
		
		
		var experiance = $(".city option:selected").val();
		if(experiance  == 'search by experiance'){
			
			experiance  = '';
		}
		
		$.ajax({
			url:'searchClient',
			type:'get',
			dataType:'json',
			data:{'clientName':$("#companyName").val(),'skill':$("#skill").val(),'experiance':experiance},
			success:function(result){
	
				
				clients = result;
				
				 dTable = $('#example').dataTable();
				 
				
				 	dTable.fnClearTable();
				 	//dTable.fnAddData(data);
				 	
				 	for(var i =0;i<result.length;i++){
				 		
				 		 var data = [result[i].clientName,result[i].type,result[i].location,result[i].mandatorySkills,result[i].sourcingRate];
				 		 addRow(data,i);
				 	}
				 	
			}

			
		});
		
		
		
	});
	
	$("body").on("click",".check",function(){
		
		//var pos = $(this).parent.attr('id'); 
		var pos = $(this).closest('tr').attr('id');
	
		$("#edit_client").click();
		
		$("#client_name").val(clients[pos].clientName);
		$("#client_id").val(clients[pos].clientId);
		$("#mandatory_skills").val(clients[pos].mandatorySkills);
		$("#additional_skills").val(clients[pos].additionalSkills);
		$("#total_positions").val(clients[pos].totalPositions);
		$("#sourcing_rate").val(clients[pos].sourcingRate);
		$("#type").val(clients[pos].type);
		$("#profiles_shared").val(clients[pos].profilesShared);
		$("#screen_reject").val(clients[pos].screenReject);
		$("#tech_interview").val(clients[pos].techInterview);
		$("#tech_rejects").val(clients[pos].techRejects);
		$("#final_select").val(clients[pos].finalSelect);
		$("#client_candidate_state").val(clients[pos].experiance);
		$("#location_client").val(clients[pos].location);
		$("#client_rate").val(clients[pos].clientRate);
		var date = clients[pos].joiningDate;
		$("#joining_date").val(formatDate(clients[pos].joiningDate));
		 
		console.log('Id'+$("#client_id").val());
		
	});
	
	$("#updatedClientDetails").click(function(){
		
		

		var clientData = ({clientId :$("#client_id").val() ,clientName : $("#client_name").val(),mandatorySkills : $("#mandatory_skills").val(), additionalSkills : $("#additional_skills").val(),
			
		totalPositions : $("#total_positions").val(), sourcingRate : $("#sourcing_rate").val(),type : $("#type").val(),profilesShared : $("#profiles_shared").val(),
		
		screenReject : $("#screen_reject").val(), techInterview : $("#tech_interview").val(), techRejects : $("#tech_rejects").val(),finalSelect : $("#final_select").val(),
		
		experiance : $("#client_candidate_state").val(), location :$("#location_client").val(),clientRate : $("#client_rate").val(),joiningDate : $("#joining_date").val()});
		
		console.log(clientData);
		
		var jsonClient = JSON.stringify(clientData);
		
		$.ajax({
			
			url : 'updateClient',
			type : 'post',
			dataType :'json',
			data : {data : jsonClient },
			complete : function(result){
					
				if(result.responseText == '1'){
					
					alert('Updated Successfully..!!');
					  $('#myModal').modal('toggle');
					
				}else{
					alert('Failed to Update Please try again...........!!')
				}
				
			}
		});
		
		
		
		
		
	});
	
	
	
	

	
});



function addRow(data,position){
	
	
	var rowid = $('#example').dataTable().fnAddData( data );
 	var theNode = $('#example').dataTable().fnSettings().aoData[rowid[0]].nTr;
 	theNode.setAttribute('id',position);
 	theNode.setAttribute('class','myrow');
 	
}


function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [month, day, year].join('/');
}