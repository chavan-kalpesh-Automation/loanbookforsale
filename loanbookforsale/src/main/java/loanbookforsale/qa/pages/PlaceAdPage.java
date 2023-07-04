package loanbookforsale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loanbookforsale.qa.base.TestBase;

public class PlaceAdPage extends TestBase {

//PageFactory

@FindBy(xpath = "//input[@name='name']")
	WebElement titlefield;

@FindBy(xpath = "//input[@name='name']")
	WebElement contentield;

@FindBy(xpath = "//input[@name='name']")
	WebElement imagefield;

@FindBy(xpath = "//input[@name='name']")
	WebElement aggregatorfield;

@FindBy(xpath = "//input[@name='name']")
	WebElement categoryfield; 

@FindBy(xpath = "//input[@name='name']")
	WebElement locationfield;  
 
@FindBy(xpath = "//input[@name='name']")
	WebElement latifield; 

@FindBy(xpath = "//input[@name='name']")
	WebElement longifield; 
    
@FindBy(xpath = "//input[@name='name']")
	WebElement pricefield;  

@FindBy(xpath = "//input[@name='name']")
	WebElement loanbooksizefield; 
    
@FindBy(xpath = "//input[@name='name']")
	WebElement savebtn;  

public PlaceAdPage(){
	PageFactory.initElements(driver,this);

}
//Page Actions
public void verifyTitleofPage(){
	
}




}