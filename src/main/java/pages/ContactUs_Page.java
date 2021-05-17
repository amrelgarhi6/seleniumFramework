package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs_Page extends PageBase{

	public ContactUs_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FullName")
	WebElement FullName;

	@FindBy(id = "Email")
	WebElement Email;

	@FindBy(id = "Enquiry")
	WebElement Enquiry;

	@FindBy(css = "button.button-1.contact-us-button")
	WebElement SubmitBtn;

	@FindBy(css = "div.result")
	public WebElement successMsg;

public void ContactUsOpertaions(String fullName,String email,String enquiry) 
{
	setText(FullName, fullName);
	setText(Email, email);
	setText(Enquiry, enquiry);
	ClickElement(SubmitBtn);
}

public void CanScroll() 
{
	
}

}
