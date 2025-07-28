package testcase;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class practice {

	
	
	@Test
	public void Tc001() {
		Reporter.log("Testcase done",true);
		
	}
	@BeforeMethod
	public void beforemethod() {
		Reporter.log("kogin",true);
	}
	
	@AfterMethod
	public void aftermethod() {
		Reporter.log("logout",true);
	}
	
	@BeforeClass
	public void beforeclass() {
		Reporter.log("launching browser");
		
	}
	
	
	@AfterClass
	public void afterclass() {
		Reporter.log("closing browser",true);
	}
	
	@BeforeTest
	public void beforetest() {
		Reporter.log("pre condidtion",true);
	}
	
	@AfterTest
	public void aftertest() {
		Reporter.log("post condtion",true);
	}
	
	@BeforeSuite
	public void beforesuite() {
		Reporter.log("DB Connectivity open",true);
	}
	
	
	@AfterSuite
	public void aftersuite() {
		Reporter.log("DB Connectivity close",true);
	}
}
