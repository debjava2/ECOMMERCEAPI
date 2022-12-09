package com.javatechie.jpa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StripePaymentContoller {

	@Value("${stripe.apiKeyd}")
	String API_KEY;
	
	@PostMapping("/api/payment")
	public String doPayment() {
		return API_KEY;
	}
}
