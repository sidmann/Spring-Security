package com.example.securityapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityApp2Application implements CommandLineRunner {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p1 = new Person();
		p1.setUsername("sid@gmail.com");
		p1.setPassword(bCryptPasswordEncoder.encode("123"));
		p1.setRole("ROLE_SOFTWARE"); // every role should be starting with ROLE_ to set roles.
		personRepository.save(p1);
		
		Person p2 = new Person();
		p2.setUsername("rahul@gmail.com");
		p2.setPassword(bCryptPasswordEncoder.encode("abc"));
		p2.setRole("ROLE_HR"); 
		personRepository.save(p2);
	}
}
