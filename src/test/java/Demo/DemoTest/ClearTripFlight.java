package Demo.DemoTest;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.FlightBooking;
import Resources.FlightConfirmation;
import Resources.SearchFlights;
import Utils.Calender;

public class ClearTripFlight extends TestBase{
	
	WebDriver driver;
	FlightBooking fb;
	FlightConfirmation fc;
	
	
	
	@BeforeTest
	public void launchAPP() throws IOException
	{
		driver = initializeDrivers();
	}
	
	@Test
	public void searchFlight()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SearchFlights sf = new SearchFlights(driver);
		Assert.assertFalse(sf.selectRadioB().isSelected(), "Round Trip radio is not button selected");
		sf.selectRadioB().click();
		
		sf.sourceCity().sendKeys(prop.getProperty("fromCity"));
		sf.sourceCity().sendKeys(Keys.ARROW_DOWN);
		sf.sourceCity().sendKeys(Keys.ENTER);
		
		sf.destCity().sendKeys(prop.getProperty("toCity"));
		sf.destCity().sendKeys(Keys.ARROW_DOWN);
		sf.destCity().sendKeys(Keys.ENTER);
		
		sf.departDate().click();
		Calender.selectstartDate(driver);
		sf.returnDate().click();
	    Calender.selectreturnDate(driver);
	    
	    
		Select s = new Select(sf.selectAdult());
		s.selectByValue(prop.getProperty("travellingAdults"));
		
		sf.search().click();
		
	}
	
	@Test(dependsOnMethods = {"searchFlight"})
	public void filteroutFlights() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FlightBooking fb = new FlightBooking(driver);
		
	Thread.sleep(5000);
		fb.chooseNonStopFlights().click();
		fb.clickonBookbtn().click();
	}
	
	@Test(dependsOnMethods = {"filteroutFlights"})
	public void switchToChildW()
	{
		
		String parentW = driver.getWindowHandle();
		Set<String> allw =  driver.getWindowHandles();
		Iterator<String> itr = allw.iterator();
		itr.next();
		while(itr.hasNext())
		{
			String childW = itr.next();
			if(!parentW.equals(childW))
			{
				System.out.println(driver.switchTo().window(childW).getTitle());
			}
		}
	}
	@Test(dependsOnMethods = {"switchToChildW"})
	public void confirmBooking()
	{
		fc = new FlightConfirmation(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fc.acceptTC().click();
		fc.continueBooking().click();
		fc.enterEmail().sendKeys(prop.getProperty("email"));
		fc.loginContinue().click();
		
	}
	@Test(dependsOnMethods = {"confirmBooking"})
	public void travellersDetails()
	{
		fc = new FlightConfirmation(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		fc.primaryFname().sendKeys(prop.getProperty("pfname"));
		fc.primaryLname().sendKeys(prop.getProperty("plname"));
		
		
		Select s = new Select(fc.selectPrimaryPassangerTitle());
		s.selectByValue("Mr");
		
		
		Select s1 = new Select(fc.selectSecondaryPassangerTitle());
		s1.selectByValue("Mrs");
		
		fc.secondaryFname().sendKeys(prop.getProperty("sfname"));
		fc.secondaryLname().sendKeys(prop.getProperty("slname"));
		
		fc.enterMobileNo().sendKeys(prop.getProperty("mobileno"));
		
		fc.continueWithPDetails().click();
	}
	
	@Test(dependsOnMethods = {"travellersDetails"})
	public void paymentDetails() throws InterruptedException
	{

		fc = new FlightConfirmation(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		fc.paymentmethod().click();
		fc.selectKotakBank().click();
		fc.submitPayment().click();
		String title = "Kotak Mahindra Bank - Payment Gateway";

		Thread.sleep(25000);
		Assert.assertEquals(driver.getTitle(), title, "Its not redirected to banking page");
		System.out.println(driver.getTitle());
	}
	@AfterTest
	public void closeAPP()
	{
		driver = tearDown();
	}
	

}
