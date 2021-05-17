package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Home_Page extends PageBase{

	public Home_Page(WebDriver driver) {
		super(driver);
		jsExecutor = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}
	
	
	@FindBy(linkText  = "Register")
	WebElement RegisterLink;
	
	@FindBy(linkText  = "Log in")
	WebElement LoginLink;
	
	@FindBy(linkText  = "Contact us")
	WebElement ContactUsLink;
	

	@FindBy(id = "customerCurrency")
	WebElement currencyElement;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computersMenu;
	
	@FindBy(xpath =  "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement NoteBooksMenu;
	
	
	
	public void OpenRegistrationPage() 
	{
		ClickElement(RegisterLink);
	}

	public void OpenLoginPage() 
	{
		ClickElement(LoginLink);
	}
	
	public void OpenContactUsPage() 
	{
		ScrollIntoElement(ContactUsLink);
		ClickElement(ContactUsLink);
	}
	
	
	public void ChangeCurrency() 
	{
		select = new Select(currencyElement);
		select.selectByVisibleText("Euro");
	}
	
	public void OpenSubMenuFromSuperByHover() 
	{
		actions.
		moveToElement(computersMenu)
		.moveToElement(NoteBooksMenu)
		.click().build().perform();
	}
}
