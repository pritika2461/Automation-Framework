package CBSV2Automation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionCommonCode extends Base {

    public static Boolean performSendKeyAction(String actionType, XSSFCell inputCell, XSSFCell nextInputCell,
            XSSFCell Expected, XSSFCell actualCell, WebElement locator, XSSFRow rowk, int inputCellIndex,
            Properties p, Keys actionKey, List<String> myList, String TCID,
            String SheetName, WebDriver driver, int j, XSSFCell ID1,
            XSSFCell ValidationXpath1, XSSFCell Action, XSSFCell Remark) throws InterruptedException {
        Boolean isBreak = false;
        try {
            if (locator.isEnabled()) {
                if (inputCell == null) {
                    inputCell = rowk.createCell(inputCellIndex);
                    inputCell.setCellValue("null");
                }
                KeywordsFunction.CheckFormTitle(inputCell, actualCell, TCID);
                KeywordsFunction.getDefaultValue(inputCell, nextInputCell, actualCell, TCID);
                KeywordsFunction.SaveFormDetails(nextInputCell, inputCell, ValidationXpath1, TCID, actualCell, ID1,
                        isBreak, Remark);
                SendInputValue(nextInputCell, inputCell, Action, actionKey);
                KeywordsFunction.checkFocusShift(nextInputCell, actualCell, TCID, ID1);
                KeywordsFunction.CheckFieldsEnabled(nextInputCell, actualCell, TCID, Expected);
                KeywordsFunction.CheckFieldsDisabled(nextInputCell, actualCell, TCID, Expected);
                KeywordsFunction.CheckEnabledButtons(nextInputCell, actualCell, TCID);
                KeywordsFunction.checkLOVDisplay(nextInputCell, actualCell, TCID);
                isBreak = captureScreenshotAndHandleButtons(driver, TCID, SheetName, p, myList, actualCell, j, ID1,
                        nextInputCell, Remark);
            } else {
                Thread.sleep(1000);
                locator.sendKeys("" + actionKey);
                if (driver.findElement(By.id("altBtn")).isDisplayed()) {
                    destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);

                    if (driver.findElement(By.id("altBtn")).isDisplayed()) {
                        String alertText = driver.findElement(By.xpath(p.getProperty("alertDialogText"))).getText();
                        driver.findElement(By.id("altBtn")).click();
                        System.out.println("alertText : " + alertText);
                    }

                    handleAlertActions(driver, myList);
                    actualCell.setCellValue(msg);
                    out1.write("Toast Msg : " + msg);
                    j += 200;
                    isBreak = true;
                }
            }
            try {
                if (inputCell.getStringCellValue().contains("null")) {
                    inputCell.setCellValue("");
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        return isBreak;
    }

    public static Boolean performSendKeyAction11(String actionType, XSSFCell inputCell, XSSFCell nextInputCell,
            XSSFCell Expected, XSSFCell actualCell, WebElement locator, XSSFRow rowk, int inputCellIndex,
            Properties p, Keys actionKey, List<String> myList, String TCID,
            String SheetName, WebDriver driver, int j, XSSFCell ID1,
            XSSFCell ValidationXpath1, XSSFCell Action, XSSFCell Remark) throws InterruptedException {
        Boolean isBreak = false;
        try {

            if (locator != null && locator.isEnabled()) {
                if (inputCell == null) {
                    inputCell = rowk.createCell(inputCellIndex);
                    inputCell.setCellValue("null");
                }
                KeywordsFunction.CheckFormTitle(inputCell, actualCell, TCID);
                KeywordsFunction.getDefaultValue(inputCell, nextInputCell, actualCell, TCID);
                KeywordsFunction.SaveFormDetails(nextInputCell, inputCell, ValidationXpath1, TCID, actualCell, ID1,
                        isBreak, Remark);
                SendInputValue1(nextInputCell, inputCell, Action, actionKey);
                KeywordsFunction.checkLOVDisplay(nextInputCell, actualCell, TCID);
                KeywordsFunction.checkFocusShift(nextInputCell, actualCell, TCID, ID1);
                KeywordsFunction.CheckFieldsEnabled(nextInputCell, actualCell, TCID, Expected);
                KeywordsFunction.CheckFieldsDisabled(nextInputCell, actualCell, TCID, Expected);
                KeywordsFunction.CheckEnabledButtons(nextInputCell, actualCell, TCID);
                isBreak = captureScreenshotAndHandleButtons(driver, TCID, SheetName, p, myList, actualCell, j, ID1,
                        nextInputCell, Remark);
                otherCaseFunctionCall(inputCell, nextInputCell, actualCell, TCID, ID1, Expected);
            } else {
            }
            try {
                if (inputCell.getStringCellValue().contains("null")) {
                    inputCell.setCellValue(".");
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        return isBreak;
    }

    public static void handleAlertActions(WebDriver driver, List<String> myList) throws InterruptedException {
        Thread.sleep(100);
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
        j += 200;
    }

    public static Boolean captureScreenshotAndHandleButtons(WebDriver driver, String TCID, String SheetName,
            Properties p, List<String> myList, XSSFCell actualCell, int j, XSSFCell ID1, XSSFCell nextInputCell,
            XSSFCell Remark)
            throws InterruptedException {
        Boolean isBreak = false;
        try {
            Thread.sleep(500);
            KeywordsFunction.CheckConfirmationMsgYes(nextInputCell);
            KeywordsFunction.CheckConfirmationMsgNo(nextInputCell);
            KeywordsFunction.SkipAlertMsg(nextInputCell);
            if (driver.findElement(By.id("altBtn")).isDisplayed()) {
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                String msg = CommonFunctions.AlertMsg();
                try {
                    if (msg.contains("SAME USER IS LOGIN FROM ANOTHER MACHINE,PLEASE VERIFY")) {
                        out1.write("Relogin by Opening Another Browser. ");
                        System.out.println("Relogin by Opening Another Browser. ");
                        Login.ReloginScreen();
                        Remark.setCellValue(msg);
                    }
                } catch (Exception e) {
                }
                handleAlertActions(driver, myList);
                actualCell.setCellValue(msg);
                out1.write("Toast Msg : " + msg);
                j += 200;
                isBreak = true;
            }

            else if (driver.findElement(By.xpath(p.getProperty("Table"))).isDisplayed()) {
                Thread.sleep(100);
                KeywordsFunction.checkOnESCAPELOVIsOpen(nextInputCell, actualCell, TCID);
                KeywordsFunction.checkLOVDisplay(nextInputCell, actualCell, TCID);
                driver.findElement(By.xpath("" + ID1)).click();

            }
        } catch (Exception e) {
        }
        return isBreak;
    }

    public static void SendInputValue(XSSFCell nextInputCell, XSSFCell inputCell, XSSFCell Action, Keys actionKey) throws InterruptedException {
        try {
        	KeywordsFunction.ENTERACTION(nextInputCell, actionKey);
        	KeywordsFunction.TABACTION(nextInputCell, actionKey);
        	
            if (inputCell.getCellType().equals(Action.getCellType())
                    && inputCell.getStringCellValue().trim().equalsIgnoreCase("null")) {
            	
                locator.sendKeys(actionKey);
                Thread.sleep(500);
            } else {
                data = CommonFunctions.getCellValue(inputCell);
                locator.sendKeys(data);
            	locator.sendKeys(actionKey);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            data = CommonFunctions.getCellValue(inputCell);
            locator.sendKeys(data + actionKey);
            System.out.println("Data Pass: " + data);
            Thread.sleep(500);
        }
    }

    public static void SendInputValue1(XSSFCell nextInputCell, XSSFCell inputCell, XSSFCell Action, Keys actionKey)
            throws InterruptedException {
        try {
        	KeywordsFunction.ENTERACTION(nextInputCell, actionKey);
        	KeywordsFunction.TABACTION(nextInputCell, actionKey);
            if (inputCell.getCellType().equals(Action.getCellType())
                    && inputCell.getStringCellValue().trim().equalsIgnoreCase("null")) {
            	
                locator.sendKeys(actionKey);
                Thread.sleep(500);
                locator.sendKeys(actionKey);
                Thread.sleep(500);
            } else {
                data = CommonFunctions.getCellValue(inputCell);
                locator.sendKeys(data + actionKey);
                locator.sendKeys(actionKey);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            data = CommonFunctions.getCellValue(inputCell);
             locator.sendKeys(data);          
        	 locator.sendKeys(actionKey);
             Thread.sleep(500);
            locator.sendKeys(actionKey);
            Thread.sleep(500);
        }
    }

    public static void handleAlertMessages(XSSFCell TCID, XSSFCell ActualCell, XSSFCell Remark)
            throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        if (driver.findElement(By.id("altBtn")).isDisplayed()) {
            Thread.sleep(100);
            String msg1 = driver.findElement(By.xpath(p.getProperty("alertDialogText"))).getText();

            driver.findElement(By.id("altBtn")).click();
            Thread.sleep(500);
            destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver,
                    "" + TCID.getStringCellValue() + "_" + SheetName);
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
            if (msg1.contains("SAME USER IS LOGIN FROM ANOTHER MACHINE,PLEASE VERIFY")) {
                out1.write("Relogin by Opening Another Browser. ");
                System.out.println("Relogin by Opening Another Browser. ");
                Login.ReloginScreen();
                Remark.setCellValue(msg);
            }

            System.out.println("Toast Msg : " + msg1);
            ActualCell.setCellValue(msg1);
            j += 200;
        }
    }

    public static void handleSelectForm(String formType, WebElement locator, XSSFCell inputCell, XSSFCell nextInputCell,
            XSSFCell actualCell, XSSFCell Expected, Keys actionKey, XSSFCell ID1,
            XSSFRow row, int cellIndex, String TCID, String SheetName, List<String> myList, WebDriver driver,
            XSSFCell Actual, PrintWriter out1, XSSFCell Remark) throws InterruptedException, IOException {

        KeywordsFunction.CheckFormTitle(inputCell, actualCell, TCID);
        KeywordsFunction.getDefaultValue(inputCell, nextInputCell, actualCell, TCID);
        KeywordsFunction.getLOVOption(nextInputCell, locator, actualCell, TCID);
        Thread.sleep(100);
        if (locator.isEnabled()) {
            if (inputCell == null) {
                inputCell = row.createCell(cellIndex);
                inputCell.setCellValue("null");
            }
            if (inputCell.getCellType().equals(CellType.STRING)
                    && inputCell.getStringCellValue().trim().equalsIgnoreCase("null")) {
                Thread.sleep(200);
                KeywordsFunction.ENTERACTION(nextInputCell, actionKey);
            	KeywordsFunction.TABACTION(nextInputCell, actionKey);
                locator.sendKeys(actionKey);
                Thread.sleep(200);

                otherCaseFunctionCall(inputCell, nextInputCell, actualCell, TCID, ID1, Expected);
                processAlertAndScreenshot(TCID, SheetName, myList, driver, Actual, Remark);
            } else {
                Select dropdown = new Select(locator);
                String option = inputCell.getStringCellValue().trim();
                dropdown.selectByVisibleText(option);
                locator.sendKeys(actionKey);
                Thread.sleep(200);
                locator.sendKeys(actionKey);
                otherCaseFunctionCall(inputCell, nextInputCell, actualCell, TCID, ID1, Expected);
                KeywordsFunction.CheckSelectedElement(nextInputCell, actualCell, dropdown, TCID);
                processAlertAndScreenshot(TCID, SheetName, myList, driver, Actual, Remark);
            }

            try {
                if (inputCell.getStringCellValue().contains("null")) {
                    inputCell.setCellValue("");
                }
            } catch (Exception e) {
            }
        } else {
            out1.write(locator + " locator is Disabled.");
        }
    }

    public static void handleSelectForm1(String formType, WebElement locator, XSSFCell inputCell,
            XSSFCell nextInputCell,
            XSSFCell actualCell, XSSFCell Expected, Keys actionKey, XSSFCell ID1,
            XSSFRow row, int cellIndex, String TCID, String SheetName, List<String> myList, WebDriver driver,
            XSSFCell Actual, PrintWriter out1, XSSFCell Remark) throws InterruptedException, IOException {

        KeywordsFunction.CheckFormTitle(inputCell, actualCell, TCID);
        KeywordsFunction.getDefaultValue(inputCell, nextInputCell, actualCell, TCID);
        KeywordsFunction.getLOVOption(nextInputCell, locator, actualCell, TCID);
        Thread.sleep(100);
        if (locator.isEnabled()) {
        	KeywordsFunction.ENTERACTION(nextInputCell, actionKey);
        	KeywordsFunction.TABACTION(nextInputCell, actionKey);
            if (inputCell == null) {
                inputCell = row.createCell(cellIndex);
                inputCell.setCellValue("null");
            }
            if (inputCell.getCellType().equals(CellType.STRING)
                    && inputCell.getStringCellValue().trim().equalsIgnoreCase("null")) {
                Thread.sleep(200);
                locator.sendKeys(actionKey);
                Thread.sleep(200);
                locator.sendKeys(actionKey);

                otherCaseFunctionCall(inputCell, nextInputCell, actualCell, TCID, ID1, Expected);
                processAlertAndScreenshot(TCID, SheetName, myList, driver, Actual, Remark);
            } else {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(locator));

                locator.click();
                Select dropdown = new Select(locator);
                String option = inputCell.getStringCellValue().trim();
                dropdown.selectByVisibleText(option);
                locator.sendKeys(actionKey);
                Thread.sleep(200);
                locator.sendKeys(actionKey);
                otherCaseFunctionCall(inputCell, nextInputCell, actualCell, TCID, ID1, Expected);
                KeywordsFunction.CheckSelectedElement(nextInputCell, actualCell, dropdown, TCID);
                processAlertAndScreenshot(TCID, SheetName, myList, driver, Actual, Remark);
            }

            try {
                if (inputCell.getStringCellValue().contains("null")) {
                    inputCell.setCellValue("");
                }
            } catch (Exception e) {
            }
        } else {
            out1.write(locator + " locator is Disabled.");
        }
    }

    private static Boolean processAlertAndScreenshot(String TCID, String SheetName, List<String> myList,
            WebDriver driver, XSSFCell Actual, XSSFCell Remark) throws InterruptedException {
        Boolean isBreak = false;
        try {
            if (driver.findElement(By.id("altBtn")).isDisplayed()) {
                destinationScreenshotPath = ScreenshotCapture.captureScreenshot(driver, TCID + "_" + SheetName);
                String msg = CommonFunctions.AlertMsg();
                if (msg.contains("SAME USER IS LOGIN FROM ANOTHER MACHINE,PLEASE VERIFY")) {
                    out1.write("Relogin by Opening Another Browser. ");
                    System.out.println("Relogin by Opening Another Browser. ");
                    Login.ReloginScreen();
                    Remark.setCellValue(msg);
                }
                handleAlertActions(driver, myList);
                for (String item : myList) {
                    try {
                        if (!driver.findElements(By.id(item)).isEmpty()
                                && driver.findElement(By.id(item)).isDisplayed()) {
                            driver.findElement(By.id(item)).click();
                            Thread.sleep(500);
                        }
                    } catch (Exception e) {
                    }
                }
                Actual.setCellValue(msg);
                j += 200;
                isBreak = true;
            }
        } catch (Exception e) {

        }
        return isBreak;
    }

    public static void selectRadioButton(String actionName, XSSFCell inputCell, WebDriver driver, XSSFCell actualCell,
            XSSFCell nextInputCell, XSSFCell Expected, String TCID, XSSFCell ID1) {
        try {

            KeywordsFunction.CheckFormTitle(inputCell, actualCell, TCID);
            KeywordsFunction.getDefaultValue(inputCell, nextInputCell, actualCell, TCID);
            KeywordsFunction.checkFocusShift(nextInputCell, actualCell, TCID, ID1);
            KeywordsFunction.CheckFieldsEnabled(nextInputCell, actualCell, TCID, Expected);
            KeywordsFunction.CheckFieldsDisabled(nextInputCell, actualCell, TCID, Expected);
            KeywordsFunction.CheckEnabledButtons(nextInputCell, actualCell, TCID);
            if (inputCell != null) {
                driver.findElement(By.id(inputCell.getStringCellValue())).click();
            }
        } catch (Exception e) {
        }
    }

    public static void otherCaseFunctionCall(XSSFCell inputCell, XSSFCell nextInputCell, XSSFCell actualCell,
            String TCID, XSSFCell ID1, XSSFCell Expected) {
        KeywordsFunction.CheckFormTitle(inputCell, actualCell, TCID);
        KeywordsFunction.checkFocusShift(nextInputCell, actualCell, TCID, ID1);
        KeywordsFunction.checkLOVDisplay(nextInputCell, actualCell, TCID);
        KeywordsFunction.checkOnESCAPELOVIsOpen(nextInputCell, actualCell, TCID);
        KeywordsFunction.CheckFieldsEnabled(nextInputCell, actualCell, TCID, Expected);
        KeywordsFunction.CheckFieldsDisabled(nextInputCell, actualCell, TCID, Expected);
        KeywordsFunction.CheckEnabledButtons(nextInputCell, actualCell, TCID);
        KeywordsFunction.getLOVOption(nextInputCell, locator, actualCell, TCID);
        KeywordsFunction.getDefaultValue(inputCell, nextInputCell, actualCell, TCID);
    }
}
