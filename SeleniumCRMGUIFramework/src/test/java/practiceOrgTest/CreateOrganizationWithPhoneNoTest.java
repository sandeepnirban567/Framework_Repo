package practiceOrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithPhoneNoTest {

	public static void main(String[] args) throws IOException, InterruptedException { 
		
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commandata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("user_name");
		String PASSWORD = pobj.getProperty("user_password");
		// run time polymorphisum // upcasting // overriding
		// read testscript data from excel file //
		// Generated random,
		Random random = new Random();
		int randomint = random.nextInt();
		FileInputStream fis1 = new FileInputStream("./src/test/resources/testscriptdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString() + randomint;
		String phoneNumber = row.getCell(3).getStringCellValue();

		wb.close();
		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else
			// by Chromediver();
			driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//1  step login 
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
//step 2 navigate to org module 
		driver.findElement(By.linkText("Organizations")).click();
//step 3  organization buttonF
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//step 4 enter all  the details create new organizataion
//from variable Name 
		
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	
	  driver.findElement(By.id("phone")).sendKeys(phoneNumber);   
		// saved button 
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	  String actPhone = driver.findElement(By.xpath("//td[@id='mouseArea_Phone']")).getText();	
	  if(actPhone.contains(phoneNumber))
		System.out.println(phoneNumber+" is successfully added");
	   else
		System.out.println(phoneNumber+" is not successfully added");    
		driver.quit();
	  }
    }
