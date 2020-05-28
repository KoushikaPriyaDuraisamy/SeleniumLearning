package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextChange {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/TextChange.html");

		WebDriverWait wait = new WebDriverWait(driver,30);

		wait.until(ExpectedConditions.textToBe(By.id("btn"), "Click ME!"));

		driver.findElementByXPath("//button[@class='btn']").click();

		driver.close();


	}

}
