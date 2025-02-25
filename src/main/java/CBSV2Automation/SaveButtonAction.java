package CBSV2Automation;

import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SaveButtonAction {
	public static void SaveAction(XSSFCell Action, WebElement locator, WebDriver driver, XSSFCell Actual,
			PrintWriter out1,
			Properties p, List<String> myList) throws InterruptedException {
		// Action : Save Form
		if (Action.getStringCellValue().trim().equalsIgnoreCase("Save")) {
			Thread.sleep(500);
			locator.click();
			Thread.sleep(1000);
			try {
				if (driver.findElement(By.id("confirmBtn")).isDisplayed()) {
					driver.findElement(By.id("confirmBtnNo")).click();
				}
			} catch (Exception e) {
			}

			if (driver.findElement(By.id("altBtn")).isDisplayed()) {
				String msg1 = driver.findElement(By.xpath(p.getProperty("alertDialogText"))).getText();
				String result = msg1.replaceAll("\\d+$", "");
				System.out.println("Toast Msg: " + result);
				Actual.setCellValue(result);
				out1.write("Toast Msg: " + result);
				Thread.sleep(500);
				driver.findElement(By.id("altBtn")).click();
				Thread.sleep(800);
			} else {
				Thread.sleep(100);
				for (String item : myList) {
					try {
						if (!driver.findElements(By.id(item)).isEmpty()) {
							if (driver.findElement(By.id(item)).isDisplayed()) {
								driver.findElement(By.id(item)).click();
								Thread.sleep(500);
							}
						}
					} catch (Exception e) {
					}
				}
			}
		}
	}

}
