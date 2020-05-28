package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3schools {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeDriver driver =new ChromeDriver();

		driver.navigate().to("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.switchTo().frame(0);

		driver.findElementByXPath("//button[text()='Try it']").click();

		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		alert.sendKeys("Koushika Priya");

		Thread.sleep(2000);

		alert.accept();

		String name = driver.findElementByXPath("//p[@id='demo']").getText();

		System.out.println(name);

		String myname = "Koushika Priya";

		if(name.contains(myname))
		{
			System.out.println("Text contains my name");
		}

		else
		{
			System.out.println("Text doesnt contain my name");
		}

		driver.close();
	}

}
