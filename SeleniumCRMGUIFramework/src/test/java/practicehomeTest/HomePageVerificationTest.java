package practicehomeTest;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.org.apache.bcel.internal.classfile.Method;

public class HomePageVerificationTest {
	
	@Test
	 public void homePageVerificationTest(){
	// Hart Assert	
		String  expectedpage = "Home";
		 WebDriver  driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("http://localhost:8888/");
		 driver.findElement(By.name("user_name")).sendKeys("admin");

		 driver.findElement(By.name("user_password")).sendKeys("admin");
		 driver.findElement(By.id("submitButton")).click();
		 
		  String actTitle = driver.findElement(By.xpath("//a[@href='index.php?action=index&module=Home']")).getText();
		  
		  Assert.assertEquals(actTitle, expectedpage);
		  
		  driver.findElement(By.name("user_password")).sendKeys("admin");
			 driver.findElement(By.id("submitButton")).click();
		  
//		   if(actTitle.contains(expectedpage))
//		   {
//			   System.out.println(expectedpage+" is Pass");
//		   }else {
//			   System.out.println(expectedpage+"is Fail");  
//		   }
	}
	@Test
	 public void  VerifiyLogoHomeTest(){ 
		
		
   // System.out.println(mtd.getName()+"Test start");
		
		String  expectedpage = "Home";
		
		   SoftAssert sa = new SoftAssert();
		   
		 WebDriver  driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("http://localhost:8888/");
		 driver.findElement(By.name("user_name")).sendKeys("admin");

		 driver.findElement(By.name("user_password")).sendKeys("admin");
		 driver.findElement(By.id("submitButton")).click();
		 
	         String actlogo = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).getText();
		       Assert.assertEquals(actlogo, expectedpage);
		     
//		   if(status){
//			   System.out.println("Logo is Pass");
//		   }else {
//			   System.out.println("Logo is Fail");  
//		   }
		       
		       driver.findElement(By.name("user_password")).sendKeys("admin");
				 driver.findElement(By.id("submitButton")).click();
				 sa.assertAll();
				 
	}
    }
