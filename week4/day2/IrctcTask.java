package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IrctcTask {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Thread.sleep(3000);

		driver.findElementByXPath("//button[text()='Ok']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//div[@id='corover-close-btn']").click();

		Thread.sleep(2000);

		driver.findElementByLinkText("FLIGHTS").click();

		Thread.sleep(5000);

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> listHandles = new ArrayList<String>(windowHandles);

		String flights = listHandles.get(1);

		driver.switchTo().window(flights);

		Thread.sleep(2000);

		Actions builder = new Actions(driver);

		WebElement agree = driver.findElementById("agree");

		builder.moveToElement(agree).click(agree).perform();

		driver.findElementByXPath("//button[text()='Continue ']").click();

		File screenshot = driver.getScreenshotAs(OutputType.FILE);

		File target = new File("./snaps/flightswindow.png");

		FileUtils.copyFile(screenshot, target);

		String train = listHandles.get(0);

		driver.switchTo().window(train);

		Thread.sleep(2000);

		driver.close();

	}

}
