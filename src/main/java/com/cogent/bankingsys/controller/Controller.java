package com.cogent.bankingsys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String getAllTrips() {
		return "Hello";
	}

}
