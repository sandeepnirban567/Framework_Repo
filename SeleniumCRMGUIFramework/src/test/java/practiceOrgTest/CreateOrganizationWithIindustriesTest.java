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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIindustriesTest {

	

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
		Row row = sh.getRow(4);
		
		String orgName = row.getCell(2).toString() + randomint;
		String Energy= row.getCell(3).toString();
		String Press = row.getCell(4).toString();
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
		Thread.sleep(2000);
		
		WebElement wbsele1 = driver.findElement(By.name("industry"));
		Select sele = new Select(wbsele1);
	     sele.selectByValue(Energy);
		// exception 
	
 WebElement wbsele2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
		 //WebElement wbsele2 = driver.findElement(By.name("accounttype"));
		
    Select sele2 = new Select(wbsele2);
	sele2.selectByValue(Press);
  
  
	driver.findElement(By.name("button")).click();
	
	
// verify  the  industries and type info  
		String actInbdustries = driver.findElement(By.xpath("//td[@id='mouseArea_Industry']")).getText();
		if ( actInbdustries.contains(Energy)) {
			System.out.println(Energy+"       infomation is verified  pass");
		} else {
			System.out.println(Energy +"      infomation is  verified  fail");
		}  
		//verify thr type  
		String actType = driver.findElement(By.xpath("//td[@id='mouseArea_Type']")).getText();
		if ( actType.contains(Press)) {
			System.out.println(Press+"        infomation is verified  pass");
		} else {
			System.out.println(Press+"        infomation is  verified  fail");
		}  
//5 step // logout 
	
		driver.quit();

	}

}
