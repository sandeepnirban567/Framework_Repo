package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrgTestJSON {
	@Test
	public void CreateOrgTest() throws EncryptedDocumentException, IOException, InterruptedException, Throwable {
		// read JSON file 
		// step 1' parse JSON physical file in to java object using json Parse class 
		    JSONParser parser = new JSONParser(); 
             Object obj = parser.parse(new FileReader("./src/test/resources/appCommonData.json"));
           //   ./src/test/resources/appCommonData.json
             // setp 2 Convert java object in to JSON Object using Down Casting 
            JSONObject map = (JSONObject)obj;
         //    JSONObject map = (JSONObject)obj;
             // step 3 get the value from JSON file using key 
            String URL = map.get("url").toString();
            String BROWSER= map.get("browser").toString();
            String USERNAME = map.get("username").toString();
            String PASSWORD= map.get("password").toString();

	    // run time polymorphisum // upcasting // overriding
	    // read testscript data from excel file  // 
	    //  Generated random, 
	        Random random = new Random();
					int randomint = random.nextInt();
		 FileInputStream fis1 = new FileInputStream("./src/test/resources/testScriptdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis1);
	     Sheet sh = wb.getSheet("sheet2");
		 Row row = sh.getRow(1);
		 String orgName = row.getCell(2).toString()+ randomint;
		  //    System.out.println(orgName);       
		           wb.close();             
           WebDriver driver = null;
       
	   if( BROWSER.equals("chrome")) {
		   driver = new ChromeDriver();
	   } 
	   else if( BROWSER.equals("firefox")) {
		   driver = new FirefoxDriver();
	   } 
	   else if( BROWSER.equals("edge")) {
		   driver = new EdgeDriver();
	   } else
		   
		   
		   // by Chromediver();
	driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    // 1  step login 
    driver.get(URL);
    driver.findElement(By.name("user_name")).sendKeys(USERNAME) ;
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD) ;
    driver.findElement(By.id("submitButton")).click() ;
    // step 2 navigate to org module 
   driver.findElement(By.linkText("Organizations")).click();
   // step 3  organization button
   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
   // step 4 enter all  the details create new organization
   // from variable Name 
     driver.findElement(By.name("accountname")).sendKeys(orgName);
     driver.findElement(By.name("button")).click();
   
    // 5 step // logout 
      Thread.sleep(3000);
      Actions act = new Actions(driver);
      act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
      Thread.sleep(2000);
        // sign out 
       driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click() ;  
       driver.quit();	 		
	    }
     }
