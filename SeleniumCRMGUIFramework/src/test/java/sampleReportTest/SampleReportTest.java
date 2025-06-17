package sampleReportTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	
	ExtentReports report;
	
    @BeforeSuite
	public  void  configBS() {
		   // ExtentSparkReporter conf 
		   ExtentSparkReporter spark = new ExtentSparkReporter("./advancereport/report.html");
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
	 
	    ExtentTest test = report.createTest("createcontactTest");
	    test.log(Status.INFO, "log in app");
	    test.log(Status.INFO, "navigate to contact page");
	    test.log(Status.INFO, "create contact");
	 
	  if("HDFC".contains("HDFC"))
	  {
		  test.log(Status.PASS,"contact  is created");
	  } else 
	  {
		  test.log(Status.FAIL,"contact  is not  created");  
	  } 
     }   
 
    @Test
    public  void  createcontactwithORGTest() {
	 
     ExtentTest test = report.createTest(" createcontactwithORG");
   test.log(Status.INFO, "log in app");
   test.log(Status.INFO, "navigate to  createcontactwithORG page");
   test.log(Status.INFO, "create  createcontactwithORG");

 if("HDFC".contains("HDFC"))
 {
	  test.log(Status.PASS,"contact  is created");
 } else 
 {
	  test.log(Status.FAIL,"contact  is not  created");  
 } 
 
}
 @Test
public  void  createcontactwithPhoneNoTest() {
	 
     ExtentTest test = report.createTest("createcontactwithPhoneNo");
   test.log(Status.INFO, "log in app");
   test.log(Status.INFO, "navigate to   createcontactwithPhoneNo page");
   test.log(Status.INFO, "create   createcontactwithPhoneNo");

 if("HDFC".contains("HDFC"))
 {
	  test.log(Status.PASS,"contact  is created");
 } else 
 {
	  test.log(Status.FAIL,"contact  is not  created");  
 } 

}
 
 
  }
