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

public class CreateNewProposal extends ServiceNowBaseClass {
	@Test(dataProvider = "fetchdata")
	public void runCreateNewProposal(String mandatory) throws IOException {
		 
	// Click All and Enter Proposal in filter navigator and press enter 
	Shadow shadow=new Shadow(driver);
	shadow.setImplicitWait(30);
	shadow.findElementByXPath("//div[text()='All']").click();
	WebElement element2 = shadow.findElementByXPath("//input[@id='filter']");
	element2.sendKeys(" Proposal");
	shadow.findElementByXPath("//span[text()='My Proposals']").click();
	 //Click- new  and  fill mandatory fields and click 'Submit' button
	//driver.switchTo().frame("gsft_main");
	WebElement element = shadow.findElementByXPath("//iframe[@name='gsft_main']");
	driver.switchTo().frame(element);
	driver.findElement(By.xpath("//button[text()='New']")).click();
	String text2 = driver.findElement(By.xpath("//input[@id='std_change_proposal.number']")).getText();
	System.out.println(text2);
	driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys(mandatory);
	driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	 
	 //Verify the successful creation of new Proposal"
String text = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
System.out.println(text);
if(text==text2);
{
	System.out.println("Sucessful creation of new proposal");
}
}
	@BeforeTest
	public void setData() {
		filename="CreateNewProposal";
	}

}