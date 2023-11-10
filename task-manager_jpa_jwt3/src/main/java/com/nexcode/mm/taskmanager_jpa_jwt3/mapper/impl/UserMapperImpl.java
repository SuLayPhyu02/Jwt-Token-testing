package com.nexcode.mm.taskmanager_jpa_jwt3.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.UserDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.User;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.RoleMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.UserMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.request.UserRequest;
import com.nexcode.mm.taskmanager_jpa_jwt3.response.UserResponse;
@Component
public class UserMapperImpl implements UserMapper{
	

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public UserDto toDto(User user) {
		if(user==null)
		{
			return null;
		}
		UserDto userDto=new UserDto();
		userDto.setUserId(user.getUserid());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setRoles(roleMapper.toDtoList(user.getRoles()));
		return userDto;
	}

	@Override
	public List<UserDto> toDtoList(List<User> users) {
		if(users==null)
		{
			return null;
		}
		List<UserDto>dtoList=new ArrayList<>();
//		users.stream().map(user->userMapper.toDto(user)).collect(Collectors.toList());
		for(User u:users)
		{
			UserDto dto=new UserDto();
			dto.setUserId(u.getUserid());
			dto.setUsername(u.getUsername());
			dto.setPassword(u.getPassword());
			dto.setRoles(roleMapper.toDtoList(u.getRoles()));
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public UserResponse toResponse(UserDto userDto) {
		if(userDto==null)
		{
			return null;
		}
		UserResponse userResponse=new UserResponse();
		userResponse.setId(userDto.getUserId());
		userResponse.setUsername(userDto.getUsername());
		userResponse.setRoles(userDto.getRoles());
		return userResponse;
	}

	@Override
	public List<UserResponse> toResponseList(List<UserDto> userDtos) {
		if(userDtos==null)
		{
			return null;
		}
		List<UserResponse>userResponseList=new ArrayList<>();
		for(UserDto u:userDtos)
		{
			UserResponse userResponse=new UserResponse();
			userResponse.setId(u.getUserId());
			userResponse.setUsername(u.getUsername());
			userResponse.setRoles(u.getRoles());
			userResponseList.add(userResponse);
		}
		return userResponseList;
	}

	@Override
	public UserDto toDto(UserRequest request) {
		if(request==null)
		{
			return null;
		}
		UserDto dto=new UserDto();
		dto.setUsername(request.getUsername());
		dto.setPassword(request.getPassword());
		dto.setRoleIds(request.getRoles());
		return dto;
	}

}
