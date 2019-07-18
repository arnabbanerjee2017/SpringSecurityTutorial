package com.arnab.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/office")
public class EmployeeController {

	@GetMapping(value = "/test")
	public String testMethod() {
		return "Test successful!"
				+ "<br /> <h4><a href=\"/logout\">Logout?</a></h4>";
	}
	
	@GetMapping(value = "/employee")
	public String getEmployee() {
		return "I am employee"
				+ "<br /> <h4><a href=\"/office/admin\">ADMIN</a></h4>"
				+ "<br /> <h4><a href=\"/office/manager\">MANAGER</a></h4>"
				+ "<br /> <h4><a href=\"/logout\">Logout?</a></h4>";
	}
	
	@GetMapping(value = "/admin")
	public String getAdmin() {
		return "I am an Admin"
				+ "<br /> <h4><a href=\"/office/employee\">EMPLOYEE</a></h4>"
				+ "<br /> <h4><a href=\"/logout\">Logout?</a></h4>";
	}
	
	@GetMapping(value = "/manager")
	public String getManager() {
		return "I am a Manager"
				+ "<br /> <h4><a href=\"/office/employee\">EMPLOYEE</a></h4>"
				+ "<br /> <h4><a href=\"/logout\">Logout?</a></h4>";
	}
	
}
