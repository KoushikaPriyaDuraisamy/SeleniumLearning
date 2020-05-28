package week4.day2;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {


	public static void takeScreenshot(WebElement button3,String eleName) throws IOException{

		Date date = new Date();

		Timestamp timestamp= new Timestamp(date.getTime());

		String time=timestamp.toString();

		time = time.replace(' ', '-');

		time = time.replace(':', '-'); 

		//String attribute = button3.getAttribute("name");

		File source = button3.getScreenshotAs(OutputType.FILE);

		File target = new File("./snaps/"+eleName+"_"+time+"_"+".png");

		FileUtils.copyFile(source, target);


	}

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		File window = driver.getScreenshotAs(OutputType.FILE);

		File target = new File("./snaps/window.png");

		FileUtils.copyFile(window, target);

		WebElement button3 = driver.findElementByXPath("//button[text()='Do not close me ']");

		takeScreenshot(button3,"button3");

		WebElement button2 = driver.findElementByXPath("//button[text()='Open Multiple Windows']");

		takeScreenshot(button2,"button2");

		WebElement button1 = driver.findElementByXPath("//button[text()='Open Home Page']");

		takeScreenshot(button1,"button1");

		WebElement button4 = driver.findElementByXPath("//button[text()='Wait for 5 seconds']");

		takeScreenshot(button4,"button4");

	}

}
