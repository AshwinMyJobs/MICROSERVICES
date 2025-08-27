package com.excel.create.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.excel.create.dto.OrderDTO;

@Component
public interface ExcelFileServiceInterface {

	public void createExcelFile() throws FileNotFoundException, IOException;
	
	public String insertRecord(OrderDTO orderDTO);
}
