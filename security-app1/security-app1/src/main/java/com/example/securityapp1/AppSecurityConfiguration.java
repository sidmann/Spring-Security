package com.example.securityapp1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppSecurityConfiguration {
	
	@Bean
	public UserDetailsService getUsers(BCryptPasswordEncoder encoder)
	{
		InMemoryUserDetailsManager userManager = 
				new InMemoryUserDetailsManager();
		userManager.createUser(User
							   .withUsername("rahul")
							   .password(encoder.encode("123"))
							   .roles("EMP")
							   .build());
		
		userManager.createUser(User
			    .withUsername("sid")
			    .password(encoder.encode("123"))
			    .roles("ADMIN")
			    .build());
		
		userManager.createUser(User
				.withUsername("vijay")
				.password(encoder.encode("great123"))
				.roles("ADMIN", "EMP")
				.build());
		
		return userManager;
	}
	
	@Bean
	public SecurityFilterChain authorization(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests()
		.requestMatchers("/").permitAll()
		.requestMatchers("/hello").hasRole("EMP")
		.requestMatchers("/test").hasAnyRole("ADMIN", "EMP")
		.and()
		.httpBasic();
		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
