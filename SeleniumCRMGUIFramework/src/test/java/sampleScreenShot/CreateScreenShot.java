package sampleScreenShot;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreateScreenShot {
	
ExtentReports report;
ExtentSparkReporter spark;
	
    @BeforeSuite
	public  void  configBS() {
		   // ExtentSparkReporter conf 
		    spark = new ExtentSparkReporter("./advancereport/report.html");
		   spark.config().setDocumentTitle("CRM Test suite result ");
		   spark.config().setReportName("CRM report ");
		   spark.config().setTheme(Theme.DARK); 
		   // Env infomation By ExtentSparkReporter
		   
		    report = new ExtentReports();
		    report.attachReporter(spark);
		    report.setSystemInfo("OS", "window - 10");
		    report.setSystemInfo("BROWSER", "Chrome"); 
	}
	
    @AfterSuite
      public  void  configAS() {
    	  // back up  IMP 
	    	report.flush();
      }    
	
 @Test   
  public  void  createcontactTest() {
	 
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://localhost:8888/");
	 TakesScreenshot   ts= (TakesScreenshot)driver;
	   // filepath is used in test.addScreenCaptureFromBase64String(filepath,"ErrorFile") ; 
	 
	    String filepath = ts.getScreenshotAs(OutputType.BASE64);
	 
	    ExtentTest test = report.createTest("createcontactTest");
	    test.log(Status.INFO, "log in app");
	    test.log(Status.INFO, "navigate to contact page");
	    test.log(Status.INFO, "create contact");
	 //   Assert.assertEquals(filepath, true);
	    test.addScreenCaptureFromBase64String(filepath,"ErrorFile") ;
	 
	  if("HDFC".equals("HF"))
	  {
		  test.log(Status.PASS,"contact  is created");
	  } 
   else 
	  {
		  test.addScreenCaptureFromBase64String(filepath,"ErrorFile") ; 
	  } 
	  driver.close();
     }   
   }
