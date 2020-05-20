package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Erailsort {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://erail.in/");

		Thread.sleep(2000);

		WebElement froms = driver.findElementByXPath("//input[@placeholder='From Station']");

		Thread.sleep(1000);

		froms.clear();

		Thread.sleep(1000);

		froms.sendKeys("MAS");

		Thread.sleep(1000);

		froms.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		WebElement tos = driver.findElementByXPath("//input[@placeholder='To Station']");

		tos.clear();

		Thread.sleep(1000);

		tos.sendKeys("SBC");

		Thread.sleep(1000);

		tos.sendKeys(Keys.ENTER);

		driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();

		Thread.sleep(2000);

		String text1 = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr[1]").getText();

		System.out.println(text1);

		String text2 = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr[1]/td[2]").getText();

		System.out.println(text2);

		List<String> trainname = new ArrayList<String>();

		List<WebElement> rows = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");

		for(int i = 1; i <=rows.size(); i ++) {

			trainname.add(driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]/a").getText());

		}
		System.out.print(trainname);
		
		driver.manage().window().maximize();
		
		Collections.sort(trainname);
		
		for (String newtrainname : trainname) {
			System.out.println(newtrainname);
			
		}
		
	}
}






