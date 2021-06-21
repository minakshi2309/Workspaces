package com.in28minutes.rest.webservices.restfulwebservices.helloWorld;

public class AuthenticationBean{

	private String message;

	public AuthenticationBean(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
