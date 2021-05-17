package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddCart_Page;
import pages.Home_Page;
import pages.ProductDetailes_Page;

public class AddToCart_TC extends TestBase
{

	String quantity = "3";
	
	ProductDetailes_Page detailesProductObject;
	AddCart_Page         addToCartObject;
	Home_Page            homePageObject;
	
	@Test(priority = 1)
	public void UserCanSelectItemFromHoverMenuIn_HomePage() throws InterruptedException 
	{
		Thread.sleep(1500);
		homePageObject = new Home_Page(driver);
		homePageObject.OpenSubMenuFromSuperByHover();
		Thread.sleep(2000);
		
		detailesProductObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(detailesProductObject.SubMenuTitle.getText().contains("Notebooks"));
		Thread.sleep(1500);
		detailesProductObject.OpenProductPage();
		System.out.println(driver.getCurrentUrl());		
	}
	
	@Test(dependsOnMethods = "UserCanSelectItemFromHoverMenuIn_HomePage")
	public void UserCanCheckCartAndEditQuantity() throws InterruptedException 
	{
		Thread.sleep(1500);
		addToCartObject =new AddCart_Page(driver);
		assertTrue(addToCartObject.productName.getText().contains("Asus N551JK-XO076H Laptop"));
		Thread.sleep(1500);
		addToCartObject.CartOperations(quantity);
		Thread.sleep(3000);
	}
}
