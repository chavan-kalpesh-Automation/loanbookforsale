package loanbookforsale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import loanbookforsale.qa.base.TestBase;

public class PricingPage extends TestBase {
	@FindBy(xpath = "//a[contains(@href,'pricing')]")
	WebElement pricingtitlebtn;
	
	
	
	
}
