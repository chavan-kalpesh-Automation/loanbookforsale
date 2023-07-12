package loanbookforsale.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import loanbookforsale.qa.base.TestBase;

public class TestUtil extends TestBase{

    static Workbook book;
    static Sheet sheet;


    public void switchiframe(){
        driver.switchTo().frame("framename");
    }

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
    public static Object[][] getTestData(String sheetName){
        try{
            Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
			Path filePath = Paths.get(root.toString(),"src", "main", "java","loanbookforSale","qa","testdata", "loanbookforsale.xlsx");

            FileInputStream fis=new FileInputStream(filePath.toString());
            Workbook book=WorkbookFactory.create(fis);
         
        }
        catch(FileNotFoundException e){
                    e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
                    Sheet sheet=book.getSheet(sheetName);
         Object [] []data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
         for(int i=0;i<sheet.getLastRowNum();i++){
                for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                    data[i][j]=sheet.getRow(i+1).getCell(j).toString();
                }
            }
        return data;
    }
   

}
