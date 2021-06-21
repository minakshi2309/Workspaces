package com.in28minutes.springboot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {
	
	public ModelAndView handleException(HttpServletRequest request, Exception ex) {
		ModelAndView mv =new ModelAndView();
		mv.addObject("exception", ex.getStackTrace());
		mv.addObject("url", request.getRequestURL());
		mv.setViewName("error");
		return mv;
	}

}