package com.nexcode.mm.taskmanager_jpa_jwt3.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nexcode.mm.taskmanager_jpa_jwt3.entities.User;
import com.nexcode.mm.taskmanager_jpa_jwt3.repository.UserRepository;
import com.nexcode.mm.taskmanager_jpa_jwt3.security.UserDetailsImpl;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		User foundedUser=userRepository.findByUsername(name).orElse(null);
		System.out.println("LoadUserByUsername involked");
		List<GrantedAuthority>authorities=foundedUser.getRoles()
				.stream().map
				(role->new SimpleGrantedAuthority("ROLE_"+role.getRoleName()))
				.collect(Collectors.toList());
		authorities.forEach(a->{System.out.println(a.getAuthority());});
		if(foundedUser!=null)
		{
			UserDetailsImpl userDetails=UserDetailsImpl.getInstance
					(
					foundedUser.getUserid(), 
					foundedUser.getUsername(),
					foundedUser.getPassword(),
					authorities
					);
			return userDetails;
		}
//		System.out.println("User worked ");
//		return UserDetailsImpl.getInstance(1L, "ko ko", "koko123");
		throw new UsernameNotFoundException("User not found with username "+name);
	}

}
