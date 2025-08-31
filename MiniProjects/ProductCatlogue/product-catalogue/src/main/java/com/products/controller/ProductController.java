package com.products.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.dto.Product;
import com.products.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public String addProduct(@RequestBody Product product) {
		
		logger.info("Product info {}",product.toString());
		
		productService.addProduct(product);
		
		return "Product added successfully";
	}
	
	@GetMapping("/listallproducts")
	public List<Product> listAllProducts() {
		
		logger.info("Inside listAllProducts method...........");
		
		return productService.listAllProducts();
	}
}
