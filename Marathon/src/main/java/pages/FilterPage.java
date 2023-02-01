package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseclass.ServiceNowMethods;
import io.github.sukgu.Shadow;

public class FilterPage extends ServiceNowMethods {
	public FilterPage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}
	public FilterPage clickAll() throws InterruptedException
	{
	Thread.sleep(5000);
	
	Shadow shadow = new Shadow(driver);
	shadow.setImplicitWait(10);
	//shadow.findElementByXPath("//div[text()='All']").click();
	//driver.executeScript("arguments[0].click();"element)
	
	WebElement element = driver.findElement(By.xpath("//div[text()='All']"));
	((JavascriptExecutor) shadow).executeScript("arguments[0].click();",element );
	return this;
	}
	public NewPage clickFilter()
	{
	WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
	shadow.setImplicitWait(10);
	filter.click();
	filter.sendKeys("Callers");
	shadow.findElementByXPath("//span[text()='Callers']").click();
	return new NewPage(driver);
	}
	
}
