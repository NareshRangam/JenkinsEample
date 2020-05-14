package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class JenkinsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsProjectApplication.class, args);
	}

}
