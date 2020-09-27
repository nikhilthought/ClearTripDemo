package Resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBooking {
	
	WebDriver driver;
	
	
	public FlightBooking(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By nonstopflight = By.xpath("//input[@type='checkbox' and @class='checkbox__input o-0']");
	By nonstopflight1 = By.xpath("//*[contains(text(),'Non-stop')]");
	
	By airAsia = By.xpath("//*[@id='root']/div/main/div/div/div[1]/div/aside/div[4]/div[6]/div[2]/div/label[2]");
	By airIndia = By.xpath("//*[@id='root']/div/main/div/div/div[1]/div/aside/div[4]/div[6]/div[2]/div/label[3]/div[1]/span");
	By Vistara = By.xpath("//*[@id='root']/div/main/div/div/div[1]/div/aside/div[4]/div[6]/div[2]/div/label[7]");
	
	By onwardView = By.xpath("//div[@data-test-attrib='onward-view']");
	By IndiGo = By.xpath("//*[@alt='IndiGo' and @class='br-2 o-hidden mx-1']");
	
	By returnView = By.xpath("//div[@data-test-attrib='return-view']");
	By goAir = By.xpath("//*[@alt='GoAir' and @class='br-2 o-hidden mx-1']");
	
	By book = By.xpath("//*[@id='root']/div/main/div/div/div[2]/div[2]/div[7]/div/div[2]/button");
	
	By indigoflight = By.xpath("//*[@id='root']/div/main/div/div/div[2]/div[2]/div[10]/div[1]/div[1]/div/div[2]/div[1]");
	
	public WebElement chooseNonStopFlights()
	{
		WebElement cb12 = driver.findElement(nonstopflight1);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(cb12));
		wait.until(ExpectedConditions.elementToBeClickable(cb12));
		return cb12;
		
	}
	public WebElement uncheckAirAsia()
	{
		return driver.findElement(airAsia);
		
	}
	public WebElement uncheckAirIndia()
	{
		return driver.findElement(airIndia);
		
	}
	public WebElement uncheckVistara()
	{
		return driver.findElement(Vistara);
		
	}
	
	public WebElement startingAirlines()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ow = driver.findElement(returnView);
		return ow.findElement(goAir);
	}

	public WebElement returnAirlines()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ow = driver.findElement(onwardView);
		return ow.findElement(IndiGo);
	}
	
	public WebElement clickonBookbtn()
	{
		return driver.findElement(book);
	}
	

}
