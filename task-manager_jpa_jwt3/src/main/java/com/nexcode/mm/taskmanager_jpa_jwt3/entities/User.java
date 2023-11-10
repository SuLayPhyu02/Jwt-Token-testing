package com.nexcode.mm.taskmanager_jpa_jwt3.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name="USER_ROLES",
			joinColumns = @JoinColumn(name="userid",referencedColumnName = "userid"),
			inverseJoinColumns = @JoinColumn(name="roleid",referencedColumnName = "roleid")
			)
	private List<Role>roles;
	public User()
	{
		
	}
	public User(Long userid, String username, String password, List<Role> roles) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
