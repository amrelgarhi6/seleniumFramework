package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUs_Page;
import pages.Home_Page;

public class contactUs_TC extends TestBase 
{

	Home_Page homepage;
	ContactUs_Page contactObject;
	
	String fullName = "Amr Ahmed";
	String email    = "afaa@test.com";
	String enquiry  = "Hello Admin !! , This Test Case Is Successed";
	

	@Test
	public void UserCanReachTocontactUs() throws InterruptedException 
	{
		homepage = new Home_Page(driver);
		homepage.OpenContactUsPage();
		
		Thread.sleep(2000);
		contactObject = new ContactUs_Page(driver);
		contactObject.ContactUsOpertaions(fullName, email, enquiry);
		Assert.assertTrue(contactObject.successMsg.getText().contains("Your enquiry has been successfully"));
	}
}
