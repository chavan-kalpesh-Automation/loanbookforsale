package loanbookforsale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loanbookforsale.qa.base.TestBase;

public class SignInPage extends TestBase {

	@FindBy(xpath = "//div[@class='modal-body']//h2")
	WebElement loginText;

	@FindBy(xpath = "//input[@id='email']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;

	@FindBy(xpath = "//div[@class='form-group']//button")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@class='link']")
	WebElement forgotPassBtn;

	@FindBy(xpath = "//a[@class='link d-block d-sm-inline-block text-sm-left text-center']")
	WebElement register;

	@FindBy(xpath = "")
	WebElement ref;

	// Initialization of page Object
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Actions

	public String validateSignPageTitle() {
		return driver.getTitle();

	}

	public boolean verifyLoginText() {
		loginText.isDisplayed();
		return true;

	}
}
