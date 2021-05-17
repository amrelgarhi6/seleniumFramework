package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper
{

	
	public static void CaptureScreenShots(WebDriver driver, String ScreenShotName) 
	{
		
		Path Destination = Paths.get("./ScreenShots",ScreenShotName+".png");
		
		try {
			Files.createDirectories(Destination.getParent());
			FileOutputStream output = new FileOutputStream(Destination.toString());
			output.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			output.close();
			
		} catch (IOException e) {
			System.out.println("Exception While Taking ScreenShot "+ e.getMessage());
		}
		
		
		
		
		
		
	}
	
}
