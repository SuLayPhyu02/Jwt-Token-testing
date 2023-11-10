package com.nexcode.mm.taskmanager_jpa_jwt3.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.RoleDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Role;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.RoleMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.request.RoleRequest;
import com.nexcode.mm.taskmanager_jpa_jwt3.response.RoleResponse;


@Component
public class RoleMapperImpl implements RoleMapper{

	@Override
	public RoleDto toDto(Role role) {
		if(role==null) {
			return null;
		}
		RoleDto dto=new RoleDto();
		dto.setRoleId(role.getRoleid());
		dto.setRoleName(role.getRoleName());
		return dto;
	}

	@Override
	public List<RoleDto> toDtoList(List<Role> roles) {
		return roles.stream().map(r->toDto(r)).collect(Collectors.toList());
	}

	@Override
	public RoleDto toDto(RoleRequest request) {
		if(request==null)
		{
			return null;
		}
		RoleDto dto=new RoleDto();
		dto.setRoleName(request.getRoleName());
		return dto;
	}

	@Override
	public RoleResponse toResponse(RoleDto dto) {
		if(dto==null)
		{
			return null;
		}
		RoleResponse response=new RoleResponse();
		response.setRoleid(dto.getRoleId());
		response.setRolename(dto.getRoleName());
		return response;
	}

}
