package com.testlabs.constatnts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {

	@Value("${dao_connectionClassName}")
	public String dao_connectionClassName;

	@Value("${dao_conectionName}")
	public String dao_conectionName;

	@Value("${dao_connectionID}")
	public String dao_connectionID;

	@Value("${dao_connectionPassword}")
	public String dao_connectionPassword;

	// --------------------------------------------------------------------
	
	@Value("${dao_login_select_query}")
	public String dao_login_select_query;
	
	@Value("${dao_login_user_id}")
	public String dao_login_user_id;
	
	@Value("${dao_login_user_number}")
	public String dao_login_user_number;
	
	@Value("${dao_login_user_email_id}")
	public String dao_login_user_email_id;
	
	@Value("${dao_login_user_access}")
	public String dao_login_user_access;
	
	@Value("${dao_login_user_name}")
	public String dao_login_user_name;
	
	// --------------------------------------------------------------------
	
	@Value("${dao_new_cand_insert_query}")
	public String dao_new_cand_insert_query;
	
	// --------------------------------------------------------------------
	
	@Value("${dao_new_client_insert_query}")
	public String dao_new_client_insert_query;
	
	
	// --------------------------------------------------------------------
	
	@Value("${dao_skill_select_query}")
	public String dao_skill_select_query;
	
	
	@Value("${dao_new_cand_skill_insert_query}")
	public String dao_new_cand_skill_insert_query;
	
	@Value("${dao_skill_id}")
	public String dao_skill_id;
	
	@Value("${dao_skill_desc}")
	public String dao_skill_desc;
	
	
	//---------------------------------------------------------------------
	
	@Value("${dao_client_clientName}")
	public String dao_client_clientName;
	
	@Value("${dao_client_clientId}")
	public String dao_client_clientId;
	
	@Value("${dao_client_mandatorySkills}")
	public String dao_client_mandatorySkills;
	
	@Value("${dao_client_additionalSkills}")
	public String dao_client_additionalSkills;
	
	@Value("${dao_client_total_pos}")
	public String dao_client_total_pos;
	
	@Value("${dao_client_sourcingRate}")
	public String dao_client_sourcingRate;
	
	@Value("${dao_client_type}")
	public String dao_client_type;
	
	@Value("${dao_client_profile_shared}")
	public String dao_client_profile_shared;
	
	@Value("${dao_client_screen_reject}")
	public String dao_client_screen_reject;
	
	@Value("${dao_client_tech_interview}")
	public String dao_client_tech_interview;
	
	@Value("${dao_client_tech_rejects}")
	public String dao_client_tech_rejects;
	
	@Value("${dao_client_finalSelect}")
	public String dao_client_finalSelect;
	
	@Value("${dao_client_experiance}")
	public String dao_client_experiance;
	
	@Value("${dao_client_joiningDate}")
	public String dao_client_joiningDate;
	
	@Value("${dao_client_insertedDate}")
	public String dao_client_insertedDate;
	
	@Value("${dao_client_updatedDate}")
	public String dao_client_updatedDate;
	
	@Value("${dao_client_location}")
	public String dao_client_location;
	
	@Value("${dao_client_client_rate}")
	public String dao_client_client_rate;
		
	
	
	//---------------------------------------------------------------------
	
	@Value("${dao_update_client_update_query}")
	public String dao_update_client_update_query;
	
	
	//---------------------------------------------------------------------
	
	@Value("${dao_update_candidate}")
	//update_candidate
	public String dao_update_candidate;
	
	//---------------------------------------------------------------------
	
	@Value("${dao_cand_candName}")
	public String dao_cand_candName;
	
	@Value("${dao_cand_candNumber}")
	public String dao_cand_candNumber;
	
	@Value("${dao_cand_email_id}")
	public String dao_cand_email_id;
	
	@Value("${dao_cand_location_preference}")
	public String dao_cand_location_preference;
	
	@Value("${dao_cand_location}")
	public String dao_cand_location;
	
	@Value("${dao_cand_notice_period}")
	public String dao_cand_notice_period;
	
	@Value("${dao_cand_current_company}")
	public String dao_cand_current_company;
	
	@Value("${dao_cand_current_salary}")
	public String dao_cand_current_salary;
	
	@Value("${dao_cand_expected_salary}")
	public String dao_cand_expected_salary;
	
	@Value("${dao_cand_candidate_status}")
	public String dao_cand_candidate_status;
	
	@Value("${dao_cand_expcected_joining}")
	public String dao_cand_expcected_joining;
	
	@Value("${dao_cand_inserted_date}")
	public String dao_cand_inserted_date;
	
	@Value("${dao_cand_updated_date}")
	public String dao_cand_updated_date;
	
	@Value("${dao_cand_updated_by}")
	public String dao_cand_updated_by;
	
	@Value("${dao_cand_onboarding_status}")
	public String dao_cand_onboarding_status;
	
	@Value("${dao_cand_invoice_start_date}")
	public String dao_cand_invoice_start_date;
	
	@Value("${dao_cand_billing_start_date}")
	public String dao_cand_billing_start_date;
	
	@Value("${dao_cand_billing_end_date}")
	public String dao_cand_billing_end_date;
	
	@Value("${dao_cand_client_salaray}")
	public String dao_cand_client_salaray;
	
	@Value("${dao_cand_duration}")
	public String dao_cand_duration;
	
	@Value("${dao_cand_skill_type}")
	public String dao_cand_skill_type;
	
	@Value("${dao_cand_skills}")
	public String dao_cand_skills;
	
	
	
	//---------------------------------------------------------------------
	
	
	@Value("${dao_insert_new_skill}")
	public String dao_insert_new_skill;
	
	
	@Value("${dao_select_imp_clients}")
	public String dao_select_imp_clients;
	
	
	
	
}
