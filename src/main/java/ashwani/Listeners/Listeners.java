package ashwani.Listeners;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import ashwani.TestCasePackage.BaseTest;



public class Listeners extends BaseTest implements ITestListener{
	
	
	
	
	
String TestName;	
	
	
	
	
	
	
	
	
	String 	path;
WebDriver driver;
ExtentTest test;

	ThreadLocal<ExtentTest> th;
	ExtentReports exr;
	public void onTestStart(ITestResult result) {
	
		
	
		exr=getExtentReport(result.getMethod().getMethodName());
	
	
		 test=exr.createTest(result.getMethod().getMethodName());
		
		th=new ThreadLocal<ExtentTest>();
		
	th.set(test);

		
		
	}

	

	public void onTestSuccess(ITestResult result) {
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
	
	}

}
