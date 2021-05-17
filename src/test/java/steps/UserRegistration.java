package steps;

import org.testng.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Home_Page;
import pages.Registeration_Page;
import testCases.TestBase;

public class UserRegistration extends TestBase
{

	Home_Page          homepageObject;
	Registeration_Page registerObject;

	Faker fakedata = new Faker();
	
	String firstName = fakedata.name().firstName();
	String lasttName = fakedata.name().lastName();
	String email     = fakedata.internet().emailAddress();
	String password  = fakedata.number().digits(8).toString();
	@Given("The user is already on Home page")
	public void the_user_is_already_on_home_page()
	{
		homepageObject = new Home_Page(driver);
		homepageObject.OpenRegistrationPage();
	}
	
	
	@When("User Can Click on registration link")
	public void user_can_click_on_registration_link() 
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	
	@When("User entered the data credienials")
	public void user_entered_the_data_credienials() throws InterruptedException 
	{
		Thread.sleep(1500);
		registerObject = new Registeration_Page(driver);
		registerObject.UserRegisterOpertaions(firstName, lasttName, email, password);

	}
	@Then("The registration page is displayed successfully")
	public void the_registration_page_is_displayed_successfully() 
	{
		Assert.assertTrue(registerObject.SuccessMassage.getText().contains("Your registration completed"));
		registerObject.Logout();
	}









}
