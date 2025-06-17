package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTestIntegration {
   // localhost:8888
	
	public static void main(String[] args) throws IOException {
		
		// read common data from pro file
		FileInputStream fis= new FileInputStream("./src/test/resources/commandata.properties");
	    Properties pobj= new Properties();
	    pobj.load(fis);    
	    String URL= pobj.getProperty("url");
	    String BROWSER = pobj.getProperty("browser");
	    String USERNAME = pobj.getProperty("user_name");
	    String PASSWORD = pobj.getProperty("user_password");

	    // run time polymorphisum // upcasting // overriding
	    // read testscript data from excel file 
		  FileInputStream fis1 = new FileInputStream("./src/test/resources/testScriptdata.xlsx");
		       Workbook wb = WorkbookFactory.create(fis1);
		                 Sheet sh = wb.getSheet("sheet2");
		                        Row row = sh.getRow(1);
		                        String orgName = row.getCell(2).toString();
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
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
        // sign out 
        driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
        
        driver.quit();
 
	}
  }
