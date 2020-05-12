package Assignments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLeads {

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
		
	     driver.findElementByXPath("(//em[@class='x-tab-left']//span[@class='x-tab-strip-text '])[3]").click();
	     
	     Thread.sleep(3000);
	     
	     WebElement email = driver.findElementByXPath("//input[@name='emailAddress']");
	     
	     Thread.sleep(2000);
	     
	     email.sendKeys("aaa@aa.com");
	     
	     Thread.sleep(2000);
	     
	     driver.findElementByXPath("(//em[@unselectable='on']//button[@class='x-btn-text'])[7]").click();
	     
	     Thread.sleep(2000);
	     
	     
	     String firstid = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']").getText();
		
	     System.out.println("First Resulting id is " + firstid);
	     
	     String firstname = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']").getText();
	     
	     System.out.println("First Resulting name is " + firstname );
	     
	     driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[@class='linktext'][1]").click();
	     
	     Thread.sleep(2000);
	     
	     driver.findElementByXPath("(//div[@class='frameSectionExtra']//a[@class='subMenuButton'])[1]").click();
	     
	     Thread.sleep(2000);
	     
	     String text2 = driver.findElementByXPath("//div[@class='x-panel-header sectionHeaderTitle' and @id='sectionHeaderTitle_leads']").getText();
	     
		System.out.println(text2);
		
		driver.findElementByXPath("//input[@type='submit' and @value='Create Lead']").click();
		
		Thread.sleep(2000);
		
		String firstdna = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
		
		System.out.println("Duplicated name is " + firstdna);
		
		driver.manage().window().maximize();
	}

}
