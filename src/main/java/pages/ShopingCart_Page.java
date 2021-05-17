package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShopingCart_Page  extends PageBase
{
	public ShopingCart_Page(WebDriver driver) {
		super(driver);

	}

	// Web Elements For Registered User

	@FindBy (xpath = "//*[@id=\"termsofservice\"]")
	WebElement termsServiceBtn;

	@FindBy (name = "checkout")
	WebElement CheckoutBtn;

	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement ContryAdressList;

	@FindBy (id = "BillingNewAddress_City")
	WebElement CityAdressTxtBox;

	@FindBy (id = "BillingNewAddress_Address1")
	WebElement Address1TxtBox;

	@FindBy (id = "BillingNewAddress_ZipPostalCode")
	WebElement ZipCodeTxtBox;

	@FindBy (id = "BillingNewAddress_PhoneNumber")
	WebElement PhoneNumberTxtBox;

	@FindBy (css = "button.button-1.new-address-next-step-button")
	WebElement BillingContinue1Btn;

	@FindBy (css = "button.button-1.shipping-method-next-step-button")
	WebElement ShippingContinue2Btn;

	@FindBy (css = "button.button-1.payment-method-next-step-button")
	WebElement PaymentContinue3Btn;

	@FindBy (css = "button.button-1.payment-info-next-step-button")
	WebElement PaymentInfoContinue4Btn;

	@FindBy (css = "button.button-1.confirm-order-next-step-button")
	WebElement ConfirmOrderContinue5Bt;

	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
	public WebElement SuccessConfirmMsg;

	@FindBy (css ="button.button-1.order-completed-continue-button")
	WebElement CompeletOrder6Btn;

	//////////////////////////////////////////////////////////////////////////////////
	// Web Elements For Guest User

	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement GuestBtn;

	@FindBy (id = "BillingNewAddress_FirstName")
	WebElement FNameTxtBox;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement LNameTxtBox;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement EmailTxtBox;



	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")
	WebElement OrderDetailsLink;


	// Open Check Out Page
	public void OpenChechOutPage() throws InterruptedException 
	{
		Thread.sleep(1500);
		ClickElement(termsServiceBtn);
		ClickElement(CheckoutBtn);
	}

	// Registered User Page
	public void RegisteredUserCheckOutOrderSteps(String Country , String CityAdress ,String Address1, String ZipCode, String PhoneNumber) throws InterruptedException 
	{
		Thread.sleep(3000);
		select = new Select(ContryAdressList);
		select.selectByVisibleText(Country);
		setText(CityAdressTxtBox, CityAdress);
		setText(Address1TxtBox, Address1);
		setText(ZipCodeTxtBox, ZipCode);
		setText(PhoneNumberTxtBox, PhoneNumber);
		ClickElement(BillingContinue1Btn);

		Thread.sleep(1500);
		ClickElement(ShippingContinue2Btn);
		Thread.sleep(1500);
		ClickElement(PaymentContinue3Btn);
		Thread.sleep(1500);
		ClickElement(PaymentInfoContinue4Btn);
	}

	// Last Step (Confirm Order)
	public void ConfirmOrder() throws InterruptedException 
	{
		Thread.sleep(1500);
		ClickElement(ConfirmOrderContinue5Bt);
	}
	
	// Open Link Order Details To (Print - Download) Invoice Order 
	public void OpenOrderDetails() throws InterruptedException 
	{
		Thread.sleep(1500);
		ClickElement(OrderDetailsLink);
	}

	// Open Guest Page To Complete The Info 
	public void OpenGuestPage() throws InterruptedException 
	{
		Thread.sleep(1500);
		ClickElement(GuestBtn);
	}

	public void GuestUserCheckOutOrderSteps(String FName, String LName, String Email, 
			String Country , String CityAdress ,String Address1, String ZipCode, String PhoneNumber) throws InterruptedException 
	{
		Thread.sleep(1500);
		setText(FNameTxtBox, FName);
		setText(LNameTxtBox, LName);
		setText(EmailTxtBox, Email);
		select = new Select(ContryAdressList);
		select.selectByVisibleText(Country);
		setText(CityAdressTxtBox, CityAdress);
		setText(Address1TxtBox, Address1);
		setText(ZipCodeTxtBox, ZipCode);
		setText(PhoneNumberTxtBox, PhoneNumber);
		ClickElement(BillingContinue1Btn);

		Thread.sleep(1500);
		ClickElement(ShippingContinue2Btn);
		Thread.sleep(1500);
		ClickElement(PaymentContinue3Btn);
		Thread.sleep(1500);
		ClickElement(PaymentInfoContinue4Btn);
	}
}
