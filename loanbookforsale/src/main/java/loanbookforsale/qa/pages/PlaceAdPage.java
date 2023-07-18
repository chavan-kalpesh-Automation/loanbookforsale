package loanbookforsale.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

@FindBy(xpath = "//span[@id='select2-category_id-container']")
	WebElement aggregatorfield;

@FindBy(xpath = "//span[@id='select2-type_id-container']")
	WebElement categoryfield; 

@FindBy(xpath = "//input[@name='location']")
	WebElement locationfield;  
 
@FindBy(xpath = "//div//input[@name='latitude']")
	WebElement latifield; 

@FindBy(xpath = "//div//input[@name='longitude']")
	WebElement longifield; 
    
@FindBy(xpath = "//div//input[@name='price']")
	WebElement pricefield;  

@FindBy(xpath = "//div//input[@name='loan_book_size']")
	WebElement loanbooksizefield; 
    
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

public void addLoanbookForm(String title,String content,String location,String lat,String longi,String price,String lbsize){

	

	titlefield.sendKeys(title);

		Helper help =new Helper();
		help.explicitWaitOnVisibility_Custom(driver, contenttoolbar, 10);

		JavascriptExecutor  javascript=(JavascriptExecutor )driver;
		javascript.executeScript("arguments[0].scrollIntoView(true);", contenttoolbar );
	
	contentield.sendKeys(content);
	
		javascript.executeScript("arguments[0].scrollIntoView(true);", location );
	locationfield.sendKeys(location);
// 	longifield.sendKeys(lat);
// 	longifield.sendKeys(longi);
// //for scrolling upto price locator 
// 		JavascriptExecutor  javascript1=(JavascriptExecutor )driver;
// 		javascript1.executeScript("arguments[0].scrollIntoView(true);", pricefield );

// pricefield.sendKeys(price);
// loanbooksizefield.sendKeys(lbsize);

}





}