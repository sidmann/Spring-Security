package com.example.securityapp3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("hello")   // SALES
	public String hello() {
		System.out.println("from hello");
		return "from hello";
	}
	
	@GetMapping("test")   // MARKETING
	public String test() {
		System.out.println("from test");
		return "from test";
	}
}
