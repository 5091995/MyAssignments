package week6;


//import java.io.IOException;
//import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateLead extends BaseClass {
	
@Test(dataProvider = "fetchdata")
public void runCreate(String cname,String fname,String lname){
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
		driver.findElement(By.name("submitButton")).click();
		
}
@BeforeTest
public void setData() {
	filename="CreateLead";
}
}






