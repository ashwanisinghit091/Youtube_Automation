package ashwani.YouTubeWebpagePackage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultWebPage {

	
	
	
	WebDriver driver;
public SearchResultWebPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}
	
	
@FindBy(css="ytd-video-renderer[class*=\"ytd-item-section-renderer\"]") List<WebElement> searchResultWebPageWe;
	@FindBy(css="span[id=\"sort-menu\"]") WebElement ClicksortCommentWe;
	@FindBy(css="div[class=\"item style-scope yt-dropdown-menu\"]") List<WebElement> selectDesiredsortCommentoptionWe;
    public void SelectResultAfterSearch(String text) throws InterruptedException {
		
	searchResultWebPageWe.stream().filter(s->s.getText().contains(text)).forEach(s->s.click());
	Thread.sleep(2000);

	}  
    
    public void sortOutTheComment(String text) throws InterruptedException {
		
    
    	    	ClicksortCommentWe.click();
    	    	selectDesiredsortCommentoptionWe.stream().filter(s->s.getText().equalsIgnoreCase(text)).forEach(s->s.click());
    	    		
    	    

    	} 
	
   
}
