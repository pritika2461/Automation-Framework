package CBSV2Automation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCapture extends Base {

    public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
        File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        // Create a subfolder for the current date
        String dateFolderPath = ScreenshotDirectoryPath + "//" + currentDate;
        File dateFolder = new File(dateFolderPath);
        if (!dateFolder.exists()) {
            dateFolder.mkdir();
        }

        // Define the destination path for saving the screenshot
        String destinationScreenshotPath = dateFolderPath + "//" + testName + ".png";
        try {
            FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationScreenshotPath;
    }

    public static String captureScreenshot1(WebDriver driver, String testName) throws IOException {
        File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        long StartTime = new Date().getTime();

        // Create a subfolder for the current date
        String dateFolderPath = ScreenshotDirectoryPath1 + "//" + currentDate;
        File dateFolder = new File(dateFolderPath);
        if (!dateFolder.exists()) {
            dateFolder.mkdir();
        }

        // Define the destination path for saving the screenshot
        String destinationScreenshotPath = dateFolderPath + "//" + testName + "_" + StartTime + ".png";
        try {
            FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationScreenshotPath;
    }
}
