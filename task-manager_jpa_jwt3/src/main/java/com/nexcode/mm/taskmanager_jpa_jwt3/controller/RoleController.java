package com.nexcode.mm.taskmanager_jpa_jwt3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.RoleDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.RoleMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.request.RoleRequest;
import com.nexcode.mm.taskmanager_jpa_jwt3.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMapper roleMapper;
	
	@GetMapping
	public List<RoleDto>getAllRoles()
	{
		return roleService.getAllRoles();
	}
	
	@PostMapping
	public RoleDto addRole(@RequestBody RoleRequest request)
	{
		RoleDto dto=roleMapper.toDto(request);
		RoleDto addedRole=roleService.addRole(dto);
		return addedRole;
	}

	
}
