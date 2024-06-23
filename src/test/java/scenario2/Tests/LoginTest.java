package scenario2.Tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest
{
  @Test
  public void loginTest() throws InterruptedException 
  {
	  lp.setLogin("Admin", "admin123");
	 
  }
}
