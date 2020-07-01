package dailypracticesession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Ajio {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeOptions options= new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver= new ChromeDriver(options);
		
		driver.get("https://www.ajio.com/shop/sale");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(10000);

		driver.manage().window().maximize();
		
		WebElement search = driver.findElementByXPath("//input[@placeholder='Search AJIO']");
		
		search.click();
		
		search.sendKeys("Bags");
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("(//span[text()='Bags in '])[1]").click();
		
		Thread.sleep(8000);
		
		driver.findElementByXPath("//div[@class='five-grid-container ']").click();
		
		Thread.sleep(8000);
		
		driver.findElementByXPath("//div[@class='filter-dropdown']//select//option[1]").click();
		
		driver.findElementByXPath("//div[@class='filter-dropdown']//select//option[4]").click();
		
		Thread.sleep(8000);
		
		driver.findElementByXPath("//span[text()='price']").click();
		
		driver.findElementById("minPrice").sendKeys("2500");
		
		driver.findElementById("maxPrice").sendKeys("5000");
		
		driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//div[text()='Sling Bag with Chain Strap']").click();
		
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> listHandles = new ArrayList<String>(windowHandles);

		String slingbag = listHandles.get(1);

		driver.switchTo().window(slingbag);

		Thread.sleep(5000);
		
		WebElement promo = driver.findElementByXPath("//div[text()='Extra Upto 32% Off on 2890 and Above. ']");
		
		String promodesc = promo.getText();
		
		if (promodesc.contains("Off on 2890")) {
			
			System.out.println("Promocode is applicable");
			
		}
		else
		{
			System.out.println("Promocode is not applicable");
		}
		
		String coupon = driver.findElementByXPath("//div[@class='promo-title']").getText();
		
		String couponcode = coupon.replaceAll("Use Code", "");
		
		System.out.println(couponcode);
		
		String price = driver.findElementByXPath("//div[@class='promo-discounted-price']//span").getText();
		
		String discountprice = price.replaceAll("[^0-9]", "");
		
		System.out.println("Discounted Price is " +discountprice);
		
		 driver.findElementByXPath("//div[@class='edd-pincode-msg-container']").click();
		 
		 Thread.sleep(1000);
		 
		 driver.findElementByName("pincode").sendKeys("560043");
		 
		 driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
		 
		 Thread.sleep(2000);
		
		 String delivery = driver.findElementByXPath("//ul[@class='edd-message-success-details']//li").getText();
		 
		 if (delivery.contains("Expected")) {
			 System.out.println("Product is available");
		 }
		 else
		 {
			 System.out.println("Product is not available");
		 }
		 String date = driver.findElementByXPath("//span[@class='edd-message-success-details-highlighted']").getText();
		 
		 System.out.println("Expected Delivery: " +date);
		
		 
		 driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		 
		 Thread.sleep(1000);
		
		 String otherinfo = driver.findElementByXPath("(//span[@class='other-info'])[7]").getText();
		 
		 System.out.println("Customer Care address : " +otherinfo);
		 
		 driver.findElementByXPath("//div[@class='pdp-addtocart-button']").click();
		 
		 Thread.sleep(8000);
		 
		 driver.findElementByXPath("//div[@class='btn-cart']").click();
		 
		 Thread.sleep(5000);
		 
		 String ordertotal = driver.findElementByXPath("//span[@class='price-value bold-font']").getText();
		 
		 
		 System.out.println("Product Price before applying coupon " + ordertotal);
	
	     driver.findElementById("couponCodeInput").sendKeys(couponcode);
	     
	     driver.findElementByXPath("//button[text()='Apply']").click();
	     
	     Thread.sleep(3000);
	     
	     String discountedprice = driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
	     
	     System.out.println("Product Price after applying coupon " + discountedprice );
	     
	     
	     if (ordertotal.equals(discountedprice)) {
	    	 System.out.println("Discount price matches with the Product price");
		}
	     else
	     {
	    	 System.out.println("Discount price doesn't matches with the Product price");
	     }
	     
	driver.findElementByXPath("//div[@class='delete-btn']").click();
	
	Thread.sleep(1000);
	
	driver.findElementByXPath("(//div[@class='delete-btn'])[2]").click();
	
	Thread.sleep(5000);
	
	driver.close();
	
	String main = listHandles.get(0);
	
    driver.switchTo().window(main);
    
	driver.close();
	     
	}

}
