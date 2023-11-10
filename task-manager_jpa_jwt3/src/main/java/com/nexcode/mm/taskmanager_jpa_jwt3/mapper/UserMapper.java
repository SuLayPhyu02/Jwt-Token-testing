package com.nexcode.mm.taskmanager_jpa_jwt3.mapper;

import java.util.List;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.UserDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.User;
import com.nexcode.mm.taskmanager_jpa_jwt3.request.UserRequest;
import com.nexcode.mm.taskmanager_jpa_jwt3.response.UserResponse;

public interface UserMapper {
	UserDto toDto(User user);
	List<UserDto> toDtoList(List<User>users);
	UserResponse toResponse(UserDto userDto);
	List<UserResponse>toResponseList(List<UserDto>userDtos);
	UserDto toDto(UserRequest request);
}
