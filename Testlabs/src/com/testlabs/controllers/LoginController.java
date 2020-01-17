package com.testlabs.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.testlabs.dao.Dao;
import com.testlabs.model.User;


@Controller

@SessionAttributes({"user"})
public class LoginController {

	@Autowired
	Dao dao;
	
	
	@RequestMapping(value="/LoginMain",method =RequestMethod.POST)
	@ResponseBody
	public String login(String userName,String password,ModelMap model) {
		
		String result = "";
		
		try {
			System.out.println("user name :"+userName+" Password :"+password);
			User user = new User();
			user = dao.verifyLogin(userName, password);
			
			Gson gson = new Gson();
			
			
			result = gson.toJson(user);
			
			if(user.getUser_email_id() != null && user.getUser_id() != 0 && user.getUser_name() != null && user.getUser_access() != null) {
				
				model.addAttribute("user",user);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "/Logout" , method = RequestMethod.GET)
	public RedirectView  logout(ModelMap model,HttpServletRequest request) {
		
		String result="";
		try {
			model.addAttribute("user", "");
			result ="login";
			request.getSession().invalidate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	
		return new RedirectView("login");
	}
	
	@RequestMapping(value="/login")
	public String reLogin() {
		
		String result ="login";
		try {
		
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	
}
