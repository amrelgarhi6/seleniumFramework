package testCases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase  extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	
	
	public static String DownPath = System.getProperty("user.dir")+("\\Downloads");


	public static ChromeOptions chromeOptions () 
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> ChromPrefs = new HashMap<String , Object>();
		ChromPrefs.put("profile.default.content.settings", 0);
		ChromPrefs.put("download.default_directory", DownPath);
		options.setExperimentalOption("prefs", ChromPrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;	
	}
	
	
	@Parameters({"browser"})
	@BeforeSuite
	public void OpenDriver (@Optional ("chrome") String BrowserName)
	{
		if (BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver(chromeOptions());
		}
		else if (BrowserName.equalsIgnoreCase("edge")) 
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void ClosrDriver() 
	{
		driver.close();
	}


	@AfterMethod
	public void ScreenShotOnFaliure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!!");
			System.out.println("Taking ScreenShot...");
			Helper.CaptureScreenShots(driver, result.getName());	
		}	
	}
}
