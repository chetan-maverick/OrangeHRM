package scenario2.pages;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By leftNav_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li");
	private By admin_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]");
	private By searchBox_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
	private By searchButton_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
	private By username_result=By.xpath("//div[@class='oxd-table-card']/div/div[2]/div");
	private By userRole_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]");
	private By adminRoleOption_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/span");
	private By roleResult_loc=By.xpath("//div[@class='oxd-table-card']/div/div[2]/div");
	private By status_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]");
	private By statusresult_loc=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div");

	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
	}		
	public void getOptions()
	{
		
		        WebElement leftOptions = driver.findElement(leftNav_loc);
		        wait.until(ExpectedConditions.visibilityOf(leftOptions));
				java.util.List<WebElement> optionsList = driver.findElements(leftNav_loc);
				for(WebElement option: optionsList)
				{
					System.out.print(option.getText()+",");
				}
				
				WebElement adminlink=driver.findElement(admin_loc);
				adminlink.click();
				
				System.out.println("Admin page opened successfully");
				System.out.println();
	}	
	public void searchUserName(String username) throws InterruptedException
	{
		driver.findElement(searchBox_loc).sendKeys(username);
		driver.findElement(searchButton_loc).click();
		System.out.println("List by Username found:");
		java.util.List<WebElement> result=driver.findElements(roleResult_loc);
		for(WebElement li:result)
		{
			
			System.out.println(" Record: "+li.getText());
				
		}
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println();
	}
	
	public void searchByUserRole() throws InterruptedException
	{
		driver.findElement(userRole_loc).click();
		driver.findElement(adminRoleOption_loc).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).getText();
		driver.findElement(searchButton_loc).click();
		java.util.List<WebElement> result=driver.findElements(roleResult_loc);		
		int count=0;
		System.out.println("List by UserRole found:");
		for(WebElement li:result)
		{
			count++;
			System.out.println(count+" record: "+li.getText());
			
			
		}
		System.out.println("Total Record found: "+count);
		driver.navigate().refresh();
		System.out.println();
	}	
	public void searchByUserStatus()
	{
		driver.findElement(status_loc).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]/span")).click();
		
		java.util.List<WebElement> result=driver.findElements(statusresult_loc);
		int count=0;
		System.out.println("Result by userStaus: ");
		for(WebElement li: result)
		{
			count++;
			System.out.println(count+ " record:"+li.getText());
		}
		System.out.println("Total Record found: "+count);
	}


	
	

}
