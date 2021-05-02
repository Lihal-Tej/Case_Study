package com.lihal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lihal.demo.dao.UserSpringJDBCDAO;
import com.lihal.demo.model.User;

@RestController
public class UserController {

	@Autowired
	UserSpringJDBCDAO cUserSpingJDBCDAO;
	
	
	@GetMapping(value = "/appName",produces = "application/json")
	public String getAppName() {
		return "Data-Access";
	}
	
	@GetMapping(value = "/getAllUsers",produces = "application/json")
	public List<User> getAllUsers(){
		List<User> lLstUsers = cUserSpingJDBCDAO.getAllUsers();
		return lLstUsers;
				
	}
	
	@PostMapping(value="/addUser", produces = "application/json")
	public String addUser(@RequestBody String pStrREquestBody){
		Gson lGson = new Gson();
		User lUser = lGson.fromJson(pStrREquestBody, User.class);
		int result = cUserSpingJDBCDAO.addUsers(lUser);
		if(result > 0) {
			return lGson.toJson(lUser);
		}else {
			return "Failed to add User";
		}
	}
}
