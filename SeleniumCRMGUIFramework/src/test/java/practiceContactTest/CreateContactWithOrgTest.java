package practiceContactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrgTest {

	// integration
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("./src/test/resources/commandata.properties");
		Properties pobj = new Properties() ;
		pobj.load(fis) ;
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

		Sheet sh = wb.getSheet("contact");
		Sheet sh1 = wb.getSheet("org");
		Row row = sh1.getRow(7);
		Row row1= sh.getRow(7);
		String orgName = row.getCell(2).toString() + randomint;
		String ContactLastName = row.getCell(3).getStringCellValue();

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
		driver.findElement(By.id("phone")).sendKeys(ContactLastName);
		// saved button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "is pass");
		} else {
			System.out.println(orgName + "is  fail");
		}
		// step 2 navigate to Contact 
		driver.findElement(By.linkText("Contacts")).click();

		// step 3 organization button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// step 4 enter all the details create new organizataion

		// from variable Name
		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		//   
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		// Last name
         // child window 
		Set<String> allid = driver.getWindowHandles();
		for (String id : allid)
		{
			driver.switchTo().window(id);
			String Curl = driver.getCurrentUrl();
			if (Curl.contains("module=Accounts"))
				break;
		}
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		// IMP to add orgName   
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		for (String pId : allid)
		{
			driver.switchTo().window(pId);
			String pUrl = driver.getCurrentUrl();
			if (pUrl.contains("Contacts&action")) 
				break;
		}
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String actLastName = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
		if ( actLastName.contains(ContactLastName)) 
		{
		System.out.println(ContactLastName + "infomation is verified  pass");
		} else 
		{
		System.out.println(ContactLastName+ "infomation is  verified  fail");
		}  
	   }
    }
