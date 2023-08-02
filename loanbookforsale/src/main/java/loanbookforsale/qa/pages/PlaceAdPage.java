package loanbookforsale.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import loanbookforsale.qa.base.Helper;
import loanbookforsale.qa.base.TestBase;

public class PlaceAdPage extends TestBase {

//PageFactory

@FindBy(xpath = "//input[@name='name']")
	WebElement titlefield;

@FindBy(xpath="//div[@class='ck ck-editor__top ck-reset_all']")
WebElement contenttoolbar;

@FindBy(xpath = "//div//p[@class='ck-placeholder']")
	WebElement contentield;
//div[@class='ck ck-editor__main']
@FindBy(xpath = "//div[@id='multiple-upload']")
	WebElement imagefield;

@FindBy(xpath = "//label[text()='Aggregator']")
	WebElement aggregatorfield;

@FindBy(xpath = "//span[@id='select2-type_id-container']")
	WebElement categoryfield; 

@FindBy(xpath = "//div//input[@name='location']")
	WebElement locationfield;  
 
@FindBy(xpath = "//div//input[@name='latitude']")
	WebElement latifield; 

@FindBy(xpath = "//div//input[@name='longitude']")
	WebElement longifield; 
    
@FindBy(xpath = "//div//input[@name='price']")
	WebElement pricefield;  

@FindBy(xpath = "//div//input[@name='loan_book_size']")
	WebElement loanbooksizefield; 
@FindBy(xpath="//div//label[text()='Investor %']")
	WebElement inverstortext;
    
@FindBy(xpath = "//div//button[@name='submit']")
	WebElement savebtn;  

	//initialization of page objects
public PlaceAdPage(){
	PageFactory.initElements(driver,this);

}

//Page Actions
public String  verifyPlaceAdPageTitle(){
	
return driver.getTitle();
}

public void addLoanbookForm(String title,String content,String aggregator,String location,String lat,String longi,String price,String lbsize){

	

	titlefield.sendKeys(title);

		Helper help =new Helper();
		help.explicitWaitOnVisibility_Custom(driver, contenttoolbar, 10);

		JavascriptExecutor  javascript=(JavascriptExecutor )driver;
		javascript.executeScript("arguments[0].scrollIntoView(true);", contenttoolbar );
	
	contentield.sendKeys(content);

		javascript.executeScript("arguments[0].scrollIntoView(true);",imagefield);
		help.explicitWaitOnVisibility_Custom(driver, aggregatorfield, 20);
		Select select=new Select(driver.findElement(By.name("category_id")));
		// select.selectByValue(aggregator);
		select.selectByVisibleText(aggregator);

		javascript.executeScript("arguments[0].scrollIntoView(true);", locationfield );
		help.explicitWaitOnVisibility_Custom(driver, locationfield, 10);
		
	
	
	locationfield.sendKeys(location);

		javascript.executeScript("arguments[0].scrollIntoView(true);", pricefield );

	latifield.sendKeys(lat);

	longifield.sendKeys(longi);

	pricefield.sendKeys(price);

		help.explicitWaitOnVisibility_Custom(driver, loanbooksizefield, 10);

	loanbooksizefield.sendKeys(lbsize);

		javascript.executeScript("arguments[0].scrollIntoView(true);", inverstortext );

		help.explicitWaitOnVisibility_Custom(driver, savebtn, 10);


}





}