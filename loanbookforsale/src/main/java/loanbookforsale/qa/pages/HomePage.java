package loanbookforsale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loanbookforsale.qa.base.TestBase;

public class HomePage extends TestBase {
@FindBy(xpath=(""))
WebElement loanbooklogo;

public HomePage() {
	PageFactory.initElements(driver, this);
}

}
