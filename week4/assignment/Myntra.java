package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Myntra {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeOptions options = new ChromeOptions();

		//options.addArguments("--incognito");

		options.addArguments("--disable-notifications");

		//DesiredCapabilities dcap = new DesiredCapabilities();

		//dcap.setCapability(ChromeOptions.CAPABILITY, options);

		//ChromeDriver driver = new ChromeDriver(dcap);

		ChromeDriver driver =new ChromeDriver(options);

		driver.get("https://www.myntra.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		WebElement women = driver.findElementByXPath("//a[@data-group='women']");

		Thread.sleep(2000);

		Actions builder = new Actions(driver);

		builder.moveToElement(women).perform();

		Thread.sleep(3000);

		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();

		Thread.sleep(4000);

		String count = driver.findElementByXPath("//span[@class='title-count']").getText();

		//System.out.println("Total count of Jackets and Coats are " + count);

		String totalcount = count.replaceAll("\\D", "");

		int count1 = Integer.parseInt(totalcount);

		System.out.println(count1);

		String jackets = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();

		String coats = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();

		String jackets1 = jackets.replaceAll("\\D", "");

		int jackets2 = Integer.parseInt(jackets1);

		String coats1 = coats.replaceAll("\\D", "");

		int coats2 = Integer.parseInt(coats1);

		int categoriescount = (jackets2+coats2);

		System.out.println(categoriescount);

		if (count1==categoriescount) {
			System.out.println("The sum of categories JACKETS & COATS count matches");
		}
		else
		{
			System.out.println("The sum of categories JACKETS & COATS count doesnt matches");
		}

		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();

		Thread.sleep(5000);

		driver.findElementByXPath("//div[@class='brand-more']").click();

		Thread.sleep(3000);

		WebElement search = driver.findElementByXPath("//input[@placeholder='Search brand']");

		builder.click(search).sendKeys("MANGO").perform();

		Thread.sleep(3000);

		driver.findElementByXPath("//label[@class=' common-customCheckbox']").click();

		Thread.sleep(3000);

		WebElement close = driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']");

		builder.moveToElement(close).click(close).perform();

		Thread.sleep(5000);


		String mcount = driver.findElementByXPath("//span[@class='title-count']").getText();

		String tmcount = mcount.replaceAll("-", "").replaceAll("\\D", "");

		int totalmango = Integer.parseInt(tmcount);

		String mc = driver.findElementByXPath("(//span[@class='brand-num'])[4]").getText();

		String mcc = mc.replaceAll("\\D", "");

		int mangocategory = Integer.parseInt(mcc);

		if (totalmango==mangocategory) {
			System.out.println("MANGO  Category Coat count matches");
		}

		else
		{
			System.out.println("MANGO  Category Coat count doesnt matches");
		}


		String text = driver.findElementByXPath("(//div[@class='filter-summary-filter'])[2]").getText();

		System.out.println("All the coats displayed below belongs to the category " + text);

		Thread.sleep(3000);

		WebElement sort = driver.findElementByXPath("//div[@class='horizontal-filters-sortContainer']");

		WebElement better = driver.findElementByXPath("//label[text()='Better Discount']");

		WebElement move = driver.findElementByXPath("//ul[@class='atsa-filters']");

		builder.moveToElement(sort).moveToElement(better).click(better).moveToElement(move).perform();

		Thread.sleep(3000);

		String price = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();

		System.out.println("Product Price of First item is " + price);

		Thread.sleep(2000);

		WebElement info = driver.findElementByXPath("(//div[@class='product-productMetaInfo'])[1] ");

		WebElement size = driver.findElementByXPath("(//div[@class='product-productMetaInfo']//h4[@class='product-sizes'])[1]");

		WebElement wl = driver.findElementByXPath("(//div[@class='product-actions ']//span[@class='product-actionsButton product-wishlist '])[1]");

		builder.moveToElement(info).moveToElement(size).click(wl).perform();

		Thread.sleep(3000);

		driver.close();



	}

}
