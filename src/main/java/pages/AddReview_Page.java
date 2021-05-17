package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReview_Page extends PageBase
{
	public AddReview_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxtBox;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement ReviewContentTxtBox;

	@FindBy(id = "addproductrating_4")
	WebElement RetingBtn;

	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submitBtn;

	@FindBy(css = "div.result")
	public WebElement succsesMsg;

	@FindBy(css = "div.product-review-list")
	public WebElement ExistingReviews;


	public void AddReview(String reviewTitle,String ReviewContent) 
	{
		setText(reviewTitleTxtBox, reviewTitle);
		setText(ReviewContentTxtBox, ReviewContent);		
		ClickElement(RetingBtn);
		ClickElement(submitBtn);
	}




}
