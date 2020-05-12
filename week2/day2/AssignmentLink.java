package week2.day2;


import org.openqa.selenium.chrome.ChromeDriver;


public class AssignmentLink {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Link.html");
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("(//div[@class='large-6 small-12 columns']//following::a)[1]").click();
		
		Thread.sleep(4000);
		
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("(//div[@class='large-6 small-12 columns']//following::a)[2]").click();
		
		Thread.sleep(4000);
		
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("(//div[@class='large-6 small-12 columns']//following::a)[3]").click();
		
		Thread.sleep(4000);
		
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("(//div[@class='large-6 small-12 columns']//following::a)[4]").click();
		
		Thread.sleep(4000);
		
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("(//div[@class='large-6 small-12 columns']//following::a)[5]");
		
		Thread.sleep(3000);

		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		driver.manage().window().maximize();
	}

}
