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
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
//
//import com.cast.CrmobjectrepositoryUtility.CreatingNewOrganizationPage;
//import com.cast.CrmobjectrepositoryUtility.LoginPage;
//import com.cast.CrmobjectrepositoryUtility.OrganizationsPage;
//
//import comcast.Crm.generic.ExcelUtility.ExcelUtility;
//import comcast.Crm.generic.fileUtility.FileUtility;
//import comcast.Crm.genericWebDriverUtility.JavaUtility;
//import comcast.Crm.genericWebDriverUtility.WebDriverUtility;
//import concast.CRMBaseTest.BaseClassTest;

//public class CreateOrganizationWithIindustriesTest extends BaseClassTest   {
//
//   @Test 
//	public void CreateOrganizationsWithIindustriesTest() throws IOException, InterruptedException {
//		
//		   // create  object   
//		   FileUtility flib = new FileUtility();  // fetch  data from properties file 
//		   ExcelUtility elib = new ExcelUtility(); 
//		   JavaUtility jlib = new JavaUtility(); 
//		   WebDriverUtility wlib = new WebDriverUtility();
//		   
//		   // first changed 
//		    String URL = flib.getDataFromPropertiesFile("url"); 
//			String BROWSER = flib.getDataFromPropertiesFile("browser"); 
//			String USERNAME = flib.getDataFromPropertiesFile("username"); 
//			String PASSWORD = flib.getDataFromPropertiesFile("password"); 
//			
//		// read testscript data from excel file // Generated random,
//	
//		String orgName = elib.getDataFromExcel("org",4, 2)+jlib.getRandomNumber();
//		    //   exception if we put random number
//		String Energy= elib.getDataFromExcel("org", 4, 3);
//		String Press = elib.getDataFromExcel("org", 4, 4);  
//		
//		WebDriver driver = null;
//
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
//		// implictwait 
//		  wlib.waitForpageToload(driver);
////1  step login 
//		  LoginPage ip = new LoginPage(driver);
//		   ip.loginToApp(URL,USERNAME,PASSWORD);
//		
////step 2 navigate to org module   
//		   CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
//	          cnp.getOrgNameEdt();
//	        //step 3  organization buttonF click;
//	          CreatingNewOrganizationPage cnp1 = new CreatingNewOrganizationPage(driver);
//                cnp1.getSaveBtn();
//              //step 4 click on button  industry 
//                cnp1.getindustryDB().sendKeys(Energy);
//                
//
//		WebElement wbsele1 = driver.findElement(By.name("industry"));
//		Select sele = new Select(wbsele1);
//	     sele.selectByValue(Energy);
//		// exception 
//		Thread.sleep(3000);
//		// name="accounttype"
// WebElement wbsele2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
//    Select sele2 = new Select(wbsele2);
//	sele2.selectByValue(Press);  
//	
//	driver.findElement(By.name("button")).click();
//	
//    // verify  the  industries and type info  
//		String actInbdustries = driver.findElement(By.xpath("//td[@id='mouseArea_Industry']")).getText();
//		if ( actInbdustries.contains(Energy)) {
//			System.out.println(Energy  +  "       infomation is verified  pass");
//		} else {
//			System.out.println(Energy +  "      infomation is  verified  fail");
//		}  
//		//verify the type
//		
//		String actType = driver.findElement(By.xpath("//td[@id='mouseArea_Type']")).getText();
//		if ( actType.contains(Press)) {
//			System.out.println(Press+"        infomation is verified  pass");
//		} else {
//			System.out.println(Press+"        infomation is  verified  fail");
//		}  
//      //5 step // logout 
//		driver.quit();
//	    }
//      }
