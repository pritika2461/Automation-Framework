package CBSV2Automation;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XlsxReportGeneration extends Base {

	public static void xlsxReport(XSSFCell Action, WebElement locator, XSSFCell TCID, XSSFCell Actual,
			WebDriver driver, Properties p, String SheetName) throws InterruptedException, IOException {

		// Action : Save Excel Report
		if (Action.getStringCellValue().trim().equalsIgnoreCase("Save Excel Report")) {
			Thread.sleep(100);
			locator.click();
			if (driver.findElement(By.id("altBtn")).isDisplayed()) {
				destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver,
						"" + TCID.getStringCellValue() + "_" + SheetName);
				String msg1 = driver.findElement(By.xpath(p.getProperty("alertDialogText"))).getText();
				String result = msg1.replaceAll("\\d+$", "");
				System.out.println("MSG : " + result);
				Actual.setCellValue(result);
				driver.findElement(By.id("altBtn")).click();
				Thread.sleep(100);
			} else {
				String documentsFolderPath = System.getProperty("user.home")
						+ "/Documents/XLS Files";
				String referenceFileName = TCID.getStringCellValue() + ".xls";

				// Get the Downloads folder path
				String downloadDir = System.getProperty("user.home") + "/Downloads";
				File downloadedFile = CommonFunctions
						.getLatestExcelFileFromDir(downloadDir);
				String downloadedFileName = downloadedFile.getName();
				String renamedFileName = TCID.getStringCellValue() + ".xlsx";
				CommonFunctions.renameDownloadedFile(downloadDir, downloadedFileName,
						renamedFileName);

				CommonFunctions.compareExcelFiles(
						documentsFolderPath + "/" + referenceFileName,
						downloadDir + "/" + renamedFileName);
				String msg = CommonFunctions.compareExcelFile(
						documentsFolderPath + "/" + referenceFileName,
						downloadDir + "/" + renamedFileName);
				System.out.println(msg);
				Actual.setCellValue(msg);
			}
		}
	}

}
