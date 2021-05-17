package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInformation_Page extends PageBase
{	
	public OrderInformation_Page(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(css = "a.button-2.print-order-button")
	WebElement PrintOderBtn;
	
	@FindBy (css = "a.button-2.pdf-invoice-button")
	WebElement pdfInvoiceBtn;
	
	
	public void UserCanPrintOrderInvoice() throws InterruptedException 
	{
		Thread.sleep(1000);
		ClickElement(PrintOderBtn);
	}
	public void UserCanDownloadPdfInvoice() throws InterruptedException 
	{
		Thread.sleep(1000);
		ClickElement(pdfInvoiceBtn);
	}
}
