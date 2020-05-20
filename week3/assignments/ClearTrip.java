package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver =new ChromeDriver(options);

		
		driver.get("https://www.cleartrip.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		driver.findElementByXPath("//input[@id='RoundTrip']").click();
		
		Thread.sleep(2000);
		
		WebElement from = driver.findElementByXPath("//input[@id='FromTag']");
		
		from.click();
		
		Thread.sleep(3000);
		
		from.sendKeys("Chennai");
		
		Thread.sleep(6000);
		
		from.sendKeys(Keys.TAB);
		
		WebElement to = driver.findElementByXPath("//input[@id='ToTag']");
		
		to.click();
		
		Thread.sleep(3000);
		
		to.sendKeys("New York");
		
		Thread.sleep(5000);
		
		to.sendKeys(Keys.TAB);
		
		List<String> calender = new ArrayList<String>();

	WebElement depart = driver.findElementByXPath("(//table[@class='calendar'])[1]");
	
	List<WebElement> rows = driver.findElementsByXPath("(//table[@class='calendar'])[1]//tbody//tr");
	
     System.out.println(rows.size());
	
     List<WebElement> cells = driver.findElementsByXPath("(//table[@class='calendar'])[1]//tbody//tr/td");
	
		System.out.println(cells.size());
		
		//driver.findElementByXPath("(//table[@class='calendar'])[1]//tbody//tr[4]/td[2]/a").click();
		
		driver.findElement(By.linkText("19")).click();
		
	WebElement returnto = driver.findElementByXPath("(//table[@class='calendar'])[2]");
		
		List<WebElement> rows1 = driver.findElementsByXPath("(//table[@class='calendar'])[2]//tbody//tr");
		
		 System.out.println(rows1.size());
		 
		 List<WebElement> cells1 = driver.findElementsByXPath("(//table[@class='calendar'])[2]//tbody//tr/td");
		 
		 System.out.println(cells1.size());
		 
		//driver.findElementByXPath("(//table[@class='calendar'])[2]//tbody//tr[2]/td[3]/a").click();
		
		 driver.findElement(By.linkText("10")).click();
		 
		 WebElement Adult = driver.findElementByXPath("//select[@id='Adults']");
		 
		 Select dropDown = new Select(Adult);
		 
		 dropDown.selectByValue("2");
		 
		 Thread.sleep(2000);
		 
		 WebElement children = driver.findElementByXPath("//select[@id='Childrens']");
		 
		 Select dropDown1 = new Select(children);
		 
		 dropDown1.selectByValue("1");
		 
		 Thread.sleep(2000);
		 
		 WebElement infant = driver.findElementByXPath("//select[@id='Infants']");
		 
		 Select dropDown2 = new Select(infant);
		 
		 dropDown2.selectByValue("1");
		 
		 Thread.sleep(2000);
		 
		 
		 driver.findElementById("MoreOptionsLink").click();
		 
		 Thread.sleep(2000);
		 
		 WebElement more = driver.findElementByXPath("//select[@name='class']");
		 
		 Select dropDown3 = new Select(more);
		 
		 dropDown3.selectByValue("Premium Economy");
		 
		 Thread.sleep(2000);
		 
		 WebElement airline = driver.findElementByXPath("//input[@name='airline']");
		 
		 airline.click();
		 
		 Thread.sleep(2000);
		 
		 airline.sendKeys("Emirates");
		 
		 Thread.sleep(2000);
		 
		 airline.sendKeys(Keys.TAB);
		 
		 driver.findElementByXPath("//input[@value='Search flights']").click();
		 
		 Thread.sleep(10000);
		 
		 String title = driver.getTitle();
		 
		 System.out.println(title);
		 
		 driver.close();
	}

}
