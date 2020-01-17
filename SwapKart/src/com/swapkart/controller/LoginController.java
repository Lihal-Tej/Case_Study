package com.swapkart.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.swapkart.dao.Dao;
import com.swapkart.model.QueryBean;
import com.swapkart.model.Sess;

@Controller
@Scope("session")
@SessionAttributes("userId")
public class LoginController {
	
	@Autowired
	Dao dao;

	@RequestMapping(value="/login",method =RequestMethod.POST)
	@ResponseBody
	public String login(ModelMap model,@RequestParam String loginDeatails) {
		
		String result = "0";
		ModelAndView modelAndView = null;
		try {
			
			Gson gson = new Gson();
			if(loginDeatails.equals("0")) {
				result = "0";
				modelAndView = new ModelAndView("login");
			}else {
				
				HashMap<String, String> map = new HashMap<>();
				map = gson.fromJson(loginDeatails, new TypeToken<HashMap<String, String>>(){}.getType());
				int userId = Integer.parseInt(map.get("userId"));
				String password = map.get("password");
				System.out.println("Checking the map return from ajax calll"+map);
			
				int res = dao.verifyUser(userId, password);
				if(res >0) {
					
					result = "1";
					
					model.put("userId",String.valueOf(res));
					System.out.println("In Login "+res);
					modelAndView = new ModelAndView();
					modelAndView.setViewName("homescreen");
				}
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(@ModelAttribute("userId") String   model_user,HttpSession session,ModelMap model) {
		
		String result = "0";
		
		try {
			System.out.println("In logout "+model_user);
		
			//session.invalidate();
			
//			HttpSession session = reServletRequest.getSession();
			if(session != null) {
				session.invalidate();
				model.addAttribute("userId", "");
				System.out.println("Inside the If Condition");
				result = "login";

			}
			System.out.println("In logout 74"+model_user+result);
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	@RequestMapping(value="/register",method =RequestMethod.POST)
	@ResponseBody
	public String newUser(@RequestParam String user) {
		
		String result = "0";
		
		try {
			Gson gson = new Gson();
			System.out.println(user);
			
			com.swapkart.model.user userData = gson.fromJson(user, new TypeToken<com.swapkart.model.user>() {}.getType());
			
			int res = dao.addUser(userData);
			
			System.out.println(res);
			if(res > 0) {
				
				result = String.valueOf(res);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@RequestMapping(value="/relogin",method =RequestMethod.GET)
	public RedirectView  singleSignOn() {
		
		  RedirectView redirectView = new RedirectView();
		    redirectView.setUrl("http://localhost:9090/user");
		    HashMap<String , String> map = new HashMap<>();
		    map.put("details", "Valid");
		    redirectView.setAttributesMap(map);
		    System.out.println("In Controller");
		    return redirectView;

	}
}
