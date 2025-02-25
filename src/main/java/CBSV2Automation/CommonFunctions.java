package CBSV2Automation;

import java.awt.GridBagConstraints;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class CommonFunctions extends Base {
    public static String RunUser = "";
    private static String XLSX_DIRECTORY = new File(
            Base.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent();

    // Get the Local time of system
    public static String generateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        return formattedDate;
    }

    // Generate the Time in Specific Format.
    public static String generateTime1() {
        LocalDateTime time = LocalDateTime.now();
        String datetime = time.toString();
        String formattedDateTime = datetime.replace("/", "_").replace(":", "_");
        return formattedDateTime;
    }

    // Handle the Alert Msg
    public static String AlertMsg() throws InterruptedException {

        String alertText = driver.findElement(By.xpath(p.getProperty("alertDialogText"))).getText();
        String cleanedMessage;
        if (alertText.matches(".*\\d.*")) {
            cleanedMessage = alertText.replaceAll("\\d+$", "");
        } else {
            cleanedMessage = alertText;
        }
        if (driver.findElement(By.xpath(p.getProperty("alertDialogText1"))).isDisplayed()) {
            String secondaryAlertText = driver.findElement(By.xpath(p.getProperty("alertDialogText1"))).getText();
            String cleanedSecondaryMessage = secondaryAlertText.replaceAll("\\d+$", "");
            cleanedMessage += "  " + cleanedSecondaryMessage;
        }

        driver.findElement(By.id("altBtn")).click();
        Thread.sleep(500);
        System.out.println("Toast Msg : " + cleanedMessage);
        if (driver.findElement(By.id("confirmBtn")).isDisplayed()) {
            driver.findElement(By.id("confirmBtn")).click();
        }       
        return cleanedMessage;
    }

    // Handle the Alert Msg there are two msgs display & return Both Msg.
    public static String AlertMsgFun() throws InterruptedException {
        Thread.sleep(500);
        String primaryAlertText = driver.findElement(By.xpath(p.getProperty("alertDialogText"))).getText();
        String cleanedPrimaryMessage = primaryAlertText.replaceAll("\\d+$", "");
        String combinedMessage = cleanedPrimaryMessage;

        if (driver.findElement(By.id("altBtn")).isDisplayed()) {
            driver.findElement(By.id("altBtn")).click();
        }
        if (driver.findElement(By.id("confirmBtn")).isDisplayed()) {
            driver.findElement(By.id("confirmBtn")).click();
        }

        if (driver.findElement(By.xpath(p.getProperty("alertDialogText1"))).isDisplayed()) {
            String secondaryAlertText = driver.findElement(By.xpath(p.getProperty("alertDialogText1"))).getText();
            String cleanedSecondaryMessage = secondaryAlertText.replaceAll("\\d+$", "");
            combinedMessage += "  " + cleanedSecondaryMessage;
            driver.findElement(By.id("altBtn")).click();
            Thread.sleep(50);
            if (driver.findElement(By.id("Confirm")).isDisplayed()) {
                driver.findElement(By.id("confirmBtn")).click();
            }
        }
        return combinedMessage;
    }

    // Handle the confirm Msg
    public static String ConfirmMsgFun() throws InterruptedException {
        String combinedMessage = driver.findElement(By.xpath(p.getProperty("Confirm"))).getText();
        driver.findElement(By.id("confirmBtn")).click();
        return combinedMessage;
    }

    // Method to wait for the file to be downloaded in the Downloads folder
    public static void waitForFileDownload(String downloadDir, String fileName) throws InterruptedException {
        File file = new File(downloadDir + "/" + fileName);
        int maxWaitTime = 30;
        int waited = 0;

        while (!file.exists() && waited < maxWaitTime) {
            Thread.sleep(1000);
            waited++;
        }

        if (!file.exists()) {
            throw new RuntimeException("File download timed out.");
        }
    }

    public static File getLatestExcelFileFromDir(String dirPath) throws InterruptedException {
        File dir = new File(dirPath);
        Thread.sleep(1000);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".xls") || name.endsWith(".xlsx"));

        if (files != null && files.length > 0) {
            Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
            return files[0];
        }
        return null;
    }

    // Method to rename the downloaded file
    public static void renameDownloadedFile(String downloadDir, String currentFileName, String newFileName) {
        File downloadedFile = new File(downloadDir + "/" + currentFileName);
        File renamedFile = new File(downloadDir + "/" + newFileName);

        if (downloadedFile.exists()) {
            if (renamedFile.exists()) {
                renamedFile.delete();
            }
            boolean success = downloadedFile.renameTo(renamedFile);
            if (success) {
            } else {
                System.out.println("File renaming failed.");
            }
        } else {
            System.out.println("File not found: " + currentFileName);
        }
    }

    // Method to compare two Excel files
    public static void compareExcelFiles(String file1, String file2) throws IOException {
        try (Workbook wb1 = WorkbookFactory.create(new FileInputStream(file1));
                Workbook wb2 = WorkbookFactory.create(new FileInputStream(file2))) {
            for (int i = 0; i < Math.min(wb1.getNumberOfSheets(), wb2.getNumberOfSheets()); i++) {
                Sheet sheet1 = wb1.getSheetAt(i);
                Sheet sheet2 = wb2.getSheetAt(i);
                for (int row = 0; row <= Math.min(sheet1.getLastRowNum(), sheet2.getLastRowNum()); row++) {
                    Row r1 = sheet1.getRow(row), r2 = sheet2.getRow(row);
                    if (r1 != null && r2 != null) {
                        for (int col = 0; col < Math.min(r1.getLastCellNum(), r2.getLastCellNum()); col++) {
                            Cell c1 = r1.getCell(col), c2 = r2.getCell(col);
                            if (c1 != null && c2 != null && !getCellValue(c1).equals(getCellValue(c2))) {
                            }
                        }
                    }
                }
            }
        }
    }

    // Method to compare two Excel files
    public static String compareExcelFile(String file1, String file2) throws IOException {
        String Excelmsg = "";
        try (Workbook wb1 = WorkbookFactory.create(new FileInputStream(file1));
                Workbook wb2 = WorkbookFactory.create(new FileInputStream(file2))) {
            boolean differencesFound = false;
            Sheet sheet1 = wb1.getSheetAt(i);
            Sheet sheet2 = wb2.getSheetAt(i);

            Excelmsg = "Number of Column :" + sheet2.getRow(0).getLastCellNum() + "\nNumber of Rows : "
                    + sheet2.getLastRowNum();
            for (int i = 0; i < Math.min(wb1.getNumberOfSheets(), wb2.getNumberOfSheets()); i++) {
                for (int row = 0; row <= Math.min(sheet1.getLastRowNum(), sheet2.getLastRowNum()); row++) {
                    Row r1 = sheet1.getRow(row), r2 = sheet2.getRow(row);
                    if (r1 != null && r2 != null) {
                        for (int col = 0; col < Math.min(r1.getLastCellNum(), r2.getLastCellNum()); col++) {
                            Cell c1 = r1.getCell(col), c2 = r2.getCell(col);
                            if (c1 != null && c2 != null && !getCellValue(c1).equals(getCellValue(c2))) {
                                String colName = getCellValue(sheet2.getRow(4).getCell(col));
                                String Excelmsg1 = "Difference Column(" + col + "): " + colName + " | Row: " + row
                                        + ",\nExpected = " + getCellValue(c1) + ", Actual = " + getCellValue(c2);
                                differencesFound = true;
                                Excelmsg = (Excelmsg + "\n" + Excelmsg1);
                            }
                        }
                    }
                }
            }
            if (!differencesFound) {
                Excelmsg = "Number of Column :" + sheet2.getRow(0).getLastCellNum() + "\nNumber of Rows : "
                        + sheet2.getLastRowNum()
                        + "\nXlSX Report get Downloaded. And Its equal to the Expected Report.";
            }
        }
        return Excelmsg;
    }

    // Method to rename the downloaded file
    public static String GetrenameDownloadedFile(String downloadDir, String newFileName) {
        File renamedFile = new File(downloadDir + "/" + newFileName);
        String Name = renamedFile.toString();
        return Name;
    }

    public static void readColumnsFromExcel(String filePath, String startCellRef) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook work = new XSSFWorkbook(fis);
        XSSFSheet sheet = work.getSheetAt(0);
        String cellValue1 = "", cellValue = null;
        int[] cellIndices = getRowAndColumnFromCellReference(startCellRef);
        int startRow = cellIndices[0];
        XSSFRow row = sheet.getRow(startRow);

        for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
            XSSFCell cell = row.getCell(colIndex);
            cellValue = getCellValue(cell);
            cellValue1 = (cellValue1 + "|" + cellValue);
        }
        System.out.println(cellValue1);
        work.close();
        fis.close();
    }

    public static String readColumnsFromExcel1(String filePath, String startCellRef) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook work = new XSSFWorkbook(fis);
        XSSFSheet sheet = work.getSheetAt(0);
        String cellValue1 = "", cellValue = null;
        int[] cellIndices = getRowAndColumnFromCellReference(startCellRef);
        int startRow = cellIndices[0];

        XSSFRow row = sheet.getRow(startRow);
        if (row != null) {

            for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
                XSSFCell cell = row.getCell(colIndex);
                cellValue = getCellValue(cell);
                cellValue1 = (cellValue1 + "|" + cellValue);
            }
        } else {
            System.out.println("Row " + (startRow + 1) + " is empty or not found.");
        }
        work.close();
        fis.close();
        return cellValue1;
    }

    // Convert an Excel cell reference (e.g., A1) to row and column indices
    public static int[] getRowAndColumnFromCellReference(String cellReference) {
        CellReference ref = new CellReference(cellReference);
        return new int[] { ref.getRow(), ref.getCol() };
    }

    // Get the cell value as a string
    public static String getCellValue(Cell cell) {
        final DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    return dateFormat.format(date);
                } else {
                    double numericValue = cell.getNumericCellValue();
                    if (numericValue == Math.floor(numericValue)) {
                        return String.valueOf((long) numericValue);
                    } else {
                        return decimalFormat.format(numericValue);
                    }
                }
            default:
                return "";
        }
    }

    static String[] loadXLSXFiles(String directoryType) throws UnsupportedEncodingException {
        // Get the list of all .xlsx files for the specified directory type
        String XLSX_DIRECTORY1 = URLDecoder.decode(XLSX_DIRECTORY, "UTF-8");
        File dir = new File(XLSX_DIRECTORY1 + "/" + directoryType + "/");

        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".xlsx"));
        if (files != null && files.length > 0) {
            return Arrays.stream(files).map(File::getName).toArray(String[]::new);
        } else {
            return new String[] { "No XLSX files found" };
        }
    }

    static void addField(JFrame frame, GridBagConstraints gbc, String label, JComponent field, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        frame.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        frame.add(field, gbc);
    }

    // Create Excel sheet Backup
    public static void createBackup(String originalFilePath) throws IOException {
        File originalFile = new File(originalFilePath);

        if (originalFile.exists()) {
            String timestamp = CommonFunctions.generateTime1();

            File backupDir = new File(originalFile.getParent() + File.separator + "Backup");
            if (!backupDir.exists()) {
                backupDir.mkdirs();
            }

            // Create the backup file path inside the "Backup" folder
            String backupFilePath = backupDir.getAbsolutePath() + File.separator +
                    originalFile.getName().replace(".xlsx", "_Backup_" + timestamp + ".xlsx");

            // Copy the original file to the backup file
            try (FileInputStream fis = new FileInputStream(originalFile);
                    FileOutputStream fos = new FileOutputStream(new File(backupFilePath))) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            }
        } else {
            throw new FileNotFoundException("Original file not found: " + originalFilePath);
        }
    }
}
