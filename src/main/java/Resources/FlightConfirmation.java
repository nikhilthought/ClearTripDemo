package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmation {

	WebDriver driver;
	
	public FlightConfirmation(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By tc = By.id("insurance_confirm");
	By cb = By.xpath("//*[@id='itineraryBtn']");
	By email = By.id("username");
	By login = By.id("LoginContinueBtn_1");
	By aTitle1 = By.id("AdultTitle1");
	By aTitle2 = By.id("AdultTitle2");
	By pfname = By.id("AdultFname1");
	By plname = By.id("AdultLname1");
	By sfname = By.id("AdultFname2");
	By slname = By.id("AdultLname2");
	By mno = By.id("mobileNumber");
	By cb1 = By.id("travellerBtn");
	By netbank = By.xpath("//*[@id='NBTab']/a");
	By kotakradio = By.xpath("//*[@id='kotak_bank']");
	By pay = By.xpath("//*[@id='paymentSubmit']");
	
	public WebElement acceptTC()
	{
		return driver.findElement(tc);
	}
	
	public WebElement continueBooking()
	{
		WebElement cb12 = driver.findElement(cb);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cb12));
		wait.until(ExpectedConditions.elementToBeClickable(cb12));
		return cb12;
	}
	
	public WebElement enterEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement loginContinue()
	{
		return driver.findElement(login);
	}
	
	public WebElement selectPrimaryPassangerTitle()
	{
		return driver.findElement(aTitle1);
	}
	
	public WebElement selectSecondaryPassangerTitle()
	{
		return driver.findElement(aTitle2);
	}
	
	public WebElement primaryFname()
	{
		return driver.findElement(pfname);
	}
	
	public WebElement primaryLname()
	{
		return driver.findElement(plname);
	}
	
	public WebElement secondaryFname()
	{
		return driver.findElement(sfname);
	}
	
	public WebElement secondaryLname()
	{
		return driver.findElement(slname);
	}
	
	public WebElement enterMobileNo()
	{
		return driver.findElement(mno);
	}
	
	public WebElement continueWithPDetails()
	{
		return driver.findElement(cb1);
	}
	
	public WebElement paymentmethod()
	{
		WebElement cb12 = driver.findElement(netbank);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(cb12));
		wait.until(ExpectedConditions.elementToBeClickable(cb12));
		return cb12;
	}
	
	public WebElement selectKotakBank()
	{
		return driver.findElement(kotakradio);
		
	}
	public WebElement submitPayment()
	{
		return driver.findElement(pay);
		
	}
}
