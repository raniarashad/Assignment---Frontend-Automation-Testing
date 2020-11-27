package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddAdvertisingPageObject extends PageBase{

	public AddAdvertisingPageObject(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		Driver = driver;
	}
	JavascriptExecutor js;	
	WebDriver Driver;

	@FindBy(className = "add_ad")
	WebElement Add_AdvertisingLink;

	@FindBy(className = "ad-car")
	WebElement AddUsed_Car;

	@FindBy(id = "Email")
	WebElement UsernameInput;

	@FindBy(id = "Password")
	WebElement PasswordInput ;

	@FindBy(id = "btnlogin")
	WebElement LoginBtn;

	@FindBy(css = "p.alert-box.alert.radius")
	public WebElement AlretMessage;


	@FindBy(id = "CC")
	WebElement CCInput;

	@FindBy(id = "KiloMeters")
	WebElement KiloMetersInput;

	@FindBy(id = "Price")
	WebElement PriceInput;

	@FindBy(css = "[tabindex='8']")
	WebElement RadioButtonForCarType;

	@FindBy (css = "[tabindex='11']")
	WebElement No_OfDoors;

	@FindBy(css = "[tabindex='12']")
	WebElement FabrekaRadioBtn;

	@FindBy(id = "AirCondition")
	WebElement AirCondition;

	@FindBy(id = "ElectricWindows")
	WebElement ElectricWindows;

	@FindBy(id = "ABS")
	WebElement ABS;

	@FindBy(id = "CenterLock")
	WebElement CenterLock;

	@FindBy(id = "EBD")
	WebElement EBD;

	@FindBy(id = "AirBags")
	WebElement AirBags;

	@FindBy(id = "RadioCassette")
	WebElement RadioCassette;

	@FindBy(id = "NotesAr")
	WebElement NotesArArea;

	@FindBy(id = "Telephones")
	WebElement MobileNumberInput;

	@FindBy(css = ".user_area a")
	WebElement ProfileDetails;

	@FindBy(css = ".dropdown li a[href='https://www.contactcars.com/user/login']")
	WebElement LoginPage;
	
	@FindBy(id = "Mobile")
    WebElement MobileNoRegistered;

	public String MobileValueThatRegistered;

	public void Login(String Email, String Password)
	{
		ClickButton(ProfileDetails);
		ClickButton(LoginPage);

		SetElementText(UsernameInput, Email);
		SetElementText(PasswordInput, Password);

		ClickButton(LoginBtn);
	}

	public void ProfileDetails()
	{
		ClickButton(ProfileDetails);

		MobileValueThatRegistered= MobileNoRegistered.getAttribute("value");
		System.out.println(MobileValueThatRegistered);
	}

	public void Fill_Form (String CC , String KiloMeters , String Price , String NotesAr ,String MobileNo) throws AWTException
	{
		ClickButton(Add_AdvertisingLink);
		ClickButton(AddUsed_Car);
		Select dropBrand = new Select(Driver.findElement(By.id("newadmake")));
		dropBrand.selectByValue("32");
		SetElementText(CCInput, CC);

		Select dropModel = new Select(Driver.findElement(By.id("ModelID"))); 
		dropModel.selectByValue("815");
		SetElementText(KiloMetersInput, KiloMeters);

		Select dropSahpeType = new Select(Driver.findElement(By.id("ShapeTypeID")));
		dropSahpeType.selectByValue("5");
		SetElementText(PriceInput, Price);

		Select dropMakeYear = new Select(Driver.findElement(By.id("MakeYear")));
		dropMakeYear.selectByValue("2019");

		ClickButton(RadioButtonForCarType);
		ClickButton(No_OfDoors);
		ClickButton(FabrekaRadioBtn);

		ClickButton(AirCondition);
		ClickButton(ElectricWindows);
		ClickButton(ABS);
		ClickButton(CenterLock);
		ClickButton(EBD);
		ClickButton(AirBags);
		ClickButton(RadioCassette);

		SetElementText(NotesArArea, NotesAr);

		Robot robot = new Robot();
		String ImagePath = System.getProperty("user.dir");
		WebElement UploadImageBtn = Driver.findElement(By.id("pickfiles"));
		sleep(10);
		ClickButton(UploadImageBtn);
		robot.setAutoDelay(2000);
		StringSelection stringselection = new StringSelection(ImagePath +"\\ImagesForUploading\\1.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.setAutoDelay(2000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		ClickButton(UploadImageBtn);
		robot.setAutoDelay(2000);
		StringSelection stringselection1 = new StringSelection(ImagePath + "\\ImagesForUploading\\2.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection1, null);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		ClickButton(UploadImageBtn);
		robot.setAutoDelay(2000);
		StringSelection stringselection2 = new StringSelection(ImagePath + "\\ImagesForUploading\\3.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection2, null);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		SetElementText(MobileNumberInput, MobileNo);
		
		sleep(10);
		
		if (MobileValueThatRegistered == MobileNo )
		{
			System.out.println("Phone number is verified that is the same phone registered in the Database for this user ");
		}
		else 
		{
			System.out.println("Phone number is not the same number that is registered in Database for this user");
		}
		
		Select Cities = new Select(Driver.findElement(By.id("cities_1")));
		Cities.selectByValue("1");
		
		Select areas = new Select(Driver.findElement(By.id("areas_1")));
		areas.selectByValue("817");
		
	}
}
