package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONReaderData;
import pages.Home_Page;
import pages.Login_Page;
import pages.Registeration_Page;

public class UserResgisterationWithDDTUsingJSONTC extends TestBase 
{
	Home_Page homepageObject; 
	Registeration_Page registerObject;
	Login_Page loginPageObject;


	@Test(priority = 1,alwaysRun = true )
	public void UserResgisterSuccessfully() throws InterruptedException, FileNotFoundException, ParseException, IOException 
	{

		JSONReaderData jReaderData = new JSONReaderData();
		jReaderData.JsonReader();

		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();
		Thread.sleep(1500);
		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions(jReaderData.firstName, jReaderData.LastName,jReaderData.Email,jReaderData.password);
		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));

		registerObject.Logout();
		Thread.sleep(1500);

	}
}
