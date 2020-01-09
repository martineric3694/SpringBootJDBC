package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {
	
	@Autowired
	AnotherWorldService anotherWorldService;
	@Autowired
	WorldServiceAgain worldServiceAgain;

	public String getMessage() {
		return "Hello from Hello World Service";
	}
	
	public String getMessage(String message) {
		return message;
	}
	
	public String getAnotherWorld(String message) {
		return this.anotherWorldService.getMessage(message);
	}
	
	public String getWorldService() {
		return this.worldServiceAgain.getMessage();
	}
}
