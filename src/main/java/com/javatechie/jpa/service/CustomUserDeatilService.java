package com.javatechie.jpa.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javatechie.jpa.entity.User;
import com.javatechie.jpa.repository.UserRepository;

@Service
public class CustomUserDeatilService  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByUserName(username);
		return new org.springframework.
				security.core.userdetails.
				User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}

	public User getUserDetails(String userName,String password) {
		return userRepository.findByUserName(userName);
	}
}