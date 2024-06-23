package scenario2.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import scenario2.pages.AdminPage;
import scenario2.pages.LoginPage;

public class BaseTest {
	
	public static WebDriver driver;
	public static LoginPage lp;
	public static AdminPage ap;
	
	
	
  @BeforeSuite
  public void setUpBrowser() 
  {
	  
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		lp=new LoginPage(driver);
		ap=new AdminPage(driver);
				
  }
}
