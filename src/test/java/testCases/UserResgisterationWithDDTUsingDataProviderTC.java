package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Home_Page;
import pages.Login_Page;
import pages.Registeration_Page;

public class UserResgisterationWithDDTUsingDataProviderTC extends TestBase 
{
	Home_Page homepageObject; 
	Registeration_Page registerObject;
	Login_Page loginPageObject;

	@DataProvider (name = "userdata")
	public static Object [][] userdata()
	{
		return (Object[][]) new Object [][] {
				{"amr" , "ahmed" ,"aawgab@test.com","123456"} ,
				{"hassan" , "jo" ,"adfgab@test.com","123456"} ,
				{"hassan" , "jo" ,"adsbab@test.com","123456"} 

		};
		}
	
	
	
	
	
	@Test(priority = 1,alwaysRun = true ,dataProvider = "userdata")
	public void UserResgisterSuccessfully(String firstName,String lastName,String email,String password) throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();

		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions( firstName, lastName,email,password );
		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));
		
		registerObject.Logout();

	}



	
}
