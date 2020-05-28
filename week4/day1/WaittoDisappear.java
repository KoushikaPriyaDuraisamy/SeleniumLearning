package week4.day1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaittoDisappear {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/disapper.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.invisibilityOf(driver.findElementById("btn")));

		String text = driver.findElementByXPath("//strong[contains(text(), 'I know you can do it')]").getText();

		System.out.println(text);

	}

}
