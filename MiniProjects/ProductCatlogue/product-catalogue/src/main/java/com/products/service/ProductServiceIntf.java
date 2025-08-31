package com.products.service;

import java.util.List;

import com.products.dto.Product;

public interface ProductServiceIntf {

	public String addProduct(Product product);
	
	public List<Product> listAllProducts();
}
