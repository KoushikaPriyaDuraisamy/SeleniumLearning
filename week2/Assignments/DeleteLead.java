package Assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		WebElement username = driver.findElementByXPath("//input[@class='inputLogin']");
		
		username.sendKeys("demosalesmanager");
		
		WebElement password = driver.findElementByXPath("//input[@class='inputLogin' and @type='password']");
		
		password.sendKeys("crmsfa");
		
		WebElement login = driver.findElementByXPath("//input[@class='decorativeSubmit' and @type='submit']");
		
		login.click();
		
		WebElement loginbutton = driver.findElementByXPath("//a[@style='color: black;']");
		
		loginbutton.click();
		
	       WebElement leads = driver.findElementByXPath("//a[@href='/crmsfa/control/leadsMain']");
	       
	       leads.click();
	       
	       WebElement findlead = driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']");
	       
	       findlead.click();
	       
	       driver.findElementByXPath("(//span[@class='x-tab-strip-text '])[2]").click();
	       
	       WebElement areacode = driver.findElementByXPath("//div[@class='x-plain-body x-plain-body-noheader x-plain-body-noborder']//input[@name='phoneAreaCode']");

	       Thread.sleep(2000);
	       
	       areacode.sendKeys("99");
	       
	       Thread.sleep(2000);
	       
	       WebElement phonenumber = driver.findElementByXPath("//div[@class='x-plain-body x-plain-body-noheader x-plain-body-noborder']//input[@name='phoneNumber']");
	       
	       Thread.sleep(2000);
	       
	       phonenumber.sendKeys("99");
	       
	       Thread.sleep(2000);
	       
	       driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
	       
	       Thread.sleep(3000);
	       
	        String firstid = driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//div[@class='x-grid3-cell-inner x-grid3-col-partyId']").getText();
	        
	        
	        System.out.println("First Resulting id is " + firstid);
	        
	        driver.findElementByXPath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a[@class='linktext']").click();
	        
	        Thread.sleep(2000);
	        
	        driver.findElementByXPath("(//div[@class='frameSectionExtra'])//a[@href='javascript:document.deleteLeadForm.submit()']").click();
	        
	        Thread.sleep(3000);
	        
	        driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']").click();
	        
	        Thread.sleep(2000);
	        
	         WebElement lid = driver.findElementByXPath("//div[@class='x-form-element']//input[@name='id']");
	         
	         lid.sendKeys(firstid);
	         
	         
	         Thread.sleep(2000);
	        
	         driver.findElementByXPath("(//td[@class='x-btn-center']//button[@class='x-btn-text'])[7]").click();
	         
	         Thread.sleep(2000);
	         
	         String nore = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
	         
	         System.out.println(nore);
	         
	         System.out.println("No records to display text in the Lead List. This message confirms the successful deletion");
	         
	         driver.manage().window().maximize();
	         
	         Thread.sleep(4000);
	         
	         driver.close();
	        
	
	       
	}

}
