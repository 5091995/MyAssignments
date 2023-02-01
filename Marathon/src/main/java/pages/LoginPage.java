package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseclass.ServiceNowMethods;

public class LoginPage extends ServiceNowMethods{
	public LoginPage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}
	public LoginPage enterUserName()
	{
	driver.findElement(By.id("user_name")).sendKeys("admin");
	return this;
	}
	public LoginPage enterPassword()
	{
	driver.findElement(By.id("user_password")).sendKeys("Dilip@2098");
	return this;
	}
	public FilterPage clickLogin()
	{
	driver.findElement(By.id("sysverb_login")).click();
	return new FilterPage(driver);
	}
	

}
