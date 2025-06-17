package practiceContactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactwithSupportDateTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("./src/test/resources/commandata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String URL =  pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("user_name");
		String PASSWORD = pobj.getProperty("user_password");
		// run time polymorphisum // upcasting // overriding // read testscript data from excel file //
		// Generated random,
		Random random = new Random() ;
		int randomint = random.nextInt() ;  
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/testscriptdata1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(4);
		String LastName = row.getCell(2).toString()+randomint;
        
		// System.out.println(orgName);
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   
        //1  step login 
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
        //step 2 navigate to contact module 
		driver.findElement(By.linkText("Contacts")).click();

        //step 3  organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// variable Name
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		Thread.sleep(2000);
      //step 4 enter all  the details create new organizataion

		Date dateobj = new Date() ;
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd") ;
		String startDate = sim.format(dateobj) ;
		
		Calendar cal = sim.getCalendar() ;
		cal.add(Calendar.DAY_OF_MONTH, 30) ;
		String endDate = sim.format(cal.getTime()) ;
		
        // from variable  date  star   // start
		driver.findElement(By.name("support_start_date")).clear() ;
		driver.findElement(By.name("support_start_date")).sendKeys(startDate) ;
		// end date 
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);

		Thread.sleep(10000);
		// saved
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(2000);

		// verify the industries and type info
		String actstartDate = driver.findElement(By.xpath("//td[@id='mouseArea_Support Start Date']")).getText();
		if (actstartDate.contains(startDate)) {
			System.out.println(startDate + "infomation is verified  pass");
		} else {
			System.out.println(startDate + "infomation is  verified  fail");
		 }
		 String actendDate = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		 if (actendDate.contains(endDate)) {
			System.out.println(endDate + "infomation is verified  pass");
		 } else {
			System.out.println(endDate + "infomation is  verified  fail");
		  }
	    }
      }
