package com.karthick.springboot.rest.security.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthick.springboot.rest.security.model.DeclineReason;

import jakarta.annotation.PostConstruct;

@Configuration
public class LoadDeclineReasons {
	
	private List<String> codes = new ArrayList<>();
	private ResourceLoader resourceLoader;
	
	public LoadDeclineReasons(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@PostConstruct
	private void init() {
		Resource resource = resourceLoader.getResource("classpath:declineReasons.json");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<DeclineReason> declineReasons = Arrays.asList(objectMapper.readValue(resource.getInputStream(), DeclineReason[].class));
			codes = declineReasons.stream().map(DeclineReason::getName).toList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getReasonCodes(){
		return codes;
	}
}
