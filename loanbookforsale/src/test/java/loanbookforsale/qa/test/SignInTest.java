package loanbookforsale.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loanbookforsale.qa.base.TestBase;
import loanbookforsale.qa.pages.HomePage;
import loanbookforsale.qa.pages.SignInPage;

public class SignInTest extends TestBase {

	SignInPage signInPagee;
	HomePage homepage;

	public SignInTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();

		signInPagee = new SignInPage();

		homepage = new HomePage();
		signInPagee = homepage.signinbtn();
	}

	// TestCases
	@Test(priority = 1)
	public void signInPageTitleTest() {
		String title = signInPagee.validateSignPageTitle();
		Assert.assertEquals("Login", title, "Title of SignInPage Not Matched to Actual Title");
	}

	@Test(priority = 2)
	public void loginTest() {
		homepage = signInPagee.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	@Test 
	public void afterLoginUsrNameTest() {
		homepage = signInPagee.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(signInPagee.validateUsrNameLable());
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
