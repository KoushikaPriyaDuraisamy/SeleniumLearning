package dailypracticesession;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		//1. Go to https://www.bigbasket.com/
		driver.get("https://www.bigbasket.com/");

		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		Thread.sleep(20000);

		// 2. mouse over on  Shop by Category 
		WebElement category = driver.findElementByXPath("//a[@class='dropdown-toggle meganav-shop']");

		Actions builder = new Actions(driver);

		builder.moveToElement(category).perform();

		WebElement bevarages = driver.findElementByXPath("(//a[@class='ng-binding' and text()='Beverages'])[2]");

		builder.moveToElement(bevarages).perform();

		Thread.sleep(1000);


		WebElement fruitjuices = driver.findElementByXPath("(//li[@class='ng-scope'])[41]");

		//3. Go to Beverages and Fruit juices & Drinks
		builder.moveToElement(fruitjuices).perform();

		Thread.sleep(1000);


		//4.Click on JUICES
		WebElement juices = driver.findElementByXPath("(//a[@ng-bind='l3.name'])[5]");

		builder.moveToElement(juices).click(juices).perform();

		Thread.sleep(5000);

		//5. click  Real under Brand

		driver.findElementByXPath("(//span[@class='ng-binding' and text()='Real'])[1]").click();

		Thread.sleep(5000);

		// counting real
		String real = driver.findElementByXPath("(//div[@class='ng-scope']//span[@class='ng-binding ng-scope'])[5]").getText();
		
		String realcount = real.replaceAll("[()]", "");

		System.out.println("Real juices count is " + realcount);
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//li[@class='tab-clear']").click();
		
		Thread.sleep(6000);
		
		// click tropicana under brand 
		
		driver.findElementByXPath("(//span[@class='ng-binding' and text()='Tropicana'])[1]").click();
		
		Thread.sleep(8000);
		
		//counting tropicana
		
		String tropicana = driver.findElementByXPath("(//span[@class='ng-binding ng-scope'])[5]").getText();
		
		String tropicanacount = tropicana.replaceAll("[()]", "");

		System.out.println("Tropicana juices count is " + tropicanacount);
		
		Thread.sleep(5000);

		//select real again
		
		driver.findElementByXPath("(//span[@class='ng-binding' and text()='Real'])[1]").click();
		
		Thread.sleep(8000);
	
		//6. Check count of the products from each Brands and total count  
		
		String total = driver.findElementByXPath("(//span[@class='ng-binding ng-scope'])[5]").getText();
	
		String totalcount = total.replaceAll("[()]", "");
		
		System.out.println("Total Count of the juices is " +totalcount);
		
		Thread.sleep(5000);
		
		//7. Check whether the products is availabe with Add button 
		
		List<WebElement> addButton = driver.findElementsByXPath("//button[@qa='add']");

		int size = addButton.size();

		System.out.println(size + " Products have add button");
		
		Thread.sleep(2000);
		
		List<WebElement> notifyme = driver.findElementsByXPath("//button[@qa='NM']");

		int size2 = notifyme.size();
		
		System.out.println(size2 + " Products have notify me button");

		Thread.sleep(2000);
		
		//8. Add the First listed available product
		driver.findElementByXPath("(//button[@qa='add'])[1]").click();
		
		Thread.sleep(2000);
		
		//9.click on Change Address 
		driver.findElementByXPath("(//a[text()='Change Location'])[1]").click();
		
		Thread.sleep(1000);
		
		//10. Select CHennai as City, Alandur-600016,Chennai as Area  and click Continue
		
		WebElement area = driver.findElementByXPath("(//input[@qa='areaInput'])[1]");
		
		area.click();
		
		area.sendKeys("Alandur,");
		
		Thread.sleep(1000);
		
		area.sendKeys(Keys.ARROW_DOWN);
		
		area.sendKeys(Keys.ARROW_DOWN);
		
		area.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//button[@type='submit'])[1]").click();
		
		Thread.sleep(3000);
		
		//11.Mouse over on My Basket print the product name. count and price.
		WebElement basket = driver.findElementByXPath("//a[@qa='myBasket']");
		
		builder.moveToElement(basket).click(basket).perform();
		
		Thread.sleep(2000);
		
		String productname = driver.findElementByXPath("//li[@qa='itemsListMB']//div[@class='product-name']").getText();

		System.out.println("Product Name is " + productname);
		
		Thread.sleep(2000);
		
		String quantity = driver.findElementByXPath("//div[@class='col-md-5']//input[@ng-model='cartItem.quantity']").getAttribute("value");
	
		System.out.println("Product Quantity is  " + quantity);
		
		Thread.sleep(2000);
		
		String price = driver.findElementByXPath("//div[@class='row mrp']").getText();
		
		System.out.println("Product Price is " + price);
		
		Thread.sleep(2000);
		
		//12.Click View Basker and Checkout
		
		WebElement checkout = driver.findElementByXPath("//div[@class='row bb-chkout-btn']");
		
		builder.moveToElement(checkout).click(checkout).perform();
		
		Thread.sleep(3000);
		
		//13. Click the close button and close the browser
		driver.findElementByXPath("(//button[@class='close'])[1]").click();
		
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

}
