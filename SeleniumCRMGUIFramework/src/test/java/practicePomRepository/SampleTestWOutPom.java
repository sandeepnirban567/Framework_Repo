package practicePomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWOutPom {

	public static void main(String[] args) {
	// get stale element reference 	
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		WebElement ele1 = driver.findElement(By.name("user_name"));
		WebElement ele2 = driver.findElement(By.name("user_password"));
		WebElement ele3 = driver.findElement(By.id("submitButton"));
		
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		// referece page------   address of element changed in back end 
		driver.navigate().refresh();
		ele3.click();
	}

}
