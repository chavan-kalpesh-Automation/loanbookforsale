package loanbookforsale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import loanbookforsale.qa.base.TestBase;

public class ContactUsPage extends TestBase{
    @FindBy (xpath="")
    WebElement contactustxt;

    @FindBy (xpath="//input[@name='name']")
    WebElement namefield;

    @FindBy (xpath="//input[@name='email']")
    WebElement emailfield;

    @FindBy (xpath="//input[@name='subject']")
    WebElement subjectfield;

    @FindBy (xpath="//input[@name='phone']")
    WebElement phonenumberfield;

    @FindBy(xpath="//textarea[@name='content']")
    WebElement messagefield;

    @FindBy (xpath="//div[@class='form-actions form-group']")
    WebElement sendmsgbtn;
    

//Initializing Page Object 
    public ContactUsPage(){
        PageFactory.initElements(driver,this);
    }    

//Page Actions
    public String  validateContactUsPageTitle(){
        return driver.getTitle();
    }
    public void validateContactUsForm(String name,String email,String subject,String phone,String message){
        namefield.sendKeys(name);
        emailfield.sendKeys(email);
        subjectfield.sendKeys(subject);
        phonenumberfield.sendKeys(phone);
        messagefield.sendKeys(message);

    }
}
