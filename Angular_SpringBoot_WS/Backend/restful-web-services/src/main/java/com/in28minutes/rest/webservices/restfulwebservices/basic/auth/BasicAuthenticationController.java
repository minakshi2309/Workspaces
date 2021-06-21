package com.in28minutes.rest.webservices.restfulwebservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.helloWorld.AuthenticationBean;

@CrossOrigin(origins="http://localhost:4200")	//to allow springboot web service to get accessed by another web server
@RestController
public class BasicAuthenticationController {

	
	@GetMapping(path="/basicauth")
	public AuthenticationBean helloWorldBean() {
		//throw new RuntimeException("Some Error Occured! Contact support at ****-***");
		return new AuthenticationBean("You are authenticated");
	}
	
}
