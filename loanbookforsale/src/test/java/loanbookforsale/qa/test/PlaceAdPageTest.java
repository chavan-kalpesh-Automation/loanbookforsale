package loanbookforsale.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import loanbookforsale.qa.base.TestBase;
import loanbookforsale.qa.pages.HomePage;
import loanbookforsale.qa.pages.PlaceAdPage;
import loanbookforsale.qa.pages.SignInPage;
import loanbookforsale.qa.util.TestUtil;

public class PlaceAdPageTest extends TestBase {
PlaceAdPage placeadpage ;
HomePage homepage;
SignInPage signInPagee;
TestUtil testutil;

String sheetName="loanbookforsale";

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
        String placeAdPageTitle =placeadpage.verifyPlaceAdPageTitle();
        Assert.assertEquals(placeAdPageTitle,"Add a Loanbook","Place Ad Page Title Not Matched");
   
}
@DataProvider
public Object[][] getAddaLaonbookdata(){
    Object data[][]=TestUtil.getTestData("Add a Loanbook data");
    return data;
}

@Test (priority=1,dataProvider="getAddaLaonbookdata")
public void validateCreateAddLoanbook(String Title,String Content,String Aggregator,String Location,String Latitude,String Longitude,String Price,String LoanBookSize ){
    
    placeadpage.addLoanbookForm(Title, Content, Aggregator, Location, Latitude, Longitude, Price, LoanBookSize);    

}

@AfterMethod
public void tearDown(){
    driver.quit();
}

}