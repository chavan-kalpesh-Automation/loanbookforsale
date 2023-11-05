package loanbookforsale.qa.extentReportListner;


import org.testng.ITestListener;
import org.testng.ITestResult;

import loanbookforsale.qa.base.Helper;
import loanbookforsale.qa.base.TestBase;

public class ListnerClass extends TestBase implements ITestListener {
	Helper help;

	@Override
	public void onTestFailure(ITestResult result) {
		help =new Helper();
		
		System.out.println("Test Failed ");
		help.captureScreenShot(result.getName());
	}

}
