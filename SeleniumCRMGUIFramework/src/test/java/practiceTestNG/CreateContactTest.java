package practiceTestNG;

import org.testng.annotations.Test;

   public class CreateContactTest {
	
	@Test(priority=1)
	public void LoginTest() {  
		
		System.out.println("login Test 1");
		
	}
	@Test(priority=2)
    public void LoginTest2() {  
		
		
		System.out.println("login Test 2");
		
	}
   @Test(priority=3)
    public void LoginTest3() {  
	
	
	System.out.println("login Test 3"); 
}

}
