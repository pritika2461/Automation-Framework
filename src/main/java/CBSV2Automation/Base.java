package CBSV2Automation;

import java.io.*;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import javax.swing.JButton;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class Base {

    // Global variables for WebDriver, Excel handling, reports, and configuration
    public static WebDriver driver;
    public static XSSFWorkbook workbook, workbook1;
    public static HSSFWorkbook workbook11;
    public static FileOutputStream fos, outputStream;
    public static FileWriter fileWriter;
    public static PrintWriter out, out1;
    public static XSSFSheet sheet, sheet1;
    public static HSSFSheet sheet11;
    public static XSSFRow row, rows, rowk;
    public static WebElement locator, elementToLongPress;
    public static Actions actions;
    public static Duration duration;
    public static List<String> myList;

    // Paths and directories for reports, screenshots, and Excel files
    public static Path consoleReportDirectoryPath, summaryReportDirectoryPath;
    public static Path ExcelDirectoryPath, consoleReportFilePath, summaryReportFilePath, DownloadsDirectoryPath;
    public static String jarPath, summaryReportDirectory, consoleReportDirectory, ScreenshotDirectoryPath,
            ScreenshotDirectoryPath1;
    public static String destinationScreenshotPath, CurrentExeExcel, executionType, SuitProperiesFileName;
    public static String SheetName, RunTestCaseFlag = "No", TestRunStatus = "RunAllCases";

    // Variables for execution and test details
    public static String ExecutionType, data, data1, Data, msg, locater, Input, restOfString;
    public static String msg1, msg2 = null, SummaryReport, SummaryReportpdf, ConsoleReport;
    public static int Data1, Data2, Count, Count1, startX, startY, endY, FlagTeststart, FlagTestend;
    public static int totalcases = 0, totalpasscases = 0, totalfailcases = 0, totalskipcases = 0, totalPRFailcases = 0;
    public static int noOfSheets, noOfRow, noOfRows, noOfCol, a = 0, i, j, k, toollvelefailexecount = 1, execount = 1;
    public static int Excetution_start, Execution_end, Test_start, Test_end;
    public static long TestStartTime, TestEndTime, ExeStartTime, ExeStopTime, SingleSheetExeStartTime,
            SingleSheetExeStopTime;

    // Properties for configuration and locators
    public static Properties p = new Properties();
    public static Properties prop = new Properties();
    public static String ElementNotFoundCount = "";
    public static int INDEX;
    public static FileChannel channel;

    public static volatile boolean paused = false;
    public static final Object lock = new Object();
    public static JButton pauseButton, executeButton, RunTestCase, DeleteButton;

    @BeforeTest
    public WebDriver capabilities() throws IOException, InterruptedException, ClassNotFoundException, SQLException {

        // Get the directory where the JAR file is located
        jarPath = new File(Base.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent();
        jarPath = URLDecoder.decode(jarPath, "UTF-8");

        // Load properties files for locators and configuration
        try (InputStream fis1 = getClass().getClassLoader().getResourceAsStream("Locator.properties");
                InputStream fis2 = new FileInputStream(jarPath + "//Suits//" + SuitProperiesFileName + ".properties")) {

            if (fis1 == null || fis2 == null) {
                throw new FileNotFoundException("Properties file not found in the classpath");
            }
            p.load(fis1);
            prop.load(fis2);
        } catch (IOException e) {
            System.err.println("Error loading properties files: " + e.getMessage());
            e.printStackTrace();
        }

        return driver;
    }

    @AfterClass
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
