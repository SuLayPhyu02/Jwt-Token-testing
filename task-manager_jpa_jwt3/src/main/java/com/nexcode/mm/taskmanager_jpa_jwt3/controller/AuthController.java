package com.nexcode.mm.taskmanager_jpa_jwt3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.UserDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.UserMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.request.LoginRequest;
import com.nexcode.mm.taskmanager_jpa_jwt3.request.UserRequest;
import com.nexcode.mm.taskmanager_jpa_jwt3.response.JwtResponse;
import com.nexcode.mm.taskmanager_jpa_jwt3.response.UserResponse;
import com.nexcode.mm.taskmanager_jpa_jwt3.security.JwtService;
import com.nexcode.mm.taskmanager_jpa_jwt3.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public JwtResponse login(@RequestBody LoginRequest loginRequest)
	{  
		Authentication authentication	=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
//		UserDto userDto=new UserDto();
//		userDto.setUsername(authentication.getName());
//		System.out.println("authentication "+authentication.getName());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwtToken=jwtService.createToken(authentication);
		JwtResponse jwtResponse=new JwtResponse();
		jwtResponse.setType("Bearer");
		jwtResponse.setAccessToken(jwtToken);
		return jwtResponse;
	}
	//adimn //user
	@PostMapping("/signup")
	public UserResponse createUser(@RequestBody UserRequest userRequest)
	{
		UserDto dto=userMapper.toDto(userRequest);
		UserDto savedDto=userService.addUser(dto);
		UserResponse userResponse=userMapper.toResponse(savedDto);
		return userResponse;
	}

}
