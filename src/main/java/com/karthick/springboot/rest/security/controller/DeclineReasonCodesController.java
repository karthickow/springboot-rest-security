package com.karthick.springboot.rest.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthick.springboot.rest.security.config.LoadDeclineReasons;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeclineReasonCodesController {

	private final LoadDeclineReasons declineReasons;
	@GetMapping("/codes")
	public String getDeclineReason(@RequestParam final List<String> reasonCodesQueryParam) {
		final var reasonCodes = new ArrayList<>(declineReasons.getReasonCodes());
		reasonCodes.retainAll(new ArrayList<>(reasonCodesQueryParam));
		return reasonCodes.stream()
				.findFirst()
				.orElse("Not loaded");

	}



}
