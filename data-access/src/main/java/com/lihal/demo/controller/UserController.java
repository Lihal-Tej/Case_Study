package com.lihal.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lihal.demo.model.User;

@RestController
public class UserController {

	List<User> lLstUsers = new ArrayList<>();
	Gson gson = new Gson();
	
	@GetMapping(value = "/appName",produces = "application/json")
	public String getAppName() {
		return "Data-Access";
	}
	
	@GetMapping(value = "/users",produces = "application/json")
	public String getAllUsers(){
		
		if(lLstUsers.size() ==0) {
			lLstUsers.add(new User(100,"Lihal","lihal@gmil.com","Bangalore"));
			lLstUsers.add(new User(1001,"teja","teja@gmil.com","Bangalore"));
		}
		
		return gson.toJson(lLstUsers);
				
	}
	
	@PutMapping(value = "/users",produces =  "application/json")
	public String updateUsers(@RequestParam int id, @RequestParam String name) {
		int index = 0;
		for(User user : lLstUsers) {
			if(user.getUserId() == id) {break;}index++;
		}
		lLstUsers.get(index).setUserName(name);
		return gson.toJson(lLstUsers.get(index));
	}
	
	@PostMapping(value="/users", produces = "application/json")
	public String addUser(@RequestBody String pStrREquestBody){
		Gson lGson = new Gson();
		User lUser = lGson.fromJson(pStrREquestBody, User.class);
		lLstUsers.add(lUser);
		return gson.toJson(lLstUsers);
	}
	
	@DeleteMapping(value="/users", produces = "application/json")
	public String deleteUser() {
		lLstUsers.clear();
		return gson.toJson(lLstUsers);
	}
}
