package loanbookforsale.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import loanbookforsale.qa.base.TestBase;
import loanbookforsale.qa.pages.PricingPage;

public class PricingPageTest extends TestBase {
	public ExtentReports extreport;
	ExtentSparkReporter htmlReporter;
	PricingPage pricepg;

	public PricingPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();

	}

	@BeforeTest
	public void startReport() {
		initializereoprt();

	}

	@Test
	public void pricingPageTitleTest() {
		String methodname = new Exception().getStackTrace()[0].getMethodName();
		extTest = extReport.createTest(methodname, "Pricing Page Title Test");
		extTest.assignCategory("Extent Report Test category");
		Assert.assertEquals(pricepg.validatePricePageTitle(), "See Our Packages",
				"Price Page Title Not Match with Actual Title");
	}

	@AfterTest
	public void endReport() {
		extReport.flush();
	}
}
