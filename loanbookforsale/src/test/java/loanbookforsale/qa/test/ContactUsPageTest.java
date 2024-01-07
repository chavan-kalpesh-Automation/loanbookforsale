package loanbookforsale.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loanbookforsale.qa.base.TestBase;
import loanbookforsale.qa.pages.ContactUsPage;
import loanbookforsale.qa.pages.HomePage;

public class ContactUsPageTest extends TestBase {
	ContactUsPage contactpg;
	HomePage homepg;

	public ContactUsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		contactpg = new ContactUsPage();
		homepg = new HomePage();
		contactpg = homepg.clickOnContactUsPage();

	}

	@Test
	public void contactUsTitleTest() {
		String title = contactpg.validateContactUsPageTitle();
		Assert.assertEquals("Trail Books and Loan Books For Sale", title,
				"Title of ContactUsPage Not Matched to Actual Title");
		System.out.println(title);
	}

	@Test
	public void contactUsFormTest() {
		contactpg.validateContactUsForm(prop.getProperty("name"), prop.getProperty("email"),
				prop.getProperty("subject"), prop.getProperty("Phone"), prop.getProperty("Message"));
	}

	@Test
	public void contactUsEmailTest() {
		String email = contactpg.validateEmailOnContactUsForm();
		System.out.println(email);
//		Assert.assertEquals(email, "info@loanbookforsale.com.au");
	}
}
