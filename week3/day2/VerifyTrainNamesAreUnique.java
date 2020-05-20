package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class VerifyTrainNamesAreUnique {

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
		
		System.out.println("########################");
		
		System.out.println(trainname.size());
		
		driver.manage().window().maximize();
		
		  Set<String> trainNameSet = new LinkedHashSet<String>(trainname);
		  trainNameSet.addAll(trainname);
		  
		  System.out.println(trainNameSet);
		  
		  System.out.println(trainNameSet.size());
		  
		  if(trainname.size()==trainNameSet.size()) {
			  System.out.println("Trainnames are Unique");
		  }
			  else
			  {
				  System.out.println("Trainnames are not Unique");
			  }
		  }
		 
	
	}
	







