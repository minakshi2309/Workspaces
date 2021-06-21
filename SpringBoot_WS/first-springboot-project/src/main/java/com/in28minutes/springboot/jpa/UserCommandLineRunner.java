package com.in28minutes.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory
            .getLogger(UserCommandLineRunner.class);
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		//System.out.println("Getting printed command line runner at the start up of application");		
		repository.save(new User("Minakshi", "Admin"));
		repository.save(new User("Harshit", "Admin"));
		repository.save(new User("Mani", "User"));
		repository.save(new User("Kavita", "User"));
		
		log.info("-------------------------------");
        log.info("Finding all users");
        log.info("-------------------------------");
        for (User user : repository.findAll()) {
            log.info(user.toString());
        }
        
	}

	
}
