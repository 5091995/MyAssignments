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
public class DeletingExistingCaller  extends ServiceNowMethods {
	@BeforeTest
	public void data() {
	    filename="DeleteExistingCaller";
	    testName="DeleteExistingCaller test case";
		testDescription="Valid credentials ";
		author="Divya";
		category="Smoke testing";
	}
	@Test(dataProvider="fetchdata",priority=3)

	public  void runDeleteExistingCaller(String name) throws InterruptedException {
		
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
		
		String mobileNumber = driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).getText();
		
		
		driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']")).click();
		
		driver.findElement(By.id("ok_button")).click();
		
		WebElement search_ = driver.findElement(By.xpath("//input[@class='form-control']"));
		Thread.sleep(3000);
		
		search_.sendKeys(mobileNumber,Keys.RETURN);
		
		
	}

}
