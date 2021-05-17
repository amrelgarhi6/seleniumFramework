package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties
{

	
	// Load the properties data From Folder 
	public static Properties userdataProperties = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");

	
	private static Properties loadProperties (String path) 
	{
		Properties pro = new Properties();

		// Stream To Reading File
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error Occured : " + e.getMessage());
		}
		
		return pro;
	}
}
