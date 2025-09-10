package com.dept.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@Scope("request")
public class HelloController {

	@GetMapping
	public String sayHello() throws InterruptedException{
		
		System.out.println("Request ....." + Thread.currentThread().getName());
		Thread.sleep(1000);
		System.out.println("Response .........." + Thread.currentThread().getName());
		return "Hello from HelloController ...." + Thread.currentThread().getName();
	}
}
