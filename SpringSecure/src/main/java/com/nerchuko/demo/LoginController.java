package com.nerchuko.demo;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	
	@RequestMapping("/home")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		System.out.println("In My Login Controller");
		return "login.jsp";
	}
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal,OAuth2Authentication authentication) {
		
//		System.out.println(principal);
//		  LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
//		System.out.println("Oauthentication :"+authentication);
//		System.out.println("Email : "+properties.get("given_name"));
		return principal;
	}
	
	
	@RequestMapping("/logout-succcess")
	public String logout(Principal principal,HttpSession session) {
		
		session.invalidate();
		
		
		return "logout.jsp";
	}
}
