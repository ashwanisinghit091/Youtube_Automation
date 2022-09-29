package ashwani.TestCasePackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ashwani.Listeners.RerunnerTest;
import ashwani.ReusableMethods.Reusable;
import ashwani.YouTubeWebpagePackage.DefaultWebPage;
import ashwani.YouTubeWebpagePackage.ExplorerWebPage;
import ashwani.YouTubeWebpagePackage.TrendingWebPage;

public class TestCase2  extends BaseTest{
	
	
	DefaultWebPage d;
	WebDriver driver;
	
	ExplorerWebPage ExplorerWebPageref;
	
	TrendingWebPage TrendingWebPageref;
	
	@BeforeMethod(alwaysRun=true)
	public void Invoke() throws IOException {
	driver=	invokeBrowser();
	}
	
	
	@Test(retryAnalyzer=RerunnerTest.class)
	public void getMeTrending() throws IOException {
		d=new DefaultWebPage(driver);
		Reusable r=new Reusable();
		ExplorerWebPageref=(ExplorerWebPage) d.SelectLeftTabOptions(r.getJasonData().get(0).get("EXPLORE"));
		
		ExplorerWebPageref.SelectOptionFromExploreTab(r.getJasonData().get(0).get("TRENDING"));
	}

	
	
	
	
	@Test()
	public void getMeLive() throws IOException, NumberFormatException, InterruptedException {
		d=new DefaultWebPage(driver);
		Reusable r=new Reusable();
		ExplorerWebPageref=(ExplorerWebPage) d.SelectLeftTabOptions(r.getJasonData().get(0).get("EXPLORE"));
		
		 TrendingWebPageref=ExplorerWebPageref.SelectOptionFromExploreTab(r.getJasonData().get(0).get("TRENDING"));
		 TrendingWebPageref.TrendingAt(Integer.parseInt(r.getJasonData().get(0).get("TrendingAt")));
	}
	
	@AfterMethod()
	public void close() {
		driver.close();
	}

}
