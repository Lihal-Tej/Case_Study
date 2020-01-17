package com.testlabs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDao {

	
	public static void main(String[] args) {
		new TestDao().getConnection();
	}
	
public Connection getConnection() {
		
		Connection connection = null;
		try {
		
			connection =DriverManager.getConnection("jdbc:mysql://testlabs.cyvhv2nmlqxx.us-east-2.rds.amazonaws.com:3306/testlabs", "root", "Lihallihal9");
			
			String sql ="SELECT * FROM testlabs.skills;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String  id = resultSet.getString("skill_id");
				String name = resultSet.getString("skill_desc");
				
				System.out.println("Name :"+name+ " Id :"+ id);
			}
			
		}catch (Exception e) {

			e.printStackTrace();
		}
		return connection;
	}
}
