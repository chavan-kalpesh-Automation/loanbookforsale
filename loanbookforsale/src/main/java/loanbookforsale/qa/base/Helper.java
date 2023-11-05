package loanbookforsale.qa.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper extends TestBase {

	public void explicitWaitOnVisibility_Custom(WebDriver driver, WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void actions_ClassMethods(WebElement triggerElement, WebElement targetElement) {
		Actions act = new Actions(driver);
		act.moveToElement(triggerElement).perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(targetElement));
		targetElement.click();
	}

	public void captureScreenShot(String methodname) {
		Date dt = new Date();
		String timestamp = dt.toString().replace(" ", "").replace(":", "_");
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("C:\\Users\\KALPESH\\git\\loanbookforsale" + methodname + timestamp + ".jpg");
			FileHandler.copy(source, destination);

		} catch (IOException e) {
			e.getMessage();

		}
	}
}
