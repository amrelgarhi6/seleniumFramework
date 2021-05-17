package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailes_Page extends PageBase 
{
	public ProductDetailes_Page(WebDriver driver) {
		super(driver);
		jsExecutor = (JavascriptExecutor) driver;
	}

	@FindBy (id = "price-value-26")
	public WebElement ProductPrice;
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[1]/h1")
	public WebElement productTitle;

	@FindBy(css = "strong.current-item")
	public WebElement breadCrumb;

	@FindBy (css = "button.button-2.email-a-friend-button")
	WebElement EmailLink;

	@FindBy(linkText = "Notebooks")
	public WebElement SubMenuTitle;
	
	@FindBy(css = "div.current-item")
	public WebElement ProductNameHeader;
	
	@FindBy (xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[3]/div[2]/a[2]")
	WebElement AddReviewLink;
	
	@FindBy(linkText = "Wishlist")
	WebElement WishListLink;
	
	@FindBy(id = "add-to-wishlist-button-5")
	WebElement AddToWishList;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement AddToCompare;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/h2/a")
	WebElement ProductLink;
	
	@FindBy(id = "add-to-cart-button-5")
	WebElement addToCartBtn;
	
	@FindBy (linkText = "Shopping cart")
	WebElement cartLink;
	
	@FindBy (linkText = "Compare products list")
	WebElement comparisonLink;
	
	
	
	
	public void OpenEmailFriendPage() 
	{
		ScrollIntoElement(EmailLink);
		ClickElement(EmailLink);
	}
	
	
	public void OpenReviewPage() 
	{
		ClickElement(AddReviewLink);
	}
	
	
	public void OpenWishListPage() 
	{
		ClickElement(AddToWishList);
		ClickElement(WishListLink);
	}
	
	public void OpenProductPage() 
	{
		ClickElement(ProductLink);
		ClickElement(addToCartBtn);
		ClickElement(cartLink);
	}
	
	public void AddToComparisonPage() 
	{
		ClickElement(AddToCompare);
	}
	public void OpenComparisonPage() 
	{
		ClickElement(comparisonLink);
	}
	
	public void OpenCartPage() 
	{
		ClickElement(cartLink);
	}
}