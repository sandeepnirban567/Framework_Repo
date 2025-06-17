package practiceBasic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AutoHealing {   
	
	@FindBy(name="user_name")   
    public WebElement Username;	
	
	@FindBy(name="user_password")
	public WebElement  Password;	
	
    @FindAll({ @FindBy(id="submitButto"), @FindBy(xpath="//input[@type='submit']")})
	private WebElement ele3;	
	
	@Test
	public void sampleTest() {
		
    WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8888/");
	AutoHealing s = PageFactory.initElements(driver,AutoHealing.class);
		 
	s.Username.sendKeys("admin");
	s.Password.sendKeys("admin"); 
	
	 s.ele3.click();
	
	}
  }
