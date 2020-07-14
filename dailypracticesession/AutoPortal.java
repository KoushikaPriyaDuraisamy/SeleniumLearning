package dailypracticesession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AutoPortal {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options= new ChromeOptions();

		options.addArguments("--disable-notifications");

		ChromeDriver driver= new ChromeDriver(options);
		
		//Goto https://autoportal.com/
		driver.get("https://autoportal.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//span[@class='change']").click();
		
		Thread.sleep(1000);
		
		WebElement location = driver.findElementByXPath("//input[@value='Select City']");
		
		location.click();
		
		//Select Location as Chennai
		location.sendKeys("Chennai");
		
		
		
		driver.findElementByXPath("//li[@class='ui-menu-item']//span[text()='Chennai']").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//div[@class='cell4 cell-xs m_b-20 text-center']").click();
		
		Thread.sleep(5000);
		
		//Select Car Brand as Renault
		WebElement brand = driver.findElementByXPath("//select[@name='brand']");
		
		Select dropDown1 = new Select(brand);
		
		dropDown1.selectByValue("renault");
		
		Thread.sleep(1000);
		
		//Select Model as Arkana
		WebElement model = driver.findElementByXPath("//select[@name='model']");
		
		Select dropDown2 = new Select(model);
		
		dropDown2.selectByValue("arkana");
		
		Thread.sleep(1000);
		
		//Search for the car
		driver.findElementByXPath("//div//input[@value='Find new cars']").click();
		
		Thread.sleep(5000);
		
		//Print the expected price
		String text = driver.findElementByXPath("//div[@class='nm_price m_b-10']").getText();
		
		System.out.println(text);
		
		driver.close();
		
		
		
	}

}
