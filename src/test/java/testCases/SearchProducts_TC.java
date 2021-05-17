package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailes_Page;
import pages.SearchProduct_Page;

public class SearchProducts_TC extends TestBase 
{
	
	String productName = "Ray Ban Aviator Sunglasses";
	

	SearchProduct_Page searchObject;
	ProductDetailes_Page DetailesObject;
	
	@Test
	public void UserCanSearchForProducts() throws InterruptedException 
	{
		searchObject = new SearchProduct_Page(driver);
		searchObject.ProductSearch(productName);
		Thread.sleep(3000);
		searchObject.OpenProductPageDetailes();
		
		
		DetailesObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(DetailesObject.productTitle.getText().equalsIgnoreCase(productName));	
	}
}
