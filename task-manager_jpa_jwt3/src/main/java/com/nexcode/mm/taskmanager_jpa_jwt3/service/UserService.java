package com.nexcode.mm.taskmanager_jpa_jwt3.service;

import java.util.List;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.UserDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.User;

public interface UserService {
	UserDto addUser(UserDto userDto);
	UserDto updateUser(Long id,User user);
	List<UserDto> getAllUser();
	UserDto getUserById(Long id);
	void deleteById(Long id);

}
