package classroomtask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public ChromeDriver driver;

	@BeforeMethod
	public void login () {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		WebElement username = driver.findElementByXPath("//input[@class='inputLogin']");

		username.sendKeys("demosalesmanager");

		WebElement password = driver.findElementByXPath("//input[@class='inputLogin' and @type='password']");

		password.sendKeys("crmsfa");

		WebElement login = driver.findElementByXPath("//input[@class='decorativeSubmit' and @type='submit']");

		login.click();

		WebElement loginbutton = driver.findElementByXPath("//a[@style='color: black;']");

		loginbutton.click();

		WebElement leads = driver.findElementByXPath("//a[@href='/crmsfa/control/leadsMain']");

		leads.click();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();

	}

}
