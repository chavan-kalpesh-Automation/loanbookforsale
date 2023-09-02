package loanbookforsale.qa.util;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class DocumentSpecificActions  {
    public void uploadFile(String fileName) throws AWTException{

        Robot robot = new Robot();
        StringSelection str = new StringSelection(fileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        
    }
}
