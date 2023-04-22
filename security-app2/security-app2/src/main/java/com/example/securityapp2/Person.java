package com.example.securityapp2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {
	
	@Id
	private String username;
	private String password;
	private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
