package servicenow;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class ServiceNowBaseClass {
	ChromeDriver driver;
	String filename;

	@BeforeMethod
	public void preCondition() {
	
	
	 ChromeOptions option=new ChromeOptions();
	 option.addArguments("--disable-notifications");
	
 driver=new ChromeDriver(option);
//Launch ServiceNow application
driver.get("https://dev102013.service-now.com/now/nav/ui/classic/params/target/ui_page.do%3Fsys_id%3D620fe3909704211034c172571153af61");
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 //Login with valid credentials username as admin and password as India@123
 driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("2$Trythebest");
driver.findElement(By.xpath("//button[text()='Log in']")).click();
}
	@AfterMethod
	public void postCondition() {
	//driver.close();
	
	}
	@DataProvider(name="fetchdata")
	public String[][] sendData() throws IOException{
		
		return ReadExcelDataServiceNow.readData(filename);
	

}
}