package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishList_Page extends PageBase
{
	public WishList_Page(WebDriver driver) {
		super(driver);
	}


	@FindBy(linkText = "Wishlist")
	public WebElement WishListTilte;

	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement ProductTilte;
	
	@FindBy(css = "div.no-data")
	public WebElement Msg ;

	@FindBy(css = "button.button-2.update-wishlist-button")
	WebElement UpdateWishListBtn;

	@FindBy(css = "button.remove-btn")
	WebElement RemoveWishListBtn;
	
	public void AddProductToWishList() 
	{
		
		ClickElement(RemoveWishListBtn);
		ClickElement(UpdateWishListBtn);	
	}
}
