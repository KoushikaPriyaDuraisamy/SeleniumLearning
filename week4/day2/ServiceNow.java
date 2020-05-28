package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeDriver driver =new ChromeDriver();

		driver.navigate().to("https://dev60453.service-now.com/");

		Thread.sleep(5000);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.switchTo().frame(0);		

		WebElement un = driver.findElementById("user_name");

		Actions builder = new Actions(driver);

		builder.moveToElement(un).click(un).sendKeys("admin").sendKeys(Keys.TAB).perform();

		WebElement pwd = driver.findElementById("user_password");

		pwd.sendKeys("India@123");

		driver.findElementById("sysverb_login").click();

		Thread.sleep(20000);

		String title = driver.getTitle();

		System.out.println("Title of the redirected Page is " + title);


		driver.close();
	}

}
