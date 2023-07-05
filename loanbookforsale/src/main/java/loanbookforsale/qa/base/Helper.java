package loanbookforsale.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper extends TestBase{
    

    public void explicitWaitOnVisibility_Custom(WebDriver driver,WebElement element,int timeout){
       try{
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeout));
    wait.until(ExpectedConditions.visibilityOf(element));
       }
       catch(Exception e){
        System.out.println(e.getMessage());
       }
    }
    
}
