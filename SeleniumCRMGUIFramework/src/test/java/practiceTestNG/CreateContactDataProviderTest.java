package practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDataProviderTest {
	
	
	
	@Test(dataProvider = "getData")
	public void CreateContactTest(String FirstName, String LastName) {
		
		System.out.println("FirstName"+ FirstName+ "LastName"+ LastName);
		
	}
	@DataProvider
	 public Object[][] getData(){
		 
		    Object[][] objarr = new Object[3][2]	;	 
		    objarr[0][0]="deepak";
		    objarr[0][1]="HR";
		    
		    objarr[1][0]="sam";
		    objarr[1][1]="sh";
		    
		    objarr[2][0]="jhon";
		    objarr[2][1]="smith";
		    
		    
		return  objarr;
		 
	 }
	
	
	
	
	
   }
