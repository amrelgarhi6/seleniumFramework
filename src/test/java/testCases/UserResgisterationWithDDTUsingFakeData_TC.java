package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.Home_Page;
import pages.Login_Page;
import pages.Registeration_Page;

public class UserResgisterationWithDDTUsingFakeData_TC extends TestBase 
{
	Home_Page homepageObject; 
	Registeration_Page registerObject;
	Login_Page loginPageObject;

	Faker fakedata = new Faker();
	
	String firstName = fakedata.name().firstName();
	String lasttName = fakedata.name().lastName();
	String email     = fakedata.internet().emailAddress();
	String password  = fakedata.number().digits(8).toString();

	
	
	@Test(priority = 1,alwaysRun = true)
	public void UserResgisterSuccessfully() throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();
		Thread.sleep(3000);

		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions(firstName,lasttName,email,password);
		Thread.sleep(3000);

		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));
		registerObject.Logout();
	}
}
