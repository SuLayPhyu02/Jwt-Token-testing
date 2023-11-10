package com.nexcode.mm.taskmanager_jpa_jwt3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.UserDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.User;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.UserMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.response.UserResponse;
import com.nexcode.mm.taskmanager_jpa_jwt3.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping
	public List<UserResponse>getAllUser()
	{
		List<UserDto>dtoList=userService.getAllUser();
		List<UserResponse>userResponseList=userMapper.toResponseList(dtoList);
		return userResponseList;
	}
	@GetMapping("/{id}")
	public UserResponse getUserById(@PathVariable Long id)
	{
		UserDto dto=userService.getUserById(id);
		UserResponse userResponse=userMapper.toResponse(dto);
		return userResponse;
	}
	@PostMapping
	public UserResponse createUser(@RequestBody UserDto userDto)
	{
		UserDto dto=userService.addUser(userDto);
		UserResponse userResponse=userMapper.toResponse(dto);
		return userResponse;
	}
	@PutMapping("/{id}")
	public UserResponse updateUser(@PathVariable Long id,@RequestBody User user)
	{
		UserDto dto= userService.updateUser(id, user);
		UserResponse userResponse=userMapper.toResponse(dto);
		return userResponse;
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id)
	{
		userService.deleteById(id);
	}

}
