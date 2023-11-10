package com.nexcode.mm.taskmanager_jpa_jwt3.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.RoleDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Role;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.RoleMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.repository.RoleRepository;
import com.nexcode.mm.taskmanager_jpa_jwt3.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public RoleDto addRole(RoleDto roleDto) {
		Role role=new Role();
		role.setRoleName(roleDto.getRoleName());
		Role savedRole=roleRepository.save(role);
		System.out.println("savedRole id "+savedRole.getRoleid());
		RoleDto dto=roleMapper.toDto(savedRole);
		System.out.println("dto's id "+dto.getRoleId());
		return dto;
	}

	@Override
	public RoleDto updateRole(Long id, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDto> getAllRoles() {
		List<Role>roles=roleRepository.findAll();
		List<RoleDto>roleDtos=roles.stream().map(r->roleMapper.toDto(r)).collect(Collectors.toList());
		return roleDtos;
	}

	@Override
	public RoleDto getRoleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
