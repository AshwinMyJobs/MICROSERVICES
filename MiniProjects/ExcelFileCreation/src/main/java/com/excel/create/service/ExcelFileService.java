package com.excel.create.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.excel.create.dto.OrderDTO;
import com.excel.create.util.Utility;

@Service
public class ExcelFileService implements ExcelFileServiceInterface {
	
	Logger logger = LoggerFactory.getLogger(ExcelFileService.class);

	@Override
	public void createExcelFile() throws FileNotFoundException, IOException {

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

	@Value("${app.shared.file.location.cpu}")
	private String cpuFileLocation;

	@Value("${app.shared.file.location.laptop}")
	private String laptopFileLocation;

	String networkFilePath = null;

	@Override
	public String insertRecord(OrderDTO orderDTO) {

		UUID orderUUID = Utility.getUUID();

		if (Utility.isUUIDEvenOrOdd(orderUUID).equals("Even")) {
			networkFilePath = cpuFileLocation;
			System.out.println("File location is : " + networkFilePath);
		} else {
			networkFilePath = laptopFileLocation;
			System.out.println("File location is : " + networkFilePath);
		}

		try {
			FileInputStream inputFile = new FileInputStream(new File(networkFilePath));
			try (HSSFWorkbook workbook = new HSSFWorkbook(inputFile)) {
				FileOutputStream outPutFile = new FileOutputStream(new File(networkFilePath));

				HSSFSheet sheet = workbook.getSheet("Orders");
				int lastRowNum = sheet.getLastRowNum();

				Row newRow = sheet.createRow(lastRowNum + 1);
				Cell cell1 = newRow.createCell(0);
				orderDTO.setOrderID(Utility.getUUID().toString());
				cell1.setCellValue(orderDTO.getOrderID());

				Cell cell2 = newRow.createCell(1);
				cell2.setCellValue(orderDTO.getOrderName());

				Cell cell3 = newRow.createCell(2);
				cell3.setCellValue(orderDTO.getDateTime());

				workbook.write(outPutFile);
				inputFile.close();
				outPutFile.close();
			}

		} catch (IOException e) {
			logger.info(e.getLocalizedMessage());
			return "Un Succfull update of file with order id : " + orderDTO.getOrderID();
		}
		logger.info("Succfully updated file with order id : {} ", orderDTO.getOrderID());
		return "Succfully updated file with order id : " + orderDTO.getOrderID();
	}
}
