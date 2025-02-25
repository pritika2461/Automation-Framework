package CBSV2Automation;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import Utilities.DatabaseConn;

public class MainFile extends Base {

	public static void AutomationLogic() throws InterruptedException, ClassNotFoundException, SQLException {

		SingleSheetExeStartTime = new Date().getTime();

		// Getting sheets one by one from the excel as per maintain in the
		PauseResumeAutomation.checkPause();
		for (i = Excetution_start; i <= Execution_end; i++) {
			int Pass_Test_Cases = 0, Fail_Test_Cases = 0, PR_Test_Cases = 0;
			try {
				ReportGenarate.reportPrint();
				try {
					sheet1 = workbook1.getSheet(sheet.getSheetName());
					noOfRows = sheet1.getLastRowNum();
					rows = sheet1.getRow(0);

					// Print the Report & initialize Test_Start and Test_End
					ReportGenarate.initialRoportrintCode();

					// Getting test cases from the Test cases excel sheet
					for (k = Test_start; k <= Test_end; k++) {
						driver.manage().window().maximize();
						PauseResumeAutomation.checkPause();
						((JavascriptExecutor) driver).executeScript("window.focus();");

						TestStartTime = new Date().getTime();
						rowk = sheet.getRow(k);
						INDEX = 1;
						XSSFRow row1 = sheet.getRow(k);
						XSSFCell TCID = row1.getCell(1);
						XSSFCell Objective = row1.getCell(3);
						XSSFCell Expected = row1.getCell(5);
						XSSFCell Actual = row1.getCell(6);
						XSSFCell Status = row1.getCell(7);
						XSSFCell Remark = row1.getCell(8);
						XSSFCell Screenshot = row1.getCell(9);
						XSSFCell time = row1.getCell(10);
						XSSFCell Database = row1.getCell(11);
						XSSFCell FieldAction = row1.getCell(12);
						XSSFCell ID1 = row1.getCell(13);

						XSSFCell input1 = row1.getCell(14);
						XSSFCell input2 = row1.getCell(15);
						XSSFCell input3 = row1.getCell(16);
						XSSFCell input4 = row1.getCell(17);
						XSSFCell input5 = row1.getCell(18);
						XSSFCell input6 = row1.getCell(19);
						XSSFCell input7 = row1.getCell(20);
						XSSFCell input8 = row1.getCell(21);
						XSSFCell input9 = row1.getCell(22);
						XSSFCell input10 = row1.getCell(23);
						XSSFCell input11 = row1.getCell(24);
						XSSFCell input12 = row1.getCell(25);
						XSSFCell input13 = row1.getCell(26);
						XSSFCell input14 = row1.getCell(27);
						XSSFCell input15 = row1.getCell(28);
						XSSFCell input16 = row1.getCell(29);
						XSSFCell input17 = row1.getCell(30);
						XSSFCell input18 = row1.getCell(31);
						XSSFCell input19 = row1.getCell(32);
						XSSFCell input20 = row1.getCell(33);
						XSSFCell input21 = row1.getCell(34);
						XSSFCell input22 = row1.getCell(35);
						XSSFCell input23 = row1.getCell(36);
						XSSFCell input24 = row1.getCell(37);
						XSSFCell input25 = row1.getCell(38);
						XSSFCell input26 = row1.getCell(39);
						XSSFCell input27 = row1.getCell(40);
						XSSFCell input28 = row1.getCell(41);
						XSSFCell input29 = row1.getCell(42);
						XSSFCell input30 = row1.getCell(43);
						XSSFCell input31 = row1.getCell(44);
						XSSFCell input32 = row1.getCell(45);
						XSSFCell input33 = row1.getCell(46);
						XSSFCell input34 = row1.getCell(47);
						XSSFCell input35 = row1.getCell(48);
						XSSFCell input36 = row1.getCell(49);
						XSSFCell input37 = row1.getCell(50);
						XSSFCell input38 = row1.getCell(51);
						XSSFCell input39 = row1.getCell(52);
						XSSFCell input40 = row1.getCell(53);
						XSSFCell input41 = row1.getCell(54);
						XSSFCell input42 = row1.getCell(55);
						XSSFCell input43 = row1.getCell(56);
						XSSFCell input44 = row1.getCell(57);
						XSSFCell input45 = row1.getCell(58);
						XSSFCell input46 = row1.getCell(59);
						XSSFCell input47 = row1.getCell(60);
						XSSFCell input48 = row1.getCell(60);
						XSSFCell input49 = row1.getCell(62);
						XSSFCell input50 = row1.getCell(63);
						XSSFCell input51 = row1.getCell(64);
						XSSFCell input52 = row1.getCell(65);
						XSSFCell input53 = row1.getCell(66);
						XSSFCell input54 = row1.getCell(67);
						XSSFCell input55 = row1.getCell(68);
						XSSFCell input56 = row1.getCell(69);
						XSSFCell input57 = row1.getCell(70);
						XSSFCell input58 = row1.getCell(71);
						XSSFCell input59 = row1.getCell(72);
						XSSFCell input60 = row1.getCell(73);
						XSSFCell input61 = row1.getCell(74);
						XSSFCell input62 = row1.getCell(75);
						XSSFCell input63 = row1.getCell(76);
						XSSFCell input64 = row1.getCell(77);
						XSSFCell input65 = row1.getCell(78);
						XSSFCell input66 = row1.getCell(79);
						XSSFCell input67 = row1.getCell(80);
						XSSFCell input68 = row1.getCell(81);
						XSSFCell input69 = row1.getCell(82);
						XSSFCell input70 = row1.getCell(83);
						XSSFCell input71 = row1.getCell(84);
						XSSFCell input72 = row1.getCell(85);
						XSSFCell input73 = row1.getCell(86);
						XSSFCell input74 = row1.getCell(87);
						XSSFCell input75 = row1.getCell(88);
						XSSFCell input76 = row1.getCell(89);
						XSSFCell input77 = row1.getCell(90);

						// Database Entries
						if (SuitProperiesFileName.contains("ShareMas")) {
							DatabaseConn.DeleteFromShmas();
						}

						// Specify the Ending Condition of test case
						try {
							if (Expected.getStringCellValue().trim().contains("End Of the Test Cases")) {
								break;
							}
						} catch (Exception e) {
						}
						if (Actual == null) {
							Actual = rowk.createCell(6);
							Actual.setCellValue("Element Not Found");
						}
						if (Status == null) {
							Status = rowk.createCell(7);
							Status.setCellValue("Element Not Found");
						}
						if (Remark == null) {
							Remark = rowk.createCell(8);
						}
						if (Screenshot == null) {
							Screenshot = rowk.createCell(9);
						}
						if (time == null) {
							time = rowk.createCell(10);
						}
						if (Database == null) {
							Database = rowk.createCell(11);
						}

						driver.manage().window().maximize();
						((JavascriptExecutor) driver).executeScript("window.focus()");

						if (!TestRunStatus.equalsIgnoreCase("RunAllCases")) {
							if (!Status.getStringCellValue().trim().equalsIgnoreCase("Pass")) {
								try {
									ReportGenarate.reportPrint1(TCID, Objective);

									ActionsCalling.ExecuteActions(FieldAction, TCID, Expected, Actual, ID1, Status,
											input1, input2, input3, input4, input5, input6, input7, input8, input9, input10, input11,
											input12, input13, input14, input15, input16, input17, input18, input19,
											input20, input21, input22, input23, input24, input25, input26, input27, input28,
											input29, input30, input31, input32, input33, input34, input35, input36, input37,
											input38, input39, input40, input41, input42, input43, input44, input45, input46,
											input47, input48, input49, input50, input51, input52, input53, input54, input55,
											input56, input57, input58, input59, input60, input61, input62, input63, input64,
											input65, input66, input67, input68, input69, input70, input71, input72, input73,
											input74, input75, input76, input77, Remark, execount);

									String ExtectedResult;
									String ActualResult;
									try {
										ExtectedResult = Expected.getStringCellValue().trim().trim();
										ActualResult = Actual.getStringCellValue().trim();
									} catch (Exception e) {
										Double ExtectedResult1 = Expected.getNumericCellValue();
										ExtectedResult = ExtectedResult1.toString();

										Double ActualResult1 = Actual.getNumericCellValue();
										ActualResult = ActualResult1.toString();

									}
									if (ExtectedResult.equalsIgnoreCase(ActualResult)) {
										Status.setCellValue("Pass");
										Remark.setCellValue("");
										System.out.println("Test Status : Pass");
										out1.write("\n Test Status : Pass\n");
										Screenshot.setCellValue("");
									}
									if (!ExtectedResult.equalsIgnoreCase(ActualResult)) {
										Status.setCellValue("Fail");
										System.out.println("Test Status : Fail");
										out1.write("\n Test Status : Fail\n");

										// Get the Screenshot path of Failed test cases
										if (Status.getStringCellValue().trim().equalsIgnoreCase("Fail")) {
											Screenshot.setCellValue(destinationScreenshotPath);
										}
									}

									if (Remark.getStringCellValue().trim().contains("2)")) {
										driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
										Remark.setCellValue(Remark.getStringCellValue()
												+ "Tool level test case gets fail due to element not found..");
										System.out.println("Tool level test case gets fail due to element not found..");
										out1.write("Tool level test case gets fail due to element not found..\n");

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
										System.out.println("toollvelefailexecount : " + toollvelefailexecount);
										if (toollvelefailexecount < 3) {
											k -= 1;
											toollvelefailexecount++;
											Status.setCellValue("");
											// Remark.setCellValue("");
										} else {
											toollvelefailexecount = 1;
										}
										if (toollvelefailexecount == 2) {
											Fail_Test_Cases -= 1;
										}
										if (toollvelefailexecount == 3) {
											Status.setCellValue("Fail");
											Remark.setCellValue(
													"Tool level test case gets fail due to element not found..");
											PR_Test_Cases += 1;
											Fail_Test_Cases -= 1;
										}
									}

									// Calculate the Time Required to execute each test case.
									TestEndTime = new Date().getTime();
									long duration = TestEndTime - TestStartTime;
									long Time = duration / 1000;
									time.setCellValue("" + Time + " Seconds");
									System.out.println("Test Time : " + Time + " Seconds");
									out1.write("Test Time : " + Time + " Seconds\n");

								} catch (Exception e) {
									System.out.println("Please Maintain Expected Result in Proper Format");
									out1.write("Please Maintain Expected Result in Proper Format");
									Status.setCellValue("Fail");
								}
							} else {
								Remark.setCellValue("");
								Screenshot.setCellValue("");
								time.setCellValue("");

							}
						} else {
							try {
								Actual.setCellValue(".");
								Status.setCellValue(".");
								Remark.setCellValue(".");
								ReportGenarate.reportPrint1(TCID, Objective);
								ActionsCalling.ExecuteActions(FieldAction, TCID, Expected, Actual, ID1, Status, input1,
										input2,
										input3, input4, input5, input6, input7, input8, input9, input10, input11,
										input12, input13, input14, input15, input16, input17, input18, input19, input20,
										input21, input22, input23, input24, input25, input26, input27, input28, input29,
										input30, input31, input32, input33, input34, input35, input36, input37, input38,
										input39, input40, input41, input42, input43, input44, input45, input46, input47,
										input48, input49, input50, input51, input52, input53, input54, input55, input56,
										input57, input58, input59, input60, input61, input62, input63, input64, input65,
										input66, input67, input68, input69, input70, input71, input72, input73, input74,
										input75, input76, input77, Remark, execount);

								String ExtectedResult;
								String ActualResult;

								try {
									ExtectedResult = Expected.getStringCellValue().trim().trim();
									ActualResult = Actual.getStringCellValue().trim().trim();
								} catch (Exception e) {
									Double ExtectedResult1 = Expected.getNumericCellValue();
									ExtectedResult = ExtectedResult1.toString();

									Double ActualResult1 = Actual.getNumericCellValue();
									ActualResult = ActualResult1.toString();
								}
								if (ExtectedResult.equalsIgnoreCase(ActualResult)) {
									Status.setCellValue("Pass");
									Remark.setCellValue("");
									System.out.println("Test Status : Pass");
									out1.write("\n Test Status : Pass\n");
									Screenshot.setCellValue("");
								}
								if (!ExtectedResult.equalsIgnoreCase(ActualResult)) {
									Status.setCellValue("Fail");
									System.out.println("Test Status : Fail");
									out1.write("\n Test Status : Fail\n");

									// Get the Screenshot path of Failed test cases
									if (Status.getStringCellValue().trim().equalsIgnoreCase("Fail")) {
										Screenshot.setCellValue(destinationScreenshotPath);
									}
								}

								if (Remark.getStringCellValue().trim().contains("2)")) {
									// PR_Test_Cases += 1;
									driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
									Remark.setCellValue("");
									Remark.setCellValue(Remark.getStringCellValue()
											+ "Tool level test case gets fail due to element not found..");
									System.out.println("Tool level test case gets fail due to element not found..");
									out1.write("Tool level test case gets fail due to element not found..\n");
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
									System.out.println("toollvelefailexecount : " + toollvelefailexecount);
									if (toollvelefailexecount < 3) {
										k -= 1;
										// Remark.setCellValue(".");
										toollvelefailexecount++;
									} else {
										toollvelefailexecount = 1;
									}
									if (toollvelefailexecount == 2) {
										Fail_Test_Cases -= 1;
									}
									if (toollvelefailexecount == 3) {
										Status.setCellValue("Fail");
										Remark.setCellValue(Remark.getStringCellValue()+"Tool level test case gets fail due to element not found..");
										PR_Test_Cases += 1;
										Fail_Test_Cases -= 1;
									}
								}
								// Calculate the Time Required to execute each test case.
								TestEndTime = new Date().getTime();
								long duration = TestEndTime - TestStartTime;
								long Time = duration / 1000;
								time.setCellValue("" + Time + " Seconds");
								System.out.println("Test Time : " + Time + " Seconds");

							} catch (Exception e) {
								System.out.println("Please Maintain Expected Result in Proper Format");
								out1.write("Please Maintain Expected Result in Proper Format");
								Status.setCellValue("Fail");
							}
						}

						if (Status.getStringCellValue().equals("Pass")) {
							Pass_Test_Cases += 1;
							Remark.setCellValue("");
						} else if (Status.getStringCellValue().equals("Fail")) {
							Fail_Test_Cases += 1;
						}

						if (k == 50 || k == 100 || k == 150 || k == 200 || k == 250 || k == 300) {
							Thread.sleep(500);
							driver.quit();
							out1.write("__________________________________________________________________________________\n");
							System.out.println("Browser Close, Reopen & Continue Execution... ");
							out1.write("Browser Close, Reopen & Continue Execution...  \n");
							Login.CallloginScreen();
						}

					}

					FileOutputStream outputStream = new FileOutputStream(
							jarPath + "//Test Cases Sheets" + File.separator + CurrentExeExcel);
					workbook.write(outputStream);

				} catch (Exception e) {
					FileOutputStream outputStream = new FileOutputStream(
							jarPath + "//Test Cases Sheets" + File.separator + CurrentExeExcel);
					workbook.write(outputStream);
				}
			} catch (Exception e) {
				out1.write("" + e + "\n");
			}

			// Calculate the Time Required to Execute Single Sheet.
			SingleSheetExeStopTime = new Date().getTime();
			long duration = SingleSheetExeStopTime - SingleSheetExeStartTime;
			long Time = duration / (1000 * 60);

			// Generate Report
			ReportGenarate.SingleSheetReportGenarate(Pass_Test_Cases, Fail_Test_Cases, PR_Test_Cases, Time);
		}
		for (Row row : workbook1.getSheet(sheet.getSheetName())) {
			if (row == null)
				continue; // Skip null rows

			for (Cell cell : row) {
				if (cell != null && cell.getCellType() == CellType.STRING) {
					String cellValue = cell.getStringCellValue().trim();
					if ("null".equalsIgnoreCase(cellValue)) {
						cell.setCellValue(""); // Replace "null" with an empty string
					}
				}
			}
		}
		Thread.sleep(500);
		driver.quit();
	}
}
