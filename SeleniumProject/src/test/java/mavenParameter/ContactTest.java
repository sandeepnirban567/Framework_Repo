package mavenParameter;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

@Test
public class ContactTest {
	
	@Test
	public void CreateContactTest() {
		String URL = System.getProperty("url"); 
		String BROWSER = System.getProperty("browser"); 
		String USERNAME = System.getProperty("username"); 
		String PASSWORD= System.getProperty("password"); 
		
		System.out.println(URL); 
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		 
		 System.out.println("execution  cretae contact Test");
	 } 
	 
	
    @Test
    public void ModifyContactTest() {
		 
		 System.out.println("execution  ModifyContactTest");
	 }
    public void DeleteContactTest() {
   	 
   	 System.out.println("execution  DeleteContact");
   }

   }
