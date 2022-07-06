package com.greatlearning.customerrelationshipmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
}