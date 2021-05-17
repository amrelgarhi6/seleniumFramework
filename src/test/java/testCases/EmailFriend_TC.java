package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailTofriend_Page;
import pages.Home_Page;
import pages.Login_Page;
import pages.ProductDetailes_Page;
import pages.Registeration_Page;
import pages.SearchProduct_Page;

public class EmailFriend_TC extends TestBase
{


	String  productName     = "Nike";
	String  FriendEmail     = "kdfis@test.com";
	String	Email           = "aa8f5wea86@test.com";
	String  PersonalMessage = " Hi Friend , Please Cheke This Product";
	String	FirstName       = "Amr Ahmed";
	String	LastName        = "Elgarhi";
	String	Password     	= "123456";


	SearchProduct_Page searchObject;
	ProductDetailes_Page DetailesObject;
	EmailTofriend_Page emailtoFriendObjec;


	Home_Page homepageObject; 
	Registeration_Page registerObject;
	Login_Page loginPageObject;


	// 1- User Can Register



	@Test(priority = 1,alwaysRun = true)
	public void UserResgisterSuccessfully() throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();
		Thread.sleep(3000);
		
		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));
	}

	// 2- User Can Search
	@Test(dependsOnMethods = "UserResgisterSuccessfully")
	public void searchWithAutoSuggest() throws InterruptedException 
	{
		searchObject = new SearchProduct_Page(driver);
		Thread.sleep(1000);
		searchObject.SelectProductFromList(productName);

		Thread.sleep(1000);
		DetailesObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(DetailesObject.breadCrumb.getText().contains(productName));	
	}

	// 3- User Can Send Product To Friend By Email
	@Test (dependsOnMethods = "searchWithAutoSuggest")
	public void RegisteredUserCanSendProductsToFriends() throws InterruptedException 
	{
		DetailesObject  = new ProductDetailes_Page(driver);
		DetailesObject.OpenEmailFriendPage();

		Thread.sleep(3000);

		emailtoFriendObjec = new EmailTofriend_Page(driver);
		emailtoFriendObjec.EmailFriendOperations( FriendEmail ,PersonalMessage );
		Assert.assertTrue(emailtoFriendObjec.successMsg.getText().contains("Your message has been sent."));
	}

	// 4- User Can LogOut
	@Test  (dependsOnMethods = "RegisteredUserCanSendProductsToFriends")
	public void RegistedUserCanLogOut() throws InterruptedException 
	{
		Thread.sleep(3000);
		registerObject.Logout();
	}
}
