package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.ProductDetailes_Page;

public class SelectSubMenuByHover_TC extends TestBase
{

	ProductDetailes_Page DetailesObject;
	Home_Page homePageObject;
	
	
	@Test
	public void UserCanSelectItemFromHoverMenuIn_HomePage() throws InterruptedException 
	{
		Thread.sleep(1500);
		homePageObject = new Home_Page(driver);
		homePageObject.OpenSubMenuFromSuperByHover();
		
		DetailesObject = new ProductDetailes_Page(driver);
		Assert.assertTrue(DetailesObject.SubMenuTitle.getText().contains("Notebooks"));
		System.out.println(driver.getCurrentUrl());		
	}
	
	
}
