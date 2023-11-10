package com.nexcode.mm.taskmanager_jpa_jwt3.response;

public class RoleResponse {
	
	private Long roleid;
	private String rolename;
//	private List<UserDto>userDto;
	
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
//	public List<UserDto> getUserDto() {
//		return userDto;
//	}
//	public void setUserDto(List<UserDto> userDto) {
//		this.userDto = userDto;
//	}
	
	

}
