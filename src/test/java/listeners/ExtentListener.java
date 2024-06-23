package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentListener implements ITestListener
{

	ExtentReports extent=ExtentManager.getInstance();	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) 
	{
		ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName());

		parentTest.set(extentTest);
	}
	public void onTestSuccess(ITestResult result) 
	{
		parentTest.get().pass("Test Passed");
	}
	public void onTestFailure(ITestResult result) 
	{

		parentTest.get().fail("Test Failed "+result.getThrowable().getMessage());

	}
	public void onTestSkipped(ITestResult result)
	{
		parentTest.get().skip("Test Skipped "+result.getThrowable().getMessage());

	}

	public  void onFinish(ITestContext context) 
	{
		extent.flush();

	}


}
