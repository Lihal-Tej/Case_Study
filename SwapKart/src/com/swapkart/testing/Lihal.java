package com.swapkart.testing;

import java.util.HashMap;

import com.google.gson.Gson;

public class Lihal {
	
	public static void main(String[] args) {
		
		new Lihal().toJson("");
	}
	
	public void toJson(Object obj) {
		
		HashMap<String ,String> json = new HashMap<>();
		String test = "{name:lihal,gender:male}";
			Character breaker = ':';
		if(test.length() > 0 ) {
			String key = "";
			for(int i =1;i<test.length();i++) {
				
				if(test.charAt(i) !=  breaker) {
					key = key+test.charAt(i);
					
				}else {
					key = "";
					
				}
			}
		}
		
		
	}

}
