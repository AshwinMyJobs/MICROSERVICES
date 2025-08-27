package com.excel.create.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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
}
