package ashwani.TestCasePackage;

import java.io.File;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ashwani.ReusableMethods.Reusable;


public class BaseTest extends Reusable {

	public  WebDriver driver;
	Properties p;
	String BrowserName;
	public WebDriver  invokeBrowser() throws IOException {
		p=getDataFromPropertyFile();
		
		BrowserName=System.getProperty("Browser")!=null?System.getProperty("Browser"):p.getProperty("Browser");
		//BrowserName= "Edgedriver";
		if(BrowserName.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
		}
		
		
		else if(BrowserName.equalsIgnoreCase("Edgedriver")) {
			System.setProperty("webdriver.edge.driver", "E:\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.get(p.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
		
			}
			
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.geckodriver.driver", "E:\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(p.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			
			}
			
		
		
		return driver;
		
		
		
		
	}
	
	
	public String getScreenshot(WebDriver driver,String TestcaseName) throws IOException {
		TakesScreenshot t=(TakesScreenshot)driver;
		
File screenShot= t.getScreenshotAs(OutputType.FILE);
//System.getProperty("user.dir")+"\\ScreenShots\\Screen.png"
File path=new File(System.getProperty("user.dir")+"\\ScreenShots\\"+TestcaseName+".png");
FileUtils.copyFile(screenShot,path);
return System.getProperty("user.dir")+"\\ScreenShots\\"+TestcaseName+".png";
		
		
		
	}
	
	
	public ExtentReports getExtentReport(String Test) {
	
		File path=new File("D:\\workspace100\\Youtube_Automation\\test-output\\index.html");

		
		ExtentSparkReporter ex=new ExtentSparkReporter(path);

		ex.config().setDocumentTitle("Yotube Testing Report");
	
		ex.config().setReportName("Youtube Functionality Testing");

		//ex.config().setTimeStampFormat("DD/MON/YY");
	
		//ex.config().setTheme(theme);
		//ex.config().setReportName("Ashwani Singh");

		ExtentReports exr=new ExtentReports();

		exr.attachReporter(ex);
	
		return exr;
		
	}
	

	
	
}
