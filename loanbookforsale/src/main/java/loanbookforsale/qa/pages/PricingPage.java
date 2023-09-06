package loanbookforsale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import loanbookforsale.qa.base.TestBase;

public class PricingPage extends TestBase {
	@FindBy(xpath = "//a[contains(@href,'pricing')]")
	WebElement pricingtitlebtn;
	
	@FindBy(xpath="//h2[text()='See Our Packages']")
	WebElement pricepgtitle;

	@FindBy(xpath="//h4[text()='Standard ad']")
	WebElement stdad;

	@FindBy(xpath="//h4[text()='Premium ad']")
	WebElement preminumad;
			
	
	
	
}
