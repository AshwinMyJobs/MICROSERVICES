package com.clients;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clients.util.Utility;
import com.google.gson.Gson;

@SpringBootApplication
public class ProductCatalogueClientsThreadsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueClientsThreadsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
        String url = "http://localhost:8080/api/product/save";
        
        Product product = new Product();
        product.setId("1");
        product.setCategoryLevel1("Clothes");
        product.setCategoryLevel2("Men");
        product.setCategoryLevel3("Sweaters");
        product.setSubCatogeries(null);
        
        Gson gsonObj = new Gson();
        String requestBody = gsonObj.toJson(product);
        System.out.println(requestBody);

        for(int i=1; i<=50; i++) {
            //String requestBody = "{\"id\": "+ i +", \"categoryLevel1\": \"Clothes\", \"categoryLevel2\": \"Men\",\"categoryLevel3\": \"Shirts\"}";

            RestApiCallable apiTask = new RestApiCallable(url, gsonObj.toJson(Utility.createProduct()));

            Future<String> future = executor.submit(apiTask);

        }
	}
}
