package ashwani.YouTubeWebpagePackage;

import java.util.List;
import java.util.stream.Stream;

import org.bouncycastle.crypto.tls.SSL3Mac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ashwani.ReusableMethods.Reusable;





public class DefaultWebPage extends Reusable{
	Object o;
	WebDriver driver;
public DefaultWebPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}
	
	
	
	@FindBy(css="ytd-rich-item-renderer[class=\"style-scope ytd-rich-grid-row\"] div[id=\"content\"]") List<WebElement> VideosWe;
	
	@FindBy(css="a[id=\"endpoint\"] tp-yt-paper-item yt-formatted-string") List<WebElement> LeftTabOptions;
	@FindBy(css="div[class=\"glow-toaster-footer\"] span:first-of-type span[class=\"a-button-inner\"] input") WebElement locationwe;
	
	
	@FindBy(css="div[id=\"search-input\"] input") WebElement searchWe;
	@FindBy(css="ytd-video-renderer[class*=\"ytd-item-section-renderer\"]") List<WebElement> searchedOptionsWe;
	
	@FindBy(css="div[id=\"main\"]") WebElement GoogleInfoAlert;
	@FindBy(css="div[id=\"main\"] div yt-button-renderer[id=\"dismiss-button\"]") WebElement GoogleInFoDismisso;
	public LoginWebPage playMusic() throws InterruptedException {

	System.out.println(VideosWe.get(0).getText());
	
		//driver.findElement(By.linkText("Sign in securely")).click();
        
        if(GoogleInfoAlert.isDisplayed()) {
        	GoogleInFoDismisso.click();
        }
     
		VideosWe.stream().filter(s->s.getText().contains("Kesariya")).forEach(s->s.click());
		return new LoginWebPage(driver);
	}
	
	
	public Object SelectLeftTabOptions(String Text) {
		LeftTabOptions.stream().filter(s->s.getText().equalsIgnoreCase(Text)).forEach(s->s.click());
		if(Text.equalsIgnoreCase("Subscription")) {
			 o=new SubscriptionWebPage();

		}
		
		if(Text.equalsIgnoreCase("EXPLORE")) {
			 o=new ExplorerWebPage(driver);

		}
		return o;
		
	}
	
	
	public SearchResultWebPage searchAnything(String Text) throws InterruptedException {
	
		searchWe.click();
	
		searchWe.sendKeys(Text);
	Thread.sleep(1000);
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).build().perform();
	
return new SearchResultWebPage(driver);
		
		
	}
	
	
	
}
