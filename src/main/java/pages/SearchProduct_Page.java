package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProduct_Page extends PageBase
{
	public SearchProduct_Page(WebDriver driver) {
		super(driver);
	}


	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;

	@FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
	WebElement searchBtn;

	@FindBy (linkText = "Ray Ban Aviator Sunglasses")
	WebElement selectProductFromResult;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productsList;

	
	
	public void ProductSearch(String ProductName) 
	{
		setText(searchTxtBox, ProductName);
		ClickElement(searchBtn);
	}
	
	public void OpenProductPageDetailes() 
	{
		ClickElement(selectProductFromResult);
	}
	
	public void SelectProductFromList(String productNameSuggest) 
	{
		setText(searchTxtBox, productNameSuggest);
		productsList.get(0).click();
	}
}
