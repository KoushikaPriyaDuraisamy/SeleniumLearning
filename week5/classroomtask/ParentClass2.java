package classroomtask;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


public class ParentClass2 {
 
	public ChromeDriver driver;
	public String workBookName;
	
	@Parameters({"url","username", "password"})
	@BeforeMethod
	public void login (String url, String username, String password) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(url);

		WebElement user = driver.findElementByXPath("//input[@class='inputLogin']");

		user.sendKeys(username);

		WebElement pass = driver.findElementByXPath("//input[@class='inputLogin' and @type='password']");

		pass.sendKeys(password);

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
	
	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException{
	
		return ReadExcel.readData(workBookName);
	}

}

	
	

