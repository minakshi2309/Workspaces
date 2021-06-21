package com.in28minutes.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")	//to allow springboot web service to get accessed by another web server
@RestController
public class HelloWorldController {

	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public AuthenticationBean helloWorldBean() {
		//throw new RuntimeException("Some Error Occured! Contact support at ****-***");
		return new AuthenticationBean("Hello World");
	}
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public AuthenticationBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new AuthenticationBean(String.format("Hello World, %s",name));
	}
	
}
