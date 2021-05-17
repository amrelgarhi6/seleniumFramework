package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends PageBase {
	
	public Login_Page(WebDriver driver) {
		super(driver);
	}


	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement logInBtn;
	
	@FindBy(partialLinkText = "My account")
	WebElement myAccountLink;
	
	
	public void OpenLoginPage(String email,String password) 
	{
		setText(emailTxtBox,email);
		setText(passwordTxtBox, password);
		ClickElement(logInBtn);
	}
	
	public void OpenMyAccount() 
	{
		ClickElement(myAccountLink);
	}
	
	
	
	

}
