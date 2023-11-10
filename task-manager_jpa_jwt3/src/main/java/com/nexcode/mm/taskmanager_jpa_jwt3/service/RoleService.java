package com.nexcode.mm.taskmanager_jpa_jwt3.service;

import java.util.List;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.RoleDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Role;

public interface RoleService {
	RoleDto addRole(RoleDto roleDto);
	RoleDto updateRole(Long id,Role role);
	List<RoleDto> getAllRoles();
	RoleDto getRoleById(Long id);
	void deleteById(Long id);

}
