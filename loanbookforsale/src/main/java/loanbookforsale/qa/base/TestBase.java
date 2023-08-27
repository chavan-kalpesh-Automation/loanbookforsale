package loanbookforsale.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {

		try {

			prop = new Properties();

//			FileInputStream fis = new FileInputStream(
//					"C:\\Users\\VISHAL\\git\\repository2\\loanbookforsale\\loanbookforsale\\src\\main\\java\\loanbookforsale\\qa\\confige\\confige.properties");
			
//			FileInputStream fis=new FileInputStream("/loanbookforsale/src/main/java/loanbookforsale/qa/confige/confige.properties");
			
		
//			this file path gives the global path to the system runs it any where
						Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
			Path filePath = Paths.get(root.toString(),"src", "main", "java","loanbookforSale","qa","confige", "confige.properties");

			//			System.out.println(filePath);
			
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
			
			//code change after chrome version change (115)
			ChromeOptions co=new ChromeOptions();
			co.setBrowserVersion("116");



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
}
