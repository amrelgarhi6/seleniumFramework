package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailes_Page;
import pages.SearchProduct_Page;
import pages.WishList_Page;

public class AddToWishList_TC extends TestBase 
{

	String productName = "Asus";
	
	SearchProduct_Page   searchObject;
	ProductDetailes_Page DetailesObject;
	WishList_Page 		 wishListObject;
	
	@Test(priority = 1)
	public void searchWithAutoSuggest() throws InterruptedException 
	{
		searchObject = new SearchProduct_Page(driver);
		Thread.sleep(1000);
		searchObject.SelectProductFromList(productName);
		
		Thread.sleep(1000);
		DetailesObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(DetailesObject.breadCrumb.getText().contains(productName));	
	}
	
	@Test (dependsOnMethods = "searchWithAutoSuggest")
	public void UserCanAddProductToWishList() throws InterruptedException 
	{
		DetailesObject = new ProductDetailes_Page(driver);
		DetailesObject.OpenWishListPage();
		
		wishListObject = new WishList_Page(driver);
		wishListObject.AddProductToWishList();
		Thread.sleep(1000);
		Assert.assertTrue(wishListObject.ProductTilte.getText().contains(productName));
		Assert.assertTrue(wishListObject.WishListTilte.getText().contains("Wishlist"));
		Assert.assertTrue(wishListObject.Msg.getText().contains("The wishlist is empty!"));	
	}
}
