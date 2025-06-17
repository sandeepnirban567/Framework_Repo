package practice.Screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;


@Test
public class SampletestForScreenShot {
	
	@Test
	 public void Screenshot() throws IOException {
		 
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("http://localhost:8888/");	   
	    
	      TakesScreenshot ts = (TakesScreenshot)driver; 

		   File source = ts.getScreenshotAs(OutputType.FILE);   
	         
	          File destination = new File("./screenShot/Vtiger.png");
	            
		   Files.copy(source, destination);  
	  }

   }
