package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.ProductDetailes_Page;
import pages.SearchProduct_Page;

public class ChangeCurrency_TC extends TestBase
{

	String productName = "Nike";

	Home_Page homePageObject;
	SearchProduct_Page searchObject;
	ProductDetailes_Page DetailesObject;

	@Test (priority = 1)
	public void UserCanChangeCurrency() 
	{
		homePageObject = new Home_Page(driver);
		homePageObject.ChangeCurrency();
	} 



	@Test(dependsOnMethods = "UserCanChangeCurrency")
	public void searchWithAutoSuggest() throws InterruptedException 
	{
		searchObject = new SearchProduct_Page(driver);
		Thread.sleep(1000);
		searchObject.SelectProductFromList(productName);

		Thread.sleep(1000);
		DetailesObject = new ProductDetailes_Page(driver);
		homePageObject.ScrollIntoElement(DetailesObject.ProductPrice);
		Assert.assertTrue(DetailesObject.ProductPrice.getText().contains("€"));	
	}
}
