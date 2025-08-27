package com.excel.create;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

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
		Path filePath = Paths.get("Orders.xls");
		
		if (Files.exists(filePath)) {
			System.out.println("File is present....");
		}else {
			System.out.println("File is not present and hence creating it.....");
			excelFileService.createExcelFile();
		}
	}
}
