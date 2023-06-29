package loanbookforsale.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import loanbookforsale.qa.base.TestBase;

public class TestUtil extends TestBase{


public  void takeScreenshotAtEndOfTestCase(){
File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
        // System.out.println(currentDir);
        File path= new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png");
		try{
        FileUtils.copyFile(scrFile, path);
        }
        catch(IOException e){
                System.out.println(e.getMessage());
        }
    }
   

}
