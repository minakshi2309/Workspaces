package com.in28minutes.springboot.web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class LoginService {
	
	public boolean validateUser(String userId, String password) {
		//in28minutes => dummy
		return userId.equalsIgnoreCase("in28minutes") && password.equalsIgnoreCase("dummy");
	}
	

}
