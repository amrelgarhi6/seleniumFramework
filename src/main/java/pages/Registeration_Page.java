package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Registeration_Page extends PageBase{

	public Registeration_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement Gender;

	@FindBy(id = "FirstName")
	WebElement FirstNameTxtBox;

	@FindBy(id = "LastName")
	WebElement LastNameTxtBox;

	@FindBy(id = "Email")
	WebElement EmailTxtBox;

	@FindBy(id = "Password")
	WebElement PasswordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy(id = "register-button")
	WebElement regiserBtn;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
	public 	WebElement SuccessMassage;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a")
	public WebElement continuBtn;

	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement logoutBtn;
	
	public void UserRegisterOpertaions(String firstName ,String lastName , String email , String password) 
	{
		ClickElement(Gender);
		setText(FirstNameTxtBox, firstName);
		setText(LastNameTxtBox, lastName);
		setText(EmailTxtBox, email);
		setText(PasswordTxtBox, password);
		setText(confirmPasswordTxtBox, password);
		ClickElement(regiserBtn);	
	}
	public void Logout() 
	{
		ClickElement(logoutBtn);
	}	
}






