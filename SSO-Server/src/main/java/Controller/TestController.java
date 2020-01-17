package Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public void test() {
		
		System.out.println("In Controller");
	}
	
	
	
	@GetMapping("/user")
	public Principal user(Principal principal) {
		
		return principal;
	}
}
