package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

		Thread.sleep(10000);

		WebElement filter = driver.findElementByXPath("//input[@id='filter']");

		builder.moveToElement(filter).click(filter).sendKeys("Change").perform();

		Thread.sleep(3000);

		driver.findElementByXPath("(//div[text()='All'])[4]").click();

		Thread.sleep(4000);

		driver.switchTo().frame("gsft_main");	

		driver.findElementByXPath("//button[@id='sysverb_new']").click();

		Thread.sleep(5000);

		driver.findElementByXPath("//a[contains(text(),'Normal')]").click();

		Thread.sleep(5000);

		String attribute = driver.findElementByXPath("//input[@id='change_request.number']").getAttribute("value");

		System.out.println("Change Request Number is " + attribute);

		WebElement description = driver.findElementByXPath("//input[@id='change_request.short_description']");

		builder.moveToElement(description).click(description).sendKeys("Normal Changes Required").perform();

		Thread.sleep(3000);

		driver.findElementByXPath("//button[@id='sysverb_insert_bottom']").click();

		Thread.sleep(4000);


		WebElement search = driver.findElementByXPath("//input[@id='change_request_table_header_search_control']");

		builder.moveToElement(search).click(search).sendKeys(attribute, Keys.ENTER).perform();

		Thread.sleep(4000);

		String changeid = driver.findElementByXPath("//a[@class='linked formlink']").getText();	

		System.out.println("ChangeID is " + changeid);

		if(attribute.contentEquals(changeid)) {
			System.out.println("Change has been created successfully");
		}

		else
		{
			System.out.println("Change has not been created successfully");
		}
	}

}
