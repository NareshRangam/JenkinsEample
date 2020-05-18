package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@GetMapping(value="notes")
	public String getName()
	{
		return "Am Fine";
	}
	
	@GetMapping(value="show")
	public String getResult()
	{
		return "I got it";
	}
	
		
	
}
