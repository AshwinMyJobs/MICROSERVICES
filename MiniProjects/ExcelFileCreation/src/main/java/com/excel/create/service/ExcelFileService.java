package com.excel.create.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.excel.create.dto.OrderDTO;

@Service
public class ExcelFileService implements ExcelFileServiceInterface{

	@Override
	public void createExcelFile() throws FileNotFoundException, IOException{
		
		Workbook wb = new HSSFWorkbook();
		
		OutputStream fileOut = new FileOutputStream("Orders.xls");

        Sheet sheet = wb.createSheet("Orders");

        Row headerRow = sheet.createRow(0);

        Cell cell1 = headerRow.createCell(0);
        cell1.setCellValue("OrderID");

        Cell cell2 = headerRow.createCell(1);
        cell2.setCellValue("Order");

        Cell cell3 = headerRow.createCell(2);
        cell3.setCellValue("DateTime");
        
        System.out.println("File and Sheet Has been Created successfully");

        wb.write(fileOut);
        fileOut.close();

	}

	@Override
	public String insertRecord(OrderDTO orderDTO) {
		
		try {
			FileInputStream inputFile = new FileInputStream(new File("Orders.xls"));
			try (HSSFWorkbook workbook = new HSSFWorkbook(inputFile)) {
				FileOutputStream outPutFile = new FileOutputStream(new File("Orders.xls"));
				
				HSSFSheet sheet = workbook.getSheet("Orders");
				int lastRowNum = sheet.getLastRowNum();
				
				Row newRow = sheet.createRow(lastRowNum + 1);
				Cell cell1 = newRow.createCell(0);
				cell1.setCellValue(orderDTO.getOrderID());

				Cell cell2 = newRow.createCell(1);
				cell2.setCellValue(orderDTO.getOrderName());
				
				Cell cell3 = newRow.createCell(2);
				cell3.setCellValue(orderDTO.getDateTime());
				
				workbook.write(outPutFile);
			}
		    
		} catch (IOException e) {
			e.printStackTrace();
			return "Un Succfull update of file with order id : " + orderDTO.getOrderID() ;
		}
		
		return "Succfully updated file with order id : " + orderDTO.getOrderID();
	}
	
}
