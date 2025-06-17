package practice.Reporter.loghomePageTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterLogTest {
	@Test
  public void ReporterLogTest() {
	
	String  expectedpage = "Home";
	Reporter.log(expectedpage);
	Reporter.log("step--1",true);
	Reporter.log("step--2",true);
	Reporter.log("step--3",true);
	Reporter.log("step--4",true);  
	Reporter.log("step--5",true); 
	
	Reporter.log(expectedpage);
	Reporter.log("step--1");
	Reporter.log("step--2");
	Reporter.log("step--3");
	Reporter.log("step--4");  
	Reporter.log("step--5");
	
	
	 WebDriver  driver = new ChromeDriver();
	 driver.manage().window().maximize(); 	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.get("http://localhost:8888/");
	 driver.findElement(By.name("user_name")).sendKeys("admin");

	 driver.findElement(By.name("user_password")).sendKeys("admin");
	 driver.findElement(By.id("submitButton")).click();
	 
	  String actTitle = driver.findElement(By.xpath("//a[@href='index.php?action=index&module=Home']")).getText();
	  
	  Assert.assertEquals(actTitle, expectedpage);
	  
	
   }


}
