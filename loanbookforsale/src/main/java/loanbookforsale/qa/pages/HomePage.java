package loanbookforsale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loanbookforsale.qa.base.Helper;
import loanbookforsale.qa.base.TestBase;

public class HomePage extends TestBase {

	// PageFactory

	@FindBy(xpath = "//img[@class='logo']")
	WebElement loanbooklogo;

	@FindBy(xpath = "//a[text()='Sign In']") 
	WebElement signInBtn;

	@FindBy(xpath = "//li[@class='menu-item-has-children']//child::a[@href='https://loanbookforsale.com.au/loanbook-opportunity?layout=full&type=loanbook']")
	WebElement loanbooks;

	@FindBy(xpath = "//div[@class='topbar bg-brand p-2 d-none d-sm-block']//ul//li//a[@title='LinkedIn']")
	WebElement linkdIntopbtn;

	@FindBy(xpath = "//div[@class='hero-search']")
	WebElement textFindLoanbookForSale;

	@FindBy(xpath = "//label[@for='cp-loanbook']")
	WebElement loanbookscheckbox;

	@FindBy(xpath = "//label[@for='cp-subaggregation']")
	WebElement subAggcontractorCheckBox;

	@FindBy(xpath = "//h2[text()='See Our Packages']")
	WebElement seeOurPacakgesText;

	@FindBy(xpath = "//input[@name='location']")
	WebElement location;

	@FindBy(xpath = "//span[@id='select2-minprice-container']")
	WebElement priceMin;

	@FindBy(xpath = "select2-maxprice-container")
	WebElement priceMax;

	@FindBy(xpath = "//span[@id='select2-ptypes-container']")
	WebElement aggregator;

	@FindBy(xpath = "//button[@class='btn search-btn']")
	WebElement searchResult;

	@FindBy(xpath = "//div[@class='pricing-wrap  platinum-pr recommended ']//a")
	WebElement stdad;

	@FindBy(xpath = "//div[@class='pricing-wrap  standard-pr ']//a")
	WebElement primiumad;

	@FindBy(xpath="//a[text()=' Place Ad']")
	WebElement placeAd;

	@FindBy(xpath="//a[text()=' Contact Us ']")
	WebElement contacUsBtn;

	// Initializing the page objects

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Page Actions :-

	public String validateHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyLogoOfThePage() {
		return loanbooklogo.isDisplayed();
	}

	public boolean stdadbtn() {
		return stdad.isDisplayed();

	}

	public boolean priumiumadbtn() {

		return primiumad.isDisplayed();

	}

	public SignInPage signinbtn() {
		signInBtn.click();
		return new SignInPage();
	}
	public ContactUsPage clickOnContactUsPage(){
		contacUsBtn.click();
		return new ContactUsPage();
	}
	public PlaceAdPage	clickonplaceadbtn(){
		Helper helper=new Helper();
		helper.explicitWaitOnVisibility_Custom(driver, placeAd, 3);
		placeAd.click();
		return new PlaceAdPage();

	}
		
}
