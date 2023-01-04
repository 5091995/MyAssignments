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

public class FillMandatoryFields extends ServiceNowBaseClass{
	@Test(dataProvider = "fetchdata")
	public  void runFillMandatoryFields(String knowledgebase,String catagory) throws IOException {
		 	//Enter Knowledge  in filter navigator and press enter
	Shadow shadow=new Shadow(driver);
	shadow.setImplicitWait(30);
	shadow.findElementByXPath("//div[text()='All']").click();
	shadow.setImplicitWait(10);
	WebElement element2 = shadow.findElementByXPath("//input[@id='filter']");
	element2.sendKeys("Knowledge");
	shadow.findElementByXPath("//span[text()='Knowledge']").click();
	
	//Create new Article 
	WebElement element = shadow.findElementByXPath("//iframe[@name='gsft_main']");
	driver.switchTo().frame(element);
	
	driver.findElement(By.xpath("//span[@class='btn-icon icon-article-document homepage-icon']")).click();
	//Select knowledge base as IT and category as IT- java and Click Ok
	driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']")).sendKeys(knowledgebase);
	//driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']")).sendKeys("IT-Java");
	//Update the other mandatory fields
	driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys(catagory);
	//Select the submit option
	driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	
    

}
	@BeforeTest
	public void setData() {
		filename="FillMandatoryFields";
	}

}