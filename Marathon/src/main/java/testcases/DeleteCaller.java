package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.ServiceNowMethods;
import pages.LoginPage;

public class DeleteCaller extends ServiceNowMethods {
	@BeforeTest
	public void data() {
	    filename="DeleteExistingCaller";
	    testName="DeleteExistingCaller test case";
		testDescription="Valid credentials ";
		author="Divya";
		category="Smoke testing";
	}
	@Test(dataProvider="fetchdata",priority=3)

	public  void runDeleteExistingCaller(String name) throws InterruptedException {
		{
			new LoginPage(driver)
			.enterUserName()
			.enterPassword()
			.clickLogin()
			.clickAll()
			.clickFilter()
			.clickNew()
			.deleteCaller(name);
		}
}
}