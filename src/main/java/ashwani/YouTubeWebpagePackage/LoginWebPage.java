package ashwani.YouTubeWebpagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginWebPage {

	
	
	
	
	
	
	
	WebDriver driver;
	public LoginWebPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
