package com.example.mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mysql.entity.Person;
import com.example.mysql.repository.PersonRepository;

@Component
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getPersonList(){
		return personRepository.findAll();
	}
}
