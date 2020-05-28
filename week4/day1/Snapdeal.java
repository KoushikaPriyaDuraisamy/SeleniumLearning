package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		ChromeDriver driver =new ChromeDriver(options);

		driver.get("https://www.snapdeal.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(3000);

		driver.manage().window().maximize();

		WebElement men = driver.findElementByXPath("(//span[@class='catText'])[6]");

		Thread.sleep(2000);

		Actions builder = new Actions(driver);

		builder.moveToElement(men).perform();

		Thread.sleep(2000);

		WebElement shirts = driver.findElementByXPath("(//span[text()='Shirts'])[2]");

		Thread.sleep(2000);

		shirts.click();

		WebElement firstshirt = driver.findElementByXPath("//p[@class='product-title'][1]");

		builder.moveToElement(firstshirt).perform();

		Thread.sleep(2000);

		driver.findElementByXPath("(//div[contains(@class,'center quick-view-bar')])[1]").click();

		Thread.sleep(2000);

		driver.quit();



	}

}
