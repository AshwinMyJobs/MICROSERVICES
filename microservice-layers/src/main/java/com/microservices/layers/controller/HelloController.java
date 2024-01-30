package com.microservices.layers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String differentLayers() {
		
		String returnString = "Hello, This microservice project is using 3 layers namely. 1.Controller(@RestController) 2.Service(@Service) 3.Repository(@Repository)";
		
		return returnString;
	}
}
