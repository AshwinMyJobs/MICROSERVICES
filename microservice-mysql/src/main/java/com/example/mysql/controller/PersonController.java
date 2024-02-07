package com.example.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.entity.Person;
import com.example.mysql.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping
	public List<Person> getAllPerson(){
		return personService.getPersonList();
	}
}
