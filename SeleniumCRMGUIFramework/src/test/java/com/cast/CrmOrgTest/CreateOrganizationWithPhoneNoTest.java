//package com.cast.CrmOrgTest;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//import java.util.Random;  
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
//
//import com.cast.CrmobjectrepositoryUtility.LoginPage;
//
//import comcast.Crm.generic.ExcelUtility.ExcelUtility;
//import comcast.Crm.generic.fileUtility.FileUtility;
//import comcast.Crm.genericWebDriverUtility.JavaUtility;
//import comcast.Crm.genericWebDriverUtility.WebDriverUtility;

//public class CreateOrganizationWithPhoneNoTest {
//
//	
//	@Test
//	public void  CreateOrganizationsWithPhoneNoTest() throws IOException, InterruptedException { 
//	
//		// create  object   
//		   FileUtility flib = new FileUtility();  // fetch  data from properties file 
//		   ExcelUtility elib = new ExcelUtility(); 
//		   JavaUtility jlib = new JavaUtility();
//		   WebDriverUtility wlib = new WebDriverUtility();
//		     
//		 // first changed 
//		   String URL = flib.getDataFromPropertiesFile("url"); 
//			String BROWSER = flib.getDataFromPropertiesFile("browser"); 
//			String USERNAME = flib.getDataFromPropertiesFile("username"); 
//			String PASSWORD = flib.getDataFromPropertiesFile("password"); 
//		// run time polymorphisum // upcasting // overriding
//		// read testscript data from excel file //
//		// Generated random,
//		
//		String orgName = elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
//		String phoneNumber =elib.getDataFromExcel("org", 7, 3)+jlib.getRandomNumber();
//
//		WebDriver driver = null  ;
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else
//			// by Chromediver();
//			driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		  wlib.waitForpageToload(driver);
////1  step login 
//		  LoginPage ip = new LoginPage(driver);
//		   ip.loginToApp(URL,USERNAME,PASSWORD);
//		
////step 2 navigate to org module 
//		   
//		driver.findElement(By.linkText("Organizations")).click();
////step 3  organization buttonF
//		
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
////step 4 enter all  the details create new organizataion
////from variable Name 
//		
//	driver.findElement(By.name("accountname")).sendKeys(orgName);
//	
//	  driver.findElement(By.id("phone")).sendKeys(phoneNumber);   
//		// saved button 
//	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//			
//	  String actPhone = driver.findElement(By.xpath("//td[@id='mouseArea_Phone']")).getText();	
//	  if(actPhone.contains(phoneNumber))
//		System.out.println(phoneNumber+" is successfully added");
//	   else
//		System.out.println(phoneNumber+" is not successfully added");    
//		driver.quit();
//	  }
//    }
