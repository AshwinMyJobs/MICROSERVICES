package com.excel.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.excel.create.service.ExcelFileService;

@SpringBootApplication
public class ExcelFileCreationApplication implements CommandLineRunner{

	@Autowired
	ExcelFileService excelFileService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExcelFileCreationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		excelFileService.createExcelFile();
	}

}
