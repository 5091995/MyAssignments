package marathon;

import java.time.Duration;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class RedBus {
	public static void main(String[] args) {

	ChromeDriver driver=new ChromeDriver();
	 driver.get("https://www.redbus.in/");
	 ChromeOptions option=new ChromeOptions();
	 option.addArguments("--disable-notifications");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
	 driver.findElement(By.xpath("//li[text()='Chennai']")).click();
	 driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Banglore");
	 driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
	 driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
	driver.findElement(By.xpath("//td[text()='15']")).click();
	//Thread.sleep(5000); 
	driver.findElement(By.xpath("//button[@id='search_btn']")).click();
	driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
	System.out.println(driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText());
	WebElement scroll=driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[2]"));
	driver.executeScript("arguments[0].scrollIntoView();",scroll);
	driver.findElement(By.xpath("(//label[@for='bt_SLEEPER'])[2]")).click();
	System.out.println(driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText());
	driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
	
	
	
	
	
	
	
	 

}
}