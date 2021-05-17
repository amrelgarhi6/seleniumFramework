package testCases;

import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Login_Page;

public class Login_TC extends TestBase
{

	Home_Page homepageObject; 
	Login_Page loginPageObject;
	
	
	@Test 
	public void UserCanSuccefullyLogin() throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenLoginPage();
		
		loginPageObject = new Login_Page(driver);
		loginPageObject.OpenLoginPage("aaaf1@gmail.com", "77778888");
	}
	
	
	@Test (dependsOnMethods = "UserCanSuccefullyLogin")
	public void UserCanGoToChangePassword() 
	{
		loginPageObject.OpenMyAccount();
	}
	
	
	
}
