package com.example.securityapp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration {

	@Autowired
	private AppUserService appUserService;
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthentication() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(appUserService);
		dao.setPasswordEncoder(getEncoder());
		return dao;
	}
	
	@Bean
	public SecurityFilterChain getAuthorization(HttpSecurity security) throws Exception {
		security.authenticationProvider(getAuthentication());
		security.authorizeHttpRequests()
		.requestMatchers("/").permitAll()
		.requestMatchers("/sales/*").hasRole("SALES")
		.requestMatchers("/marketing/*").hasRole("MARKETING")
		.requestMatchers("/both/*").hasAnyRole("SALES", "MARKETING")
		.and()
		.httpBasic()
		.and()
		.formLogin();
		return security.build();
	}
}
