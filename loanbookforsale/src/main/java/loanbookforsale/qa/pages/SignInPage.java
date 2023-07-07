package loanbookforsale.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import loanbookforsale.qa.base.Helper;
import loanbookforsale.qa.base.TestBase;

public class SignInPage extends TestBase {

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement signInBtn;

	@FindBy(xpath = "//div[@class='modal-body']//h2")
	WebElement loginText;

	@FindBy(xpath = "//input[@id='email']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;

	@FindBy(xpath = "//div[@id='app']//button[@type='submit']")
	WebElement loginBtn;
	//div[@class='form-group']//button[@type='submit']

	@FindBy(xpath = "//a[@class='link']")
	WebElement forgotPassBtn;

	@FindBy(xpath = "//a[@class='link d-block d-sm-inline-block text-sm-left text-center']")
	WebElement register;

	@FindBy(xpath = "//li[@class='login-item']//span")
	WebElement loginUsrNameLable;

	@FindBy(xpath = "//div[@class='rc-anchor-normal-footer']")
	WebElement reCaptchalocator;

	// Initialization of page Object
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Actions

	public String validateSignPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd)  {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
	
		// If login button not visible on web page then we have to scroll web page up-to
		JavascriptExecutor  js=(JavascriptExecutor )driver;
		js.executeScript("arguments[0].scrollIntoView(true);", loginBtn );

		Helper help =new Helper();
		help.explicitWaitOnVisibility_Custom(driver, reCaptchalocator, 4);

		loginBtn.click();
		
		return new HomePage();
	}

	public boolean validateUsrNameLable() {
		return loginUsrNameLable.isDisplayed();
	}


}
