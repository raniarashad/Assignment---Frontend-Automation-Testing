package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import pages.PageBase;

public class SearchingForCarsPageObject extends PageBase {

	public SearchingForCarsPageObject(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		Driver = driver;
	}
	JavascriptExecutor js;	
	WebDriver Driver;

	@FindBy(id = "btnnewsearch")
	WebElement SearchBtn;

	@FindBy(linkText = "1.6 A/T H/L New Shape Sedan")
	WebElement CarDetails;

	@FindBy(css = ".orange a")
	WebElement monthlyInstallment ; 

	@FindBy(css  = "span.inline.left.tag")
	WebElement Price;

	@FindBy(css = "[itemprop='model']")
	WebElement ModelName;

	String Model;
	String priceCar ; 
	String financing;

	public void SearchingForCars() throws IOException {

		sleep(20);

		Select dropMake = new Select(Driver.findElement(By.id("ncmakes")));
		dropMake.selectByValue("10");

		Select dropModel = new Select(Driver.findElement(By.id("ncmodels")));
		dropModel.selectByValue("10");

		ClickButton(SearchBtn);
		sleep(20);
		ClickButton(CarDetails);

		financing = monthlyInstallment.getText();
		System.out.println("the monthly installment for financing the car is : " + financing);

		sleep(20);

		priceCar = Price.getText();
		System.out.println("The Price is : " + priceCar);

		Model = ModelName.getText();
		System.out.println("Model : " + Model);
		WriteDataToExcelSheet();
	}

	public void WriteDataToExcelSheet() throws IOException{
		File source = new File("C:\\Users\\dell\\Desktop\\Automation\\Assignment\\src\\test\\java\\utilities\\Cars Data.xlsx");
		FileInputStream input = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheetAt(0);
		sheet.createRow(0).createCell(0).setCellValue("Car Model");
		sheet.getRow(0).createCell(1).setCellValue("Price");
		sheet.getRow(0).createCell(2).setCellValue("Monthly installment for financing the car");	

		sheet.createRow(1).createCell(0).setCellValue(Model);
		sheet.getRow(1).createCell(1).setCellValue(priceCar);
		sheet.getRow(1).createCell(2).setCellValue(financing);

		FileOutputStream output = new FileOutputStream(source);
		wb.write(output);
		wb.close();
	}


}

