package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Comparison_page extends PageBase 
{
	public Comparison_page(WebDriver driver) {
		super(driver);
	}

	
	@FindBy (css = "div.page-title")
	public WebElement comparisonTitl;
	
	@FindBy (linkText = "Build your own computer")
	public WebElement FirstProductName;
	
	@FindBy (linkText = "Digital Storm VANQUISH 3 Custom Performance PC")
	public WebElement SecondProductName;
	
	@FindBy (tagName  = "td")
	public	WebElement FirstProductPrice;
	
	@FindBy (tagName  = "td")
	public WebElement SecondProductPrice;
	
	@FindBy (css = "div.no-data")
	public WebElement NoItemMsg;
	
	@FindBy(css = "a.clear-list")
	WebElement ClearListBtn;
	
	@FindBy(tagName = "tr")
	public   List<WebElement> allRows;
 	
	@FindBy(tagName = "td")
	public List<WebElement> allCols;
	
	@FindBy (css = "div.page-body")
	WebElement tableElements;
	
	
	public void compareProducts() 
	{
		System.out.println(allRows.size());
		
		for (WebElement rows : allRows) 
		{
			System.out.println(rows.getText()  + "\t");
		
			for (WebElement cols : allCols) 
			{
			System.out.println(cols.getText()   + "\t");	
			}
		}
	}
	
	public void ClearCompareList() 
	{
		ClickElement(ClearListBtn);
	}
}
