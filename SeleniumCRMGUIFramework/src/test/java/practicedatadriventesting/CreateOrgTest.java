package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrgTest {
     @Test
	public void  CreateOrgTest  () throws IOException {
    	 // used data from CMD prompt
		 FileInputStream fis= new FileInputStream("./src/test/resources/commandata.properties");
			    Properties pobj= new Properties();
			    pobj.load(fis);    
			    String URL= pobj.getProperty("url");
			    String BROWSER = pobj.getProperty("browser");
			    String USERNAME = pobj.getProperty("user_name");
			    String PASSWORD = pobj.getProperty("user_password");
		
			    // run time polymorphisum // upcasting // overriding
               WebDriver driver = null ;
               
			   if( BROWSER.equals("chrome")) {
				   driver = new ChromeDriver();
			   } 
			   else if( BROWSER.equals("firefox")) {
				   driver = new FirefoxDriver();
			   } 
			   else if( BROWSER.equals("edge")) {
				   driver = new EdgeDriver();
			   } else
			   
		    driver= new ChromeDriver();
	        driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get(URL);
		    
		    driver.findElement(By.name("user_name")).sendKeys(USERNAME) ;
	        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD) ;
            driver.findElement(By.id("submitButton")).click() ;
            driver.findElement(By.linkText("Organizations")).click();
            driver.quit();
	     }
      }
