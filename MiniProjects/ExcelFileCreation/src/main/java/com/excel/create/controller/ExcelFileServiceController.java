package com.excel.create.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.create.dto.OrderDTO;
import com.excel.create.service.ExcelFileServiceInterface;
import com.excel.create.tasks.RestApiCallable;

@RestController
@RequestMapping("/fileService")
public class ExcelFileServiceController {
	
	Logger logger = LoggerFactory.getLogger(ExcelFileServiceController.class);
	
	@Autowired
	ExcelFileServiceInterface excelFileServiceInterface;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertRecord(@RequestBody OrderDTO orderDTO) {
		
		orderDTO.setDateTime(LocalDateTime.now().toString());
		logger.info("Inside ExcelFileServiceController.insertRecord() method.......");
		logger.info(orderDTO.getOrderID() + " " + orderDTO.getOrderName() + " " + orderDTO.getDateTime());
		return excelFileServiceInterface.insertRecord(orderDTO);
	}
}
