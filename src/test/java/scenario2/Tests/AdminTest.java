package scenario2.Tests;

import org.testng.annotations.Test;

public class AdminTest extends BaseTest
{
  @Test
  public void adminTest() throws InterruptedException 
  {
	   //lp.setLogin(null, null);g
	  ap.getOptions();
	  ap.searchUserName("admin");
	  ap.searchByUserRole();
	  ap.searchByUserStatus();
  }
}
