package loanbookforsale.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extReport;
	public static ExtentTest extTest;

	public TestBase() {

		try {

			prop = new Properties();

//			FileInputStream fis = new FileInputStream(
//					"C:\\Users\\VISHAL\\git\\repository2\\loanbookforsale\\loanbookforsale\\src\\main\\java\\loanbookforsale\\qa\\confige\\confige.properties");

//			FileInputStream fis=new FileInputStream("/loanbookforsale/src/main/java/loanbookforsale/qa/confige/confige.properties");

//			this file path gives the global path to the system runs it any where
			Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
			Path filePath = Paths.get(root.toString(), "src", "main", "java", "loanbookforSale", "qa", "confige",
					"confige.properties");

			// System.out.println(filePath);

			FileInputStream fis = new FileInputStream(filePath.toString());

			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");
		// String chromeDriverPath = prop.getProperty("chromedriverpath");
		String fireFoxDriverPath = prop.getProperty("firefoxdriverpath");

		if (browsername.equals("chrome")) {

			// System.setProperty("webdriver.chrome.driver", chromeDriverPath);

			WebDriverManager.chromedriver().setup();

			// WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}

		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("url"));
	}

	public void initializereoprt() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/extentSparkReports.html");
		sparkReporter.config().setDocumentTitle("Loanbookforsale Test Report");
		sparkReporter.config().setReportName("Loanbookforsale Automation Test Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extReport = new ExtentReports();
		extReport.attachReporter(sparkReporter);

	}

	public String captureScreenShot(WebDriver driver) {
		String FileSeparator = System.getProperty("file.separator");
		String Extent_report_path = "." + FileSeparator + "Reports";
		String ScreenshotPath = Extent_report_path + FileSeparator + "screenshots";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "screenshot" + Math.random() + ".png";
		String screenshotpath = ScreenshotPath + FileSeparator + screenshotName;
		try {
			FileUtils.copyFile(src, new File(screenshotpath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "." + FileSeparator + "screenshots" + FileSeparator + screenshotName;
	}
}
