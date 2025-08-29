package com.excel.create;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
public class ExcelFileCreationApplication implements CommandLineRunner {

	@Autowired
	ExcelFileService excelFileService;

	public static void main(String[] args) {
		SpringApplication.run(ExcelFileCreationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Path filePath = Paths.get("Orders.xls");
//		
//		if (Files.exists(filePath)) {
//			System.out.println("File is present....");
//		}else {
//			System.out.println("File is not present and hence creating it.....");
//			excelFileService.createExcelFile();
//		}
//
//		Path filePath = Paths.get("\\\\\\\\ASHWINS\\\\SharedFolder\\\\Orders.xls");
//
//		if (Files.exists(filePath)) {
//			System.out.println("File is present....");
//		} else {
//			System.out.println("File is not present and hence creating it.....");
//			String networkFilePath = "\\\\ASHWINS\\SharedFolder\\Orders.xls";
//
//			try {
//				// Create a File object representing the file on the network drive
//				File networkFile = new File(networkFilePath);
//
//				// Create the new file if it doesn't already exist
//				if (networkFile.createNewFile()) {
//					System.out.println("File created successfully on network drive: " + networkFile.getAbsolutePath());
//
//					// Optional: Write content to the file
//					try (FileWriter writer = new FileWriter(networkFile)) {
//						writer.write("This is some content for the network file.");
//						System.out.println("Content written to the file.");
//					}
//				} else {
//					System.out.println("File already exists on network drive: " + networkFile.getAbsolutePath());
//				}
//
//			} catch (IOException e) {
//				System.err.println("An error occurred while creating or writing to the file on the network drive:");
//				e.printStackTrace();
//			}
//		}
	}
}
