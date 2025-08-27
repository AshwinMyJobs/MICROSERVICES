package com.excel.create.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.create.service.ExcelFileServiceInterface;

@RestController
@RequestMapping("/fileService")
public class ExcelFileServiceController {
	
	@Autowired
	ExcelFileServiceInterface excelFileServiceInterface;
	
	@GetMapping
	public String insertRecord() {
		excelFileServiceInterface.insertRecord();
		return "";
	}
}
