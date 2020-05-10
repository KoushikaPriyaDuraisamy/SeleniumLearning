package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentButton {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
	driver.get("http://www.leafground.com/pages/Button.html");
	
	driver.findElementByXPath("//button[@id='home']").click();
	
	Thread.sleep(4000);
	
	WebElement button = driver.findElementByXPath("//img[@class='wp-categories-icon svg-image' and @alt='Buttons']");
	
	Thread.sleep(2000);
	
	button.click();
	
	driver.findElementByXPath("//button[@id='position']");
	
	driver.findElementByXPath("//button[@id='color']");
	
	driver.findElementByXPath("//button[@id='size']");
	
	String title = driver.getTitle();
	
	System.out.println(title);

	}

}
