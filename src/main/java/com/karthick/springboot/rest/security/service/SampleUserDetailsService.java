package com.karthick.springboot.rest.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.karthick.springboot.rest.security.entity.Customer;
import com.karthick.springboot.rest.security.repository.CustomerRepository;

@Service
public class SampleUserDetailsService implements UserDetailsService {

	private CustomerRepository customerRepository;
	
	public SampleUserDetailsService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		String username = null;
		String password = null;
		List<GrantedAuthority> authorities = null;
		List<Customer> customers = customerRepository.findByEmail(email);
		if(customers.isEmpty()) {
			throw new UsernameNotFoundException("User details not found for the user " + email);
		}
		else {
			authorities = new ArrayList<>();
			username = customers.get(0).getEmail();
			password = customers.get(0).getPwd();
			authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
		}
		return new User(username, password, authorities);
	}

}
