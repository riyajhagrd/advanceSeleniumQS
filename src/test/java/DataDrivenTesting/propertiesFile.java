package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class propertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		FileInputStream fis = new FileInputStream("./ConfigData/ninzaCrmCommonData.properties.txt");
		Properties prop = new Properties();
		prop.load(fis);
		String Browsers = prop.getProperty("Browser");
		System.out.println(Browsers);
		String url = prop.getProperty("URL");
		String username = prop.getProperty("Usr");
		String pwd = prop.getProperty("pwd");
		
		WebDriver driver = null;
		
		if(Browsers.equals("Edge")) {
			driver = new EdgeDriver();
		}
		if(Browsers.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
	}

}
