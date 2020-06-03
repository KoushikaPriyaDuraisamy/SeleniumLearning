package classroomtask;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MergeExcel extends ParentClass2 {
	
	@BeforeTest
	public void setFileName() {
		workBookName ="MergeLead";

	}
	

	
  @Test(dataProvider= "fetchData")
  public void runMergeLead(String fromName, String toName) throws InterruptedException {

		driver.findElementByLinkText("Merge Leads").click();

		Thread.sleep(2000);

		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> listHandles = new ArrayList<String>(windowHandles);

		String fromlead = listHandles.get(1);

		driver.switchTo().window(fromlead);

		Thread.sleep(3000);

		String fromleadwindow = driver.getTitle();

		System.out.println("Title of the window FromLeadWidget is " + fromleadwindow);
		
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(fromName);
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(1000);

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
		
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(toName);
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(1000);

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

		if(title.contains("View Lead"))
		{
			System.out.println("Leads Merged");
		}

		else {
			System.out.println("Leads doesnt get Merged");
		}


	}
}


