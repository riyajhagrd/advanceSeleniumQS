package PropertiesFileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	
	public String getdatafrompropertiesfile(String key) throws IOException{
			FileInputStream fis = new
			FileInputStream("./ConfigData/ninzaCrnCommonData.properties.txt");
			Properties prop = new Properties();
			prop.load(fis);
			String value = prop.getProperty(key);
			return value;

}
}
