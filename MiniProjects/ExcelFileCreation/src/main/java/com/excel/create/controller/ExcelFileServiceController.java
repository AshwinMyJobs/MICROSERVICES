package com.excel.create.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.create.dto.OrderDTO;
import com.excel.create.service.ExcelFileServiceInterface;

@RestController
@RequestMapping("/fileService")
public class ExcelFileServiceController {
	
	@Autowired
	ExcelFileServiceInterface excelFileServiceInterface;
	
	@PostMapping
	public String insertRecord(@RequestBody OrderDTO orderDTO) {
		orderDTO.setDateTime(LocalDateTime.now().toString());
		System.out.println(orderDTO.getOrderID() + " " + orderDTO.getOrderName() + " " + orderDTO.getDateTime());
		return excelFileServiceInterface.insertRecord(orderDTO);
	}
	
	@GetMapping("/custom")
	public void customMethod() throws Exception{
		System.out.println("Custom Method is called.......");
		
		String url = "http://localhost:8080/fileService"; // Example API endpoint
        String jsonInputString = "{\"orderID\": 1, \"orderName\": \"foo\", \"dateTime\": \"\"}";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Set request method to POST
        con.setRequestMethod("POST");

        // Set request headers
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        // Enable output for sending the request body
        con.setDoOutput(true);

        // Send the request body
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            byte[] postData = jsonInputString.getBytes(StandardCharsets.UTF_8);
            wr.write(postData);
            wr.flush();
        }

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        // Read the response
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println("Response Body :: " + response.toString());
        }
	}
}
