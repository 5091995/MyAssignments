package baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.sukgu.Shadow;
import util.ReadExcel;

public class ServiceNowMethods {
	public  RemoteWebDriver driver;
	public String filename;
	public static ExtentReports extent;
    public static ExtentTest createTest2;
    public String testName,testDescription,author,category;
    public  Shadow shadow;
	//@Parameters({"url"})
	@BeforeMethod
	public void preConditions() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev109566.service-now.com");
		//https://dev109566.service-now.com
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
	    extent=new ExtentReports();
		extent.attachReporter(reporter);
	}
	@BeforeClass
	public void testcaseDetails()
	{
	    createTest2 = extent.createTest(testName,testDescription);
		createTest2.assignAuthor(author);
		createTest2.assignCategory(category);
		
	}
	public void reportStep(String status,String message) throws IOException
	{
		if(status.equalsIgnoreCase("pass")) {
			createTest2.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snap"+takeSnap()+"/pic.png").build());
		}else if(status.equalsIgnoreCase("fail"))
		{
			createTest2.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(".././snap"+takeSnap()+"/pic.png").build());
			
		}
	}
	public int takeSnap() throws IOException
	{
		int random=(int)(Math.random()*999999);
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination=new File(".././snap/shot"+random+".png");
		FileUtils.copyFile(source, destination);
		return random;
		
	}
	@AfterSuite
	public void endReport()
	{
	extent.flush();
	}


	@DataProvider(name="fetchdata")
	public String[][] sendData() throws IOException{
		
		
		return ReadExcel.readData(filename);
		

		}



}
