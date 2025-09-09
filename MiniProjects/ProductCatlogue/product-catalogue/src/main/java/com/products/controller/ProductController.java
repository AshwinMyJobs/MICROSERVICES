package com.products.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.products.dto.JwtToken;
import com.products.dto.Product;
import com.products.dto.ProductJwtDTO;
import com.products.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
//@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RestTemplate restTemplate;
	
//	@PostMapping("/save")
//	public String addProduct(@RequestBody Product product) {
//		
//		logger.info("Product info {}",product.toString());
//		
//		productService.addProduct(product);
//		
//		return "Product added successfully";
//	}
	
	@PostMapping("/save")
	public String addProduct(@RequestBody ProductJwtDTO productJwtDTO) {
		
		//logger.info("Product info {}",productJwtDTO.getProduct().toString());

		JwtToken jwtToken = productJwtDTO.getJwtToken();
		
		restTemplate.postForObject("http://localhost:8080/api/jwt/validate", jwtToken, JwtToken.class);
		
		productService.addProduct(productJwtDTO.getProduct());
		
		return "Product added successfully";
	}
	
	@GetMapping("/listallproducts")
	public List<Product> listAllProducts() {
		
		logger.info("Inside listAllProducts method...........");
		
		return productService.listAllProducts();
	}
	
	@GetMapping
	public String helloMethod() {
		return "Hi there , wassup !!!!!!!!";
	}
	
}
