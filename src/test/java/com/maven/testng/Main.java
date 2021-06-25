package com.maven.testng;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Main {
	
	@Test (dataProvider = "testdata")
	public void loginTest(String username, String password) {
		
		Reporter.log(username);
		Reporter.log(password);
	}
	
//	public static void main(String[] args)  {
//	
//		
//
//	
//		
//		
//	
//	}
	
	@DataProvider(name = "testdata")
	public String[][] readExcel() throws BiffException, IOException{
		File file = new File ("C:/Users/Prasanga Fernando/Documents/Eclipse/DataDrivenTesting/Book1.xls");

		Workbook wb = Workbook.getWorkbook(file);


		Sheet sheet = wb.getSheet(0);
		int rowsCount = sheet.getRows();
		int columnsCount = sheet.getColumns();

		String[][] extractedData = new String [rowsCount][columnsCount];

		for(int i=0;i<rowsCount;i++) {
			for(int j=0;j<columnsCount;j++) {
				Cell cell = sheet.getCell(j,i);
				//String data = cell.getContents();
				extractedData[i][j] = cell.getContents();
				//	System.out.println(extractedData[i][j]);
			}
		}

		for(int i=0;i<extractedData.length;i++) {
			for(int j=0;j<extractedData[i].length;j++) {
				System.out.println(extractedData[i][j]);

				System.out.println(extractedData[0].length);
			}
		}
		return extractedData;
	}
}
