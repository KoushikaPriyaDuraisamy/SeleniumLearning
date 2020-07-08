package dailypracticesession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Trivago {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities dcap = new DesiredCapabilities();
		dcap.setCapability(ChromeOptions.CAPABILITY, options);

		ChromeDriver driver = new ChromeDriver(dcap);

		//1. Go to https://www.trivago.com/
		driver.get("https://www.trivago.com");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Thread.sleep(5000);

		WebElement destination = driver.findElementByXPath("//input[@type='search']");

		destination.click();

		Thread.sleep(2000);

		//2. Type Agra in Destination and select Agra, Uttar Pradesh.
		destination.sendKeys("Agra");

		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='City - Uttar Pradesh, India']").click();

		Thread.sleep(2000);

		WebElement checkin = driver.findElementByXPath("(//span[@class='dealform-button__text-wrapper'])[1]");

		checkin.click();
		Thread.sleep(1000);
		checkin.click();

		Thread.sleep(3000);

		//3. Choose july 15 as check in and july30 as check out
		WebElement july15 = driver.findElementByXPath("//table//tr//td[@class='cal-day-wrap']//time[@datetime='2020-07-15']");

		july15.click();

		Thread.sleep(2000);

		WebElement july31 = driver.findElementByXPath("//table//tr//td[@class='cal-day-wrap']//time[@datetime='2020-07-31']");

		july31.click();

		Thread.sleep(2000);


		/*
		 * //4. Select Room as Family Room driver.
		 * findElementByXPath("(//ul[@class='df_container_roomtype_selector df_dropdown']//li)[3]"
		 * ).click();
		 * 
		 * Thread.sleep(2000);
		 */

		//5.Choose Number of Adults 2, Childern 1 and set Child's Age as 4

		WebElement children = driver.findElementById("children-input");

		children.clear();

		children.sendKeys("1");

		children.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		WebElement age = driver.findElementByXPath("//select[@id='child-0']");

		Select dropDown2 = new Select(age);

		dropDown2.selectByValue("4");

		Thread.sleep(2000);

		//6.Click Confirm button and click Search
		driver.findElementByXPath("//button[@class='btn btn--primary btn--small btn--apply-config']").click();

		Thread.sleep(5000);


		//7.Select Accommodation type as Hotels only and choose 4 stars
		WebElement accommodation = driver.findElementByXPath("//li[@class='toolbar-list__item toolbar-list__item--stars js-toolbar__item--stars js-toolbar-stars']");

		accommodation.click();

		Thread.sleep(1000);

		driver.findElementByXPath("//li//input[@id='acc-type-filter-1']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//button[@title='4-star hotels']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//button[@id='filter-popover-done-button']").click();

		Thread.sleep(3000);

		//8.Select Guest rating as Very Good
		WebElement rating = driver.findElementByXPath("//li[@class='toolbar-list__item toolbar-list__item--rating js-toolbar__item--rating js-toolbar-rating']");

		rating.click();

		Thread.sleep(1000);

		driver.findElementByXPath("(//li[@class='range__item'])[2]").click();

		Thread.sleep(3000);

		//9. Set Hotel Location as Agra Fort and click Done
		WebElement location = driver.findElementByXPath("//li[@class='toolbar-list__item toolbar-list__item--location js-toolbar__item--location js-toolbar-location']");

		location.click();

		Thread.sleep(2000);

		WebElement hotellocation = driver.findElementByXPath("//select[@name='pois']");

		Select dropDown3 = new Select(hotellocation);

		dropDown3.selectByValue("159477/500");

		Thread.sleep(2000);

		driver.findElementByXPath("//button[@id='filter-popover-done-button']").click();

		Thread.sleep(3000);

		//10. In more Filters, select Air conditioning, Restaurant and WiFi and click Done
		WebElement morefilters = driver.findElementByXPath("//li[@class='toolbar-list__item toolbar-list__item--more js-toolbar__item--more js-toolbar-more']");

		morefilters.click();

		Thread.sleep(2000);

		driver.findElementByXPath("//li[@class='filter-components__concept--5c101']//label[text()='Air conditioning']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//li[@class='filter-components__concept--5c101 filter-components__hasNoBorder--8b337']//label[text()='Restaurant']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//li[@class='filter-components__concept--5c101']//label[text()='WiFi']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//button[@id='filter-popover-done-button']").click();

		Thread.sleep(5000);

		//11. Sort the result as Rating & Recommended
		WebElement sorting = driver.findElementByXPath("//select[@id='mf-select-sortby']");

		Select dropDown4 = new Select(sorting);

		dropDown4.selectByValue("7");	

		Thread.sleep(5000);
		
		//12. Print the Hotel name, Rating, Number of Reviews and Click View Deal(all hotel names)
		
		List<WebElement> hotelnames = driver.findElementsByXPath("//span[@data-qa='item-name']");
		
		int size = hotelnames.size();
		
		System.out.println("Total number of hotels fetched : " +size);
		
		System.out.println("List of Hotels:");
		
		System.out.println("***************");
		
		Thread.sleep(10000);
		
		for(int i=0;i<size;i++)
		{
			System.out.println((i+1)+". " +hotelnames.get(i).getText());
		}
		
		Thread.sleep(5000);
		
		//13. Print the URL of the Page
		String currentURL = driver.getCurrentUrl();
		
		System.out.println("Current URL is: "+currentURL);
		
		 //clicking on the deal of first resulting hotel
		driver.findElementByXPath("(//span[text()='View Deal'])[1]").click();
		
		
		Set<String> setWindowHandles = driver.getWindowHandles();
		
		List<String> listWindowHandles = new ArrayList<String>(setWindowHandles);
		
		// getting the second window
		String secondWindow = listWindowHandles.get(1);	
		
		driver.switchTo().window(secondWindow);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().refresh();
		
		//printing price and clicking choose your room
		String price = driver.findElementByXPath("(//div[contains(@class,'bui-price-display__value prco-text-nowrap-helper')])[1]").getText();
		
		System.out.println("Price of Hotel: "+price.substring(2));
		
		driver.findElementByXPath("(//span[@class='bui-button__text'])[1]").click();
		
		
		//Selecting Reseve and I will Reserve
		driver.findElementByXPath("(//span[@class='bui-button__text'])[1]").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//button[@type='submit'])[3]").click();
		
		// closes the second window
		driver.close();

		// going back to first window again
		driver.switchTo().window(listWindowHandles.get(0));

		// closes the first window
		driver.close();

	}


}
