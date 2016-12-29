package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String inicio () {
		return "default mapping!";
	}
	
	@RequestMapping("/hello")
	public String hello () {
		return "Hola Toño from RestController!";
	}

}
