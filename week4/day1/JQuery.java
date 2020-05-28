package week4.day1;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class JQuery {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver =new ChromeDriver();

		driver.get("https://jqueryui.com/sortable/");

		Thread.sleep(2000);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(0);		


		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item6 = driver.findElementByXPath("//li[text()='Item 6']");

		Actions builder = new Actions(driver);


		Point Location = item6.getLocation(); 
		int xloc = Location.getX();
		int yloc = Location.getY();

		builder.dragAndDropBy(item1, xloc, yloc).perform();

		//builder.dragAndDrop(item1, item6).perform();

		Thread.sleep(3000);
	}
}
