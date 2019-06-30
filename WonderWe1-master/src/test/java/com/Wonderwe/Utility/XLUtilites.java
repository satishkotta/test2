package com.Wonderwe.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class XLUtilites {
	public static DataFormatter formatter = new DataFormatter();
	
	@DataProvider
	public static String[][] registerdata(Method m) throws IOException
	{
		switch(m.getName()) {
		/*case "signup": 
			return readsheet(0);*/
		case "Billingaddress":
			return readsheet(1);
		case "Shippingaddress":
			return readsheet(2);
		}
		return null;
	}
	private static String[][] readsheet(int index) throws IOException
	{
		try {
			FileInputStream fis=new FileInputStream("F:\\gurur99_e-commerce\\signup.xlsx");
			System.out.println(fis);
			
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheetAt(index);
			int rowcount=sheet.getPhysicalNumberOfRows();
			int columcount=sheet.getRow(0).getLastCellNum();
			String Data[][] = new String[rowcount-1][columcount];
			
			for (int i = 0; i <rowcount-1; i++) {
				
				XSSFRow currentrow=sheet.getRow(i+1);
				
				for (int j = 0; j <currentrow.getPhysicalNumberOfCells(); j++) {
					
					String value = formatter.formatCellValue(currentrow.getCell(j));
					Data[i][j] = value;
					
					System.out.print("  "  +  value);
					
				}
				
				System.out.println();

				return Data;
				
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
