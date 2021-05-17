package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCart_Page extends PageBase
{
	public AddCart_Page(WebDriver driver) {
		super(driver);
	}


	@FindBy(css = "a.product-name")
	public WebElement productName;	

	@FindBy(css = "input.qty-input")
	WebElement QuantityTxtBox;

	@FindBy(css = "button.button-2.update-cart-button")
	WebElement UpdateCartBtn;

	@FindBy(css = "button.button-2.continue-shopping-button")
	WebElement CountinueShopingBtn;


	public void CartOperations(String  quantity) 
	{
		QuantityTxtBox.clear();
		setText(QuantityTxtBox, quantity);
		ClickElement(UpdateCartBtn);
		//ClickElement(CountinueShopingBtn);
	}

}
