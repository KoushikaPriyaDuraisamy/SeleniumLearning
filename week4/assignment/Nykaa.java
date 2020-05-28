package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.nykaa.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Thread.sleep(8000);
		
		WebElement brands = driver.findElementByXPath("//a[text()='brands']");
		
		WebElement popular = driver.findElementByXPath("//div[@class='BrandsCategoryHeading']//a[text()='Popular']");
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(brands).moveToElement(popular).perform();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[@href='/brands/loreal-paris/c/595?eq=desktop']").click();
		
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> listHandles = new ArrayList<String>(windowHandles);
		
		String lorealparis = listHandles.get(1);
		
		driver.switchTo().window(lorealparis);
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if(title.contains("L'Oreal Paris")) {
			System.out.println("Page Title contains L'Oreal Paris");
		}
		else
		{
			System.out.println("Page Title doesn't contains L'Oreal Paris");
		}
			
		  String nykaa = listHandles.get(0);
		  
		  driver.switchTo().window(nykaa);
		  
		  driver.close();
		 
		  String lorealparis1 = listHandles.get(1);
			
		driver.switchTo().window(lorealparis1);
		
		driver.findElementByXPath("//span[@title='POPULARITY']").click();
		
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[text()='Category']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Shampoo (16)']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[@title='POPULARITY']").click();
		
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//div[@class='col-xs-12 card-img-container '])[1]").click();
		
		Thread.sleep(3000);
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> listHandles2 = new ArrayList<String>(windowHandles2);
		
		String pdp = listHandles2.get(1);
		
		driver.switchTo().window(pdp);
		
		driver.findElementByXPath("//span[text()='360ml']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//button[text()='ADD TO BAG'])[1]").click();
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		
		driver.findElementByXPath("//div[@class='second-col']").click();
		
		String text = driver.findElementByXPath("//div[@class='popup-error']").getText();
		
		System.out.println("Error message is " + text);
		
		driver.close();

}
	
}
