package dailypracticesession;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {


	public static void takeSnapshot(WebElement element, String elemName) throws
	IOException {

		File source = element.getScreenshotAs(OutputType.FILE);

		File target = new File("./snaps/" +elemName + ".png");

		FileUtils.copyFile(source, target);

	}


	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		//1. Go to https://www.zoomcar.com/chennai
		driver.get("https://www.zoomcar.com/chennai");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Thread.sleep(5000);


		//2. Click on Start your wonderful journey
		driver.findElementByXPath("//a[@title='Start your wonderful journey']").click();

		Thread.sleep(5000);

		//3.Select  any location under POPULAR PICK-UP POINTS and click next
		driver.findElementByXPath("(//div[@class='items'])[1]").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//div[@class='component-breadcrumb']//button[text()='Next']").click();

		Thread.sleep(3000);

		//4. Select tomorrow's date and time as 9:00 AM as start date and time and Click Next
		driver.findElementByXPath("(//div[@class='day low-price'])[1]").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='09:00']").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//button[@class='proceed']").click();

		Thread.sleep(4000);

		//5. Click on Show More and Select tomorrow's date and Select time as 6:00 PM as end date  and Click Done

		driver.findElementByXPath("(//div[@class='day low-price'])[1]").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='18:00']").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//button[@class='proceed']").click();

		Thread.sleep(4000);


		//6.Take the snapshot for PICKUP TIME and DROP OFF TIME

		WebElement duration =
				driver.findElementByXPath("//div[@class='duration-details']");

		takeSnapshot(duration, "duration");

		Thread.sleep(4000);


		//7. Validate the pickup time and Drop off time are correct (as you selected) and click on Done
		String pickup = driver.findElementByXPath("(//div[@class='time']//div)[2]").getText();

		String drop = driver.findElementByXPath("(//div[@class='time']//div)[4]").getText();

		if (pickup.contains("09:00 AM") && (drop.contains("06:00 PM"))) {

			System.out.println("PickUp Time selected is 09:00 AM & Drop Time selected is 06:00 PM.");
			System.out.println("Time Validation Done");

		}

		//8. Click on Price: High to Low and validate the sort order of the car price programmatically4
		driver.findElementByXPath("//div[@class='item' and text()=' Price: High to Low ']").click();

		Thread.sleep(3000);

		//9.Print all the Car name and respective Price from High to Low ( car name -- price ) 
		List<WebElement> carName = driver.findElementsByXPath("//div[@class='details']//h3");

		List<WebElement> carPrice = driver.findElementsByXPath("//div[@class='new-price']");
		Map<String, String> map = new LinkedHashMap<String, String>(); 

		for(int i=0;i<=carName.size()-1;i++)
		{

			WebElement CarNameListed = carName.get(i);
			WebElement CarPriceListed = carPrice.get(i);
			map.put(CarNameListed.getText(), CarPriceListed.getText().replaceAll("[^0-9.]", ""));

		}
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println("Car --> " + entry.getKey() + " Price --> " + entry.getValue());
		}


		//10. Take snapshot of the details for the Highest price car

		WebElement firstcar =
				driver.findElementByXPath("(//div[@class='component-car-item'])[1]");

		takeSnapshot(firstcar, "firstcar");

		Thread.sleep(4000);



		//11. Click on Know More for the Highest price car and print the rate after 45Kms

		driver.findElementByXPath("(//div[@class='know-more-details'])[1]").click();

		Thread.sleep(3000);

		WebElement rate = driver.findElementByXPath("(//div[@class='price-info'])[1]");

		String rateafter45 = rate.getText().substring(2, 4);

		System.out.println("Rate after 45 kms:"+rateafter45+"perkm");

		Thread.sleep(3000);

		//12. Close the Browser

		driver.close();


	}



}
