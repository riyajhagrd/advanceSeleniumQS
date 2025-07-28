package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class priority {

	@Test(priority = 0)
	public void  amazon() {
		Reporter.log("amazon executed",true);
	}
	
	@Test(priority = -2)
	public void  bookmyshow() {
		Reporter.log("bookmyshow executed",true);
	}
	
	@Test(priority = 3)
	public void  flipkart() {
		Reporter.log("flipkart executed",true);
	}
	
}
