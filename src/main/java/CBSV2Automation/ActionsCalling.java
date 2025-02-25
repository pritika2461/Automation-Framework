package CBSV2Automation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ActionsCalling extends Base {
	public static void ExecuteActions(XSSFCell FieldAction, XSSFCell TCID, XSSFCell Expected, XSSFCell Actual,
			XSSFCell ID1, XSSFCell Status, XSSFCell input1, XSSFCell input2, XSSFCell input3, XSSFCell input4,
			XSSFCell input5, XSSFCell input6, XSSFCell input7, XSSFCell input8, XSSFCell input9, XSSFCell input10,
			XSSFCell input11, XSSFCell input12, XSSFCell input13, XSSFCell input14, XSSFCell input15, XSSFCell input16,
			XSSFCell input17, XSSFCell input18, XSSFCell input19, XSSFCell input20, XSSFCell input21, XSSFCell input22,
			XSSFCell input23, XSSFCell input24, XSSFCell input25, XSSFCell input26, XSSFCell input27, XSSFCell input28,
			XSSFCell input29, XSSFCell input30, XSSFCell input31, XSSFCell input32, XSSFCell input33, XSSFCell input34,
			XSSFCell input35, XSSFCell input36, XSSFCell input37, XSSFCell input38, XSSFCell input39, XSSFCell input40,
			XSSFCell input41, XSSFCell input42, XSSFCell input43, XSSFCell input44, XSSFCell input45, XSSFCell input46,
			XSSFCell input47, XSSFCell input48, XSSFCell input49, XSSFCell input50, XSSFCell input51, XSSFCell input52,
			XSSFCell input53, XSSFCell input54, XSSFCell input55, XSSFCell input56, XSSFCell input57, XSSFCell input58, 
			XSSFCell input59, XSSFCell input60, XSSFCell input61, XSSFCell input62, XSSFCell input63, XSSFCell input64, 
			XSSFCell input65, XSSFCell input66, XSSFCell input67, XSSFCell input68, XSSFCell input69, XSSFCell input70,
			XSSFCell input71, XSSFCell input72, XSSFCell input73, XSSFCell input74,	XSSFCell input75, XSSFCell input76, 
			XSSFCell input77, XSSFCell Remark, int execount)throws IOException {

		try {
			Actual.setCellValue(".");
			Status.setCellValue(".");
			Remark.setCellValue(".");
			for (j = 1; j < noOfRows; j++) {
				try {
					PauseResumeAutomation.checkPause();
					XSSFRow row111 = sheet1.getRow(1);
					XSSFRow row11 = sheet1.getRow(j);
					XSSFCell SRNO = row11.getCell(0);
					XSSFCell Action = row11.getCell(2);
					XSSFCell LocatorType = row11.getCell(3);
					XSSFCell IDXPath = row11.getCell(4);

					XSSFCell ValidationXpath1 = row111.getCell(5);
					XSSFCell ValidationXpath2 = row111.getCell(6);
					XSSFCell ValidationXpath3 = row111.getCell(7);
					XSSFCell ValidationXpath4 = row111.getCell(8);
					XSSFCell ValidationXpath5 = row111.getCell(9);
					XSSFCell ValidationXpath6 = row111.getCell(10);
					XSSFCell ValidationXpath7 = row111.getCell(11);
					XSSFCell ValidationXpath8 = row111.getCell(12);

					Keys actionKey;
					try {
						String actionString = FieldAction.getStringCellValue().trim().toString().toUpperCase();
						actionKey = Keys.valueOf(actionString);
					} catch (Exception e) {
						actionKey = Keys.ENTER;
					}

					if (IDXPath.getCellType().equals(SRNO.getCellType())) {
						int locater1 = (int) IDXPath.getNumericCellValue();
						locater = String.valueOf(locater1);
					}
					if (IDXPath.getCellType().equals(Action.getCellType())) {
						locater = IDXPath.getStringCellValue();
					}

					// Get the locator is ID or Xpath & set locator value
					if (LocatorType.getStringCellValue().trim().equalsIgnoreCase("id")) {
						locator = driver.findElement(By.id(locater));
					} else {
						locator = driver.findElement(By.xpath(locater));
					}
					Thread.sleep(100);

					try {
						myList = new ArrayList<>();
						myList.add("" + ValidationXpath2.getStringCellValue().trim());
						myList.add("" + ValidationXpath3.getStringCellValue().trim());
						myList.add("" + ValidationXpath4.getStringCellValue().trim());
						myList.add("" + ValidationXpath5.getStringCellValue().trim());
						myList.add("" + ValidationXpath6.getStringCellValue().trim());
						myList.add("" + ValidationXpath7.getStringCellValue().trim());
						myList.add("" + ValidationXpath8.getStringCellValue().trim());
					} catch (Exception e) {
					}

					// Maximize Browser and Focus to Current Running Window
					driver.manage().window().maximize();
					((JavascriptExecutor) driver).executeScript("window.focus();");

					// Actions : Call the Common Metatata Actions
					CommonActions.commonmetadataactions(FieldAction, TCID, Expected, Actual,
							ID1, Status, input1, input2, input3, input4, input5, input6, input7, input8, input9,
							input10, input11, input12, input13, input14, input15, input16, input17, input18, input19,
							input20, input21, input22, input23, input24, input25, input26, input27, input28, input29,
							input30, input31, input32, input33, input34, input35, input36, input37, input38, input39,
							input40, input41, input42, input43, input44, input45, input46, input47, input48, input49,
							input50, input51, input52, input53, input54, input55, input56, input57, input58, input59,
							input60, input61, input62, input63, input64, input65, input66, input67, input68, input69,
							input70, input71, input72, input73, input74, input75, input76, input77, Remark, Action,
							locator, rowk, p, actionKey, myList, SheetName, driver, j, ValidationXpath1);

					// Actions : Call the Sendkeys Actions
					SendkeyActions.CommonSendkeyActions(FieldAction, TCID, Expected, Actual,
							ID1, Status, input1, input2, input3, input4, input5, input6, input7, input8, input9,
							input10, input11, input12, input13, input14, input15, input16, input17, input18, input19,
							input20, input21, input22, input23, input24, input25, input26, input27, input28, input29,
							input30, input31, input32, input33, input34, input35, input36, input37, input38, input39,
							input40, input41, input42, input43, input44, input45, input46, input47, input48, input49,
							input50, input51, input52, input53, input54, input55, input56, input57, input58, input59,
							input60, input61, input62, input63, input64, input65, input66, input67, input68, input69,
							input70, input71, input72, input73, input74, input75, input76, input77, Remark, Action,
							locator, rowk, p, actionKey, myList, SheetName, driver, j, ValidationXpath1);

					// Actions : Call the LOV Selection Metatata Actions
					LOVSelectionActions.LOVSelections(FieldAction, TCID, Expected, Actual,
							ID1, Status, input1, input2, input3, input4, input5, input6, input7, input8, input9,
							input10, input11, input12, input13, input14, input15, input16, input17, input18, input19,
							input20, input21, input22, input23, input24, input25, input26, input27, input28, input29,
							input30, input31, input32, input33, input34, input35, input36, input37, input38, input39,
							input40, input41, input42, input43, input44, input45, input46, input47, input48, input49,
							input50, input51, input52, input53, input54, input55, input56, input57, input58, input59,
							input60, input61, input62, input63, input64, input65, input66, input67, input68, input69,
							input70, input71, input72, input73, input74, input75, input76, input77, Remark, Action,
							locator, rowk, p, actionKey, myList, SheetName, driver, j, ValidationXpath1, out1);

					// Actions : Call the Radio Button Selection Metatata Actions
					RadioButtonActions.RadioButton(FieldAction, TCID, Expected, Actual,
							ID1, Status, input1, input2, input3, input4, input5, input6, input7, input8, input9,
							input10, input11, input12, input13, input14, input15, input16, input17, input18, input19,
							input20, input21, input22, input23, input24, input25, input26, input27, input28, input29,
							input30, input31, input32, input33, input34, input35, input36, input37, input38, input39,
							input40, input41, input42, input43, input44, input45, input46, input47, input48, input49,
							input50, input51, input52, input53, input54, input55, input56, input57, input58, input59,
							input60, input61, input62, input63, input64, input65, input66, input67, input68, input69,
							input70, input71, input72, input73, input74, input75, input76, input77, Remark, Action,
							locator, driver);

					// Actions : Call the Checkbox Selection Metatata Actions
					CheckboxSelectionActions.CheckBoxSelection(FieldAction, TCID, Expected, Actual,
							ID1, Status, input1, input2, input3, input4, input5, input6, input7, input8, input9,
							input10, input11, input12, input13, input14, input15, input16, input17, input18, input19,
							input20, input21, input22, input23, input24, input25, input26, input27, input28, input29,
							input30, input31, input32, input33, input34, input35, input36, input37, input38, input39,
							input40, input41, input42, input43, input44, input45, input46, input47, input48, input49,
							input50, input51, input52, input53, input54, input55, input56, input57, input58, input59,
							input60, input61, input62, input63, input64, input65, input66, input67, input68, input69,
							input70, input71, input72, input73, input74, input75, input76, input77, Remark, Action,
							locator, driver);

					// Actions : Download XLSX Report and Check it
					XlsxReportGeneration.xlsxReport(Action, locator, TCID, Actual, driver, p, SheetName);

					// Action : Save Button Action
					SaveButtonAction.SaveAction(Action, locator, driver, Actual, out1, p, myList);

					// Maximize Browser and Focus to Current Running Window
					driver.manage().window().maximize();
					((JavascriptExecutor) driver).executeScript("window.focus();");

					// Write Result of Test Case into Excel sheet.
					FileOutputStream outputStream = new FileOutputStream(
							jarPath + "//Test Cases Sheets" + File.separator + CurrentExeExcel);
					workbook.write(outputStream);

				} catch (Exception e) {
					// Exception Handle
					if (Remark == null) {
					} else {
						Remark.setCellValue(
								Remark.getStringCellValue() + INDEX + ")Element Not Found For ID/Xpath = " + locater);
						System.out.println(INDEX + ") Element Not Found For ID/Xpath = " + locater);
						out1.write(INDEX + ") Element Not Found For ID/Xpath = " + locater + "\n");
						INDEX++;
						if (Remark.getStringCellValue().contains("5)")) {
							destinationScreenshotPath = ScreenshotCapture.captureScreenshot1(driver,
									TCID + "_" + SheetName);
							WebElement body = driver.findElement(By.tagName("body"));
							body.sendKeys(Keys.ESCAPE);
							driver.findElement(By.tagName("body")).sendKeys("" + Keys.ESCAPE);
							if (execount <= 3) {
								execount += 1;
								driver.navigate().refresh();
								driver.navigate().refresh();
								for (String item : myList) {
									try {
										if (!driver.findElements(By.id(item)).isEmpty()) {
											if (driver.findElement(By.id(item)).isDisplayed()) {
												driver.findElement(By.id(item)).click();
												Thread.sleep(100);
											}
										}
									} catch (Exception e1) {
									}
								}
								j = 1;
								System.out.println("Webpage get Refresh..");
								out1.write("Webpage get Refresh.. \n");
								break;
							} else {
								System.out.println("Execution continue..");
								driver.navigate().refresh();
								for (String item : myList) {
									try {
										if (!driver.findElements(By.id(item)).isEmpty()) {
											if (driver.findElement(By.id(item)).isDisplayed()) {
												driver.findElement(By.id(item)).click();
												Thread.sleep(100);
											}
										}
									} catch (Exception e1) {
									}
								}

								if (driver.findElement(By.className("other_detail new_od")).isDisplayed()) {
									driver.findElement(By.className("new")).click();
									Login.CallloginScreen();
								}

								j = 1;
								System.out.println("Webpage get Refresh..");
								Remark.setCellValue("...");
								out1.write("Webpage get Refresh due to more than 5 elements are not founds & execution get continue.");
								break;
							}
						}
					}
				}
			}

			// Write Excel Sheet
			FileOutputStream outputStream = new FileOutputStream(
					jarPath + "//Test Cases Sheets" + File.separator + CurrentExeExcel);
			workbook.write(outputStream);

		} catch (Exception e) {
			System.out.println(e);
			FileOutputStream outputStream = new FileOutputStream(
					jarPath + "//Test Cases Sheets" + File.separator + CurrentExeExcel);
			workbook.write(outputStream);
		}
	}
}
