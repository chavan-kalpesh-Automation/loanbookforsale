package loanbookforsale.qa.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loanbookforsale.qa.base.TestBase;
import loanbookforsale.qa.pages.PlaceAdPage;

public class PlaceAdPageTest extends TestBase {
PlaceAdPage placeadpage ;

public PlaceAdPageTest(){
    super();

}
@BeforeMethod
public void setup(){
    initialization();
    placeadpage = new  PlaceAdPage(); 
}

@Test
public void verifyPlaceAdPageTitle(){

}

}