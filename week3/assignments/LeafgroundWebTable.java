package assignments;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/table.html");
		
		Thread.sleep(2000);
		
		WebElement table = driver.findElementByXPath("//table[@id='table_id']");
		
		Thread.sleep(2000);
		
		List<WebElement> rows = driver.findElementsByXPath("//table[@id='table_id']//tr");
		
		Thread.sleep(2000);
		
		List<WebElement> cells = driver.findElementsByXPath("//table[@id='table_id']//tr/td");
		
		Thread.sleep(2000);
		
		System.out.println(rows.size());
		
		
		System.out.println(cells.size());

		
		WebElement Progress = driver.findElementByXPath("//table[@id='table_id']//tr[3]/td[2]");
		
		System.out.println(Progress.getText());
		
		Thread.sleep(2000);
		
		WebElement vital = driver.findElementByXPath("//table[@id='table_id']//tr[4]/td[3]/input");
		
		vital.click();
		
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
	}

}
