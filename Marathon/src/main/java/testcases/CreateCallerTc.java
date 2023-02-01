package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.ServiceNowMethods;
import pages.LoginPage;

public class CreateCallerTc extends ServiceNowMethods {
	@BeforeTest
	public void data() {
	    filename="CreateNewCaller";
	    testName="CreateNewCaller test case";
		testDescription="Valid credentials ";
		author="Divya";
		category="Sanity testing";
	}
	@Test(dataProvider="fetchdata",priority=1)
	public void runCreateNewCaller (String fname,String lname,String email,String title,String ph,String mobile) throws InterruptedException{
		{
			new LoginPage(driver)
			.enterUserName()
			.enterPassword()
			.clickLogin()
			.clickAll()
			.clickFilter()
			.clickNew()
			.CreateCaller(fname, lname, email, title, ph, mobile);
			
		}

}
}