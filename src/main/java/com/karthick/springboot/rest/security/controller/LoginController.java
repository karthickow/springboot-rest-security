package com.karthick.springboot.rest.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karthick.springboot.rest.security.entity.Customer;
import com.karthick.springboot.rest.security.repository.CustomerRepository;

@RestController
public class LoginController {

	private CustomerRepository customerRepository;
	
	public LoginController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		Customer savedCustomer = null;
		ResponseEntity<String> responseEntity = null;
		try {
			savedCustomer = customerRepository.save(customer);
			if(savedCustomer.getId() > 0) {
				responseEntity = ResponseEntity
						.status(HttpStatus.CREATED)
						.body("Gived user details are successfully saved");
			}
		}catch (Exception e) {
			responseEntity = ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An expection occured due to " + e.getMessage());
		}
		return responseEntity;
	}
}
