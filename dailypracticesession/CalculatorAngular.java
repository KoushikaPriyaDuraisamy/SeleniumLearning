package dailypracticesession;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorAngular {

	public static void main(String[] args) throws InterruptedException {

		

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

			ChromeDriver driver = new ChromeDriver();

			driver.get("https://juliemr.github.io/protractor-demo/");
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			
			WebElement firstNum = driver.findElementByXPath("//input[@ng-model='first']");
			
			firstNum.click();
			
			firstNum.sendKeys("10");
			
			WebElement operator = driver.findElementByXPath("//select[@ng-model='operator']");
			
			Select dropDown = new Select(operator);
			
			dropDown.selectByValue("MULTIPLICATION");
			
			WebElement secondNum = driver.findElementByXPath("//input[@ng-model='second']");
			
			secondNum.click();
			
			secondNum.sendKeys("10");
			
			driver.findElementByXPath("//button[@id='gobutton']").click();
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(1))
					.pollingEvery(Duration.ofMillis(500))
					.ignoring(ElementNotInteractableException.class);
					
			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//h2[@class='ng-binding']"), ". . ."));
			
		String answer = driver.findElementByXPath("(//table//tr//td[@class='ng-binding'])[2]").getText();
			
		System.out.println("Answer is " + answer);
			
			driver.close();
			
	}

}
