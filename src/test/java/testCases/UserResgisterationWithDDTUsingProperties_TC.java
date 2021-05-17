package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.Home_Page;
import pages.Login_Page;
import pages.Registeration_Page;

public class UserResgisterationWithDDTUsingProperties_TC extends TestBase 
{
	Home_Page homepageObject; 
	Registeration_Page registerObject;
	Login_Page loginPageObject;

	String firstName = LoadProperties.userdataProperties.getProperty("firstName");
	String lasttName = LoadProperties.userdataProperties.getProperty("lastName");
	String email     = LoadProperties.userdataProperties.getProperty("email");
	String password  = LoadProperties.userdataProperties.getProperty("password");

	
	
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
	}



	@Test  (dependsOnMethods = "UserResgisterSuccessfully")
	public void RegistedUserCanLogOut() 
	{
		registerObject.Logout();
	}
}
