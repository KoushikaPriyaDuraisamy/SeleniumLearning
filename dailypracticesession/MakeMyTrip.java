package dailypracticesession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(10000);

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		Actions builder = new Actions(driver);
		
		WebElement menu = driver.findElementByXPath("//ul[@class='makeFlex font12']");
		
		builder.moveToElement(menu).click(menu).perform();
		
		WebElement hotel = driver.findElementByXPath("//li[@class='menu_Hotels']");

		hotel.click();
		
		//driver.findElementByXPath("//div[contains(@class,'loginModal')]").click();

		//driver.findElementByXPath("//div[@class='chHeaderContainer']//li[@class='menu_Hotels']/a").click();

		Thread.sleep(3000);

		driver.findElementById("checkin").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//div[@aria-label='Wed Jul 15 2020']").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//div[@aria-label='Sun Jul 19 2020']").click();

		Thread.sleep(1000);

		driver.findElementById("guest").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//li[@data-cy='children-1']").click();

		Thread.sleep(2000);

		WebElement childage = driver.findElementByXPath("//select[@class='ageSelectBox']");

		childage.click();

		Select dropDown = new Select(childage);

		dropDown.selectByVisibleText("12");

		Thread.sleep(2000);

		driver.findElementByXPath("//button[@data-cy='submitGuest']").click();

		Thread.sleep(2000);

		driver.findElementById("hsw_search_button").click();

		Thread.sleep(5000);

		

		WebElement header = driver.findElementByXPath("//div[@class='flexOne appendRight30 alignSelfBottom']");

		builder.moveToElement(header).click(header).perform();

		driver.findElementByXPath("(//div[@class='locationFtrModal']//li)[4]").click();

		Thread.sleep(5000);

		WebElement userrating = driver.findElementByXPath("//div[text()='User Rating']");

		WebElement good = driver.findElementByXPath("//label[text()='3 & above (Good)']");

		good.click();

		Thread.sleep(8000);

		driver.findElementByXPath("//span[text()='Popularity']").click();

		driver.findElementByXPath("//li[text()='Price - Low to High']").click();

		Thread.sleep(8000);

		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

		driver.findElementByXPath("//div[@class='listingRowOuter' and @id='Listing_hotel_1']").click();

		driver.manage().deleteAllCookies();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> listHandles = new ArrayList<String>(windowHandles);

		String firsthotel = listHandles.get(1);

		driver.switchTo().window(firsthotel);

		Thread.sleep(5000);

		String firsthotelwindow = driver.getTitle();

		System.out.println(firsthotelwindow);

		WebElement hotelname = driver.findElementById("detpg_hotel_name");

		String name = hotelname.getText();

		System.out.println("First Resulting Hotel Name is " + name);

		driver.findElementByXPath("//button[text()='VIEW THIS COMBO']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='Book this combo']").click();

		Thread.sleep(12000);


		driver.findElementByXPath("//div[@class='_Modal modalCont']//span[@class='close']").click();

		Thread.sleep(2000);

		WebElement amount = driver.findElementByXPath("//span[@id='revpg_total_payable_amt']");

		String totalamount = amount.getText();

		System.out.println("Total Payable is " + totalamount);

		driver.close();
		
		String main = listHandles.get(0);
		
        driver.switchTo().window(main);
        
    	driver.close();
	}



}
