package com.lihal.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.lihal.demo.model.User;

@Component
public class UserSpringJDBCDAO {

	@Autowired
	JdbcTemplate template;
	@Autowired
	DataSource dataSource;
	
	AmazonS3 client;
	private AWSCredentials credentials = new BasicAWSCredentials("userAccess", "securityKey");
	
	public UserSpringJDBCDAO() {
		this.client = clientBuilder();
	}
	

	
	public  AmazonS3 clientBuilder() {
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		System.out.println(s3client);
		return s3client;
	}
	
	
	public List<User> getAllUsers(){
		List<User> lLstUsers = new ArrayList<>();
		try {
			lLstUsers =template.query("select * from users.userdetails;",new ResultSetExtractor<List<User>>() {
				@Override
				public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<User> lLstUsersRs = new ArrayList<>();
					while(rs.next()) {
						User user = new User();
						user.setUserAddress(rs.getString("userAddress"));
						user.setUserName(rs.getString("userName"));
						user.setUserEmail(rs.getString("userEmail"));
						user.setUserId(rs.getInt("userId"));
						lLstUsersRs.add(user);
					}
					return lLstUsersRs;
				}
			});
		}catch (Exception e) {
			System.out.println("Error Occured while fetching users :"+e.getMessage());
		}
		return lLstUsers;
	}
	
	
	public int addUsers(User user) {
		int result = 0;
		try {
			SimpleJdbcInsert addressInsert = new SimpleJdbcInsert(dataSource).withTableName("users.userdetails");
			Map<String,Object> userParams= new HashMap<String,Object>();
			userParams.put("userName",user.getUserName());
			userParams.put("userEmail",user.getUserEmail());
			userParams.put("userAddress",user.getUserAddress());
			result = addressInsert.execute(userParams);
		}catch(Exception e) {
			System.out.println("Error occured while adding user :"+ e.getMessage());
		}
		return result;
	}
	
}
