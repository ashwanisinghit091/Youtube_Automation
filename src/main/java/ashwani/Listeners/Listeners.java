package ashwani.Listeners;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ashwani.TestCasePackage.BaseTest;



public class Listeners extends BaseTest implements ITestListener{
	String 	path;
WebDriver driver;
ExtentTest test;
String TestName;
	ThreadLocal<ExtentTest> th;
	ExtentReports exr;
	public void onTestStart(ITestResult result) {
		 System.out.println("reorptwa");
		exr=getExtentReport(result.getMethod().getMethodName());
		 System.out.println("reorptwa1");
		 test=exr.createTest(result.getMethod().getMethodName());
		 System.out.println("reorptwa2");
		th=new ThreadLocal<ExtentTest>();
	th.set(test);
	
		
		
	}

	

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		TestName=result.getMethod().getMethodName();
		 System.out.println("reorptwa3");
		 try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	path=	getScreenshot(driver,TestName);
	 System.out.println("reorptwa4");
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th.get().addScreenCaptureFromPath(path,TestName); 
		 
		 
			
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		TestName=result.getMethod().getMethodName();
		 try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	path=	getScreenshot(driver,TestName);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th.get().addScreenCaptureFromPath(path,TestName); 
		 
		 
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		exr.flush();
		 System.out.println("reorptwa5");
	}

}
