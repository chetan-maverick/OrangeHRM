package scenario2.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By username_loc=By.name("username");
	private By pass_loc=By.name("password");
	private By button_loc=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	}
	
	public void setLogin(String username, String password)
	{
		
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(username_loc));
        usernameField.sendKeys(username);
        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(pass_loc));
        passwordField.sendKeys(password);
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(button_loc));
        loginButton.click();
	}

	public void activeUser(String user)
	{
		if(user.equalsIgnoreCase("vinay")) {
			System.out.println("Vinay has started the work");
		}
		else {
			System.out.println("other user is working");
		}
	}
	
}
