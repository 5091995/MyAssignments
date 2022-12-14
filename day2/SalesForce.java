package week4.day2;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForce {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		 option.addArguments("--disable-notifications");
		
			 ChromeDriver driver=new ChromeDriver(option);
			
			 driver.get("https://login.salesforce.com/");
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
			 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
			 driver.findElement(By.xpath("//input[@type='submit']")).click();
			 
			 
			 //6.click on the learn more option in the Mobile publisher
			 
			 driver.findElement(By.xpath("//span[text()='Learn More']")).click();
			// 7.Switch to the next window using Windowhandles.
			 Set<String> windowHandles = driver.getWindowHandles();
			 System.out.println(windowHandles.size());
			 List<String> window=new ArrayList<String>(windowHandles);
			 driver.switchTo().window(window.get(1));
			 
			 //8.click on the confirm button in the redirecting page
			 driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			 //9.Get the title
			 String title = driver.getTitle();
			 System.out.println(title);
			 //10.Get back to the parent window
			 driver.switchTo().window(window.get(0));
			 //11.close the browser
			 driver.close();
}
}