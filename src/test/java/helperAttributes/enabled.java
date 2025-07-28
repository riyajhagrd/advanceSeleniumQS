package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class enabled {

	
	@Test(enabled = true)
	public void a10() {
		Reporter.log("execution done",true);
	}
	
	@Test(enabled = false)
	public void a11() {
		Reporter.log("execution done",true);
	}
	
	@Test
	public void a12() {
		Reporter.log("execution done",true);
	}
}
