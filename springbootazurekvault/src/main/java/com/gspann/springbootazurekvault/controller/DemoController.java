package com.gspann.springbootazurekvault.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class DemoController {
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${welcome.message2}")
	private String welcomeMessage2;
	
	@GetMapping("/welcome")
	public String retrieveWelcomeMessage() {
		// Complex Method
		return welcomeMessage;
	}
	@GetMapping("/welcome2")
	public String retrieveWelcomeMessage2() {
		// Complex Method
		return welcomeMessage2;
	}
}
