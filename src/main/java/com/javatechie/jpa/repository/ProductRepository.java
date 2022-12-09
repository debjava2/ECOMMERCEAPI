package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Categories;
import com.javatechie.jpa.entity.Products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
	
	List<Products> findByTitleEndingWith(String category);

	Products findByProductId(String pid);
	
}
