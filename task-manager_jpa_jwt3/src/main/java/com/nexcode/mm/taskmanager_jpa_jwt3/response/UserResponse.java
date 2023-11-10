package com.nexcode.mm.taskmanager_jpa_jwt3.response;

import java.util.List;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.RoleDto;

public class UserResponse {
	private Long id;
	private String username;
	private List<RoleDto>roles;
	public UserResponse()
	{
		
	}
	public UserResponse(Long id, String username, List<RoleDto> roles) {
		super();
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<RoleDto> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
	
}
