package com.nexcode.mm.taskmanager_jpa_jwt3.request;

import java.util.List;

import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Role;


public class UserRequest {
	private String username;
	private String password;
	private List<Long> roles;
	
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
	public List<Long> getRoles() {
		return roles;
	}
	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}
	public UserRequest(String username, String password, List<Long> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	
}
