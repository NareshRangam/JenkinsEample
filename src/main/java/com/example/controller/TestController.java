package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@RequestMapping("notes")
	public String getName()
	{
		return "Am Fine";
	}
	
	@RequestMapping("show")
	public String getResult()
	{
		return "I got it";
	}
}
