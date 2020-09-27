package Demo.DemoTest;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	static FileInputStream fis;
	
	
	public static WebDriver initializeDrivers() throws IOException
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		fis = new FileInputStream(projectPath+"\\src\\main\\java\\Resources\\Data.properties");
		prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\main\\java\\Resources\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("WebDriver.chrome.driver", projectPath+"src\\main\\java\\Resources\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//driver.switchTo().alert().dismiss();
		
		return driver;
	}
	
	public WebDriver tearDown()
	{
		driver.close();
		return driver;
	}

}
