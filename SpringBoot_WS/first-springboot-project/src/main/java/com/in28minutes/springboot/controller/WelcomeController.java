package com.in28minutes.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.springboot.configuration.BasicConfiguration;
import com.in28minutes.springboot.service.WelcomeService;

@Controller
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;
	
	@Autowired
	private BasicConfiguration config;
	
	@RequestMapping("/welcome")
	@ResponseBody
	public String getWelcomeMessage() {
		return welcomeService.retrieveWelcomeMessage();
	}
	
	@RequestMapping("/dynamic-configuration")
	@ResponseBody
	public Map dynamicConfiguration() {
		Map map = new HashMap<>();
		map.put("message", config.getMessage());
		map.put("number", config.getNumber());
		map.put("value", config.isValue());
		
		return map;
	}
}
