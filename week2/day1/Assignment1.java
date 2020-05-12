package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {
		
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
		
		
		WebElement marketing = driver.findElementById("createLeadForm_marketingCampaignId");
		
		Select dropDown3 = new Select(marketing);
		
		dropDown3.selectByValue("9001");
		
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		
		Select dropDown4 = new Select(country);
		
		dropDown4.selectByVisibleText("India");
		
		driver.findElementByClassName("smallSubmit").click();
		  
	  	  driver.manage().window().maximize();
	  	  
	  String title = driver.getTitle();
	  
	  System.out.println(title);
	  }
	 
	}

