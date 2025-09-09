package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.Message;
import com.login.entity.UserInfo;
import com.login.service.JWTService;
import com.login.service.LoginService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	JWTService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@GetMapping("/hello")
	public UserInfo sayHelloMethod() {
		System.out.println("sayHelloMethod is called ..............");
		return new UserInfo();
	}

	@GetMapping("/helloAuthorized")
	@PreAuthorize("hasAuthority('USER')")
	public UserInfo sayHelloAuthorizedMethod() {
		System.out.println("sayHelloAuthorizedMethod is called ..............");
		return new UserInfo();
	}
	
	@PostMapping(value = "/register")
	public Message addNewUser(@RequestBody UserInfo userInfo) {
		System.out.println(userInfo.toString());
		if(userInfo.getRoles()==null) userInfo.setRoles("USER");
		return loginService.addUser(userInfo);
	}

	@GetMapping("/all")
	public List<UserInfo> listAllUsers() {
		List<UserInfo> list = loginService.listAllUsers();
		return list;
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody UserInfo userInfo) {
		System.out.println(userInfo.toString());
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userInfo.getName(), userInfo.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			//return new ResponseEntity<Message>((new Message("Invalid Username or Passsword")), HttpStatus.OK);
			return new String("Invalid Username or Passsword");
		}
		//return new ResponseEntity<Message>((new Message(jwtService.generateToken(userInfo.getName()))), HttpStatus.OK);
		return jwtService.generateToken(userInfo.getName());
	}
}
