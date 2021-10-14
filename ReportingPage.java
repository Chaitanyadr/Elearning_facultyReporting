package FacultyReporting;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

public class ReportingPage {
	WebDriver driver;
	
	 By reportingbutton = By.xpath("//*[@id=\"navbar\"]/ul[1]/li[4]");
	 By Keyword = By.id("search_user_keyword");
	 By Status = By.id("search_user_active");
	 By Inactiveday = By.id("search_user_sleeping_days");
	 By Submit = By.id("search_user_submit");
	 By View = By.cssSelector("#cm-content > div > h4");
	 By view1 = By.xpath("//*[@id=\"search_user\"]/fieldset/div[2]/div[1]/div/button/div/div/div");
	 //By View = By.xpath("//*[@id=\"tracking_student61640e4113209\"]/tbody/tr[3]");

	public ReportingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean report()
	{
        boolean activestud=false;
        
		driver.findElement(reportingbutton).click();
		driver.findElement(Keyword).sendKeys("ayan");
		driver.findElement(Status);
		
		
		//User with active account
		Select slc = new Select(driver.findElement(Status));
		slc.selectByVisibleText("active");
		Select select1 = new Select(driver.findElement(Inactiveday));
        select1.selectByVisibleText("1");
        driver.findElement(Submit).click();
       // System.out.println("Active User's Account Displayed");
    	try
    	{
    	   driver.findElement(view1);
    	   System.out.println("Active User's Account Displayed");
    	   activestud=true;
    	}
    	catch(NoSuchElementException e) {
    		
    	}
    	return activestud;
	}
	
      public boolean inactivereport() { 
    	  boolean inactivestud=false;
    	  
        //User with disabled account
		Select slc1 = new Select(driver.findElement(Status));
		slc1.selectByVisibleText("inactive");
        driver.findElement(Submit).click();
       // System.out.println("Disabled User's Account Displayed");
        
	    try
	  {
	    driver.findElement(view1);
	    System.out.println("Disabled User's Account Displayed");
	    inactivestud=true;
	   }
	catch(NoSuchElementException e) {
		
	}

		return inactivestud;
		
	}
}
