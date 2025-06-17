//package com.cast.CrmOrgTest;
//
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//import java.util.Random;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
//
//import com.cast.CrmobjectrepositoryUtility.CreatingNewOrganizationPage;
//import com.cast.CrmobjectrepositoryUtility.HomePage;
//import com.cast.CrmobjectrepositoryUtility.LoginPage;
//import com.cast.CrmobjectrepositoryUtility.OrganizationInfoPage;
//import com.cast.CrmobjectrepositoryUtility.OrganizationsPage;
//
//import comcast.Crm.generic.ExcelUtility.ExcelUtility;
//import comcast.Crm.generic.fileUtility.FileUtility;
//import comcast.Crm.genericWebDriverUtility.JavaUtility;
//import comcast.Crm.genericWebDriverUtility.WebDriverUtility;
//import concast.CRMBaseTest.BaseClassTest;
//
//public class CreateOrganizationTest extends BaseClassTest{
//     @Test
//	public void CreateOrganizationsTest() throws InterruptedException, EncryptedDocumentException, IOException {
//		      // ava.lang.NullPointerException:
//		     // create  object   
//		   FileUtility flib = new FileUtility();  // fetch  data from properties file 
//		   ExcelUtility elib = new ExcelUtility(); 
//		   JavaUtility jlib = new JavaUtility();
//		   WebDriverUtility wlib = new WebDriverUtility();
//		 // first changed get data from pro file 
//		   
//		    String URL = flib.getDataFromPropertiesFile("url"); 
//			String BROWSER = flib.getDataFromPropertiesFile("browser"); 
//			String USERNAME = flib.getDataFromPropertiesFile("username"); 
//			String PASSWORD = flib.getDataFromPropertiesFile("password"); 
//        //  Generated random ,   // null point except
//			
//			// get data from excel sheet with random number 
//			
//	 String orgName = elib.getDataFromExcel("org",1,2)+jlib.getRandomNumber();
//	//    System.out.println(orgName);       
//	                      
//       WebDriver driver = null;
//   
//   if( BROWSER.equals("chrome")) {
//	   driver = new ChromeDriver();
//   } 
//   else if( BROWSER.equals("firefox")) {
//	   driver = new FirefoxDriver();
//   } 
//   else if( BROWSER.equals("edge")) {
//	   driver = new EdgeDriver();
//   } else
//  // {
//	   driver = new ChromeDriver();
//  // }      
//	                                    
//      // 1  step login 
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	   driver.get(URL); 
//	   LoginPage ip = new LoginPage(driver);
//	   ip.loginToApp(URL,USERNAME,PASSWORD);
//	  Thread.sleep(1000);
//     //  checked and run  // step 2 navigate to org module
//	    HomePage hp = new HomePage(driver);
//	    hp.getOrganizationLink().click(); 
//     // step 3 click organization button
//        OrganizationsPage cnp = new OrganizationsPage(driver);
//          cnp.getCreateNewOrgBtn().click();   
//        // step 4 enter all  the details create new organization
//         CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
//              cnop.createOrg(orgName);
//         // verify Header msg excepted result 
//          OrganizationInfoPage oip = new OrganizationInfoPage(driver);
//              String actorgName = oip.getHeaderMsg().getText();  
//              if(actorgName.contains(orgName)) {
//            	  System.out.println(orgName+" name is verifid --- Pass");
//              }
//              else {
//            	  System.out.println(orgName+" name is verifid --- failed"); 
//              }       // 5 step // logout   
//          HomePage hp1=new HomePage(driver);
//           hp1.LogOut();   
//           hp.getSignOutlink();
//           driver.quit();	 	
//	      }
//      }
