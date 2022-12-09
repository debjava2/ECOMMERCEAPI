package com.javatechie.jpa;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.javatechie.jpa.entity.User;
import com.javatechie.jpa.repository.UserRepository;

@SpringBootApplication
public class SpringDataJpaMappingApplication {

	@Autowired
	UserRepository repository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@PostConstruct
	public void insertData() {
		/*
		 * List<User> user=Stream.of( new
		 * User("Debashish",passwordEncoder.encode("123"),"deb@gmail.com",true,"User"),
		 * new
		 * User("Raj",passwordEncoder.encode("8881212"),"raj@gmail.com",true,"Admin"),
		 * new
		 * User("Vikash",passwordEncoder.encode("4242"),"vikash@gmail.com",false,"User")
		 * ) .collect(Collectors.toList()); repository.saveAll(user);
		 */
	}
	public static void main(String[] args) {

		SpringApplication.run(SpringDataJpaMappingApplication.class, args);
	}

}
