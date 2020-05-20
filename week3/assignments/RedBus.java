package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		ChromeDriver driver =new ChromeDriver(options);

		driver.get("https://www.redbus.in/");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		Thread.sleep(3000);

		driver.manage().window().maximize();
		
		WebElement from = driver.findElementByXPath("//input[@id='src']");
		
		Thread.sleep(5000);
		
		from.click();
	    
		Thread.sleep(5000);
		
		from.sendKeys("Chennai");
		
		Thread.sleep(3000);
		
		from.sendKeys(Keys.TAB);
		
		
		WebElement to = driver.findElementByXPath("//input[@id='dest']");
		
		Thread.sleep(2000);
		
		to.click();
		
		Thread.sleep(2000);
		
		to.sendKeys("Trichy");
		
		Thread.sleep(3000);
		
		to.sendKeys(Keys.TAB);
		
		List<String> calender = new ArrayList<String>();
	
	WebElement onward = driver.findElementByXPath("(//table[@class='rb-monthTable first last'])[1]");
	
	List<WebElement> rows1 = driver.findElementsByXPath("(//table[@class='rb-monthTable first last'])[1]//tbody//tr");
	
	System.out.println("Onward table rows size are " + rows1.size());
	
	List<WebElement> cells1 = driver.findElementsByXPath("(//table[@class='rb-monthTable first last'])[1]//tbody//tr/td");
	
	System.out.println("Onward table cells size are " + cells1.size());
	 
	driver.findElementByXPath("//div[@id='rb-calendar_onward_cal']//td[@class='current day']").click();
	
	Thread.sleep(2000);
		
	WebElement returnto = driver.findElementByXPath("//div[@class='fl search-box date-box gtm-returnCalendar']");
	
	Thread.sleep(2000);
	
	returnto.click();
	
	Thread.sleep(2000);
	
	List<WebElement> rows2 = driver.findElementsByXPath("(//table[@class='rb-monthTable first last'])[2]//tbody//tr");
	
	System.out.println("Returnto table rows sizes are " + rows2.size());
	
	List<WebElement> cells2 = driver.findElementsByXPath("(//table[@class='rb-monthTable first last'])[2]//tbody//tr/td");
	
	System.out.println("Returnto table cells sizes are " +cells2.size());
	
	driver.findElementByXPath("(//div[@id='rb-calendar_return_cal']//td[@class='we day'])[4]").click();
	
	Thread.sleep(2000);
	
	WebElement  search = driver.findElementByXPath("//button[@id='search_btn']");
	
	Thread.sleep(2000);
	
	String text = search.getText();
	
	System.out.println("Button name is " +  text);
	
	search.click();
	
	String title = driver.getTitle();
	
	System.out.println("Title of the redirected page is " + title);
	
	}
	
}
	
	
	


