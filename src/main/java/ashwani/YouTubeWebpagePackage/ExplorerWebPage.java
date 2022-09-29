package ashwani.YouTubeWebpagePackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplorerWebPage {
	WebDriver driver;
public 	ExplorerWebPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	
	
	
	@FindBy(id="destination-content-root") List<WebElement>  exploreOptionsWe; 
	
	
	
	public TrendingWebPage SelectOptionFromExploreTab(String Option) {
		System.out.println(Option);
		exploreOptionsWe.stream().filter(s->s.getText().equalsIgnoreCase(Option)).forEach(s->s.click());
		//System.out.println(exploreOptionsWe.get(0).getText());
		return new TrendingWebPage(driver);
	}

}
