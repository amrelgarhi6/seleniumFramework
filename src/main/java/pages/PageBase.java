package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	
	protected WebDriver driver;
	public JavascriptExecutor jsExecutor;
	public Select select;
	public Actions actions;
	
	
	public PageBase(WebDriver driver) 	
	{
		PageFactory.initElements(driver, this);
	}

	
	
	protected static void ClickElement(WebElement button) 
	{
		button.click();
	}
	
	protected static void setText(WebElement textBox,String text) 
	{
		textBox.sendKeys(text);
	}
	
	public void ScrollIntoElement(WebElement element) 
	{
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);" ,element);	
	}
	
	
}
