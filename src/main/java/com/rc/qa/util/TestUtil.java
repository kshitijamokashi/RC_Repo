package com.rc.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.rc.qa.base.TestBase;
public class TestUtil extends TestBase
{
	public static long Page_Load_TIMEOUT = 400;
	public static long IMPLICIT_WAIT = 100;
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		String machineName = prop.getProperty("machine");
		
		try {
			if(machineName.equalsIgnoreCase("office")) 
			{
			file = new FileInputStream(prop.getProperty("testDataPath"));
			}
			
			else if(machineName.equalsIgnoreCase("personal")) 
			{
			file = new FileInputStream("C:\\Users\\swapnil\\eclipse-workspace\\UKTD_Maven\\src\\main\\java\\com"
					+ "\\uktd\\qa\\testdata\\AddAgent.xlsx");
			}
			
			else 
			{
				System.out.println("Excel file path needs to be set on your machine");
			}
			
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "--------" +
		 sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
		
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
			
		}
		return data;
	
}
	
	public static void takeScreenshotAtEndOfTest() throws IOException 
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
}
