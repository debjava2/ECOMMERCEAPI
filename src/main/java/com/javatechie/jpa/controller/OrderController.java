package com.javatechie.jpa.controller;

import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.dto.ProductResponse;
import com.javatechie.jpa.entity.Products;
import com.javatechie.jpa.repository.CategoryRepository;
import com.javatechie.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Products placeOrder(@RequestBody OrderRequest request){
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	request.getProducts().setProductId(UUID.randomUUID().toString());
    	request.getProducts().setCreatedAt(timestamp);
    	request.getProducts().setUpdatedAt(timestamp);
    	//productRepository.save(null)
    	return productRepository.save(request.getProducts());
    }

	/*
	 * @GetMapping("/findAllOrders") public List<Products> findAllOrders(){ return
	 * categoryRepository.findAll(); }
	 */

//  @GetMapping("/getInfo")
//  public List<OrderResponse> getJoinInformation(){
//        return customerRepository.;
//    }
    @GetMapping("/api/getProduts")
    public List<Products> getProductsDetails(){
    	return productRepository.findAll();
    	//productRepository.
    }
    
    @GetMapping("/api/getProdutsBasedOnCategory/{category}")
    public List<Products> getProductsBasedOnCategory(@PathVariable String category){
    	return productRepository.findByTitleEndingWith(category);
    	//productRepository.
    }
    
    @GetMapping("/api/getProdutsBasedOnPid/{productId}")
    public Products getProductsBasedProductId(@PathVariable String productId){
    	return productRepository.findByProductId(productId);
    }
    
    
}

