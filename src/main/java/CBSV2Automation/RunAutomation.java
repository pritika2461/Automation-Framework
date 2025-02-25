package CBSV2Automation;

import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class RunAutomation extends Base {

    public static String consoleReportFile, summaryReportFile, pdfReportFile;

    @Test
    public void Login() throws InterruptedException, ClassNotFoundException, SQLException, IOException {

        ExeStartTime = new Date().getTime();
        String ExecutionStart = CommonFunctions.generateTime();

        String inputDataExcel = prop.getProperty("InputDataExcel");
        String metaDataExcel = prop.getProperty("MetaDataExcel");

        String[] excelFiles = inputDataExcel.split(",");
        String[] metaFiles = metaDataExcel.split(",");

        System.out.println("Run Automation");

        for (String fileName : excelFiles) {
            fileName = fileName.trim();
            CurrentExeExcel = fileName;

            jarPath = URLDecoder.decode(jarPath, "UTF-8");
            String matchingMetaSheet = findMatchingMetaSheet(fileName, metaFiles);

            if (matchingMetaSheet != null) {
                executeTestCase(fileName, matchingMetaSheet);
            } else {
                System.out.println("No matching metaSheet found for file: " + fileName + ". Skipping execution.");
            }
        }
        logSummary(ExecutionStart);
    }

    private void executeTestCase(String fileName, String matchingMetaSheet) {
        try {
            String excelFilePath = jarPath + "\\Test Cases Sheets" + File.separator + fileName;
            CommonFunctions.createBackup(excelFilePath);
            String metaDataSheetPath = jarPath + "\\MetaData Sheets" + File.separator + matchingMetaSheet;

            loadExcelFiles(excelFilePath, metaDataSheetPath);

            String timestamp = CommonFunctions.generateTime1();
            consoleReportFile = generateFilePath("ConsoleReport", fileName, timestamp);
            summaryReportFile = generateFilePath("SummaryReport", fileName, timestamp);
            pdfReportFile = generatepdfPath("PDFReport", fileName, timestamp);

            consoleReportFile = URLDecoder.decode(consoleReportFile, "UTF-8");
            summaryReportFile = URLDecoder.decode(summaryReportFile, "UTF-8");

            ScreenshotDirectoryPath = jarPath + "\\Test-Output\\Screenshots\\" + SuitProperiesFileName + "//";
            ScreenshotDirectoryPath1 = jarPath + "\\Test-Output\\Screenshots\\" + SuitProperiesFileName + "//ToolLevelFailCases//";

            ScreenshotDirectoryPath = URLDecoder.decode(ScreenshotDirectoryPath, "UTF-8");
            ScreenshotDirectoryPath1 = URLDecoder.decode(ScreenshotDirectoryPath1, "UTF-8");

            setupDirectories();
            initializeReportWriters(consoleReportFile, summaryReportFile);
            ReportGenarate.writeExecutionDetails(fileName);

            pauseButton.setEnabled(true);
            PauseResumeAutomation.checkPause();
            processSheets(executionType);

        } catch (IOException | ClassNotFoundException | InterruptedException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error during test case execution: " + e.getMessage(), e);
        }
    }

    private void loadExcelFiles(String excelFilePath, String metaDataSheetPath) throws IOException {
        File excelFile1 = new File(excelFilePath);
        File excelFile2 = new File(metaDataSheetPath);

        if (excelFile1.exists() && excelFile2.exists()) {
            try (FileInputStream excelStream1 = new FileInputStream(excelFile1);
                    FileInputStream excelStream2 = new FileInputStream(excelFile2)) {

                workbook = new XSSFWorkbook(excelStream1);
                workbook1 = new XSSFWorkbook(excelStream2);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            throw new FileNotFoundException("Excel file not found: " + excelFilePath + " or " + metaDataSheetPath);
        }
    }

    private String generateFilePath(String reportType, String fileName, String timestamp) {
        return jarPath + "\\Test-Output\\" + reportType + "\\" + SuitProperiesFileName + "//" + reportType + "_"
                + fileName + "_ExeType(" + executionType + ")_Date" + timestamp + ".txt";
    }

    private String generatepdfPath(String reportType, String fileName, String timestamp) {
        return jarPath + "\\Test-Output\\" + reportType + "\\" + SuitProperiesFileName + "//" + reportType + "_"
                + fileName + "_ExeType(" + executionType + ")_Date" + timestamp + ".pdf";
    }

    private void setupDirectories() {
        new File(jarPath + "\\Test-Output\\ConsoleReport\\" + SuitProperiesFileName).mkdirs();
        new File(jarPath + "\\Test-Output\\SummaryReport\\" + SuitProperiesFileName).mkdirs();
        new File(jarPath + "\\Test-Output\\PDFReport\\" + SuitProperiesFileName).mkdirs();
        new File(jarPath + "\\Test-Output\\Screenshots\\" + SuitProperiesFileName + "\\ToolLevelFailCases").mkdirs();
    }

    private void initializeReportWriters(String consoleReportFile, String summaryReportFile) throws IOException {
        out1 = new PrintWriter(new FileWriter(consoleReportFile, true));
        out = new PrintWriter(new FileWriter(summaryReportFile, true));
    }

    private String findMatchingMetaSheet(String fileName, String[] metaFiles) {
        for (String metaFile : metaFiles) {
            metaFile = metaFile.trim();
            if (metaFile.equalsIgnoreCase(fileName)) {
                return metaFile;
            }
        }
        return null;
    }

    private void processSheets(String executionType)
            throws IOException, ClassNotFoundException, InterruptedException, SQLException {
        if (executionType.contains("All")) {
            Excetution_start = 0;
            Execution_end = workbook.getNumberOfSheets();
            MainFile.AutomationLogic();
        } else if (executionType.contains(",")) {
            for (String value : executionType.split(",")) {
                Login.CallloginScreen();
                processExecutionRange(value.trim());
            }
        } else {
            Login.CallloginScreen();
            processExecutionRange(executionType);
        }
    }

    private void processExecutionRange(String range)
            throws IOException, ClassNotFoundException, InterruptedException, SQLException {
        if (range.contains("-")) {
            String[] rangeParts = range.split("-");
            Excetution_start = Integer.parseInt(rangeParts[0].trim());
            Execution_end = Integer.parseInt(rangeParts[1].trim());
        } else {
            Excetution_start = Integer.parseInt(range.trim());
            Execution_end = Excetution_start;
        }
        MainFile.AutomationLogic();
    }

    private void logSummary(String executionStart) throws IOException {
        ExeStopTime = new Date().getTime();
        long duration = ExeStopTime - ExeStartTime;
        long Time = duration / (1000 * 60);
        String ExecutionStop = CommonFunctions.generateTime();

        System.out.println(" Total Time Required To Run All Test Cases : " + Time + " Minutes");
        ReportGenarate.logFinalSummary(executionStart, ExecutionStop, Time);

        out.close();
        out1.close();
    }
}