package com.javatechie.jpa.controller;

import com.javatechie.jpa.Util.JwtUti;

import com.javatechie.jpa.entity.AuthRequest;
import com.javatechie.jpa.entity.User;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private JwtUti jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
    public String welcome() {
    	return "Welcome";
    }
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
		Authentication use=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), 
						authRequest.getPassword()));
		}catch(Exception ex) {
			throw new Exception("User Name or Password Not correct");
		}
		
		User user=new User();
		user.setUserName(authRequest.getUserName());
		user.setPassword(authRequest.getPassword());
		return jwtUtil.generateToken(user);
	}
}


