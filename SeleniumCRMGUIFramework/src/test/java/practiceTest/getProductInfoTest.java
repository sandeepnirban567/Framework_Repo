package practiceTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 //import comcast.Crm.generic.ExcelUtility.ExcelUtility;

//public class getProductInfoTest {
//	    
//	@Test(dataProvider= "getData")
//	public void getProductInfoTest(String brandName, String productName) {
//		// data from sheet 
//		 WebDriver driver = new FirefoxDriver();
//		 driver.manage().window().maximize();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		 driver.get("https://www.flipkart.com/");
//		 // search of the product  
//		 driver.findElement(By.name("q")).sendKeys(brandName,Keys.ENTER);
//		 //  dynamic xpath in this 
//		 String x = "//div[text()='"+productName+"']/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']";
////		 String x = "//div[@class='tUxRFH' and contains(., 'Apple iPhone 13 (Midnight, 128 GB)')]//div[@class='Nx9bqj _4b5DiR']";
//		 String price = driver.findElement(By.xpath(x)).getText();
//		 System.out.println(price);
//		 driver.quit();
//	}
//	    @DataProvider
//		 public Object[][] getData() throws EncryptedDocumentException, IOException{
//			 
//			   ExcelUtility eLib = new ExcelUtility();
//			   int rowCount = eLib.getRowCount("product");   
//			    Object[][] objarr = new Object[rowCount][2];	 
//			             //    array in out  bound    <rowCount in in corrent <=
//			      for(int i=0;i<rowCount;i++) {
//				  objarr [i][0]= eLib .getDataFromExcel("product",i+1,0);
//				  objarr [i][1]= eLib .getDataFromExcel("product",i+1,1);
//			           }  
//			     return  objarr;
//		      } 
//	      }


