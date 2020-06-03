package classroomtask;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateExcel extends ParentClass2 {
	
	@BeforeTest
	public void setFileName() {
		workBookName ="CreateLead";

	}
	
  
	@Test(dataProvider="fetchData")
	public void runCreate(String companyname, String firstname, String lastname) {
		
		WebElement createlead = driver.findElementByXPath("//a[@href='/crmsfa/control/createLeadForm']");

		createlead.click();

		WebElement company = driver.findElementByXPath("//input[@type='text' and @class='inputBox']");

		company.sendKeys(companyname);

		WebElement fn  = driver.findElementByXPath("//input[@type='text' and @class='inputBox' and @name='firstName']");

		fn.sendKeys(firstname);

		WebElement ln = driver.findElementByXPath("//input[@type='text' and @class='inputBox' and @name='lastName']");

		ln.sendKeys(lastname);

		WebElement lb = driver.findElementByXPath("//input[@type='submit']");

		lb.click();

		driver.manage().window().maximize();

		String title = driver.getTitle();

		System.out.println(title);
	}
	
	
}
