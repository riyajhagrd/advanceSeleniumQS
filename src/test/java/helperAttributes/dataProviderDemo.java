package helperAttributes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderDemo {

	
	
	@Test(dataProvider ="logindetails" )
	public void login(String username , String password ) {
		System.out.println(username+"===="+password);
	}
	
	
	
	@DataProvider
	public Object[][] logindetails() {
		Object[][] obj = new Object[3][2];
		obj[0][0]="riya";
		obj[0][1]="rani";
		obj[1][0]="tannu";
		obj[1][1]="jha";
		obj[2][0]="qa";
		obj[2][1]="sdet";
		
		return obj;
	}
}
