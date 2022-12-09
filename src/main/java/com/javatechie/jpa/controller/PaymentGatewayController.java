package com.javatechie.jpa.controller;

import com.javatechie.jpa.controller.StripeClient;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/payment")
public class PaymentGatewayController {
	 private StripeClient stripeClient;
	 @Autowired
	    PaymentGatewayController(StripeClient stripeClient) {
	        this.stripeClient = stripeClient;
	    }
	 
	 @PostMapping("/charge")
	    public String chargeCard(@RequestHeader(value="token") String token, @RequestHeader(value="amount") Double amount) throws Exception {
	       // return this.stripeClient.chargeNewCard(token, amount);
		 	System.out.println(this.stripeClient.paymentToClient(amount).getAmount());
		 		return "Success";
	    }
}
