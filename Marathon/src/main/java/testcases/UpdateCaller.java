package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.ServiceNowMethods;
import pages.LoginPage;

public class UpdateCaller extends ServiceNowMethods{
	@BeforeTest
	public void data() {
	    filename="UpdateExistingCaller";
	    testName="UpdateExisting test case";
		testDescription="Valid credentials ";
		author="Divya";
		category="Regression testing";
	}
	@Test(dataProvider="fetchdata",priority=2)
public void runUpdateExistingCaller (String name,String ph) throws InterruptedException {
		
		{
			new LoginPage(driver)
			.enterUserName()
			.enterUserName()
			.clickLogin()
			.clickAll()
			.clickFilter()
			.clickNew()
			.updateCaller(name, ph);
		}
}
}
