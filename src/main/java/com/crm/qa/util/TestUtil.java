package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;
import com.google.common.io.Files;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=60;
	public static long IMPLICIT_WAIT=60;
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}

	public static String TESTDATA_SHEET_PATH = "E:\\eclipse workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\crmtestdata.xlsx";
	
	//flashing the web element
	@SuppressWarnings("unused")
	public static void flash(WebElement element,WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor) driver);
		String bgcolor=element.getCssValue("backgroundColor");
		changeColor("rgb(0,200,0)",element,driver);
		changeColor(bgcolor,element,driver);
	}
	
	//changing the background of a web element for a specific amount of time
	public static void changeColor(String color,WebElement element, WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
		try{
			Thread.sleep(20);
			
		}catch(InterruptedException e){
			
		}
	}
	

	// clicking on the web element using java script executor
	public static void clickElement(WebElement element,WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			
		}
	}

	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
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
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Files.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
	
}
