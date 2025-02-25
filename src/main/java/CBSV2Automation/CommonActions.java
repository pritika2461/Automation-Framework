package CBSV2Automation;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonActions extends Base {

	static Boolean isBreak1;

	public static Boolean commonmetadataactions(XSSFCell FieldAction, XSSFCell TCID, XSSFCell Expected, XSSFCell Actual,
			XSSFCell ID1, XSSFCell Status, XSSFCell input1, XSSFCell input2, XSSFCell input3, XSSFCell input4,
			XSSFCell input5, XSSFCell input6, XSSFCell input7, XSSFCell input8, XSSFCell input9, XSSFCell input10,
			XSSFCell input11, XSSFCell input12, XSSFCell input13, XSSFCell input14, XSSFCell input15, XSSFCell input16,
			XSSFCell input17, XSSFCell input18, XSSFCell input19, XSSFCell input20, XSSFCell input21, XSSFCell input22,
			XSSFCell input23, XSSFCell input24, XSSFCell input25, XSSFCell input26, XSSFCell input27, XSSFCell input28,
			XSSFCell input29, XSSFCell input30, XSSFCell input31, XSSFCell input32, XSSFCell input33, XSSFCell input34,
			XSSFCell input35, XSSFCell input36, XSSFCell input37, XSSFCell input38, XSSFCell input39, XSSFCell input40,
			XSSFCell input41, XSSFCell input42, XSSFCell input43, XSSFCell input44, XSSFCell input45, XSSFCell input46,
			XSSFCell input47, XSSFCell input48, XSSFCell input49, XSSFCell input50, XSSFCell input51, XSSFCell input52,
			XSSFCell input53, XSSFCell input54, XSSFCell input55, XSSFCell input56,
			XSSFCell input57, XSSFCell input58, XSSFCell input59, XSSFCell input60, XSSFCell input61, XSSFCell input62,
			XSSFCell input63, XSSFCell input64, XSSFCell input65, XSSFCell input66, XSSFCell input67, XSSFCell input68,
			XSSFCell input69, XSSFCell input70, XSSFCell input71, XSSFCell input72, XSSFCell input73, XSSFCell input74,
			XSSFCell input75, XSSFCell input76, XSSFCell input77, XSSFCell Remark, XSSFCell Action, WebElement locator,
			XSSFRow rowk, Properties p, Keys actionKey, List<String> myList, String SheetName, WebDriver driver, int j,
			XSSFCell ValidationXpath1) throws InterruptedException, IOException {
		// Action 1 : Click
		if (Action.getStringCellValue().trim().equalsIgnoreCase("Click")) {
			locator.click();
			Thread.sleep(500);
		}

		// Action 2 : Clear Filed
		else if (Action.getStringCellValue().trim().equalsIgnoreCase("Clear")) {
			locator.clear();
		}

		// Action 3 : Skip Toast Msg on Button click
		else if (Action.getStringCellValue().trim().equalsIgnoreCase("Skip Toast")) {
			locator.click();
			Thread.sleep(100);
			if (driver.findElement(By.id("altBtn")).isDisplayed()) {
				driver.findElement(By.id("altBtn")).click();
			}
		}

		// Action 4 :Check Toast msg on button click
		else if (Action.getStringCellValue().trim().equalsIgnoreCase("Check Toast msg")) {
			locator.click();
			Thread.sleep(100);
			if (driver.findElement(By.id("altBtn")).isDisplayed()) {
				destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver,
						"" + TCID.getStringCellValue() + "_" + SheetName);
				String msg1 = CommonFunctions.AlertMsgFun();
				for (String item : myList) {
					try {
						if (!driver.findElements(By.id(item)).isEmpty()) {
							if (driver.findElement(By.id(item)).isDisplayed()) {
								driver.findElement(By.id(item)).click();
								Thread.sleep(100);
							}
						}
					} catch (Exception e) {
					}
				}
				Actual.setCellValue(Actual.getStringCellValue() + "\n" + msg1);
				j += 100;
				isBreak1 = true;
			}
		}
		// Action 5: Double Click
		else if (Action.getStringCellValue().equalsIgnoreCase("Double Click")) {
			Thread.sleep(100);
			Actions actions = new Actions(driver);
			actions.doubleClick(locator).perform();
		}

		// Action : Click & check
		else if (Action.getStringCellValue().equalsIgnoreCase("Handle Alert Msg")) {
			locator.click();
			Thread.sleep(1000);
			if (driver.findElement(By.id("altBtn")).isDisplayed()) {
				driver.findElement(By.id("altBtn")).click();
			}
			Thread.sleep(500);
		}

		// Action 1 : Wait
		else if (Action.getStringCellValue().trim().equalsIgnoreCase("Wait")) {
			Thread.sleep(1000);
		}

		// Double Action Perform
		else if (Action.getStringCellValue().trim().equalsIgnoreCase("SendkeyAction9")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction11("Sendkey9",
					input9, input10, Expected, Actual,
					locator, rowk, 22, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		}

		else if (Action.getStringCellValue().trim().equalsIgnoreCase("SendkeyAction10")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction11("Sendkey10",
					input10, input11, Expected, Actual,
					locator, rowk, 23, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		}

		// Action : Recalculate F9 Form
		else if (Action.getStringCellValue().equalsIgnoreCase("Recalculate F9 Form")) {
			try {
				locator.click();
				Thread.sleep(100);
				ActionCommonCode.handleAlertMessages(TCID, Actual, Remark);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				String a = (String) js.executeScript("return arguments[0].value;",
						driver.findElement(By.id("INSTALLMENT")));
				String b = (String) js.executeScript("return arguments[0].value;",
						driver.findElement(By.id("MARGIN_AMT")));
				String c = (String) js.executeScript("return arguments[0].value;",
						driver.findElement(By.id("INTEREST")));
				String d = (String) js.executeScript("return arguments[0].value;",
						driver.findElement(By.id("LOAN_AMT")));

				long aa = (long) Double.parseDouble(a);
				long bb = (long) Double.parseDouble(b);
				long cc = (long) Double.parseDouble(c);
				long dd = (long) Double.parseDouble(d);

				System.out.println("INSTALLMENT : " + aa + " MARGIN_AMT : " + bb + " INTEREST : " + cc
						+ " LOAN_AMT : " + dd);
				out1.write("INSTALLMENT : " + aa + " MARGIN_AMT : " + bb + " INTEREST : " + cc
						+ " LOAN_AMT : " + dd + "\n");
				Actual.setCellValue("INSTALLMENT : " + aa + "\nMARGIN_AMT : " + bb + "\nINTEREST : " + cc
						+ "\nLOAN_AMT : " + dd);
			} catch (Exception e) {
			}
		}
		return isBreak1;

	}

}
