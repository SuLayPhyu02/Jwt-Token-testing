package com.nexcode.mm.taskmanager_jpa_jwt3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nexcode.mm.taskmanager_jpa_jwt3.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity httpSecurity,UserDetailsService userDetailsService,PasswordEncoder passwordEncoder) throws Exception
	{
		//get authManager builder
		AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		//set user details service and password
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
		//build authManager
		AuthenticationManager authenticationManager=builder.build();
		return authenticationManager;
	}
//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
//		return manager;
//	}
	// username password ပါမပါ ပဲ စစ်
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//policy needed if the jwt token is created the filter didn't care about anything only for token
		http.csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests(authorize -> authorize.antMatchers(HttpMethod.POST,"/api/auth/login").permitAll()
				.antMatchers("/api/auth/signup").hasRole("ADMIN")
				.anyRequest().authenticated());
		
		//http.authorizeRequests(authorize -> authorize.anyRequest().permitAll());
		//http.formLogin();
		//http.httpBasic();
		//create custom filter to retrieve jwt token
		//add custom filter to httpSecurity filter
		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	

}
