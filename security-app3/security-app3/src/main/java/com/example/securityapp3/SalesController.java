package com.example.securityapp3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sales")
public class SalesController {

	@GetMapping("service1")
	public String service1() {
		System.out.println("sales service1");
		return "From sales service1";
	}
	
	@GetMapping("service2")
	public String service2() {
		System.out.println("sales service2");
		return "From sales service2";
	}	
}
