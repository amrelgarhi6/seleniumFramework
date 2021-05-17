package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_Page extends PageBase
{
	public MyAccount_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")	
	WebElement changePasswordOption;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxtBox;

	@FindBy(id = "NewPassword")
	WebElement NewPasswordTxtBox;

	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxtBox;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement changePassBtn;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div")
	public WebElement successMsgElement;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
	public WebElement ClosesuccessMsgElement;
	
	public void ChangePassword(String OldPass,String NewPass,String ConfirmNewPass) 
	{
		ClickElement(changePasswordOption);
		setText(oldPasswordTxtBox, OldPass);
		setText(NewPasswordTxtBox, NewPass);
		setText(ConfirmNewPasswordTxtBox, ConfirmNewPass);
		ClickElement(changePassBtn);
		ClickElement(ClosesuccessMsgElement);
	}

}
