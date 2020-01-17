$(document).ready(function(){

	$('#data').addClass('active');
	
	
	  $('.datepicker').datepicker({
		    format: 'dd/mm/yyyy'

		});	
	  
	  //$("#first_h").text("IBM \n Java Developer");
	  
	  //document.getElementById('first_h').innerHTML = "IBM" +"<br>" +"Java Developer"
	  
	 
	 
	  
	  
	  
	  
	   
//	var USA = [
//		{display: "Washington, D.C." , value: "1"},
//		{display: "Alaska", value: "2"},
//		{display: "New York",value: "3"},
//		{display: "Florida",value: "4"},
//		{display: "Hawaii",value: "5"},
//		{display: "California",value: "6"}
//		];
	
	$.ajax({
		
		url:'Skills',
		type:'get',
		dataType: 'json',
		success:function(result){
			
			
			$(".city").empty(); //To reset cities
			$(".city").append("<option>--Select--</option>");
			$(result).each(function(i) { //to list cities
			$(".city").append("<option value="+ result[i].skillId +">" + result[i].skillDesc + "</option>")
			});
			
			
			
		}
	});
	
	
	
	$("#skill_save").click(function(){
		
		var skillName = $("#skill_name").val();
		
		console.log("skill Name :"+skillName);
		
		if(skillName == ''){
			
			alert("Please enter Skill Name");
		}else{
			$.ajax({
				
				url:'newSkill',
				type:'post',
				dataType:'json',
				data:{'skillName':skillName},
				complete:function(result){
					alert(result.responseText);
					if(result.responseText == 'Success'){
						   $("#skill_name").css("display","none");
						   $("#skill_save").css("display","none");
						   location.reload();
					}
					
				}
			});
		}
		
		
		
	});
	
	

	

	    $('[rel="tooltip"]').tooltip();
	    
	   $("#cand_save").click(function(){
		  
		   
		 
		   
		   var skills = [];	

			$(".skillbody").each(function(i){
				
				var skill = ({skillId : $(this).find(".city option:selected").val(),skillDuration : $(this).find(".duration").val(), skillType : $(this).find(".type").val() });
				
				skills[i] =skill;
				
				
			});
			
			alert("Candidiate Joining Date"+$("#cand_expcted_joining").val());
			
			if($("#cand_name").val() == ''){
				
				alert('Please enter candidate Name');
			}else if($("#cand_number").val() == ''){
				
				alert('Candidate Name is empty');
			}else if($("#cand_email_id").val() == ''){
				
			}else if($("#cand_location_preference").val() == ''){
				
			}else if($("#cand_location").val() == ''){
				
			}else if($("#cand_notice_period").val()){
				
			}
			
			
			  var user = ({candidateName: $("#cand_name").val(), candidateNumber: $("#cand_number").val(),emailId: $("#cand_email_id").val(),
				   locationPreference:$("#cand_location_preference").val(),location:$("#cand_location").val(),noticePeriod : $("#cand_notice_period").val(),
				   currentCompany : $("#cand_current_company").val(),currentSalary:$("#cand_current_salary").val(),expectesSalary:$("#cand_expected_salary").val(),
				   candidateStatus:$("#cand_candidate_status").val(),expectedJoining : $("#cand_expcted_joining").val(),onBoradingStatus : $("#cand_on_board_status").val(),
				   invoiceStartDate:$("#cand_inovice_start_date").val(),billingStartDate:$("#cand_billing_start_date").val(),billingEndDate : $("#cand_billing_end_date").val(),
				   clientSalaray : $("#cand_client_salary").val(),skill :skills });
			
			
		   
		   var jsonUser = JSON.stringify(user);
		   

		   $.ajax({
				
			   url:'Candidate',
				type:'post',
				dataType:'json',
				data:{data:jsonUser},
				complete:function(result){
					
					alert(result.responseText);
					
					$("#cand_id").val(result.responseText);
					
//					$("#resume_form").submit(function(){
//						  alert("Submitted");
//						});
//					
					document.getElementById("resume_form").submit();
					
										
				}
		   });
		   
		   
	   });
	   
	   
	   $("#client_save").click(function(){
		  
		   var imp = $("#imp").val();
		   
		   var mainImp =0;
		   if(imp == "High"){
			   mainImp = "1";
		   }else if(imp == "Medium"){
			   mainImp = "2";
		   }else if(imp == "Light"){
			   mainImp = "3";
		   }
		  
		 loadClientData(mainImp);
		   
		  
	   });
	   
	   $("#new_skill").click(function(){
		  
		   $("#skill_name").css("display","block");
		   $("#skill_save").css("display","block");
		   
	   });
	   
	   
	   $("#add_Skill").click(function(){
		  
		   var row = $("#rowDummy").clone();
		   row.css({ display: "block" });
		   
		   row.addClass("skillbody");
		   
		   var existingRows = document.getElementsByClassName("skillbody");
		   var sum = 1;
		   var presentlength = existingRows.length;
		   var current =+presentlength;
		   row.attr('id',"row"+(existingRows.length));
		 
		   row.find(".skill_dummy").attr('id','row'+(existingRows.length)+'_skill');
		   row.find(".duration_dummy").attr('id','row'+(existingRows.length)+'_duration');
		   row.find(".type_dummy").attr('id','row'+(existingRows.length)+'_type');
		   
		   row.appendTo("#skill_main");
		   
	   });

});


function rotateCard(btn){
    var $card = $(btn).closest('.card-container');
    console.log($card);
    if($card.hasClass('hover')){
        $card.removeClass('hover');
    } else {
        $card.addClass('hover');
    }
}


function loadClientData(impL){
	
	
	var clientData = ({clientName : $("#client_name").val(),mandatorySkills : $("#mandatory_skills").val(), additionalSkills : $("#additional_skills").val(),
		
	totalPositions : $("#total_positions").val(), sourcingRate : $("#sourcing_rate").val(),type : $("#type").val(),profilesShared : $("#profiles_shared").val(),
	
	screenReject : $("#screen_reject").val(), techInterview : $("#tech_interview").val(), techRejects : $("#tech_rejects").val(),finalSelect : $("#final_select").val(),
	
	experiance : $("#client_candidate_state").val(), location :$("#location_client").val(),clientRate : $("#client_rate").val(),joiningDate : $("#joining_date").val(),
	
	imp : impL
	
	});
	
	console.log(clientData);
	
	var jsonClient = JSON.stringify(clientData);
	
	$.ajax({
		
		url : 'Client',
		type : 'post',
		dataType :'json',
		data : {data : jsonClient },
		complete : function(result){
				
			console.log("Result :"+result);
			alert("Result :"+result.responseText);
			
		}
	});
}




function loadSkills(){
	

	

}

