package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_Page;
import pages.Login_Page;
import pages.Registeration_Page;

public class UserResgisteration_TC extends TestBase 
{
	Home_Page homepageObject; 
	Registeration_Page registerObject;
	Login_Page loginPageObject;

	@Test(priority = 1,alwaysRun = true)
	public void UserResgisterSuccessfully() throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();

		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions("amr ahmed", "Elgarhi", "aaa361a@gmail.com", "111111112");
		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));
	}



	@Test  (dependsOnMethods = "UserResgisterSuccessfully")
	public void RegistedUserCanLogOut() 
	{
		registerObject.Logout();
	}
}
