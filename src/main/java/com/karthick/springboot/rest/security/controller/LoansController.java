package com.karthick.springboot.rest.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
	@GetMapping("/my-loans")
	public String getLoanDetails() {
		return "Here are the loan details from the DB";
	}
}
