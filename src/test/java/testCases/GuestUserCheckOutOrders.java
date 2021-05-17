package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddCart_Page;
import pages.Home_Page;
import pages.OrderInformation_Page;
import pages.ProductDetailes_Page;
import pages.Registeration_Page;
import pages.SearchProduct_Page;
import pages.ShopingCart_Page;

public class GuestUserCheckOutOrders extends TestBase
{
	String  productName     = "Asus";
	String	Email           = "asfdada@test.com";
	String	FirstName       = "Amr Ahmed";
	String	LastName        = "Elgarhi";
	String	Password     	= "123456";

	String  quantity 		= "4";

	String  Country 		= "Egypt";
	String 	CityAddress 	= "Cairo";
	String  Address1 		= "Egypt-Cairo";
	String  ZipCode 		= "5555";
	String  PhoneNumber 	= "011XXXXXXX";


	Home_Page            homePageObject;
	Registeration_Page	 registerObject;
	SearchProduct_Page	 searchObject;
	AddCart_Page      	 addToCartObject;
	ShopingCart_Page   	shopingCartObject;
	OrderInformation_Page orderInfoObject;

	ProductDetailes_Page DetailesObject;

	

	// 1- User Can Search

	@Test(priority = 1)
	public void UserCanSelectItemFromHoverMenuIn_HomePage() throws InterruptedException 
	{
		Thread.sleep(1500);
		homePageObject = new Home_Page(driver);
		homePageObject.OpenSubMenuFromSuperByHover();
		Thread.sleep(1000);

		DetailesObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(DetailesObject.SubMenuTitle.getText().contains("Notebooks"));
		Thread.sleep(1500);
		DetailesObject.OpenProductPage();
		System.out.println(driver.getCurrentUrl());	

	}

	@Test(dependsOnMethods = "UserCanSelectItemFromHoverMenuIn_HomePage")
	public void UserCanCheckCartAndEditQuantity() throws InterruptedException 
	{
		Thread.sleep(2000);
		addToCartObject =new AddCart_Page(driver);
		assertTrue(addToCartObject.productName.getText().contains("Asus N551JK-XO076H Laptop"));
		Thread.sleep(1500);
		addToCartObject.CartOperations(quantity);
		Thread.sleep(5000);

	}


	// 3- User Can Check Out Product And Confirm Orders
	@Test (dependsOnMethods = "UserCanCheckCartAndEditQuantity")
	public void GuestUserCanCheckOutOrders() throws InterruptedException 
	{
		Thread.sleep(3000);
		shopingCartObject = new ShopingCart_Page(driver);
		shopingCartObject.OpenChechOutPage();
		shopingCartObject.OpenGuestPage();
		shopingCartObject.GuestUserCheckOutOrderSteps(FirstName, LastName, Email, Country, CityAddress, Address1, ZipCode, PhoneNumber);
		shopingCartObject.ConfirmOrder();
		assertTrue(shopingCartObject.SuccessConfirmMsg.getText().contains("Your order has been successfully processed!"));

		shopingCartObject.OpenOrderDetails();
		Thread.sleep(2000);
		orderInfoObject = new OrderInformation_Page(driver);
		orderInfoObject.UserCanDownloadPdfInvoice();
		orderInfoObject.UserCanPrintOrderInvoice();
		Thread.sleep(2000);
	}

}
