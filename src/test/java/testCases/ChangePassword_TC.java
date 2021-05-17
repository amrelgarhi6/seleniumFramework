package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Login_Page;
import pages.MyAccount_Page;
import pages.Registeration_Page;

public class ChangePassword_TC extends TestBase
{

	MyAccount_Page myAccountObject;
	Login_Page     loginObject;
	
	String OldPass   = "1234567";
	String NewPass   = "12345678";
	String email     = "aaa1sf52658s94@gmail.com";
	String  FirstName = "Amr Ahmed";
	String lastName  ="Elgarhi";
	
	Home_Page  			homepageObject; 
	Registeration_Page 	registerObject;
    Login_Page			 loginPageObject;
	
	@Test(priority = 1,alwaysRun = true)
	public void UserResgisterSuccessfully() throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();

		Thread.sleep(3500);
		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions(FirstName, lastName, email, OldPass);
		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));
	}
	
	
	@Test(dependsOnMethods = "UserResgisterSuccessfully")
	public void UserCanChangePasswordSuccessfully() throws InterruptedException 
	{
		loginObject = new Login_Page(driver);
		loginObject.OpenMyAccount();
		
		Thread.sleep(5000);

		myAccountObject = new MyAccount_Page(driver);
		myAccountObject.ChangePassword(OldPass, NewPass, NewPass);
		Assert.assertTrue(myAccountObject.successMsgElement.getText().equalsIgnoreCase("Password was changed"));
		myAccountObject.successMsgElement.isDisplayed();
		myAccountObject.ClosesuccessMsgElement.click();

	}
	
	@Test (dependsOnMethods = "UserCanChangePasswordSuccessfully")
	public void RegistedUserCanLogOut() throws InterruptedException 
	{
		Thread.sleep(5000);

		registerObject.Logout();
	}
	
	
	@Test(dependsOnMethods = "RegistedUserCanLogOut") 
	public void UserCanSuccefullyLogin() throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenLoginPage();
		
		Thread.sleep(5000);

		loginPageObject = new Login_Page(driver);
		loginPageObject.OpenLoginPage(email, NewPass);
	}
}
