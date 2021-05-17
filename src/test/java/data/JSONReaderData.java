package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReaderData
{

	public	String firstName,LastName,Email,password ;


	
	 public void JsonReader () throws ParseException, FileNotFoundException, IOException 
	 {
		 
		 String FilePath = System.getProperty("user.dir")+ "/src/test/java/data/userdata.json";
		 
		 File source = new File(FilePath);
		 
		 JSONParser parser = new JSONParser();
		 JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(source));
		 
		 for (Object object : jsonArray)
		 {
			 JSONObject person = (JSONObject) object;
			 
			 firstName = (String) person.get("firstName");
			 System.out.println(firstName);
			 
			 LastName = (String) person.get("lastName");
			 System.out.println(LastName);
			 
			 Email = (String) person.get("email");
			 System.out.println(Email);
			 
			 password = (String) person.get("password");
			 System.out.println(password);
		} 
	 }
}
