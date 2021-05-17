package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Comparison_page;
import pages.ProductDetailes_Page;
import pages.SearchProduct_Page;

public class AddToCompareProducts_TC extends TestBase
{

	String  FirstproductName   = "Digital Storm";
	String	SecondproductName = "Build your";

	SearchProduct_Page   searchObject;
	ProductDetailes_Page DetailesObject;
	Comparison_page      ComparisonObject;

	@Test(priority = 1)
	public void searchForProduct_1() throws InterruptedException 
	{
		searchObject = new SearchProduct_Page(driver);
		Thread.sleep(1000);
		searchObject.SelectProductFromList(FirstproductName);

		Thread.sleep(1000);
		DetailesObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(DetailesObject.breadCrumb.getText().contains(FirstproductName));

		// User Add Product To Compare
		DetailesObject.AddToComparisonPage();
	}

	@Test(priority = 2)
	public void searchForProduct_2() throws InterruptedException 
	{
		searchObject = new SearchProduct_Page(driver);
		Thread.sleep(1000);
		searchObject.SelectProductFromList(SecondproductName);

		Thread.sleep(1000);
		DetailesObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(DetailesObject.breadCrumb.getText().contains(SecondproductName));

		// User Add Product To Compare
		DetailesObject.AddToComparisonPage();
	}

	@Test (priority = 3)
	public void UserCanCompareProducts () throws InterruptedException   
	{
		Thread.sleep(1500);
		DetailesObject = new ProductDetailes_Page(driver);
		DetailesObject.OpenComparisonPage();

		ComparisonObject = new Comparison_page(driver);
		Assert.assertTrue(ComparisonObject.comparisonTitl.getText().contains("Compare products"));
		Assert.assertTrue(ComparisonObject.FirstProductName.getText().contains(SecondproductName));
		Assert.assertTrue(ComparisonObject.SecondProductName.getText().contains(FirstproductName));
		//Assert.assertTrue(ComparisonObject.FirstProductPrice.getText().contains("$1,200.00"));
		// Assert.assertTrue(ComparisonObject.SecondProductPrice.getText().contains("$1,259.00"));
		ComparisonObject.compareProducts();
		Thread.sleep(1500);

		ComparisonObject.ClearCompareList();
		Assert.assertTrue(ComparisonObject.NoItemMsg.getText().contains("You have no items to compare."));
	}




}
