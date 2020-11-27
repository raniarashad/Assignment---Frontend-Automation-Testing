package tests;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AddAdvertisingPageObject;

public class AddAdvertisingTest extends TestBase {

	AddAdvertisingPageObject object;
	
	@DataProvider(name ="UserLoginData_Invaild")
	public static Object[][] LoginData_Invaild (){
		return new Object[][]{
				{"",""}};
	}
	
	String validationMsg = "من فضلك ادخل البيانات صحيحة";

	@Test(dataProvider = "UserLoginData_Invaild", priority = 0 , enabled = true)
	public void Add_Advertising_InVaildLogin(String username, String Password) {
		
		object = new AddAdvertisingPageObject(driver);
		object.Login(username, Password);
		if (object.AlretMessage.isDisplayed())
		{
			System.out.println("Login Validation message is displayed successfully");
		}
		else 
		{
			System.out.println("There is no validation message displayed");
		}
	}
	
	@DataProvider(name ="UserLoginData")
	public static Object[][] LoginData_Valid (){
		return new Object[][]{
				{"rania2410","Rania123456"}};
	}
	
	@Test(dataProvider = "UserLoginData" , priority = 1 , enabled = true)
	public void Add_Advertising_VaildLogin(String username, String Password) {
		
		object = new AddAdvertisingPageObject(driver);
		object.Login(username, Password);
		object.ProfileDetails();
	}
	
	
	@DataProvider(name ="FillForm")
	public static Object[][] FillFormValid (){
		return new Object[][]{
				{"2000", "1000" , "500000" , "any free text for testing", "01111112223"}};
	}
	
	@Test(dataProvider = "FillForm" , priority = 2 ,enabled = true)
	public void FillForm(String CC , String KiloMeters , String Price , String NotesAr , String MobileNumber) throws AWTException {
		
		object = new AddAdvertisingPageObject(driver);
		object.Fill_Form(CC, KiloMeters, Price, NotesAr, MobileNumber);
		//Assert.assertEquals(MobileNo, object.MobileValueThatRegistered);
	}
}
