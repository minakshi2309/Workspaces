package com.in28minutes.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

	@Value("${welcome.message}")
	public String welcomeMessge;
	
	public String retrieveWelcomeMessage() {
		return welcomeMessge;
	}
}
