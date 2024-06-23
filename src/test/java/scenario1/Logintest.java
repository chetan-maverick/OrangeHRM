package scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.Screenshot;

public class Logintest 
{
	public static WebDriver driver;
	

	@Test(dataProvider ="excelData",dataProviderClass = DataSet.class)
	public void login(String username, String pass) throws InterruptedException 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebElement userNameBox=driver.findElement(By.name("username"));
		userNameBox.sendKeys(username);
		
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(2000);
		Screenshot.getScreenShot(driver);
		String expUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actUrl=driver.getCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
		driver.quit();
	}
}
