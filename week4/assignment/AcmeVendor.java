package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AcmeVendor {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://acme-test.uipath.com/account/login");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Actions builder = new Actions(driver);

		WebElement email = driver.findElementById("email");

		builder.click(email).sendKeys(email, "kumar.testleaf@gmail.com").sendKeys(Keys.TAB).perform();

		WebElement password = driver.findElementById("password");

		password.sendKeys("leaf@12");

		WebElement login = driver.findElementById("buttonLogin");

		login.click();

		Thread.sleep(4000);

		WebElement vendor = driver.findElementByXPath("//i[@class='fa fa-truck']");

		builder.moveToElement(vendor).perform();

		Thread.sleep(2000);

		driver.findElementByLinkText("Search for Vendor").click();

		Thread.sleep(3000);

		WebElement vname = driver.findElementById("vendorName");

		builder.click(vname).sendKeys("Blue Lagoon").perform();

		driver.findElementById("buttonSearch").click();

		Thread.sleep(3000);

		String countryname = driver.findElementByXPath("//table//tbody//tr//td[5]").getText();

		System.out.println("Country Name based on the Vendor is " + countryname);


		Thread.sleep(3000);

		WebElement logout = driver.findElementByLinkText("Log Out");

		String text = logout.getText();

		System.out.println(text);

		builder.moveToElement(logout).click(logout).perform();

		Thread.sleep(3000);

		String title = driver.getTitle();

		System.out.println("Title of the redirected Page is " + title);

		Thread.sleep(2000);

		driver.close();

	}

}
