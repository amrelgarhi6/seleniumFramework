package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddReview_Page;
import pages.Home_Page;
import pages.ProductDetailes_Page;
import pages.Registeration_Page;
import pages.SearchProduct_Page;

public class AddReview_TC extends TestBase
{
	String reviewTitle   = "Nike Review";
	String reviewContent = "This Product IS Very Valuable & I recommend it!!";

	String  productName     = "Nike";
	String	Email           = "aaa@test.com";
	String	FirstName       = "Amr Ahmed";
	String	LastName        = "Elgarhi";
	String	Password     	= "123456";

	AddReview_Page addReviewObject;
	SearchProduct_Page searchObject;
	ProductDetailes_Page DetailesObject;
	Home_Page homepageObject; 
	Registeration_Page registerObject;


	// 1- User Can Register

	@Test(priority = 1,alwaysRun = true)
	public void UserResgisterSuccessfully() throws InterruptedException 
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();
		Thread.sleep(1500);

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


	// 3- User Can Add Review

	@Test(dependsOnMethods = "searchWithAutoSuggest") 
	public void UserRegisterCanAddReview() throws InterruptedException 
	{
		DetailesObject.OpenReviewPage();	
		Thread.sleep(1500);
		
		addReviewObject =new AddReview_Page(driver);
		addReviewObject.AddReview(reviewTitle, reviewContent);
		Assert.assertTrue(addReviewObject.succsesMsg.getText().contains("Product review is successfully added."));
		Assert.assertTrue(addReviewObject.ExistingReviews.getText().contains(reviewTitle));
		System.out.println(addReviewObject.succsesMsg.getText());
		System.out.println(addReviewObject.ExistingReviews.getText());
		Thread.sleep(1500);
	}
}
