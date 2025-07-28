package helperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class dependsOnMethod {
	
	@Test
	public void creatAcc() {
		Reporter.log("created",true);
		
	}
		@Test(dependsOnMethods = "creatAcc")
		public void editAcc() {
			Reporter.log("edited",true);
			}
		
		@Test(dependsOnMethods = "editAcc")
		public void deleteAcc() {
			Reporter.log("deleted",true);
			}
		
		
}
