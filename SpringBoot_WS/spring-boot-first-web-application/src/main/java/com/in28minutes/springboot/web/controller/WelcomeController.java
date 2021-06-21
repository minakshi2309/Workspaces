package com.in28minutes.springboot.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@SessionAttributes("name") //not needed anymore as username is retrieved from Spring Security 
public class WelcomeController {
	
	/*@Autowired
	LoginService service;*/ //not required anymore as now login is getting handled by Spring Security Context  
	
	//making a default path and hardcoding  the user and refactoring the login to be done by Spring Security 
	/*@RequestMapping(value="/", method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", "in28Minutes");
		return "welcome";
	}*/
	//removing the hardcoded user name
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUserName());
		return "welcome";
	}
	
	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		}
		return principal.toString();	
	}
	
	//with view and request method type
	/*@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginMessage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValid= service.validateUser(name, password);
		if(!isValid) {
			model.put("errorMessage", "Invalid Credentials!");
			return "login";
		}
		model.put("name", name);
		//model.put("password", password);
		return "welcome";
	}*/
	
	//without jsp/view/html
	/*@RequestMapping("/login")
	@ResponseBody
	public String loginMessage() {
		return "Hello World Modified";
	}*/
	
	//with view  
	/*@RequestMapping("/login")
	public String loginMessage(@RequestParam String name, ModelMap model) {
		System.out.println("name: "+name);
		model.put("name", name);
		return "login";
	}*/
	

}
