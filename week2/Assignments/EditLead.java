package Assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

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
       
       WebElement fn = driver.findElementByXPath("(//div[@class='x-form-element']//input[@name='firstName'])[3]");
       
       fn.sendKeys("Koushika");
       
       driver.findElementByXPath("(//em[@unselectable='on']//button[@class='x-btn-text'])[7] ").click();
       
       Thread.sleep(3000);
       
       driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").click();
       
       String title = driver.getTitle();
       
       System.out.println(title);
       
       driver.findElementByXPath("//div[@class='frameSectionExtra']//a[@href='updateLeadForm?partyId=10187']").click();
       
       WebElement ue = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']");
       
       ue.clear();
       
       ue.sendKeys("Lister");
       
       driver.findElementByXPath("(//input[@type='submit'])[1]").click();
       
       String title2 = driver.getTitle();
       
       System.out.println(title2);
       
       WebElement ucn = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
       
       String text = ucn.getText();
       
       System.out.println(text);
       
       driver.manage().window().maximize();
       
       Thread.sleep(2000);
       
       driver.close();
       
       
    
    

}

}