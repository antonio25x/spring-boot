package com.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static final String[] USERS = {"Luis Antonio", "Miguel Diaz"};

	@RequestMapping("/")
	public String inicio () {
		return "default mapping!";
	}
	
	@RequestMapping("/hello")
	public String hello () {
		return "Hola Toño from RestController!";
	}
	
	@CrossOrigin(origins={"localhost:4200"})
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String[] getUsers () {
		return USERS;
	}

}
