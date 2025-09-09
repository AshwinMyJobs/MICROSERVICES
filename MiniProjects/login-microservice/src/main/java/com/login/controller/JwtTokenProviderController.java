package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.JwtToken;
import com.login.dto.Message;
import com.login.entity.UserInfo;
import com.login.service.JWTService;
import com.login.service.JwtUtil;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/jwt")
public class JwtTokenProviderController {
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
		
	@PostMapping("validate")
	public Message validateToken(@RequestBody JwtToken jwtToken) throws Exception{
		
		try {
		String userName = jwtUtil.extractUsername(jwtToken.getJwtToken());
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		
		Message message = new Message("Token is valid and can be trusted.");
		
		if(jwtUtil.validateToken(jwtToken.getJwtToken(), userDetails))
			return message;
		else
			new Exception("Token is not valid");

		}catch(Exception e){
			System.out.println(e.getMessage());
			Message message = new Message(e.getMessage());
			return message;
		}
		return null;
	}
}
