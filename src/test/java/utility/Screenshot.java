package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot
{
	public static void getScreenShot(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir")+"//Screenshots//Orange-"+System.currentTimeMillis()+".png");
		
		try {
			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
