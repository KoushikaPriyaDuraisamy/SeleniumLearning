package Assignments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonandCheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/radio.html");
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//label[@for='yes']//following::input)[1]").click();
		
		driver.findElementByXPath("(//label[@for='Checked']//following::input)[1]").click();
		
		driver.findElementByXPath("(//label[@for='java']//following::input)[6]").click();
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
        Thread.sleep(3000);
        
        
		driver.get("http://leafground.com/pages/checkbox.html");
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[1]").click();
		
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[6]").isSelected();
		
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[8]").click();
		
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[9]").click();
		
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[10]").click();
		
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[11]").click();
		
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[12]").click();
	
		driver.findElementByXPath("(//div[@class='example']//input[@type='checkbox'])[13]").click();
	}
	
}
				
				
				
