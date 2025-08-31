package com.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.dto.Product;
import com.products.repository.ProductRepository;
import com.products.utility.Utility;

@Service
public class ProductService implements ProductServiceIntf{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public String addProduct(Product product) {
		
		String id = Utility.getUUID().toString();
		
		product.setId(id);
		
		productRepository.save(product);
		
		return "Product added successfully";
	}

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

}
