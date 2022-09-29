package ashwani.ReusableMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

import org.openqa.selenium.support.ui.FluentWait;




public class Reusable {
	
	WebDriver driver;
	WebDriverWait wait;
	File f;

	
	public void visibilityOfWebElement(WebElement Element) {
	 wait=new WebDriverWait(driver,20);
	 wait.until(ExpectedConditions.visibilityOf(Element ));
	
	}
	
	

	public void inVisibilityOfWebElement(WebElement Element) {
	 wait=new WebDriverWait(driver,20);
	 wait.until(ExpectedConditions.invisibilityOf(Element ));
	
	}

	public void elementToBeClickable(WebElement Element,WebDriver driver) {
		 wait=new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.elementToBeClickable(Element));
		
		}
	
	public void elementToBeSelected(WebElement Element) {
		 wait=new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.elementToBeSelected(Element));
		
		}
	
	
	
	public List<HashMap<String,String>>  getJasonData() throws IOException {
		
	
		String jasonData=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\ashwani\\DataReaderPackage\\JasonDataFile.jason"),StandardCharsets.UTF_8);
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> jasonContent=mapper.readValue(jasonData,new  TypeReference<List<HashMap<String,String>>>(){});
	return jasonContent;
	
	}
	
	public Properties getDataFromPropertyFile() throws IOException {
		
		File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\ashwani\\DataReaderPackage\\DataFile.properties");
		FileInputStream fs=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fs);
		return p;
	}
	
	public void FluentWait(WebDriver driver,final String locator) {

		//Wait<WebDriver> w=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
	
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		wait.until(new Function<WebDriver,WebElement>(){
			 public WebElement apply(WebDriver driver) {
				 
					return driver.findElement(By.xpath(locator));	}
		
		});
		 }
	

	public void CheckFileExistence(String path)   {
		
		try {
		 f=new File(path);}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(f.exists());
		
	}
	
	
	public void  UploadFile(String FileName) throws AWTException, IOException {
		Properties p=getDataFromPropertyFile();
		String path=p.getProperty("UploadFilePath");
		StringSelection s=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void javaScriptExecutorScrollBy(int value,WebDriver driver) {
		System.out.println(value);
		 JavascriptExecutor jv= (JavascriptExecutor)driver;
 	    jv.executeScript("window.scrollBy(0,"+value+")");
 	   
	}
}
