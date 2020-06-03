package classroomtask;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateLead1 extends BaseClass{

	@Test
	public void runCreateLead() {
		
		WebElement createlead = driver.findElementByXPath("//a[@href='/crmsfa/control/createLeadForm']");

		createlead.click();

		WebElement company = driver.findElementByXPath("//input[@type='text' and @class='inputBox']");

		company.sendKeys("TestLeaf");

		WebElement fn  = driver.findElementByXPath("//input[@type='text' and @class='inputBox' and @name='firstName']");

		fn.sendKeys("Koushika");

		WebElement ln = driver.findElementByXPath("//input[@type='text' and @class='inputBox' and @name='lastName']");

		ln.sendKeys("Priya");

		WebElement lb = driver.findElementByXPath("//input[@type='submit']");

		lb.click();

		driver.manage().window().maximize();

		String title = driver.getTitle();

		System.out.println(title);


	}
}
