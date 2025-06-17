package practiceTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3Array {
	
	
	
	@Test(dataProvider ="getData")
	public void CreateContactTest(String FirstName, String LastName,long phoneNumber ) {
		
		System.out.println("FirstName"+ FirstName+ "LastName"+ LastName +"phoneNumber"+phoneNumber);
		
	}
	@DataProvider
	 public Object[][] getData(){
		 
		    Object[][] objarr = new Object[3][3]	;	 
		    objarr[0][0]="deepak";
		    objarr[0][1]="HR";
		    objarr[0][2]=1234567852;
		    
		    objarr[1][0]="sam";
		    objarr[1][1]="sh";
		    objarr[1][2]=587413654;
		    
		    objarr[2][0]="jhon";
		    objarr[2][1]="smith";
		    objarr[2][2]=1234566541;
		  
		return  objarr; 
	 }
	

}
