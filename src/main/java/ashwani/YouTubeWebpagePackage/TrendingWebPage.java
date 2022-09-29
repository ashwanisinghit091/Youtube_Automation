package ashwani.YouTubeWebpagePackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ashwani.TestCasePackage.BaseTest;

public class TrendingWebPage extends BaseTest {
	
	
	
	WebDriver driver;
	JavascriptExecutor js;
	TrendingWebPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(css="ytd-video-renderer[class*=\"ytd-expanded-shelf-contents-renderer\"] div ytd-thumbnail")List<WebElement> TrendingAtWe;
	
	public void TrendingAt(int index) throws IOException, InterruptedException {
		System.out.println(index);
	
		//javaScriptExecutorScrollBy(600,driver);
		//elementToBeClickable(TrendingAtWe.get(index-1),driver);
		TrendingAtWe.get(index-1).click();
		//TrendingAtWe.stream().filter(s->s.getText().equalsIgnoreCase("")).forEach(s->s.click(););
	}


}
