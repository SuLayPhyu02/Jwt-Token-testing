package com.nexcode.mm.taskmanager_jpa_jwt3.mapper;

import java.util.List;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.RoleDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Role;
import com.nexcode.mm.taskmanager_jpa_jwt3.request.RoleRequest;
import com.nexcode.mm.taskmanager_jpa_jwt3.response.RoleResponse;



public interface RoleMapper {
	
	RoleDto toDto(Role role);
	List<RoleDto>toDtoList(List<Role>roles);
	RoleDto toDto(RoleRequest request);
	RoleResponse toResponse(RoleDto dto);
}
