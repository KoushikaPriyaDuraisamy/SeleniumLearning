package dailypracticesession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Zalando {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

	
		ChromeDriver driver= new ChromeDriver();

		//1.Go to https://www.zalando.com/
		driver.get("https://www.zalando.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(8000);
		
		//2.Get the Alert text and print it 
		
		 Alert alert = driver.switchTo().alert();
		 
		 String text = alert.getText();
		
		System.out.println("Alert text is " + text);
		
		
		//3.Close the Alert box and click on Zalando.uk
		alert.accept();
		
		Thread.sleep(3000);
	
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
	
		driver.manage().deleteAllCookies();
		
		driver.findElementByXPath("//li[@class='nav_item']//a[text()='Zalando.uk']").click();
		
		Thread.sleep(12000);
		
		driver.findElementByXPath("//div[@class='uc-banner-content ']//button[@class='uc-btn uc-btn-primary']").click();
		
		Thread.sleep(3000);
		
		
		//4. Click Women--> Clothing and click Coats
		driver.findElementByXPath("//li[@class='z-navicat-header_genderItem']//a//span[text()='Women']").click();
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//a[@class='z-navicat-header_categoryListLink']//span[text()='Clothing']").click();
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//li[@class='cat_item-z_SDi'] //a[text()='Coats']").click();
		
		Thread.sleep(10000);
		
		WebElement material = driver.findElementByXPath("//button[@aria-label='filter by Material']");
		
		material.click();
		
		Thread.sleep(1000);
		
		WebElement cotton = driver.findElementByXPath("//span[text()='cotton (100%)']");
		
		Actions builder = new Actions(driver);
		
		//5. Choose Material as cotton (100%) and Length as thigh-length
		
		builder.moveToElement(cotton).click(cotton).perform();
		
		Thread.sleep(2000);
		 
		driver.findElementByXPath("//div[@class='cat_pane-xETbh'] //button[text()='Save']").click();
		
		Thread.sleep(5000);
		
		WebElement length = driver.findElementByXPath("//button[@aria-label='filter by Length'] ");
		
		length.click();
		
		Thread.sleep(1000);
		
		WebElement tlength = driver.findElementByXPath("//span[text()='thigh-length'] ");
		
		builder.moveToElement(tlength).click(tlength).perform();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[@aria-label='apply the Length filter'] ").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//button[@aria-label='filter by Colour']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Black']").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//div[@class='cat_pane-xETbh']//button[@aria-label='apply the Colour filter']").click();
		
		Thread.sleep(5000);
		
		
		//6.Click on JUNAROSE - by VERO MODA
		WebElement junarose = driver.findElementByXPath("//div[text()='JUNAROSE - by VERO MODA']");
		
		builder.moveToElement(junarose).click(junarose).perform();
		
		Thread.sleep(5000);
		
		//7.Click Color as Black and Size as 'M' Under Manufacture Sizes
		driver.findElementByXPath("//button[@aria-haspopup='listbox']").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//span[text()='Manufacturer sizes']").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//span[text()='M']").click();
		
		Thread.sleep(1000);
		
		
		//8.Add to bag only if Standard Delivery is free
		String freetext = driver.findElementByXPath("(//div[@aria-haspopup='true'])[1]").getText();
		
		System.out.println("Standard Delivery is " + freetext);
		
		driver.findElementByXPath("//button[@aria-label='Add to bag']").click();
		
		Thread.sleep(6000);
		
		//9.Mouse over on Your Bag and Click on "Go to Bag"
          WebElement bag = driver.findElementByXPath("//a[@class='z-navicat-header_navToolItemLink']");
          
          WebElement gtbag = driver.findElementByXPath("//div[text()='Go to bag']");
          
          builder.moveToElement(bag).moveToElement(bag).click(gtbag).perform();
          
          Thread.sleep(3000);
	
          
          //10. Read the Estimated Deliver Date and print
	      String text2 = driver.findElementByXPath("//div[@data-id='delivery-estimation']").getText();
	      
	      System.out.println("Estimated Deliver Date " + text2);
          
	      Thread.sleep(1000);
	      
	      
	      //11.  Click on 'Go To Checkout'
	      driver.findElementByXPath("(//div[text()='Go to checkout'])[1]").click();
          
	      Thread.sleep(5000);
	      
	     
	WebElement email = driver.findElementByXPath("//input[@id='login.email'] ");
	
	//12.Enter your email
	email.sendKeys("koushika90@gmail.com");
	
	Thread.sleep(2000);
	
	//13. Click on Login button
	driver.findElementByXPath("//button[@data-testid='login_button'] ").click();
	
	Thread.sleep(2000);
	
	//14.Print the error message
	String text3 = driver.findElementByXPath("//div[@data-validation='error'] ").getText();
	
	System.out.println("Error Message " + text3);
	
	Thread.sleep(2000);
	
	driver.close();
	}
	

}
