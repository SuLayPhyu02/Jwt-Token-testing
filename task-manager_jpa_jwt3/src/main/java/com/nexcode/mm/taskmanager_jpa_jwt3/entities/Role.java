package com.nexcode.mm.taskmanager_jpa_jwt3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	@Column(name="roleid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleid;
	@Column(name="roleName")
	private String roleName;
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Role(Long roleid, String roleName) {
		super();
		this.roleid = roleid;
		this.roleName = roleName;
	}
	public Role(String roleName)
	{
		this.roleName=roleName;
	}
	public Role()
	{
		
	}
	
}
