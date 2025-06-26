package mavenParameter;

import org.testng.annotations.Test;

public class OrgTest {
	
	@Test
	 public void CreateOrgtTest() {
		
		String URL = System.getProperty("url"); 
		String BROWSER = System.getProperty("browser"); 
		String USERNAME = System.getProperty("username"); 
		String PASSWORD= System.getProperty("password"); 
		
		System.out.println(URL); 
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		 

		 System.out.println("execution  cretae Org Test");
	 } 
	 
	
@Test
public void ModifyOrgTest() {
		 
		 System.out.println("execution  ModifyOrgTest");
	 }
public void DeleteContactTest() {
	 
	 System.out.println("execution  DeleteContact");
}

}
