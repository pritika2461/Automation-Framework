package CBSV2Automation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ReportGenarate extends Base {

    public static void initialRoportrintCode() {
        try {
            if (RunTestCaseFlag == "Yes") {
                Test_start = FlagTeststart;
                Test_end = FlagTestend;
                System.out.println("Test Cases Executing from : TCID" + Test_start + "  -  TCID" + Test_end);
                out.write("Test Cases Executing from : TCID" + Test_start + " - TCID" + Test_end + "\n");
                out1.write("Test Cases Executing from : TCID" + Test_start + " - TCID" + Test_end + "\n");
            } else {
                if (!(prop.getProperty("TestCaseEnd").trim().equalsIgnoreCase("All"))) {
                    Test_start = Integer.parseInt(prop.getProperty("TestCaseStart"));
                    Test_end = Integer.parseInt(prop.getProperty("TestCaseEnd"));
                    System.out.println(" Test Cases Executing from : TCID" + Test_start + "  -  TCID" + Test_end);
                    out.write("\n Test Cases Executing from : TCID" + Test_start + " - TCID" + Test_end + "\n");
                    out1.write("\n Test Cases Executing from : TCID" + Test_start + " - TCID" + Test_end + "\n");
                } else {
                    Test_start = Integer.parseInt(prop.getProperty("TestCaseStart"));
                    Test_end = sheet.getLastRowNum();
                    System.out.println(
                            "Test Cases Executing from : TCID" + Test_start + " - TCID" + sheet.getLastRowNum());
                    out.write("\n Test Cases Executing from : TCID" + Test_start + " - TCID" + Test_end + "\n");
                    out1.write("\n Test Cases Executing from : TCID" + Test_start + " - TCID" + Test_end + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void writeExecutionDetails(String fileName) {

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("Test cases executing for : " + CurrentExeExcel);
        System.out.println("Test case sheets index : " + executionType);
        System.out.println("Application User ID : " + prop.getProperty("UserId"));
        System.out.println("Execution Start Date & Time : " + formattedDate);
        System.out.println("Test Cases Executed By : " + LoginScreen.RunUser);
        System.out.println("Test Run Type: " + TestRunStatus);

        out1.write("*******************************************************************************\n");
        out1.write("                                                        Automation Testing Report \n");
        out1.write("*******************************************************************************\n\n");

        out.write("Test cases executing for : " + CurrentExeExcel);
        out.write("\nTest case sheets index : " + executionType);
        out.write("\nApplication User ID : " + prop.getProperty("UserId"));
        out.write("\nExecution Start Date & Time : " + formattedDate);
        out.write("\nTest Cases Executed By : " + LoginScreen.RunUser + "\n");
        out.write("Test Run Type: " + TestRunStatus + "\n");

        out1.write("Test cases executing for : " + CurrentExeExcel);
        out1.write("\nTest case sheets index : " + executionType);
        out1.write("\nApplication User ID : " + prop.getProperty("UserId"));
        out1.write("\nExecution Start Date & Time : " + formattedDate);
        out1.write("\nTest Cases Executed By : " + LoginScreen.RunUser + "\n");
        out1.write("Test Run Type: " + TestRunStatus + "\n");

    }

    public static void reportPrint() {
        sheet = workbook.getSheetAt(i);
        out.write("----------------------------------------------------------------------------------------------------------------------\n");
        out.write(" Summary Report of " + sheet.getSheetName() + " sheet\n");
        out.write("----------------------------------------------------------------------------------------------------------------------\n");

        out1.write("__________________________________________________________________________________\n");
        out1.write("                                      Console Report of " + sheet.getSheetName() + " sheet\n");
        out1.write("__________________________________________________________________________________\n");

        System.out.println("*****************************************************************************");
        System.out.println(" Reading data from " + sheet.getSheetName() + " sheet Present at index " + i);
        System.out.println("*****************************************************************************");

        SheetName = sheet.getSheetName();
        row = sheet.getRow(0);
        noOfRow = (sheet.getLastRowNum());
        noOfCol = row.getLastCellNum();

        System.out.println("\n " + sheet.getSheetName() + " has " + noOfRow + " Test Cases");
        out1.write(" " + sheet.getSheetName() + " has " + noOfRow + " Test Cases \n");
    }
 
    public static void reportPrint1(XSSFCell TCID, XSSFCell Objective) {
        System.out.println("__________________________________________________________________________________________");
        out1.write("__________________________________________________________________________________\n\n");
        System.out.println("\n Executing Test Case With ID : " + TCID.getStringCellValue().trim());
        out1.write(" # Executing Test Case With ID : " + TCID.getStringCellValue() + "\n");
        System.out.println("# Objective : " + Objective.getStringCellValue().trim());
        out1.write(" * Objective : " + Objective.getStringCellValue() + "\n");
    }

    public static void SingleSheetReportGenarate(int Pass_Test_Cases, int Fail_Test_Cases, int PR_Test_Cases, long Time) {
        System.out.println("");
        System.out.println(" -----------------------------------------------------");
        System.out.println("| " + sheet.getSheetName() + " Sheet Total test Cases       | " + noOfRow + "   |");
        System.out.println(" -----------------------------------------------------");
        System.out.println("| Pass Test Cases                            | " + Pass_Test_Cases + "   |");
        System.out.println(" -----------------------------------------------------");
        System.out.println("| Total Fail Test Cases                      | " + Fail_Test_Cases + "   |");
        System.out.println(" -----------------------------------------------------");
        System.out.println("| Actual Fail Test Cases                     | " + (Fail_Test_Cases - PR_Test_Cases) + "   |");
        System.out.println(" -----------------------------------------------------");
        System.out.println("| Tool Level Fail Cases                      | " + PR_Test_Cases + "   |");
        System.out.println(" -----------------------------------------------------");
        System.out.println("| Skip Test Cases                            | " + ((noOfRow - (Pass_Test_Cases + Fail_Test_Cases))) + "   |");
        System.out.println(" -----------------------------------------------------");
        System.out.println(" " + sheet.getSheetName() + " Test cases executed.\n( Time : " + Time + " Minutes)");
        System.out.println("__________________________________________________________________________\n");

        out.write("");
        out.write(" " + sheet.getSheetName() + " Sheet Cases       =    " + noOfRow + "   \n");
        out.write(" Pass Test Cases                            =     " + Pass_Test_Cases + "   \n");
        out.write(" Total Fail Test Cases                      =    " + Fail_Test_Cases + "\n");
        out.write(" Actual Fail Test Cases                     =    " + (Fail_Test_Cases - PR_Test_Cases) + "\n");
        out.write(" Tool Level Fail Cases                      =    " + PR_Test_Cases + "\n");
        out.write(" Skip Test Cases                            =    " + ((noOfRow - (Pass_Test_Cases + Fail_Test_Cases))) + "\n");
        out.write(" " + sheet.getSheetName() + " Test cases executed.\nTest cases executed.( Time : " + Time + " Minutes)\n");
        out.write("\n*******************************************************************************\n\n");

        out1.write("\n");
        out1.write("__________________________________________________________________________________\n");
        out1.write("                             Summary Report of " + sheet.getSheetName() + " Sheet \n");
        out1.write("__________________________________________________________________________________\n");
        out1.write(" " + sheet.getSheetName() + " Sheet Cases       =    " + noOfRow + "  \n");
        out1.write(" Pass Test Cases                                =     " + Pass_Test_Cases + " \n");
        out1.write(" Total Fail Test Cases                       =    " + Fail_Test_Cases + "\n");
        out1.write(" Actual Fail Test Cases                     =    " + (Fail_Test_Cases - PR_Test_Cases) + "\n");
        out1.write(" Tool Level Fail Cases                      =    " + PR_Test_Cases + "\n");
        out1.write(" Skip Test Cases                                 =    "
                + ((noOfRow - (Pass_Test_Cases + Fail_Test_Cases))) + "\n");
        out1.write(" " + sheet.getSheetName() + " Test cases executed.\nTest cases executed.( Time : " + Time
                + " Minutes)\n");
        out1.write("\n*******************************************************************************\n\n");

        // Get the Count of Pass / Fail Test Cases Count
        int skipcases = (noOfRow - (Pass_Test_Cases + Fail_Test_Cases));
        totalcases += noOfRow;
        totalpasscases += Pass_Test_Cases;
        totalfailcases += Fail_Test_Cases;
        totalskipcases += skipcases;
        totalPRFailcases += PR_Test_Cases;
    }

    public static void logFinalSummary(String executionStart, String executionStop, long Time) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("             Final Summary Report of All Run test Case sheets ");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("| Total  Test Cases                  |   " + totalcases + " |");
        System.out.println("---------------------------------------------");
        System.out.println("| Total Pass Test Cases              |   " + totalpasscases + " |");
        System.out.println("---------------------------------------------");
        System.out.println("| Total Fail Test Cases              |   " + totalfailcases + "  |");
        System.out.println("---------------------------------------------");
        System.out.println("| Actual Fail Test Cases             |   " + (totalfailcases - totalPRFailcases) + "  |");
        System.out.println("---------------------------------------------");
        System.out.println("| Tool Level Fail Cases              |   " + totalPRFailcases + "  |");
        System.out.println("---------------------------------------------");
        System.out.println("| Skip Test Cases                    |   " + totalskipcases + " |");
        System.out.println("---------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Execution Start Time : " + executionStart);
        System.out.println("Execution End Time : " + executionStop);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Total Time Required To Run All Test Cases : " + Time + " Minutes");

        out1.write("__________________________________________________________________________________\n");
        out1.write("               Final Summary Report of All Run test Case sheets \n");
        out1.write("__________________________________________________________________________________\n");

        out1.write("--------------------------------------------------------------------------\n");
        out1.write("| Total  Test Cases                                                  |       " + totalcases + "   |\n");
        out1.write("--------------------------------------------------------------------------\n");
        out1.write("| Total Pass Test Cases                                            |       " + totalpasscases+ "   |\n");
        out1.write("--------------------------------------------------------------------------\n");
        out1.write("| Total Fail Test Cases                                             |       " + totalfailcases+ "   |\n");
        out1.write("--------------------------------------------------------------------------\n");
        out1.write("| Actual Fail Test Cases                                          |       "+ (totalfailcases - totalPRFailcases) + "   |\n");
        out1.write("---------------------------------------------------------------------------\n");
        out1.write("| Tool Level Fail Cases                                           |       " + totalPRFailcases+ "   |\n");
        out1.write("---------------------------------------------------------------------------\n");
        out1.write("| Skip Test Cases                                                    |       " + totalskipcases+ "     |\n");
        out1.write("---------------------------------------------------------------------------\n");

        out1.write("__________________________________________________________________________________\n");
        out1.write("Execution Start Time : " + executionStart + "\n");
        out1.write("Execution End Time : " + executionStop + "\n");
        out1.write("Total Time Required To Run All Test Cases : " + Time + " Minutes \n");
        out1.write("__________________________________________________________________________________\n");

        out.write("------------------------------------------------------------------------------------\n");
        out.write("                                        Final Summary Report of All Run test Case sheets \n");
        out.write("------------------------------------------------------------------------------------\n");
        out.write("\n Total Cases from all sheets  =  " + totalcases + "   \n");
        out.write(" Pass Test Cases              =   " + totalpasscases + "   \n");
        out.write(" Total Fail Test Cases        =   " + totalfailcases + "  \n");
        out.write(" Actual Fail Test Cases       =   " + (totalfailcases - totalPRFailcases) + "  \n");
        out.write(" Tool Level Fail Cases        =   " + totalPRFailcases + "  \n");
        out.write(" Skip Test Cases              =   " + totalskipcases + "   \n\n");

        out.write("------------------------------------------------------------------------------------\n");
        out.write("Execution Start Time : " + executionStart + "\n");
        out.write("Execution End Time : " + executionStop + "\n");
        out.write("------------------------------------------------------------------------------------\n");
        out.write("Total Time Required To Run All Test Cases : " + Time + " Minutes \n");

        out.close();
        out1.close();
    }

}