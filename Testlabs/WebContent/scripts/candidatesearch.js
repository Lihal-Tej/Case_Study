$(document).ready(function(){
	
	$('#searchCandidate').addClass('active');
	
	$( ".city" ).change(function() {
		if( $("#city").val() == "select skill type"){
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

	var candidates = [];
	
	$.ajax({
		
		url:'http://localhost:8080/Testlabs/Skills',
		type:'get',
		dataType: 'json',
		success:function(result){
			
			
			$(".city").empty(); //To reset cities
			$(".city").append("<option>select skill type</option>");
			$(result).each(function(i) { //to list cities
			$(".city").append("<option value="+ result[i].skillId +">" + result[i].skillDesc + "</option>")
			});
			
		
			
			if( $(".city").val() == "select skill type"){
				$("#city").addClass("dropdown_placeholder");
				$("#city").removeClass("dropdown_selected");
			}else{
				$("#city").addClass("dropdown_selected");
				$("#city").removeClass("dropdown_placeholder");
			}
		}
	});
	
	
	
	
	$("#candidateSearch").click(function(){
		
		console.log('Skill Type'+$(".city option:selected").val());	
		
		$.ajax({
			
			url : 'http://localhost:8080/Testlabs/searchCandidte',
			type : 'get',
			data:{'candidateName':$("#candName").val(),'skillId':$(".city option:selected").val(),'candidateLocation':$("#candLocation").val()},
			dataType : 'json',
			success : function(result){
				
				candidates = result;
				
//				 dTable = $('#example').dataTable();
//				 
//					
//				 	dTable.fnClearTable();
//				 	//dTable.fnAddData(data);
//				 	
//				 	for(var i =0;i<result.length;i++){
//				 		
//				 		 var data = [result[i].candidateName,result[i].currentCompany,result[i].location,result[i].skills,result[i].currentSalary,result[i].resume_name];
//				 		 addRow(data,i);
//				 	}
				  $('#example').dataTable().fnClearTable();
				    $('#example').dataTable().fnDestroy();
				createDataTable(candidates);
				
			}
		});
	});
	
	
	$("body").on("click",".resume",function(){
		
		alert('Resume');
		var candId = this.id;
		console.log(candId);
		$.ajax({
			
			url : 'http://localhost:8080/Testlabs/download',
			type : 'get',
			data:{'resumeId':candId},
			dataType : 'json',
			success : function(result){
				
				alert(result);
				
			}
		});
		
		
	});
	
	
	$("body").on("click","#updateCand",function(){
		
		  var user = ({candidateName: $("#cand_name").val(), candidateNumber: $("#cand_number").val(),emailId: $("#cand_email_id").val(),
			   locationPreference:$("#cand_location_preference").val(),location:$("#cand_location").val(),noticePeriod : $("#cand_notice_period").val(),
			   currentCompany : $("#cand_current_company").val(),currentSalary:$("#cand_current_salary").val(),expectesSalary:$("#cand_expected_salary").val(),
			   candidateStatus:$("#cand_candidate_status").val(),expectedJoining : $("#cand_expcted_joining").val(),onBoradingStatus : $("#cand_on_board_status").val(),
			   invoiceStartDate:$("#cand_inovice_start_date").val(),billingStartDate:$("#cand_billing_start_date").val(),billingEndDate : $("#cand_billing_end_date").val(),
			   clientSalaray : $("#cand_client_salary").val(),skill :$("#cand_experiance_skills").val(),candidateId :$("#cand_id").val()});
		
		
		  console.log(user);
	   var jsonUser = JSON.stringify(user);
	   
		
		$.ajax({
			
			url : 'http://localhost:8080/Testlabs/updateCandidte',
			type : 'post',
			dataType :'json',
			data : {data : jsonUser },
			complete : function(result){
					
				console.log("Result :"+result.responseText);
				alert("Result :"+result.responseText);
				
			}
		});
	});
	
	$("body").on("click",".tButton",function(){
		
		$("#edit_candidate").click();
		
		var pos = $(this).closest('tr').attr('id');
		
				$("#cand_name").val(candidates[pos].candidateName);
				$("#cand_number").val(candidates[pos].candidateNumber);
				$("#cand_email_id").val(candidates[pos].emailId);
				$("#cand_location_preference").val(candidates[pos].locationPreference);
				$("#cand_location").val(candidates[pos].location);
				$("#cand_notice_period").val(candidates[pos].noticePeriod);
				$("#cand_current_company").val(candidates[pos].currentCompany);
				$("#cand_current_salary").val(candidates[pos].currentSalary);
				$("#cand_expected_salary").val(candidates[pos].expectesSalary);
				$("#cand_candidate_status").val(candidates[pos].candidateStatus);
				$("#cand_expcted_joining").val(formatDate(candidates[pos].expectedJoining));
				$("#cand_on_board_status").val(candidates[pos].onBoradingStatus);
				$("#cand_inovice_start_date").val(formatDate(candidates[pos].invoiceStartDate));
				$("#cand_billing_start_date").val(formatDate(candidates[pos].billingStartDate));
				console.log("Billing Start Date :"+candidates[pos].billingStartDate);
				$("#cand_billing_end_date").val(formatDate(candidates[pos].billingEndDate));
				$("#cand_client_salary").val(candidates[pos].clientSalaray);
				$("#cand_resume").val(candidates[pos].resume_name);
				$("#cand_resume_id").val(candidates[pos].resume_id);
				$("#cand_experiance_skills").val(candidates[pos].skills);
				$("#cand_id").val(candidates[pos].candidateId);
		
		
	});

	
});




function addRow(data,position){
		
	var rowid = $('#example').dataTable().fnAddData( data );
 	var theNode = $('#example').dataTable().fnSettings().aoData[rowid[0]].nTr;
 	theNode.setAttribute('id',position);
 	theNode.setAttribute('class','myrow');
 	
}





function createDataTable(cand_data){
	
	 $('#example').dataTable({
	        "pageLength": 5,
	            "lengthMenu": [5, 10, 25, 50],
	            "scrollX": true,
	            "data": cand_data,
	            "pagingType": "numbers",
	            "order": [
	            [1, "asc"]
	        ],
	            "drawCallback": function (settings) {
	            console.log("table redrawn");
	        },
	        "createdRow": function ( row, data, index ) {
	        	console.log("Index : "+index +"Cand Name "+cand_data[index].candidateName);
	        	row.id = index;
	        },
	            "columns": [
	            	{
	            "title": "Canididate Name",
	                "data": "candidateName",
	                "className": "vendorID"
	        }, {
	            "title": "Current Company",
	                "data": "currentCompany"
	        }, {
	            "title": "Location",
	                "data": "location"
	        }, {
	            "title": "Skills",
	                "data": "skills"
	        }, {
	            "title": "Current Salary",
	                "data": "currentSalary"
	        }, {
	            "title": "Resume",
	                "data": "resume_name",
	                "render":function(data,type,full,meta){
	                	return '<p><a href="#" class="resume" id = '+full.resume_id+'>'+data+'</a></p>';
	                }
	                	
	        },{
	            "title": "Select",
	                "data": "candidateId",
	                "render":function(data,type,full,meta){
	                	return '<button type ="checkbox" value="Edit"  class="btn btn-primary edit tButton" id= "'+data+'" >Edit</button>';
	                }
	        }]
	    });


	
	
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