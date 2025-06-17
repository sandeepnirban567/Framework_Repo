package practiceTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {
	
	@BeforeSuite
	public void confiBS() {
		System.out.println(" -----Connect to DB , report Config----");
		
	}
	@BeforeClass
	public void confiBC() {
		System.out.println(" ----- launch the Browser ");
		
	}
	@BeforeMethod
	public void confiBM() {
		System.out.println(" ----- logIn");
		
	}
	@AfterMethod
	public void confiAM() {
		System.out.println(" ----- Logout");
		
	}
	@AfterClass
	public void confiAC() {
		System.out.println(" ----- closed the Browser ");		
	}

	@AfterSuite
	public void confiAS() {
		System.out.println(" -----closed to DB , report Config----");
		
	}

}
