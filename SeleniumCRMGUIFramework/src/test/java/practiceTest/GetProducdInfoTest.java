package practiceTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import comcast.Crm.generic.ExcelUtility.ExcelUtility;

public class GetProducdInfoTest {
	    // hardcode  data   correct script 
	@Test(dataProvider= "getData")
	public void getProductInfoTest(String brandName, String productName) {
		
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get("https://www.flipkart.com/");
		 // search of the product  
		 driver.findElement(By.name("q")).sendKeys(brandName,Keys.ENTER);
		 // capture product info     ='"+productName+"'
		 String x = "//div[text()='"+productName+"']/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']";
//		 String x = "//div[@class='tUxRFH' and contains(., 'Apple iPhone 13 (Midnight, 128 GB)')]//div[@class='Nx9bqj _4b5DiR']";
		 String price = driver.findElement(By.xpath(x)).getText();
		 System.out.println(price);
	}
	    @DataProvider
		 public Object[][] getData() throws EncryptedDocumentException, IOException{    
			    Object[][] objarr = new Object[3][2];	 
			               objarr[0][0]="iphone";
			               objarr[0][1]="Apple iPhone 13 (Midnight, 128 GB)";
			               objarr[1][0]="iphone";
			               objarr[1][1]="Apple iPhone 15 (Yellow, 128 GB)";
			               objarr[2][0]="iphone";
			               objarr[2][1]="Apple iPhone 15 (Green, 128 GB)";
			     return  objarr;
		      } 
     }
