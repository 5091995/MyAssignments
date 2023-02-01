package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseclass.ServiceNowMethods;

public class CallerPage  extends ServiceNowMethods{
	public CallerPage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}
	public CallerPage CreateCaller(String fname,String lname,String email,String title,String ph,String mobile) throws InterruptedException
	{
	driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fname);
	driver.findElement(By.id("sys_user.last_name")).sendKeys(lname);
	
	driver.findElement(By.id("sys_user.email")).sendKeys(email);
	driver.findElement(By.id("sys_user.title")).sendKeys(title);
	driver.findElement(By.id("sys_user.phone")).sendKeys(ph);
	driver.findElement(By.id("sys_user.mobile_phone")).sendKeys(mobile);
	driver.findElement(By.id("sysverb_insert_bottom")).click();
	Thread.sleep(3000);
    WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));Thread.sleep(8000);
	search.clear();
	search.sendKeys("Divya",Keys.RETURN);
	return this;
	}
	public CallerPage updateCaller(String name,String ph) throws InterruptedException
	{
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
		return this;
	}
	public CallerPage deleteCaller(String name) throws InterruptedException
	{

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
		
		
		return this;
	}

}
