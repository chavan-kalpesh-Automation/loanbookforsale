package loanbookforsale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loanbookforsale.qa.base.TestBase;

public class LoanbooksPage extends TestBase{
	@FindBy(xpath = "//div//h2[text()='Buy a LoanBook']")
	WebElement buyloanbookpagetitle;

	@FindBy(name = "location")
	WebElement location;
	@FindBy(xpath = "//select[@id='minprice']")
	WebElement minprice;

	@FindBy(xpath = "//select[@id='maxprice']")
	WebElement maxprice;

	@FindBy(xpath = "//select[@id='ptypes']")
	WebElement aggregator;

	@FindBy(xpath = "//a[@class='ad-search']")
	WebElement morefilterbtn;

	@FindBy(xpath = "//button[@class='btn search-btn']")
	WebElement searchbtn;

	@FindBy(id = "select2-minarea-container")
	WebElement loanbooksizemin;

	@FindBy(id = "select2-maxarea-container")
	WebElement loanbooksizemax;

	@FindBy(id = "select2-facilities-container")
	WebElement loantype;

	@FindBy(id = "select2-franchise_new-container")
	WebElement franchise;
	
	// Initialization of page Object
	public LoanbooksPage() {
		PageFactory.initElements(driver, this);
	}
	//Page Actions
	
	public String validateloanbookspagetitle() {
		return driver.getTitle();
		
	}
	public boolean verifyloanbookpagetitletext() {
		return buyloanbookpagetitle.isDisplayed();
	}
	
	
}
