package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseclass.ServiceNowMethods;

public class NewPage extends ServiceNowMethods {
	public NewPage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}
	public CallerPage clickNew() throws InterruptedException
	{
	Thread.sleep(3000);
	WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(eleFrame);
	
	driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
	return new CallerPage(driver);
	}
	
}
