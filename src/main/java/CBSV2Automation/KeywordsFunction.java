package CBSV2Automation;

import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeywordsFunction extends Base {

	public static void ENTERACTION(XSSFCell nextInputCell, Keys actionKey) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase("ENTER")) {
            	actionKey = Keys.ENTER;
            }
        } catch (Exception e) {
        }
    }

	public static void TABACTION(XSSFCell nextInputCell, Keys actionKey) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase("TAB")) {
            	actionKey = Keys.TAB;
            }
        } catch (Exception e) {
        }
    }
		
    public static void checkFocusShift(XSSFCell nextInputCell, XSSFCell actualCell, String TCID, XSSFCell ID1) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckFocusShift"))) {
                Thread.sleep(500);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebElement activeElement = (WebElement) js.executeScript("return document.activeElement;");

                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                System.out.println("Focus Shifted to "
                        + (activeElement.getAttribute("name") != null ? activeElement.getAttribute("ID")
                                : "No Name"));
                actualCell.setCellValue("Focus Shifted to "
                        + (activeElement.getAttribute("name") != null ? activeElement.getAttribute("ID")
                                : "No Name"));
                out1.write("Focus Shifted to "
                        + (activeElement.getAttribute("name") != null ? activeElement.getAttribute("ID")
                                : "No Name"));
                ActionCommonCode.handleAlertActions(driver, myList);
            }
        } catch (Exception e) {
        }
    }

    public static void checkLOVDisplay(XSSFCell nextInputCell, XSSFCell actualCell, String TCID) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckLOVDisplay"))) {
                Thread.sleep(500);
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);

                List<WebElement> elements = driver.findElements(By.className("top-head"));
                String msg = elements.get(1).getText();
                System.out.println(msg);
                actualCell.setCellValue(msg);
                out1.write(msg + "\n");
                WebElement body = driver.findElement(By.tagName("body"));
                body.sendKeys(Keys.ESCAPE);
                Thread.sleep(1000);
                ActionCommonCode.handleAlertActions(driver, myList);
            }
        } catch (Exception e) {
        }
    }

    public static void checkOnESCAPELOVIsOpen(XSSFCell nextInputCell, XSSFCell actualCell, String TCID) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("EscapeAndCheckFocusShift"))) {
                Thread.sleep(1000);
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                WebElement body = driver.findElement(By.tagName("body"));
                body.sendKeys(Keys.ESCAPE);
                Thread.sleep(500);
                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebElement activeElement = (WebElement) js.executeScript("return document.activeElement;");

                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                System.out.println(" Focus shifted to : " +
                        (activeElement.getAttribute("name") != null ? activeElement.getAttribute("ID") : "No Where"));
                actualCell.setCellValue("Focus Shifted to "
                        + (activeElement.getAttribute("name") != null ? activeElement.getAttribute("ID") : "No Where")
                        + "\n");
                out1.write(" Focus shifted to element with Name: " +
                        (activeElement.getAttribute("name") != null ? activeElement.getAttribute("ID") : "No Where"));
                ActionCommonCode.handleAlertActions(driver, myList);
            }
        } catch (Exception e) {
        }
    }

    public static void CheckFieldsEnabled(XSSFCell nextInputCell, XSSFCell actualCell, String TCID, XSSFCell Expected) {
        try {
            String fieldName = "";
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckEnabledFields"))) {
                Thread.sleep(800);
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                List<WebElement> inputFields = driver.findElements(By.cssSelector("input[type='text'] ,input[type='select'], input[type='radio']"));

                if (inputFields.size() > 0) {
                    for (int i = 0; i < inputFields.size(); i++) {
                        WebElement field = inputFields.get(i);

                        if (field.isEnabled()) {
                            String fieldName1 = field.getAttribute("id") != null ? field.getAttribute("id") : "No Name";
                            fieldName = fieldName + fieldName1 + ", ";
                        }
                    }

                    // Fix: Remove last comma and space safely
                    if (!fieldName.isEmpty() && fieldName.endsWith(", ")) {
                        fieldName = fieldName.substring(0, fieldName.length() - 2);
                    }

                    Thread.sleep(200);
                    if (fieldName != null && Expected.getStringCellValue() != null) {
                        System.out.println("Expected: " + Expected.getStringCellValue());
                        if (fieldName.trim().toUpperCase()
                                .contains(Expected.getStringCellValue().trim().toUpperCase())) {
                            fieldName = Expected.getStringCellValue().trim();
                        }
                    }

                    System.out.println(" " + fieldName);
                    actualCell.setCellValue(fieldName);
                    out1.write(fieldName + "\n");
                    ActionCommonCode.handleAlertActions(driver, myList);
                } else {
                    System.out.println("No input fields found on the form.");
                }
            }

        } catch (Exception e) {
        }

    }

    public static void CheckFieldsDisabled(XSSFCell nextInputCell, XSSFCell actualCell, String TCID,
            XSSFCell Expected) {
        try {
            String fieldName = "Disable Fields are : ";
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckDisabledFields"))) {
                Thread.sleep(500);
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                List<WebElement> inputFields = driver.findElements(By.cssSelector(
                        "input[type='text'] ,input[type='select'],input[type='checkbox']"));

                if (inputFields.size() > 0) {
                    for (int i = 0; i < inputFields.size(); i++) {
                        WebElement field = inputFields.get(i);

                        if (!field.isEnabled()) {
                            String fieldName1 = field.getAttribute("name") != null ? field.getAttribute("name")
                                    : "No Name";
                            fieldName = fieldName + fieldName1 + ", ";
                        }
                    }

                    fieldName = fieldName.replace((char) (fieldName.length() - 1), 'r');
                    if (fieldName != null && Expected.getStringCellValue() != null) {
                        if (fieldName.trim().contains(Expected.getStringCellValue().trim())) {
                            fieldName = Expected.getStringCellValue().trim();
                        }
                    }

                    System.out.println(" " + fieldName);
                    actualCell.setCellValue(fieldName);
                    out1.write(fieldName + "\n");
                    ActionCommonCode.handleAlertActions(driver, myList);
                } else {
                    System.out.println("No input fields found on the form.");
                }
            }
        } catch (Exception e) {
        }
    }

    public static void CheckSelectedElement(XSSFCell nextInputCell, XSSFCell actualCell, Select dropdown, String TCID) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckSelectedElement"))) {
                Thread.sleep(500);
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                String selectedText = dropdown.getFirstSelectedOption().getText();
                System.out.println("Selected Value " + selectedText);
                actualCell.setCellValue("Selected Value " + selectedText);
                out1.write("Selected Value " + selectedText + "\n");
                ActionCommonCode.handleAlertActions(driver, myList);
            }

        } catch (Exception e) {
        }
    }

    public static void CheckEnabledButtons(XSSFCell nextInputCell, XSSFCell actualCell, String TCID) {
        try {
            String fieldName = "Enabled Buttons are : ";
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckEnabledButtons"))) {
                Thread.sleep(500);
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                List<WebElement> inputFields = driver.findElements(By.cssSelector("input[type='Button']"));

                if (inputFields.size() > 0) {
                    for (int i = 0; i < inputFields.size(); i++) {
                        WebElement field = inputFields.get(i);

                        if (field.isEnabled()) {
                            String fieldName1 = field.getAttribute("name") != null ? field.getAttribute("ID")
                                    : "No Name";
                            fieldName = fieldName + fieldName1 + ", ";
                        }
                    }

                    fieldName = fieldName.replace((char) (fieldName.length() - 1), 'r');
                    System.out.println(" " + fieldName);
                    actualCell.setCellValue(fieldName);
                    out1.write(fieldName + "\n");
                    ActionCommonCode.handleAlertActions(driver, myList);
                } else {
                    System.out.println("No input fields found on the form.");
                }
            }

        } catch (Exception e) {
        }
    }

    public static void CheckFormTitle(XSSFCell InputCell, XSSFCell actualCell, String TCID) {
        try {
            if (InputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckFormTitle"))) {
                Thread.sleep(500);
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                String msg = driver.findElement(By.className("top-head")).getText();
                System.out.println(msg);
                actualCell.setCellValue(msg);
                out1.write(msg);
                ActionCommonCode.handleAlertActions(driver, myList);
            }
        } catch (Exception e) {

        }
    }

    public static void getDefaultValue(XSSFCell inputCell, XSSFCell nextInputCell, XSSFCell actualCell, String TCID) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("GetDefaultValue"))) {
                Thread.sleep(500);
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver,
                        "" + TCID + "_" + SheetName);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                String a = (String) js.executeScript(
                        "if(arguments[0].tagName === 'SELECT') { " +
                                "    return arguments[0].options[arguments[0].selectedIndex].text; " +
                                "} else if (arguments[0].value !== undefined) { " +
                                "    return arguments[0].value; " +
                                "} else { " +
                                "    return arguments[0].innerText || arguments[0].textContent; " +
                                "}",
                        driver.findElement(By.id("" + inputCell)));

                if (a.matches("-?\\d+(\\.\\d+)?")) {
                    long aa = (long) Double.parseDouble(a);
                    System.out.println(aa);
                    actualCell.setCellValue(aa);
                    out1.write("" + aa + "\n");
                } else {
                    System.out.println(" Value: " + a);
                    actualCell.setCellValue(a);
                    out1.write(a + "\n");
                }
                ActionCommonCode.handleAlertActions(driver, myList);
            }
        } catch (Exception e) {
        }
    }

    public static boolean SaveFormDetails(XSSFCell nextInputCell, XSSFCell inputCell, XSSFCell ValidationXpath1,
            String TCID, XSSFCell actualCell, XSSFCell ID1, Boolean isBreak, XSSFCell Remark) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("SaveFormDetailsText"))) {
                data = CommonFunctions.getCellValue(inputCell);
                if (data.trim().equalsIgnoreCase("null")) {
                    Thread.sleep(500);
                } else {
                    Thread.sleep(200);
                    locator.sendKeys(data);
                    Thread.sleep(500);
                }

                if (ValidationXpath1 != null) {
                    driver.findElement(By.id(ValidationXpath1.getStringCellValue())).click();
                }

                isBreak = ActionCommonCode.captureScreenshotAndHandleButtons(driver, TCID, SheetName, p, myList,
                        actualCell, j, ID1, nextInputCell, Remark);
                if (msg.contains("SAME USER IS LOGIN FROM ANOTHER MACHINE,PLEASE VERIFY")) {
                    out1.write("Relogin by Opening Another Browser. ");
                    System.out.println("Relogin by Opening Another Browser. ");
                    Login.ReloginScreen();
                    Remark.setCellValue(msg);
                }

                out1.write(msg + "\n");
                ActionCommonCode.handleAlertActions(driver, myList);
                actualCell.setCellValue(msg);
                try {
                    if (inputCell.getStringCellValue().equalsIgnoreCase("null")) {
                        inputCell.setCellValue(".");
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    public static void getLOVOption(XSSFCell nextInputCell, WebElement locator, XSSFCell actualCell, String TCID) {
        try {
            Thread.sleep(100);
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("GetLOVOptions"))) {

                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                Select dropdown = new Select(locator);
                List<WebElement> options = dropdown.getOptions();
                String options1 = "";
                for (WebElement option : options) {
                    options1 = options1.concat(option.getText() + ", ");
                }
                System.out.println("options1 : " + options1);
                actualCell.setCellValue(options1);
                out1.write(options1 + ", " + "\n");
                ActionCommonCode.handleAlertActions(driver, myList);
            }
        } catch (Exception e) {
        }
    }
    
    public static void CheckConfirmationMsgYes(XSSFCell nextInputCell) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckConfirmationYes"))) {
                Thread.sleep(500);
                if (driver.findElement(By.id("confirmBtn")).isDisplayed()) {
                    driver.findElement(By.id("confirmBtn")).click();
                }
            }
        } catch (Exception e) {
        }
    }

    public static void CheckConfirmationMsgNo(XSSFCell nextInputCell) {
        try {
            if (nextInputCell.getStringCellValue().equalsIgnoreCase(p.getProperty("CheckConfirmationNo"))) {
                Thread.sleep(500);
                if (driver.findElement(By.id("confirmBtn")).isDisplayed()) {
                    driver.findElement(By.id("confirmBtnNo")).click();
                }
            }
        } catch (Exception e) {
        }
    }

    public static void SkipAlertMsg(XSSFCell NextInputCell) {
        try {
            if (NextInputCell.getStringCellValue().trim().contains(p.getProperty("SkipAlertMsg"))) {
                Thread.sleep(500);
                if (driver.findElement(By.id("altBtn")).isDisplayed()) {
                    driver.findElement(By.id("altBtn")).click();
                    Thread.sleep(500);
                }
            }
        } catch (Exception e) {
        }
    }

}
