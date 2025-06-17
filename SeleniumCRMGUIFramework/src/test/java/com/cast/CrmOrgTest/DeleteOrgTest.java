//package com.cast.CrmOrgTest;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
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

//public class DeleteOrgTest {
//
//	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
//		// create  object   
//		   FileUtility flib = new FileUtility();  // fetch  data from properties file 
//		   ExcelUtility elib = new ExcelUtility(); 
//		   JavaUtility jlib = new JavaUtility();
//		   WebDriverUtility wlib = new WebDriverUtility();
//		 
//		 // first changed p
//		   String URL = flib.getDataFromPropertiesFile("url"); 
//			String BROWSER = flib.getDataFromPropertiesFile("browser"); 
//			String USERNAME = flib.getDataFromPropertiesFile("username"); 
//			String PASSWORD = flib.getDataFromPropertiesFile("password"); 
// //  Generated random , 
//      // null point except
//	 String orgName = elib.getDataFromExcel("org",1,2)+jlib.getRandomNumber();
//
//	//    System.out.println(orgName);       
//	                      
//     WebDriver driver = null;
//
//if( BROWSER.equals("chrome")) {
//	   driver = new ChromeDriver();
//} 
//else if( BROWSER.equals("firefox")) {
//	   driver = new FirefoxDriver();
//} 
//else if( BROWSER.equals("edge")) {
//	   driver = new EdgeDriver();
//} else
//// {
//	   driver = new ChromeDriver();
//// }  
//	                                    
////1  step login 
//
//	   driver.get(URL); 
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	   driver.manage().window().maximize();
//	   LoginPage ip = new LoginPage(driver);
//	   ip.loginToApp(URL,USERNAME,PASSWORD);
//         
//	  
//               // checked and run  
// //step 2 navigate to org module
//	    HomePage hp = new HomePage(driver);
//	    hp.getOrganizationLink().click(); 
////step 3 click organization button
//   OrganizationsPage cnp = new OrganizationsPage(driver);  
//       cnp.getCreateNewOrgBtn().click();   
////step 4 enter all  the details create new organization
//      CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
//           cnop.createOrg(orgName);
//// verify Header msg excepted result 
//      OrganizationInfoPage oip = new OrganizationInfoPage(driver);
//           String actorgName = oip.getHeaderMsg().getText();  
//           if(actorgName.contains(orgName)) {
//         	  System.out.println(orgName+" name is verifid --- Pass");
//           }
//           else {
//         	  System.out.println(orgName+" name is verifid --- failed"); 
//           }       // 5 step // logout   
//         //step  
//         // go back Org page  by  HomePage 
//           HomePage hp1 = new HomePage(driver);
//   	    hp1.getOrganizationLink().click(); 
//          
//   // search for OrganizationsPage // not allowed to hardcode
//   	    
//   	   OrganizationsPage cnp1 = new OrganizationsPage(driver); 
//   	   // do  as same as  hard not allowed 
//   	   //  CreateOrganizationWithIindustriesTest
//   	   //String Energy= elib.getDataFromExcel("org", 4, 3);    
//           wlib.selectText(cnp.getSearchDD(),"Organization Name");
//           cnp1.getsearchEt().sendKeys(orgName);
//           cnp1.getsearchBtn().click();
//           Thread.sleep(2000);
//        //  driver.findElement(By.xpath("//tr[@class='lvtColData' and contains(.,'"+orgName+"')]//a[text()='del']")).click();//        // wlib.switchToAlertandAccept(driver);
//         driver.findElement(By.xpath("//a[text()='del']")).click(); 
//       Thread.sleep(3000);
//       
//           //   HomePage hp2=new HomePage(driver);
//           //   hp2.LogOut(); 
//         driver.quit();	 	
//	     }
//	}
//
//
