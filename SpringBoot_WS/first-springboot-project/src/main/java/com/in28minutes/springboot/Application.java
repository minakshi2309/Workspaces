package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@ComponentScan("com.in28minutes")
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		//System.out.println("Harshit is bakchonhar");
	}
	
	@Profile("dev")
	@Bean
	public String dummy() {
		return "something";
	}

}