package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement username = driver.findElementById("username");

		WebElement password = driver.findElementById("password");

		Actions builder = new Actions(driver);

		builder.click(username).sendKeys("demosalesmanager").perform();

		builder.click(password).sendKeys("crmsfa").perform();

		driver.findElementByClassName("decorativeSubmit").click();

		Thread.sleep(3000);

		driver.findElementByLinkText("CRM/SFA").click();

		Thread.sleep(3000);

		driver.findElementByLinkText("Contacts").click();

		Thread.sleep(3000);

		driver.findElementByLinkText("Merge Contacts").click();

		Thread.sleep(2000);

		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> listHandles = new ArrayList<String>(windowHandles);

		String fromlead = listHandles.get(1);

		driver.switchTo().window(fromlead);

		Thread.sleep(3000);

		String fromleadwindow = driver.getTitle();

		System.out.println("Title of the window FromLeadWidget is " + fromleadwindow);

		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").click();

		Thread.sleep(3000);

		String mergelead = listHandles.get(0);

		driver.switchTo().window(mergelead);

		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();

		Thread.sleep(3000);

		Set<String> windowHandles1 = driver.getWindowHandles();

		List<String> listHandles1 = new ArrayList<String>(windowHandles1);

		String tolead = listHandles1.get(1);

		driver.switchTo().window(tolead);

		Thread.sleep(3000);

		String tolead1 = driver.getTitle();

		System.out.println("Title of the window ToLeadWidget is " + tolead1);

		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]").click();

		Thread.sleep(3000);

		String mergelead1 = listHandles1.get(0);

		driver.switchTo().window(mergelead1);

		Thread.sleep(3000);

		driver.findElementByXPath("//a[text()='Merge']").click();

		Thread.sleep(10000);

		Alert alert = driver.switchTo().alert();

		alert.accept();

		Thread.sleep(5000);

		String title = driver.getTitle();

		System.out.println("Title of the Page is " + title);

		if(title.contains("View Contact"))
		{
			System.out.println("Contacts Merged");
		}

		else {
			System.out.println("Contacts doesnt get Merged");
		}

		driver.close();
	}

}
