package loanbookforsale.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import loanbookforsale.qa.base.TestBase;
import loanbookforsale.qa.pages.HomePage;
import loanbookforsale.qa.pages.PlaceAdPage;
import loanbookforsale.qa.pages.SignInPage;

public class PlaceAdPageTest extends TestBase {
PlaceAdPage placeadpage ;
HomePage homepage;
SignInPage signInPagee;
public PlaceAdPageTest(){
    super();

}
@BeforeMethod
public void setup() throws InterruptedException{
    initialization();
    homepage = new HomePage();
	signInPagee = homepage.signinbtn();
    homepage = signInPagee.login(prop.getProperty("username"), prop.getProperty("password"));
    
    placeadpage = new  PlaceAdPage(); 
    placeadpage=homepage.clickonplaceadbtn();

}

@Test
public void verifyPlaceAdPageTitleTest(){
        String placeAdPageTitle =placeadpage.verifyPlaceAsPageTitle();
        Assert.assertEquals(placeAdPageTitle,"Add a Loanbook","Place Ad Page Title Not Matched");
   
}
@AfterMethod
public void tearDown(){
    driver.quit();
}

}