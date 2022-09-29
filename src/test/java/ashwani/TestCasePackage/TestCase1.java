package ashwani.TestCasePackage;

import java.io.IOException;




import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ashwani.Listeners.RerunnerTest;
import ashwani.YouTubeWebpagePackage.DefaultWebPage;
import ashwani.YouTubeWebpagePackage.SearchResultWebPage;

public class TestCase1 extends BaseTest {

	SearchResultWebPage searchResultWebPage;
	DefaultWebPage d;
	static WebDriver driver;

	
	@BeforeMethod(alwaysRun=true)
	public void Invoke() throws IOException {
	driver=	invokeBrowser();
	}
	
	@Test(groups="Smoke")	
	@Parameters({"user","pswd"})
	public void  playMusicOnYoutube(String user,String pswd) throws IOException, InterruptedException {
		System.out.println(user);
		System.out.println(pswd);
	//l.debug("Debugging Login Fuctionality");
	d=new DefaultWebPage(driver);
	d.playMusic();
	
	
	
	}
		
	

	@Test()	
	
	public void  playFrmSubscriptionTab() throws IOException, InterruptedException {

	d=new DefaultWebPage(driver);
	
	
	System.out.println();
	d.SelectLeftTabOptions(p.getProperty("LeftTabOption"));

	}

	
	
	@Test(priority=0)	
	public void  searchandPlay() throws IOException, InterruptedException {

	d=new DefaultWebPage(driver);

	Thread.sleep(3000);
	searchResultWebPage=d.searchAnything("Chaand taare");

	Thread.sleep(2000);
	searchResultWebPage.SelectResultAfterSearch("Chand Tare Phool");

	


	}
	
	

	
	@Test(retryAnalyzer=RerunnerTest.class,groups="Smoke")	
	public void  sortComments() throws IOException, InterruptedException {
	
	d=new DefaultWebPage(driver);

	Thread.sleep(3000);
	searchResultWebPage=d.searchAnything("Kal ho na ho");

	Thread.sleep(2000);
	searchResultWebPage.SelectResultAfterSearch("Title Track");
	javaScriptExecutorScrollBy(300,driver);
	searchResultWebPage.sortOutTheComment("Newest first");


	}
	
	@AfterMethod()
	public void close() {
		driver.close();	}
	
	
}
