package com.clients.util;

import com.clients.Product;

public class Utility {

	
	public static Product createProduct() {
				
		Product product = new Product();
		
		int randomNumber = (int) (Math.random() * (4 - 1 + 1)) + 1;
		
		if(randomNumber==1) {
			product.setCategoryLevel3("Shirts");
		}else if(randomNumber==2) {
			product.setCategoryLevel3("Pants");
		}if(randomNumber==3) {
			product.setCategoryLevel3("Sweater");
		}else if(randomNumber==4) {
			product.setCategoryLevel3("T-Shirts");
		}
		
		return product;
	}
}
