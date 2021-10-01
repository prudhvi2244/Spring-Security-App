package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	public String getHomePage()
	{
		return "home";
	}
	
	@GetMapping(value = "/admin")
	public String getadminPage()
	{
		return "admin";
	}
	
	@GetMapping(value = "/employee")
	public String getEmployeePage()
	{
		return "employee";
	}
	
	@GetMapping(value = "/student")
	public String getStudentPage()
	{
		return "student";
	}
	
	@GetMapping(value = "/services")
	public String getServicesPage()
	{
		return "services";
	}
	
	@GetMapping(value = "/welcome")
	public String getWelcomePage()
	{
		return "welcome";
	}
	
	@GetMapping(value = "/access-denied")
	public String getAcessDeniedPage()
	{
		return "access-denied";
	}
}
