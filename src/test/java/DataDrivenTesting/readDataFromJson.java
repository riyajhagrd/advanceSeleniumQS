package DataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readDataFromJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./configData/commondata.json"));
		
		JSONObject obj1 = (JSONObject)obj ; 
		
		System.out.println(obj1.get("Browser"));
		System.out.println(obj1.get("url"));
		System.out.println(obj1.get("username"));
		System.out.println(obj1.get("password"));
		
		
	}

}
