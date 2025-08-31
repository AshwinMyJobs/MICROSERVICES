package com.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.products.dto.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
}
