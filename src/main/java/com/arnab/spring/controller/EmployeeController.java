package com.arnab.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@GetMapping(value = "/test")
	public String testMethod() {
		return "Test successful!";
	}
	
}
