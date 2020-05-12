package week2.day1;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchApplication {
/*
	public static void main(String[] args)  {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
			
		driver.get("https://www.youtube.com/");
		
	driver.manage().window().maximize();
		
		driver.close();
		*/

	
	
	  public static void main(String[] args) throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	  
	  ChromeDriver driver = new ChromeDriver();
	  
	  driver.get("http://leaftaps.com/opentaps/control/main");
	  
	  WebElement username = driver.findElementById("username");
	  
	  username.sendKeys("demosalesmanager"); 
	  
	   driver.findElementById("password").sendKeys("crmsfa");
	   
	   driver.findElementByClassName("decorativeSubmit").click();
	   
	  driver.findElementByLinkText("CRM/SFA").click();
	  
	  driver.findElementByLinkText("Leads").click();
	  
	  driver.findElementByLinkText("Create Lead").click();
	  
	
	  driver.findElementById("createLeadForm_companyName").sendKeys("Photon");
	  
	 driver.findElementById("createLeadForm_firstName").sendKeys("Reyash");
	  
	driver.findElementById("createLeadForm_lastName").sendKeys("Kumar");
	  
	WebElement source = driver.findElementById("createLeadForm_dataSourceId");

	Select dropDown = new Select(source);
	
	dropDown.selectByValue("LEAD_CONFERENCE");
	
	
	WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
			Select dropDown1 = new Select(industry);
			
			dropDown1.selectByVisibleText("Computer Hardware");
			
			WebElement ownership = driver.findElementById("createLeadForm_ownershipEnumId");
			Select dropDown2 = new Select(ownership);
			
			dropDown2.selectByIndex(4);
			
			driver.findElementByClassName("smallSubmit").click();
	  
	  	  driver.manage().window().maximize();
	  
	  
	  }
	 
	
//Thread.sleep(4000);
	  
	  //driver.close();
	  
	/*public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		

		FirefoxDriver driver = new FirefoxDriver();
		
		 driver.get("http://leaftaps.com/opentaps/control/main");
		
		 driver.manage().window().maximize();
		*/
	}
	
	

