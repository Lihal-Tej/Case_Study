package com.testlabs.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.protocol.PacketReceivedTimeHolder;
import com.mysql.cj.xdevapi.Result;
import com.testlabs.constatnts.Constant;
import com.testlabs.controllers.SkillMapper;
import com.testlabs.model.CandidateMaster;
import com.testlabs.model.ClientMaster;
import com.testlabs.model.SkillMaster;
import com.testlabs.model.User;


@Component
public class Dao {
	
	@Autowired
	Constant constant;
	
	public Connection getConnection() {
		Connection connection = null;
		try {

			

			Class.forName(constant.dao_connectionClassName);

			connection = DriverManager.getConnection(constant.dao_conectionName, constant.dao_connectionID,
					constant.dao_connectionPassword);
			//connection =DriverManager.getConnection("jdbc:mysql://testlabs.cyvhv2nmlqxx.us-east-2.rds.amazonaws.com:3306/testlabs", "root", "Lihallihal9");
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
		}
		return connection;

	}
	
	public static void main(String[] args) {
		
		System.out.println("Before");
		new Dao().cassandraConnection();
		System.out.println("After");
	}
	
	
	public Connection cassandraConnection() {
		
		Connection connection = null;
		try {
//			Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
//			
//			connection = DriverManager
//			        .getConnection("jdbc:cassandra://13.127.148.69:9160/retailerapp");
//
//			    String query = "SELECT * from hul_retailers_auth;";
//
//			    Statement stmt = connection.createStatement();
//			    ResultSet result = stmt.executeQuery(query);
//			    if(result != null) {
//			    	
//			    	System.out.println(""+result.getRow());
//			    	
//			    }
			    
		}catch (Exception e) {
			
			System.out.println("Before Exception");
			e.printStackTrace();
			System.out.println("After Exception");
		}
		
		return connection;
	}
	
	
	public User verifyLogin(String userName,String password) {
		
		User userDetails = new User();
		Connection connection = null ;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			String sql = constant.dao_login_select_query;
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				userDetails.setUser_id(resultSet.getInt(constant.dao_login_user_id));
				userDetails.setUser_access(resultSet.getString(constant.dao_login_user_access));
				userDetails.setUser_email_id(resultSet.getString(constant.dao_login_user_email_id));
				userDetails.setUser_name(resultSet.getString(constant.dao_login_user_name));
				userDetails.setUser_number(resultSet.getString(constant.dao_login_user_number));
				
			}
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return userDetails;
	}
	
	public String newCandidate(CandidateMaster data,List<SkillMapper> skills) {
		
		String result = "";
		Connection connection = null;
		ResultSet resultSet = null;
		
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_new_cand_insert_query;
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			

			String currentTime = sdf.format(new Date());
			
			String candidateId = UUID.randomUUID().toString();
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, data.getCandidateName());
			preparedStatement.setString(2, data.getCandidateNumber());
			preparedStatement.setString(3, data.getEmailId());
			preparedStatement.setString(4, data.getLocationPreference());
			preparedStatement.setString(5, data.getLocation());
			preparedStatement.setString(6, data.getNoticePeriod());
			preparedStatement.setString(7, data.getCurrentCompany());
			
			
			preparedStatement.setString(8,data.getCurrentSalary());
			preparedStatement.setString(9, data.getExpectesSalary());
			preparedStatement.setString(10, data.getCandidateStatus());
			preparedStatement.setDate(11, new java.sql.Date(data.getExpectedJoining().getTime()));
			preparedStatement.setString(12, currentTime);
			preparedStatement.setString(13, currentTime);
			
			
			preparedStatement.setString(14, "");
			preparedStatement.setString(15, data.getOnBoradingStatus());
			preparedStatement.setDate(16, new java.sql.Date(data.getInvoiceStartDate().getTime()));
			preparedStatement.setDate(17, new java.sql.Date(data.getBillingStartDate().getTime()));
			preparedStatement.setDate(18, new java.sql.Date(data.getBillingEndDate().getTime()));
			preparedStatement.setString(19, data.getClientSalaray());
			preparedStatement.setString(20, candidateId);
		
			int res = preparedStatement.executeUpdate();
			
			if( res == 1) {
				result = "Success"; 
				
				String sql1 =constant.dao_new_cand_skill_insert_query;
				PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
				
				for(int i=0;i<skills.size();i++) {
					
				
					preparedStatement1.setString(1, String.valueOf(candidateId));
					preparedStatement1.setString(2, skills.get(i).getSkillDuration());
					preparedStatement1.setString(3, skills.get(i).getSkillType());
					preparedStatement1.setString(4, skills.get(i).getSkillId());
					
					preparedStatement1.addBatch();
					
				
				}
				
				
				int[] resu = preparedStatement1.executeBatch();
				
				int count = 0;
				for(int i=0;i<resu.length;i++) {
					
					if(resu[i] > 0) {
						count = count+1;
					}
				}
				if(count == resu.length) {
					result = candidateId;
					
					
					//----------------------------------------------------------------------------------
//					
//					String sql2 = "insert into testlabs.cand_resume (resume_id,cand_id,resume,resume_name,file_type)values ('"+UUID.randomUUID().toString()+"',150,?,?,?)";
//					
//					PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
//			
//					preparedStatement2.setBlob(1, file);
//					preparedStatement2.setString(2, name);
//					preparedStatement2.setString(3, type);
//					
//					
//					int res1 = preparedStatement.executeUpdate();
//					
//					if(res1 == 1) {
//						result = "Success";
//					}
//					
					
					
					//-----------------------------------------------------------------------------------
				}
				
				
			}else {
				
				candidateId = "";
				result = "failed";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public String candSkills(List<SkillMapper> skills,int userId) {
		
		String result ="";
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sql =constant.dao_new_cand_skill_insert_query;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			for(int i=0;i<skills.size();i++) {
				
			
				preparedStatement.setString(1, String.valueOf(userId));
				preparedStatement.setString(2, skills.get(i).getSkillDuration());
				preparedStatement.setString(3, skills.get(i).getSkillType());
				preparedStatement.setInt(4, Integer.parseInt(skills.get(i).getSkillId()));
				
				preparedStatement.addBatch();
				
			
			}
			
			
			int[] res = preparedStatement.executeBatch();
			
			int count = 0;
			for(int i=0;i<res.length;i++) {
				
				if(res[i] > 0) {
					count = count+1;
				}
			}
			if(count == res.length) {
				result = "Success";
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public String newClient(ClientMaster client) {
		
		String result = "";
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_new_client_insert_query;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(new Date());
			
			preparedStatement.setString(1, client.getClientName());
			preparedStatement.setString(2, client.getMandatorySkills());
			preparedStatement.setString(3, client.getAdditionalSkills());
			preparedStatement.setString(4, client.getTotalPositions());
			preparedStatement.setString(5, client.getSourcingRate());
			preparedStatement.setString(6, client.getType());
			
			preparedStatement.setString(7, client.getProfilesShared());
			preparedStatement.setString(8, client.getScreenReject());
			preparedStatement.setString(9, client.getTechInterview());
			preparedStatement.setString(10, client.getTechRejects());
			preparedStatement.setString(11, client.getFinalSelect());
			preparedStatement.setString(12, client.getExperiance());
			
			preparedStatement.setDate(13,  new java.sql.Date(client.getJoiningDate().getTime()));
			preparedStatement.setString(14, currentTime);
			preparedStatement.setString(15, currentTime);
			preparedStatement.setString(16, client.getLocation());
			preparedStatement.setString(17, client.getClientRate());
			preparedStatement.setString(18,client.getImp());
			
			System.out.println("New Client Query"+preparedStatement);
			
		
			int res = preparedStatement.executeUpdate();
			
			if(res == 1) {
				result = "Success";
			}else {
				result = "Failed to  Update Please Try Again...!!";
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public List<SkillMaster> getSkills(){
		
		Connection connection = null ;
		ResultSet resultSet = null;
		List<SkillMaster> skills = new ArrayList<SkillMaster>();
		
		try {
			
			connection = getConnection();

			String sql = constant.dao_skill_select_query;
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				SkillMaster skillMaster = new SkillMaster();
				
				skillMaster.setSkillId(resultSet.getString(constant.dao_skill_id));
				skillMaster.setSkillDesc(resultSet.getString(constant.dao_skill_desc));
						
				skills.add(skillMaster);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return skills;
	}
	
	
	
	public List<ClientMaster> searchClients(String clientName,String skills,String experiance){
		
		Connection connection = null;
		ResultSet resultSet = null;
		List<ClientMaster> clientList =  new ArrayList<>();
		try {
			
			connection = getConnection();
			String sql = "";
			//12781293
			Statement statement = connection.createStatement();
			sql ="select * from testlabs.client_master where ";
			
			if(clientName != "") {
				sql = sql+" clinet_name like '%"+ clientName + "%' and ";
			}
			if(skills != "") {
				sql = sql + " mandatory_skills like '%"+skills+"%' and ";
			}
			if(experiance != null && experiance  != "") {
				
				sql = sql+" experiance like '%"+experiance + "%' and ";
			}
			
			sql = sql.substring(0,sql.length()-4);
			
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				ClientMaster clientMaster = new ClientMaster();
				clientMaster.setClientId(resultSet.getInt(constant.dao_client_clientId));
				clientMaster.setAdditionalSkills(resultSet.getString(constant.dao_client_additionalSkills));
				clientMaster.setExperiance(resultSet.getString(constant.dao_client_experiance));
				clientMaster.setClientName(resultSet.getString(constant.dao_client_clientName));
				//clientMaster.setClientRate(resultSet.getString(constant.dao_client_client_rate));
				clientMaster.setFinalSelect(resultSet.getString(constant.dao_client_finalSelect));
				clientMaster.setInsertedDate(resultSet.getDate(constant.dao_client_insertedDate));
				clientMaster.setJoiningDate(resultSet.getDate(constant.dao_client_joiningDate));
				clientMaster.setLocation(resultSet.getString(constant.dao_client_location));
				clientMaster.setMandatorySkills(resultSet.getString(constant.dao_client_mandatorySkills));
				clientMaster.setProfilesShared(resultSet.getString(constant.dao_client_profile_shared));
				clientMaster.setScreenReject(resultSet.getString(constant.dao_client_screen_reject));
				clientMaster.setSourcingRate(resultSet.getString(constant.dao_client_sourcingRate));
				clientMaster.setTechInterview(resultSet.getString(constant.dao_client_tech_interview));
				clientMaster.setTechRejects(resultSet.getString(constant.dao_client_tech_rejects));
				clientMaster.setTotalPositions(resultSet.getString(constant.dao_client_total_pos));
				clientMaster.setType(resultSet.getString(constant.dao_client_type));
				//clientMaster.setUpdatedDate(resultSet.getDate(constant.dao_type));
				
				clientList.add(clientMaster);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return clientList;
	}
	
	
	
	public String UpdateClient(ClientMaster clientMaster) {
		
		
		String result="";
		Connection connection= null;
		ResultSet resultSet = null;
		
		try {
			
			String sql = constant.dao_update_client_update_query;
			connection = getConnection();
			
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String currentTime = sdf.format(new Date());
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, clientMaster.getClientName());
			preparedStatement.setString(2, clientMaster.getMandatorySkills());
			preparedStatement.setString(3, clientMaster.getAdditionalSkills());
			preparedStatement.setString(4, clientMaster.getTotalPositions());
			preparedStatement.setString(5, clientMaster.getSourcingRate());
			preparedStatement.setString(6, clientMaster.getType());
			preparedStatement.setString(7,clientMaster.getProfilesShared());
			preparedStatement.setString(8, clientMaster.getScreenReject());
			preparedStatement.setString(9, clientMaster.getTechInterview());
			preparedStatement.setString(10, clientMaster.getTechRejects());
			preparedStatement.setString(11, clientMaster.getFinalSelect());
			preparedStatement.setString(12, clientMaster.getExperiance());
			preparedStatement.setString(13, sdf.format(clientMaster.getJoiningDate()));
			preparedStatement.setString(14, currentTime);
			preparedStatement.setString(15, clientMaster.getLocation());
			preparedStatement.setInt(16, clientMaster.getClientId());
			
			int res = preparedStatement.executeUpdate();
			System.out.println("Res :"+res);
			if(res > 0) {
				result = "1";
			}else {
				
				result = "0";
			}
					
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public List<CandidateMaster> candidateSearch(String candName,String candLocation,String skillId){
		
		List<CandidateMaster> candidateList = new ArrayList<>();
		ResultSet resultSet = null;
		Connection connection = null;
		
		try {
			
		
			connection = getConnection();
			String sql = "select *, GROUP_CONCAT(skill_desc.skill_desc) as skills from testlabs.candidate_master as cand inner join testlabs.cand_resume  as resume using(cand_id) inner join  testlabs.skill_map as skill using (cand_id) inner join testlabs.skills as skill_desc using(skill_id) where  ";
			
			
			
			if(candName != null && candName != ""){
					
				sql = sql +" cand_name like '%" + candName +"%' and ";
				
			}else if(candLocation != null && candLocation != "") {
				
				sql = sql + " location like '%" +candLocation + "%' and ";
				
			}else if(skillId != null) {
				
				sql = sql +" skill_id = '"+skillId +"' and ";
				
			}
			
			sql = sql.substring(0,sql.length()-4);
			
			sql = sql+"    group by cand.cand_id;";
			
			System.out.println(sql);
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				CandidateMaster candidateMaster = new CandidateMaster();
				
				candidateMaster.setBillingEndDate(resultSet.getDate(constant.dao_cand_billing_end_date));
				candidateMaster.setBillingStartDate(resultSet.getDate(constant.dao_cand_billing_start_date));
				candidateMaster.setCandidateName(resultSet.getString(constant.dao_cand_candName));
				candidateMaster.setCandidateNumber(resultSet.getString(constant.dao_cand_candNumber));
				candidateMaster.setCandidateStatus(resultSet.getString(constant.dao_cand_candidate_status));
				candidateMaster.setClientSalaray(resultSet.getString(constant.dao_cand_client_salaray));
				candidateMaster.setCurrentCompany(resultSet.getString(constant.dao_cand_current_company));
				candidateMaster.setCurrentSalary(resultSet.getString(constant.dao_cand_current_salary));
				candidateMaster.setEmailId(resultSet.getString(constant.dao_cand_email_id));
				candidateMaster.setExpectedJoining(resultSet.getDate(constant.dao_cand_expcected_joining));
				candidateMaster.setExpectesSalary(resultSet.getString(constant.dao_cand_expected_salary));
				candidateMaster.setLocation(resultSet.getString(constant.dao_cand_location));
				candidateMaster.setInvoiceStartDate(resultSet.getDate(constant.dao_cand_invoice_start_date));
				candidateMaster.setLocationPreference(resultSet.getString(constant.dao_cand_location_preference));
				candidateMaster.setNoticePeriod(resultSet.getString(constant.dao_cand_notice_period));
				candidateMaster.setOnBoradingStatus(resultSet.getString(constant.dao_cand_onboarding_status));
				//candidateMaster.setUpdatedDate(resultSet.getDate(constant.dao_client_updatedDate));
				candidateMaster.setSkills(resultSet.getString(constant.dao_cand_skills));
				candidateMaster.setResume_id(resultSet.getString("resume_id"));
				candidateMaster.setResume_name(resultSet.getString("resume_name"));
				candidateMaster.setCandidateId(resultSet.getString("cand_id"));
				
				candidateList.add(candidateMaster);
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return candidateList;
		
		
	}


	public String uploadResume(String name,Blob file,String type,String CandidateId) {
		
		Connection connection= null;
		ResultSet resultSet = null;
		String result  = "Failed to upload resume , Please try again";
		
		try {
			
			connection = getConnection();
			String sql = "insert into testlabs.cand_resume (resume_id,cand_id,resume,resume_name,file_type)values ('"+UUID.randomUUID().toString()+"',?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			System.out.println("Candidate Id :"+CandidateId);
	
			preparedStatement.setString(1,CandidateId );
			preparedStatement.setBlob(2, file);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, type);
			
			
			int res = preparedStatement.executeUpdate();
			
			if(res == 1) {
				result = "Success";
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		// TODO Auto-generated method stub
		
	}


	public File getFile(String resumeId) {
		
		File file = null;
		InputStream io = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String fileName="",fileType="";
		Blob fileBlob = null;
		
		try {
			
			connection = getConnection();
			String sql = "SELECT * FROM testlabs.cand_resume where resume_id  =? ;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, resumeId);
			System.out.println(preparedStatement);
			
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				fileName = resultSet.getString("resume_name");
				fileType = resultSet.getString("file_type");
				fileBlob =  resultSet.getBlob("resume");
			}
			
			System.out.println("File Name :"+fileName + "File Type : "+fileType);
			
			int blobLength = (int) fileBlob.length();  
			byte[] blobAsBytes = fileBlob.getBytes(1, blobLength);
			fileBlob.free();

			//io = fileBlob.getBinaryStream();
			
			 file = new File("C:\\Work\\eclipse-workspace\\"+fileName);
			 FileOutputStream fileOutputStream = new FileOutputStream(file);
			 fileOutputStream.write(blobAsBytes);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	
	public String updateCandidate(CandidateMaster data) {
		
		Connection connection = null;
		ResultSet resultSet = null;
		String result = "Fail";
		
		try {
			
			connection = getConnection();
			String sql = constant.dao_update_candidate;
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			java.text.SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(new Date());
				
			
			preparedStatement.setString(1, data.getCandidateName());
			preparedStatement.setString(2, data.getCandidateNumber());
			preparedStatement.setString(3, data.getEmailId());
			preparedStatement.setString(4, data.getLocationPreference());
			preparedStatement.setString(5, data.getLocation());
			preparedStatement.setString(6, data.getNoticePeriod());
			preparedStatement.setString(7, data.getCurrentCompany());
			
			
			preparedStatement.setString(8,data.getCurrentSalary());
			preparedStatement.setString(9, data.getExpectesSalary());
			preparedStatement.setString(10, data.getCandidateStatus());
			preparedStatement.setDate(11, new java.sql.Date(data.getExpectedJoining().getTime()));
			preparedStatement.setString(12, currentTime);
			preparedStatement.setString(13, currentTime);
			
			
			preparedStatement.setString(14, data.getOnBoradingStatus());
			preparedStatement.setDate(15, new java.sql.Date(data.getInvoiceStartDate().getTime()));
			preparedStatement.setDate(16,new java.sql.Date(data.getBillingStartDate().getTime() ));
			preparedStatement.setDate(17,new java.sql.Date(data.getBillingEndDate().getTime() ));
			preparedStatement.setString(18, data.getClientSalaray());
			preparedStatement.setString(19, data.getCandidateId());
		
			
			
			System.out.println(preparedStatement);
			
			int res = preparedStatement.executeUpdate();
			
			System.out.println("Result :"+res);
			if(res > 0) {
				result = "Success";
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
		
	}
	
	public String newSkill(String skillName) {
		
		String result ="Failure";
		Connection connection = null;
		ResultSet resultSet= null;
		
		try {
			
		connection = getConnection();
		String sql = constant.dao_insert_new_skill;
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, UUID.randomUUID().toString());
		preparedStatement.setString(2, skillName);
		
		int res = preparedStatement.executeUpdate();
		if(res > 0) {
			result = "Success";
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}

	
	public List<ClientMaster> getImpClient() {
		
		List<ClientMaster> clients = null ;
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			
			clients = new ArrayList<>();
			String sql = constant.dao_select_imp_clients;
			connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			resultSet =preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				ClientMaster clientMaster = new ClientMaster();
				clientMaster.setClientName(resultSet.getString(constant.dao_client_clientName));
				clientMaster.setMandatorySkills(resultSet.getString(constant.dao_client_mandatorySkills));
				
				clients.add(clientMaster);
			}
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}if(resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clients;
		
	}
	

}
