package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnXpathinCreateLead {

	public static void main(String[] args) {
		
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
       
       WebElement createlead = driver.findElementByXPath("//a[@href='/crmsfa/control/createLeadForm']");
       
       createlead.click();
       
       WebElement company = driver.findElementByXPath("//input[@type='text' and @class='inputBox']");
       
       company.sendKeys("TestLeaf");
       
       WebElement fn  = driver.findElementByXPath("//input[@type='text' and @class='inputBox' and @name='firstName']");
       
       fn.sendKeys("Koushika");
       
       WebElement ln = driver.findElementByXPath("//input[@type='text' and @class='inputBox' and @name='lastName']");
       
       ln.sendKeys("Priya");

       WebElement lb = driver.findElementByXPath("//input[@type='submit']");
       
       lb.click();
       
       driver.manage().window().maximize();
	
	
       String title = driver.getTitle();
 	  
 	  System.out.println(title);
		

	}

}
