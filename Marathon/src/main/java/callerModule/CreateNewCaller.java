package callerModule;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.ServiceNowMethods;

import io.github.sukgu.Shadow;

public class CreateNewCaller extends ServiceNowMethods {
@BeforeTest
public void data() {
    filename="CreateNewCaller";
    testName="CreateNewCaller test case";
	testDescription="Valid credentials ";
	author="Divya";
	category="Sanity testing";
}
@Test(dataProvider="fetchdata",priority=1)
public void runCreateNewCaller (String fname,String lname,String email,String title,String ph,String mobile) throws InterruptedException{
		
		
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
		
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fname);
		driver.findElement(By.id("sys_user.last_name")).sendKeys(lname);
		
		driver.findElement(By.id("sys_user.email")).sendKeys(email);
		driver.findElement(By.id("sys_user.title")).sendKeys(title);
		driver.findElement(By.id("sys_user.phone")).sendKeys(ph);
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys(mobile);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		

		Thread.sleep(3000);
	
		WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
		Thread.sleep(8000);
		search.clear();
		search.sendKeys("Divya",Keys.RETURN);
	}


}
