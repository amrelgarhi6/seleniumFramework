package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.Home_Page;
import pages.Login_Page;
import pages.Registeration_Page;

public class UserResgisterationWithDDTUsingExcelTC extends TestBase 
{
	Home_Page homepageObject; 
	Registeration_Page registerObject;
	Login_Page loginPageObject;

	@DataProvider (name = "userdata")
	public  Object [][] userdata() throws IOException
	{
		ExcelReader excelReader = new ExcelReader();
		return excelReader.getExcelFile();
	}






	@Test(priority = 1,alwaysRun = true ,dataProvider = "userdata")
	public void UserResgisterSuccessfully(String firstName,String lastName,String email,String password) throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();
		Thread.sleep(1500);
		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions( firstName, lastName,email,password );
		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));

		registerObject.Logout();
		Thread.sleep(1500);

	}




}
