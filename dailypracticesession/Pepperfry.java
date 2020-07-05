package dailypracticesession;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class Pepperfry {

	public static void takeScreenshot(WebElement element,String eleName) throws IOException{

		File source = element.getScreenshotAs(OutputType.FILE);

		File target = new File("./snaps/" +eleName + ".png");

		FileUtils.copyFile(source, target);


	}

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options= new ChromeOptions();

		options.addArguments("--disable-notifications");

		ChromeDriver driver= new ChromeDriver(options);

		//1.Go to https://www.pepperfry.com/
		driver.get("https://www.pepperfry.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		//closing pop-up window
		driver.findElementByXPath("//div[@id='regPopUp']/a").click();

		Thread.sleep(2000);

		Actions builder = new Actions(driver);

		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");

		//closing the image
		WebElement image = driver.findElementByXPath("//div[@id='webklipper-publisher-widget-container-notification-close-div']");

		builder.moveToElement(image).click(image).perform();

		Thread.sleep(3000);


		//switching back to parent frame
		driver.switchTo().defaultContent();


		WebElement furniture = driver.findElementByLinkText("Furniture");

		WebElement chairs = driver.findElementByXPath("(//div[text()='Chairs'])[1]");

		WebElement officechair = driver.findElementByXPath("(//a[text()='Office Chairs'])[1]");

		//2. Mouseover on Furniture and click Office Chairs under Chairs
		builder.moveToElement(furniture).click(furniture).perform();

		Thread.sleep(2000);

		builder.moveToElement(chairs).moveToElement(officechair).click(officechair).perform();

		Thread.sleep(8000);

		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");

		//closing the freedomimage
		WebElement image1 = driver.findElementByXPath("//div[@id='webklipper-publisher-widget-container-notification-close-div']");

		builder.moveToElement(image1).click(image1).perform();

		Thread.sleep(3000);

		//switching back to parent frame
		driver.switchTo().defaultContent();

		WebElement executivechair = driver.findElementByXPath("//div[@class='cat-wrap-ttl']//h5[text()='Executive Chairs']");

		//3. click Executive Chairs
		builder.moveToElement(executivechair).click(executivechair).perform();

		Thread.sleep(6000);

		WebElement inch = driver.findElementByXPath("(//div[@class='clip__filter-dimension-input-holder']//input[@type='number'])[1]");

		// 4.Change the minimum Height as 50 in under Dimensions
		inch.clear();

		Thread.sleep(1000);

		inch.sendKeys("50");

		inch.sendKeys(Keys.ENTER);

		Thread.sleep(5000);


		WebElement poise = driver.findElementByXPath("(//div[@class='clip-prd-hrt pf-col xs-2']//a[@class='clip-heart-icn pf-right'])[6]");

		builder.moveToElement(poise).click(poise).perform(); 

		Thread.sleep(5000);

		WebElement furniture1 = driver.findElementByXPath("//a[text()='Furniture']");

		//6. Mouseover on Furniture and Click Office tables
		builder.moveToElement(furniture1).click(furniture1).perform();

		WebElement tables = driver.findElementByXPath("(//div[text()='Tables'])[1] ");



		WebElement officetables = driver.findElementByXPath("(//a[text()='Office Tables'])[1]");

		builder.moveToElement(tables).moveToElement(officetables).click(officetables).perform();

		Thread.sleep(8000);

		//7. Select Executive Desks
		WebElement executive = driver.findElementByXPath("//div[@class='cat-wrap-img']//img[@alt='Executive Desks']");

		builder.moveToElement(executive).click(executive).perform();

		//8.Select Price between 20000 to 40000 rs
		driver.findElementByXPath("(//label[@for='price20000-40000'])[1]").click();

		Thread.sleep(5000);

		WebElement browncolour = driver.findElementByXPath("//a[text()='Executive Office Table in Brown Color']"); 

		WebElement wishlist = driver.findElementByXPath("//div[@class='clip-prd-hrt pf-col xs-2']//a[@id='clip_wishlist_']");

		//9. Add "Executive Office Table in Brown Color" to Wishlist
		builder.moveToElement(browncolour).moveToElement(wishlist).click(wishlist).perform();

		Thread.sleep(4000);


		//10.Verify the number of items in Wishlist
		String wishlistcount = driver.findElementByXPath("//div[@class='wishlist_bar']//span[@class='count_alert']").getText();

		System.out.println("Wishlist count is " + wishlistcount);

		if (wishlistcount.contains("2")) {
			System.out.println("Wishlist Verified");	
		}
		else
		{
			System.out.println("Wishlist not verified");
		}


		WebElement wishlisticon = driver.findElementByXPath("//div[@class='wishlist_bar']//a[@data-tooltip='Wishlist']");

		//11. Navigate to Wishlist
		builder.moveToElement(wishlisticon).click(wishlisticon).perform();

		Thread.sleep(2000);

		//12. Get the offer Price and Coupon Code for Executive Office Table in Brown Color
		String offerprice = driver.findElementByXPath("(//p[@class='oprice']//span[@class='txt-green'])[1]").getText();

		System.out.println("Offer Price for Executive Office Table in Brown Color  " + offerprice);


		String couponcode = driver.findElementByXPath("(//p[@class='pf-border pf-border-lighter-grey-50 pf-border-style-dashed pf-center pf-padding-tiny font-14 pf-italic-txt pf-text-grey pf-margin-top use-coupon']//strong)[1]").getText();

		System.out.println("Coupon Code for Executive Office Table in Brown Color " + couponcode);

		//13. Move Executive Office Table in Brown Color only to Cart from Wishlist
		driver.findElementByXPath("(//div[@class='action_block']//a[@data-tooltip='Add to Cart'])[1]").click();

		Thread.sleep(2000);

		WebElement pincode = driver.findElementByXPath("//div[@class='pin_block']//input[@type='text']");

		//14. Check for the availability for Pincode 600128
		builder.moveToElement(pincode).click(pincode).perform();

		pincode.sendKeys("600128");

		driver.findElementByXPath("//div[@class='pin_block']//a[@class='check_available']").click();

		Thread.sleep(3000);

		//15.  Click on PROCEED TO PAY SECURELY from My Cart
		driver.findElementByXPath("//div[@class='minicart_footer']//a[@class='proceed_cta']").click();

		Thread.sleep(5000); 

		//16. Enter the Coupon code and click Apply
		WebElement coupon = driver.findElementByXPath("//div[@class='ck-cpn-input-wrap']//input[@id='coupon_code']");

		coupon.sendKeys(couponcode);

		Thread.sleep(2000);

		driver.findElementByXPath("//div[@class='ck-cpn-input-wrap']//input[@value='APPLY']").click();

		Thread.sleep(5000);

		//17. Click Proceed to Pay
		driver.findElementByXPath("//span[@class='ck-proceed-btn-wrap']//a[@class='btn_green_big  '] ").click();

		Thread.sleep(4000);


		//18. Capture the screenshot of the item under ORDER SUMMARY
		driver.findElementByXPath("(//div[@class='nCheckout__accrodian-header-right']//span)[1]").click();

		Thread.sleep(2000);

		WebElement orderimage = driver.findElementByXPath("//li[@role='option']//figure//img ");

		takeScreenshot(orderimage, "orderimage");

		Thread.sleep(2000);

		//19. Close the browser
		driver.close(); 




	}

}
