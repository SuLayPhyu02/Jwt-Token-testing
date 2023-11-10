package com.nexcode.mm.taskmanager_jpa_jwt3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.UserDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Role;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.User;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.UserMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.repository.RoleRepository;
import com.nexcode.mm.taskmanager_jpa_jwt3.repository.UserRepository;
import com.nexcode.mm.taskmanager_jpa_jwt3.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto addUser(UserDto userDto) {
		
	    User user = new User();
	    user.setUsername(userDto.getUsername());
	    String encodedPassword = passwordEncoder.encode(userDto.getPassword());
	    user.setPassword(encodedPassword);
	    //this way is adding default user
//	    List<Role> roles = new ArrayList<>();
//		Role role=roleRepository.findByRoleid(1L).orElse(null);
//		if(role!=null)
//		{
//			roles.add(role);
//		}
//		user.setRoles(roles);
	    //this way is adding roles with list<long> in body request
	    List<Long>ids=userDto.getRoleIds();
		List<Role> roles = new ArrayList<>();
		for(Long roleId:ids)
		{
			Role role=roleRepository.findByRoleid(roleId).orElse(null);
			System.out.println(role.getRoleName());
			if(role!=null)
			{
				roles.add(role);
			}
		}
		user.setRoles(roles);
	    User savedUser = userRepository.save(user);
	    UserDto savedUserDto = userMapper.toDto(savedUser);
	    return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		Optional<User> optionalUser=userRepository.findById(id);
		User foundedUser=optionalUser.get();
		UserDto userDto=null;
		if(foundedUser!=null)
		{
			userDto=userMapper.toDto(foundedUser);
		}
		return userDto;
	}
	@Override
	public UserDto updateUser(Long id, User user) {
		Optional<User> optionalUser=userRepository.findById(id);
		User foundedUser=optionalUser.get();
		UserDto userDto=null;
		if(foundedUser!=null)
		{
			foundedUser.setUsername(user.getUsername());
			String encodedPassword=passwordEncoder.encode(foundedUser.getPassword());
			user.setPassword(encodedPassword);
			User updatedUser=userRepository.save(foundedUser);
			userDto=userMapper.toDto(updatedUser);
		}
		return userDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User>users=userRepository.findAll();
		List<UserDto>userDtos=userMapper.toDtoList(users);
		return userDtos;
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
//		User user=userRepository.deleteById(id);
//		UserDto deletedUserDto=userMapper.toDto(deletedUser);
//		return deletedUserDto;
	}

}
