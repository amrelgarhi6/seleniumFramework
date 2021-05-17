package testCases;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.Home_Page;
import pages.Login_Page;
import pages.Registeration_Page;

public class UserResgisterationWithDDTUsingCSV_TC extends TestBase 
{
	Home_Page homepageObject; 
	Registeration_Page registerObject;
	Login_Page loginPageObject;

	CSVReader reader;
	

	@Test(priority = 1,alwaysRun = true)
	public void UserResgisterSuccessfully() throws InterruptedException, CsvValidationException, IOException 
	{
		String CSV_File = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userdata.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		
		String [] csvCell;
		
		while ((csvCell = reader.readNext()) != null) 
		{
		String 	firstName = csvCell[0];
		String 	lasttName = csvCell[1];
		String 	email 	  = csvCell[2];
		String 	password  = csvCell[3];

		Thread.sleep(1500);
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();
		Thread.sleep(3000);

		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions(firstName,lasttName,email,password);
		Thread.sleep(3000);
		registerObject.Logout();

		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));
		
		registerObject.Logout();

		}	
	}
}
