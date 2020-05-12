package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AssignmentEdit {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Edit.html");
		
		WebElement email = driver.findElementByXPath("//input[@type='text' and @id='email']");
		
		email.sendKeys("abc@test.com");
		
		WebElement append = driver.findElementByXPath("//input[@type='text' and @value='Append ']");
		
		append.sendKeys("123");
		
	driver.findElementByXPath("//input[@type='text' and @value='TestLeaf']").isDisplayed();
	
    driver.findElementByXPath("//input[@type='text' and @value='Clear me!!']").clear();
    
    driver.findElementByXPath("//input[@type='text' and @disabled='true']").isEnabled();
	
		
	}

}
