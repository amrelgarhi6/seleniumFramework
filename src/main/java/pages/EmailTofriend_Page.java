package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailTofriend_Page extends PageBase
{
	public EmailTofriend_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy (id  = "FriendEmail")
	WebElement friendEmail;
	
	@FindBy (id  = "YourEmailAddress")
	WebElement myEmailAddress;
	
	@FindBy (id  = "PersonalMessage")
	WebElement personalMessage;
	
	@FindBy (css  = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy (css = "div.result")
	public WebElement  successMsg;


public void EmailFriendOperations (String FriendEmail, String PersonalMessage) 
{
	setText(friendEmail, FriendEmail);
	setText(personalMessage, PersonalMessage);
	ClickElement(sendEmailBtn);
}}







