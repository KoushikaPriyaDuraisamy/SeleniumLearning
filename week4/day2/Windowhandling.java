package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		//String windowHandle = driver.getWindowHandle();

		//System.out.println(windowHandle);

		String pagename = driver.getTitle();

		System.out.println(pagename);

		driver.findElementById("home").click();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String TwoWindows : windowHandles) {
			System.out.println(TwoWindows);

		}

		List<String> listHandles = new ArrayList<String>(windowHandles);

		String secondwindow = listHandles.get(1);

		//listHandles.addAll(windowHandles);

		driver.switchTo().window(secondwindow);

		String pagename2 = driver.getTitle();

		System.out.println(pagename2);

		driver.close();  

		/*
		 * driver.findElementByXPath("(//img)[7]").click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * System.out.println(driver.getTitle());
		 */

		String firstwindow = listHandles.get(0);

		driver.switchTo().window(firstwindow);

		String title = driver.getTitle();

		System.out.println(title);






	}

}
