package servicenow;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewCaller extends ServiceNowBaseClass {
	@Test(dataProvider = "fetchdata")
	public void runCreateNewCaller(String fname,String lname,String title,String email,String mobile,String phno) throws IOException {
		//Click-All and Enter Callers in filter navigator and press enter 
	Shadow shadow=new Shadow(driver);
	shadow.setImplicitWait(30);
	shadow.findElementByXPath("//div[text()='All']").click();
	WebElement element2 = shadow.findElementByXPath("//input[@id='filter']");
	element2.sendKeys("Callers");
	shadow.findElementByXPath("//span[text()='Callers']").click();
	
	//Create new Caller by filling all the fields and click 'Submit'.
	WebElement element = shadow.findElementByXPath("//iframe[@name='gsft_main']");
	driver.switchTo().frame(element);
	
	driver.findElement(By.xpath("//button[text()='New']")).click();
	driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fname);
	driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lname);
	driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys(title);
	driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys(mobile);
	driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys(phno);
	driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	//Search and verify the newly created Caller"
String text = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
System.out.println(text);
}
	@BeforeTest
	public void setData() {
		filename="CreateNewCaller";
	}

}