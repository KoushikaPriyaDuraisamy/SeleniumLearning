package dailypracticesession;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AzureMicrosoft {
	
	public static void verifyFile(String filename) {
		
		File file = new File ("C:\\Users\\LENOVO\\Downloads\\" + filename);
		
		if(file.exists()) {
			System.out.println("File has been downloaded");
		}
		else
		{
			System.out.println("File has not been downloaded");
		}
	}
			
	
	

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		//1. Go to https://azure.microsoft.com/en-in/
		driver.get("https://azure.microsoft.com/en-in/");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		
		Actions builder = new Actions(driver);
		
		//2. Click on Pricing
		driver.findElementByLinkText("Pricing").click();
		
		Thread.sleep(10000);
		
		//3.Click on Pricing Calculator
		driver.findElementByLinkText("Pricing calculator").click();
		
		Thread.sleep(20000);
		
		//4.Click on Containers
		driver.findElementByXPath("//button[text()='Containers']").click();
		
		Thread.sleep(5000);
		
		//5.Select Container Instances
		driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		
		Thread.sleep(1000);
		
		WebElement view = driver.findElementById("new-module-loc");
		
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		
		//6.Click on Container Instance Added View
		wait.until(ExpectedConditions.visibilityOf(view)).click();
		
		Thread.sleep(3000);
		
		WebElement region = driver.findElementByXPath("//select[@name='region']");
		
		Select dropDown1 = new Select(region);
		
		//7.Select Region as "South India"
		dropDown1.selectByValue("south-india");
		
		WebElement duration = driver.findElementByName("seconds");
		
		duration.clear();
		
		//8.Set the Duration as 180000 seconds
		
		duration.sendKeys(Keys.BACK_SPACE);
		
		duration.sendKeys(Keys.ARROW_LEFT);
		
		duration.sendKeys("18000");
		
		Thread.sleep(2000);
		
		WebElement memory = driver.findElementByXPath("//select[@name='memory']");
		
		Select dropDown2 = new Select(memory);
		
		//9.Select the Memory as 4GB
		dropDown2.selectByVisibleText("4 GB");
		
		
		//10.Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//button[@name='devTestSelected']").click();
		
		Thread.sleep(2000);
		
		WebElement rupee = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		
		Select dropDown3 = new Select(rupee);
		
		//11. Select Indian Rupee  as currency
		dropDown3.selectByValue("INR");
		
		Thread.sleep(3000);
		
		String cost = driver.findElementByXPath("(//span[@class='numeric'])[6]").getText();
		
		//String monthcost = cost.replaceAll("[^0-9]", "");
		
		//12.Print the Estimated monthly price
		System.out.println("Estimated monthly price " + cost);
		
		//13.Click on Export to download the estimate as excel
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		
		Thread.sleep(3000);
		
		//14.Verify the downloded file in the local folder
		verifyFile("ExportedEstimate.xlsx");
		
		WebElement example = driver.findElementByXPath("//a[text()='Example Scenarios']");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		
		//15. Navigate to Example Scenarios and Select CI/CD for Containers
		builder.moveToElement(example).click(example).perform();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[@title='CI/CD for Containers']").click();
		
		Thread.sleep(2000);
		
		//16.Click Add to Estimate
		
		 js.executeScript("window.scrollBy(0,-10000)");
		 
		WebElement estimate = driver.findElementByXPath("//button[text()='Add to estimate']");
		
		builder.moveToElement(estimate).click(estimate).perform();
		
		
		Thread.sleep(10000);
		
		
		 js.executeScript("window.scrollBy(0,-5000)");
		 
		 WebElement money1 = driver.findElementByXPath("//select[@class='select currency-dropdown']");
		 
		 Select dropDown4 = new Select(money1);
		 
		 //17. Change the Currency as Indian Rupee
		 dropDown4.selectByValue("INR");
		 
		 Thread.sleep(2000);
		 
		 //18. Enable SHOW DEV/TEST PRICING
		 driver.findElementByXPath("//button[@name='devTestSelected']").click();
		 
		 Thread.sleep(4000);
		 
		 //19.Export the Estimate
		 driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		 
		 Thread.sleep(5000);
		 
		 //20.
		 verifyFile("ExportedEstimate (1).xlsx");
		 
		 
		 driver.close();
	}

}
