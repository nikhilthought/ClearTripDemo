package Resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchFlights {
	
	WebDriver driver;
	
	public SearchFlights(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	
	By roundtrip = By.xpath("//*[@id='SearchForm']/nav/ul/li[2]/label");
	By sourceC = By.id("FromTag");
	By targetC = By.id("ToTag");
	
	By dDate = By.id("DepartDate");
	By firstmonthBlock = By.xpath("//*[@id='ui-datepicker-div']/div[2]");
	By ndays = By.className("ui-state-default");
	By firstmonthT = By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div");	
	
	
	By rDate = By.id("ReturnDate");
	By secondmonthBlock = By.xpath("//*[@id='ui-datepicker-div']/div[1]");
	By secondmonthT = By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div");
	
	By adultDD = By.id("Adults");
	By searchB = By.id("SearchBtn");
	
	
	public WebElement selectRadioB()
	{
		return driver.findElement(roundtrip);
	}
	
	public WebElement sourceCity()
	{
		return driver.findElement(sourceC);
		 
	}
	
	public WebElement destCity()
	{
		return driver.findElement(targetC);
		
	}
	
	public WebElement departDate()
	{
		return driver.findElement(dDate);
		
		
	}
	
	public List<WebElement> firstMothBlock()
	{
		WebElement fm = driver.findElement(firstmonthBlock);
		List<WebElement> days = fm.findElements(ndays);
		return days;
		
	}
	
	public List<WebElement> secondMothBlock()
	{
		WebElement fm = driver.findElement(secondmonthBlock);
		List<WebElement> days = fm.findElements(ndays);
		return days;
		
	}
	
	
	
	public WebElement monthTitle()
	{
		return driver.findElement(firstmonthT);
	}
	
	public WebElement secondmonthTitle()
	{
		return driver.findElement(secondmonthT);
	}
	
	public WebElement returnDate()
	{
		return driver.findElement(rDate);
	}
	
	public WebElement selectAdult()
	{
		return driver.findElement(adultDD);
	}
	
	public WebElement search()
	{
		return driver.findElement(searchB);
	}
	
	
	

}
