package com.excel.create.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelFileService {

	
	public void createExcelFile() throws FileNotFoundException, IOException{
		
		Workbook wb = new HSSFWorkbook();
		
		OutputStream fileOut = new FileOutputStream("DailyTasks.xlsx");

        Sheet sheet1 = wb.createSheet("Array");
        Sheet sheet2 = wb.createSheet("String");
        Sheet sheet3 = wb.createSheet("LinkedList");
        Sheet sheet4 = wb.createSheet("Tree");
        Sheet sheet5 = wb.createSheet("Dynamic Programming");
        Sheet sheet6 = wb.createSheet("Puzzles");
        
        // Display message on console for successful
        // execution of program
        System.out.println(
            "Sheets Has been Created successfully");

        // Finding number of Sheets present in Workbook
        int numberOfSheets = wb.getNumberOfSheets();
        System.out.println("Total Number of Sheets: "
                           + numberOfSheets);

        wb.write(fileOut);
	}
	
}
