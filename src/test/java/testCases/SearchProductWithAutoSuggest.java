package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailes_Page;
import pages.SearchProduct_Page;

public class SearchProductWithAutoSuggest extends TestBase 
{

	String productName = "Nike";
	
	SearchProduct_Page searchObject;
	ProductDetailes_Page DetailesObject;
	
	
	@Test
	public void searchWithAutoSuggest() throws InterruptedException 
	{
		searchObject = new SearchProduct_Page(driver);
		Thread.sleep(1000);
		searchObject.SelectProductFromList(productName);
		
		Thread.sleep(1000);
		DetailesObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(DetailesObject.breadCrumb.getText().contains(productName));	
	}
}
