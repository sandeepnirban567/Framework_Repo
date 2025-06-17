package practiceOrgTest;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		 FileInputStream fis= new FileInputStream("./src/test/resources/commandata.properties");
		    Properties pobj = new Properties() ;
		    pobj.load(fis) ;     
		    String URL= pobj .getProperty("url");
		    String BROWSER  = pobj.getProperty("browser");
		    String USERNAME = pobj.getProperty("user_name");
		    String PASSWORD = pobj.getProperty("user_password");
	
    // run time polymorphisum // upcasting // overriding
    // read testscript data from excel file  // 
    //  Generated random , 
        Random random = new Random();    
	    int randomint = random.nextInt(100000);
	 FileInputStream fis1 = new FileInputStream("./src/test/resources/testScriptdata1.xlsx");
	 Workbook wb = WorkbookFactory.create(fis1);
	 // nullpointer 
     Sheet sh = wb.getSheet("org");
	 Row row = sh.getRow(1);
	 String orgName = row.getCell(2).toString()+ randomint;       
	                      
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
     // org  name 
 driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgName);
 // saved button 
 driver.findElement(By.name("button")).click();
  // verify Header msg excepted result 
    String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    if(headerInfo.contains(orgName)) {
    	System.out.println(orgName+"is pass");
    }else {
    	System.out.println(orgName+"is  fail");
    	
    }
 // verify Header orgName info excepted result 
        String actorgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
     if( actorgName.contains(orgName)) {
     	System.out.println(orgName+"is pass");
     }else {
     	System.out.println(orgName+"is  fail");
     }
     
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
