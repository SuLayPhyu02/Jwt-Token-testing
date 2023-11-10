package com.nexcode.mm.taskmanager_jpa_jwt3.security;

import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.nexcode.mm.taskmanager_jpa_jwt3.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {// we can called it jwt util
	private JwtParser jwtParser;
	
	private UserRepository userRepository;

	public JwtService() {
		jwtParser = Jwts.parser().setSigningKey("helloSecret");
		//jwtParser = Jwts.parser().setSigningKey("lovespring");
	}

	private final long duration = 24 * 60 * 60 * 1000;

	public Claims resolveClaims(HttpServletRequest request) {
		String token = getToken(request);
		try {
			if (token != null) {

				// get authorized username
				Claims claims = jwtParser.parseClaimsJws(token).getBody();
				String username=claims.getId();
				//in here i will check username from security context how?
				return claims;
			}
			return null;
			// save to SecurityContext
		} catch (ExpiredJwtException ex) {

			request.setAttribute("expired", ex.getMessage());
			throw ex;
		}
	}

	public String createToken(Authentication authentication) {
//		Claims claims=Jwts.claims();
//		claims.setId(userDto.getName());
//		Date tokenValidty=new Date(System.currentTimeMillis()+duration);
//		String jwtString=Jwts.builder().setClaims(claims).setExpiration(tokenValidty).signWith(SignatureAlgorithm.HS256,"helloSecret").compact();
//		return jwtString;

		
		Date tokenValidty = new Date(System.currentTimeMillis() + duration);
		
		
		String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		
		
		//System.out.println("In creation token "+authorities);
		String jwtString = Jwts.builder()
				.setId(authentication.getName())
				.setExpiration(tokenValidty)
				.claim("roles", authorities)
				.signWith(SignatureAlgorithm.HS256, "helloSecret").compact();
		return jwtString;
	}

	private String getToken(HttpServletRequest request) {
		String value = request.getHeader("Authorization");
		if (value != null && value.startsWith("Bearer ")) {
			return value.substring(7);
		}
		return null;
	}

}
