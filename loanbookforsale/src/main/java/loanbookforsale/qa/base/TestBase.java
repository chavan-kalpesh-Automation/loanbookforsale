package loanbookforsale.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {

		try {

			prop = new Properties();

			//FileInputStream fis = new FileInputStream(
			//		"C:\\Users\\VISHAL\\git\\repository2\\loanbookforsale\\loanbookforsale\\src\\main\\java\\loanbookforsale\\qa\\confige\\confige.properties");
			
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
		String chromeDriverPath = prop.getProperty("chromedriverpath");
		String fireFoxDriverPath = prop.getProperty("firefoxdriverpath");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
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
