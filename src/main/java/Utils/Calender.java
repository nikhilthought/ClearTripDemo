package Utils;



import org.openqa.selenium.WebDriver;


import Resources.SearchFlights;

public class Calender{
	
	static WebDriver driver;
	public Calender(WebDriver driver)
	{
		Calender.driver=driver;
	}
	
	static SearchFlights sr ;
	public static void selectstartDate(WebDriver driver)
	{
		sr = new SearchFlights(driver);
		int ndays = sr.firstMothBlock().size();
		System.out.println(ndays);
		
		while(!sr.monthTitle().getText().contains("October"))
		{
			sr.monthTitle().click();
		
		}
		
		for(int i=0;i<ndays;i++)
		{
			
			if(sr.firstMothBlock().get(i).getText().contains("1"))
			{
				
				sr.firstMothBlock().get(i).click();
				break;				
			}
				
		}

	}
	
	
	public static void selectreturnDate(WebDriver driver)
	{
		sr = new SearchFlights(driver);
		int nndays =  sr.secondMothBlock().size();
		
		
		System.out.println(nndays);
		
		while(!sr.secondmonthTitle().getText().contains("October"))
		{
			sr.secondmonthTitle().click();
			
		}
		
		for(int i=0;i<nndays;i++)
		{
			
			if(sr.secondMothBlock().get(i).getText().contains("7"))
			{
				
				sr.secondMothBlock().get(i).click();
				
				break;
				
			}
				
		}
		
		
		
		
	}

}
