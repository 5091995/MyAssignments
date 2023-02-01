package callerModule;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.ServiceNowMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class UpdatingExistingCaller extends ServiceNowMethods {
	@BeforeTest
	public void data() {
	    filename="UpdateExistingCaller";
	    testName="UpdateExisting test case";
		testDescription="Valid credentials ";
		author="Divya";
		category="Regression testing";
	}
	@Test(dataProvider="fetchdata",priority=2)
public void runUpdateExistingCaller (String name,String ph) throws InterruptedException {
		
		
		driver.get("https://dev109566.service-now.com");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Dilip@2098");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();
		
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		//shadow.setImplicitWait(10);
		filter.click();
		filter.sendKeys("Callers");
		shadow.findElementByXPath("//span[text()='Callers']").click();
		
		
		Thread.sleep(3000);
		WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame);

		WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
		Thread.sleep(3000);
		search.clear();
		search.sendKeys(name,Keys.RETURN);
		
		driver.findElement(By.xpath("(//a[contains(@class,'btn btn-icon')])[2]")).click();
		
		driver.findElement(By.linkText("Open Record")).click();
		
		WebElement updatePhoneNumber = driver.findElement(By.id("sys_user.phone"));
		updatePhoneNumber.clear();
		updatePhoneNumber.sendKeys(ph);
		
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
	
		
		
		
	}


}
