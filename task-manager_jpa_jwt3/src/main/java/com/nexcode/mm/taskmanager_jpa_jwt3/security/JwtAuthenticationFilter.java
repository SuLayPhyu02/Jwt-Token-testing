package com.nexcode.mm.taskmanager_jpa_jwt3.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtService jwtService;
	//controller တွေ အလုပ်မလုပ်ခင် ဒါအရင်လာ
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//retrieve token from request header
		
		Claims claims=jwtService.resolveClaims(request);
		System.out.println("dofilterInternal "+claims);
		if(claims!=null)
		{
			//create authentication
	        String roles = claims.get("roles",String.class);
	        List<String> authorityArray = Arrays.asList(roles.split(","));
	        // Map roles to GrantedAuthority objects
	        List<GrantedAuthority> authorities = authorityArray.stream()
	                .map(role -> new SimpleGrantedAuthority(role))
	                .collect(Collectors.toList());
			Authentication authentication=new UsernamePasswordAuthenticationToken(claims.getId(),"",authorities);
			//save new security context
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		//do filter internal
		//continue filter chain
		filterChain.doFilter(request, response);
	}

}
