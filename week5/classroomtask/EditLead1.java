package classroomtask;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditLead1 extends BaseClass{
	
  @Test(dependsOnMethods= {"classroomtask.CreateLead1.runCreateLead"})
  public void runEditLead()throws InterruptedException {
	  
	  WebElement findlead = driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']");
      
      findlead.click();
      
      WebElement fn = driver.findElementByXPath("(//div[@class='x-form-element']//input[@name='firstName'])[3]");
      
      fn.sendKeys("Koushika");
      
      driver.findElementByXPath("(//em[@unselectable='on']//button[@class='x-btn-text'])[7] ").click();
      
      Thread.sleep(3000);
      
      driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").click();
      
      String title = driver.getTitle();
      
      System.out.println(title);
      
      driver.findElementByXPath("//div[@class='frameSectionExtra']//a[text()='Edit']").click();
      
      WebElement ue = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']");
      
      ue.clear();
      
      ue.sendKeys("Lister");
      
      driver.findElementByXPath("(//input[@type='submit'])[1]").click();
      
      String title2 = driver.getTitle();
      
      System.out.println(title2);
      
      WebElement ucn = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
      
      String text = ucn.getText();
      
      System.out.println(text);
      
      driver.manage().window().maximize();
      
      Thread.sleep(2000);
  }
}
