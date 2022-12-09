package com.javatechie.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.javatechie.jpa.entity.Products;

class ProductRepositoryTest {

	@Autowired
    private ProductRepository productRepository;
	@Test
	void test() {
		try {
		List<Products> list=productRepository.findAll();
		System.out.println(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
