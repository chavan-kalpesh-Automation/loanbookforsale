package loanbookforsale.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loanbookforsale.qa.base.TestBase;
import loanbookforsale.qa.pages.HomePage;
import loanbookforsale.qa.pages.SignInPage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	SignInPage signIn;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {

		initialization(); // browser launching
		homepage = new HomePage();

	}

//Test Cases
	@Test
	public void homePageTitleTest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Loan Book For Sale - buy a trail book",
				"Home Page Title Does Not match with actual ");
	}

	@Test
	public void loanbookLogoTest() {
		boolean logo = homepage.verifyLogoOfThePage();
		Assert.assertTrue(logo);

	}

	@Test(priority = 3)
	public void signInBtnTest() {
		signIn = homepage.signinbtn();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
