package practiceTestNG;

import org.testng.annotations.Test;


public class SampleTestNG {
	
	@Test
	public void SampleTestNG1(){
		
		System.out.println(" execute1 test");
		
		
		
	}
	
	@Test(dependsOnMethods ="SampleTestNG1")
public void SampleTestNG2(){
		
		System.out.println(" execute2 test");
	}  

	
	@Test(invocationCount = 10)
	public void SampleTestNG3(){
		
		System.out.println(" execute1 3test");
		
	
	}
	
	  @Test(enabled=false)
	public void SampleTestNG4(){
		
		System.out.println(" execute1 4test");
		
	
	}
	
	
}
