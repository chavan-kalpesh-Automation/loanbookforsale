package loanbookforsale.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loanbookforsale.qa.base.Helper;
import loanbookforsale.qa.base.TestBase;
import loanbookforsale.qa.pages.BuyaLoanbooksPage;
import loanbookforsale.qa.pages.HomePage;
import loanbookforsale.qa.pages.SignInPage;

public class BuyaLoanbooksPageTest extends TestBase {

	BuyaLoanbooksPageTest loanbook;
	BuyaLoanbooksPage buyaloanbbokpg;
	HomePage homepg;
	SignInPage signinpg;
	Helper helper;
	public BuyaLoanbooksPageTest() {
		super();
		
	}
@BeforeMethod
public void setup(){
	initialization();
	homepg =new HomePage();
	signinpg=homepg.signinbtn();
	homepg=signinpg.login(prop.getProperty("username"), prop.getProperty("password"));
	buyaloanbbokpg =homepg.clickonBuyaLoanBookbtn();
}

//Test Cases
	@Test
	public void loanbookspagetitlePageTest(){
		String title=buyaloanbbokpg.validateloanbookspagetitle();
		Assert.assertEquals(title,"Loanbook & Opportunity");
			}

	@Test
	public void loanbookpagetitleTest(){
		boolean istitleDisplay=buyaloanbbokpg.verifyloanbookpagetitletext();
		if(istitleDisplay){
			System.out.println("Test Case Pass ,Loanbook Page Text Displayed.");
		}
		else{
			System.out.println("Test Case Failed :Loanbook Page Text Not Dispalyed.");
		}
	}
	@Test
	public void buyaLoanbookSearchTest(){
			buyaloanbbokpg.buyloanbooksearch(prop.getProperty("location"), prop.getProperty("minprice"), prop.getProperty("maxprice"), prop.getProperty("aggregator"));
	}
	

	@BeforeMethod
	public void teardown(){
		driver.quit();

	}
	}


	
	

