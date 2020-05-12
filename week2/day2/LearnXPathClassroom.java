package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnXPathClassroom {

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
	       
	       WebElement fl = driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']");
	       
	       fl.click();
	       
	       Thread.sleep(3000);
	       
	       WebElement fe = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'] /a");
	       
	       fe.click();
	       
	       WebElement ml = driver.findElementByXPath("//a[@href='/crmsfa/control/mergeLeadsForm']");
	       
	       ml.click();
	       
	       Thread.sleep(2000);
	       
	       driver.findElementByXPath("//input[@name='partyIdFrom']//following::a[1]");
	       
	       driver.findElementByXPath("//input[@name='partyIdTo']//following::a[1]");
	       
	      
	}

}
