package CBSV2Automation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LOVSelectionActions {
	public static void LOVSelections(XSSFCell FieldAction, XSSFCell TCID, XSSFCell Expected, XSSFCell Actual,
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
			XSSFCell ValidationXpath1, PrintWriter out1) throws InterruptedException, IOException {
		// Action : Select From LOV
		if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV1")) {
			ActionCommonCode.handleSelectForm("Select Form LOV1", locator, input1,
					input2, Actual, Expected,
					actionKey, ID1, rowk, 14, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV2")) {
			ActionCommonCode.handleSelectForm("Select Form LOV2", locator, input2,
					input3, Actual, Expected,
					actionKey, ID1, rowk, 15, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV3")) {
			ActionCommonCode.handleSelectForm("Select Form LOV3", locator, input3,
					input4, Actual, Expected,
					actionKey, ID1, rowk, 16, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV4")) {
			ActionCommonCode.handleSelectForm("Select Form LOV4", locator, input4,
					input5, Actual, Expected,
					actionKey, ID1, rowk, 17, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV5")) {
			ActionCommonCode.handleSelectForm("Select Form LOV5", locator, input5,
					input6, Actual, Expected,
					actionKey, ID1, rowk, 18, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);

		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV6")) {
			ActionCommonCode.handleSelectForm("Select Form LOV6", locator, input6,
					input7, Actual, Expected,
					actionKey, ID1, rowk, 19, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);

		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV7")) {
			ActionCommonCode.handleSelectForm("Select Form LOV7", locator, input7,
					input8, Actual, Expected,
					actionKey, ID1, rowk, 20, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV8")) {
			ActionCommonCode.handleSelectForm("Select Form LOV8", locator, input8,
					input9, Actual, Expected,
					actionKey, ID1, rowk, 21, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV9")) {
			ActionCommonCode.handleSelectForm("Select Form LOV9", locator, input9,
					input10, Actual, Expected,
					actionKey, ID1, rowk, 22, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV10")) {
			ActionCommonCode.handleSelectForm("Select Form LOV10", locator, input10,
					input11, Actual, Expected,
					actionKey, ID1, rowk, 23, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV11")) {
			ActionCommonCode.handleSelectForm("Select Form LOV11", locator, input11,
					input12, Actual, Expected,
					actionKey, ID1, rowk, 24, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV12")) {
			ActionCommonCode.handleSelectForm("Select Form LOV12", locator, input12,
					input13, Actual, Expected,
					actionKey, ID1, rowk, 25, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV13")) {
			ActionCommonCode.handleSelectForm("Select Form LOV13", locator, input13,
					input14, Actual, Expected,
					actionKey, ID1, rowk, 26, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV14")) {
			ActionCommonCode.handleSelectForm("Select Form LOV14", locator, input14,
					input15, Actual, Expected,
					actionKey, ID1, rowk, 27, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV15")) {
			ActionCommonCode.handleSelectForm("Select Form LOV15", locator, input15,
					input16, Actual, Expected,
					actionKey, ID1, rowk, 28, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV16")) {
			ActionCommonCode.handleSelectForm("Select Form LOV16", locator, input16,
					input17, Actual, Expected,
					actionKey, ID1, rowk, 29, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV17")) {
			ActionCommonCode.handleSelectForm("Select Form LOV17", locator, input17,
					input18, Actual, Expected,
					actionKey, ID1, rowk, 30, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV18")) {
			ActionCommonCode.handleSelectForm("Select Form LOV18", locator, input18,
					input19, Actual, Expected,
					actionKey, ID1, rowk, 31, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV19")) {
			ActionCommonCode.handleSelectForm("Select Form LOV19", locator, input19,
					input20, Actual, Expected,
					actionKey, ID1, rowk, 32, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV20")) {
			ActionCommonCode.handleSelectForm("Select Form LOV20", locator, input20,
					input21, Actual, Expected,
					actionKey, ID1, rowk, 33, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV21")) {
			ActionCommonCode.handleSelectForm("Select Form LOV21", locator, input21,
					input22, Actual, Expected,
					actionKey, ID1, rowk, 34, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV22")) {
			ActionCommonCode.handleSelectForm("Select Form LOV22", locator, input22,
					input23, Actual, Expected,
					actionKey, ID1, rowk, 35, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV23")) {
			ActionCommonCode.handleSelectForm("Select Form LOV23", locator, input23,
					input24, Actual, Expected,
					actionKey, ID1, rowk, 36, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV24")) {
			ActionCommonCode.handleSelectForm("Select Form LOV24", locator, input24,
					input25, Actual, Expected,
					actionKey, ID1, rowk, 37, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV25")) {
			ActionCommonCode.handleSelectForm("Select Form LOV25", locator, input25,
					input26, Actual, Expected,
					actionKey, ID1, rowk, 38, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV26")) {
			ActionCommonCode.handleSelectForm("Select Form LOV26", locator, input26,
					input27, Actual, Expected,
					actionKey, ID1, rowk, 39, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV27")) {
			ActionCommonCode.handleSelectForm("Select Form LOV27", locator, input27,
					input28, Actual, Expected,
					actionKey, ID1, rowk, 40, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV28")) {
			ActionCommonCode.handleSelectForm("Select Form LOV28", locator, input28,
					input29, Actual, Expected,
					actionKey, ID1, rowk, 41, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV29")) {
			ActionCommonCode.handleSelectForm("Select Form LOV29", locator, input29,
					input30, Actual, Expected,
					actionKey, ID1, rowk, 42, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV30")) {
			ActionCommonCode.handleSelectForm("Select Form LOV30", locator, input30,
					input31, Actual, Expected,
					actionKey, ID1, rowk, 43, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV31")) {
			ActionCommonCode.handleSelectForm("Select Form LOV31", locator, input31,
					input32, Actual, Expected,
					actionKey, ID1, rowk, 44, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV32")) {
			ActionCommonCode.handleSelectForm("Select Form LOV32", locator, input32,
					input33, Actual, Expected,
					actionKey, ID1, rowk, 45, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV33")) {
			ActionCommonCode.handleSelectForm("Select Form LOV33", locator, input33,
					input34, Actual, Expected,
					actionKey, ID1, rowk, 46, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV34")) {
			ActionCommonCode.handleSelectForm("Select Form LOV34", locator, input34,
					input35, Actual, Expected,
					actionKey, ID1, rowk, 47, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV35")) {
			ActionCommonCode.handleSelectForm("Select Form LOV35", locator, input35,
					input36, Actual, Expected,
					actionKey, ID1, rowk, 48, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV36")) {
			ActionCommonCode.handleSelectForm("Select Form LOV36", locator, input36,
					input37, Actual, Expected,
					actionKey, ID1, rowk, 49, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV37")) {
			ActionCommonCode.handleSelectForm("Select Form LOV37", locator, input37,
					input38, Actual, Expected,
					actionKey, ID1, rowk, 50, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV38")) {
			ActionCommonCode.handleSelectForm("Select Form LOV38", locator, input38,
					input39, Actual, Expected,
					actionKey, ID1, rowk, 51, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV39")) {
			ActionCommonCode.handleSelectForm("Select Form LOV39", locator, input39,
					input40, Actual, Expected,
					actionKey, ID1, rowk, 52, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV40")) {
			ActionCommonCode.handleSelectForm("Select Form LOV40", locator, input40,
					input41, Actual, Expected,
					actionKey, ID1, rowk, 53, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV41")) {
			ActionCommonCode.handleSelectForm("Select Form LOV41", locator, input41,
					input42, Actual, Expected,
					actionKey, ID1, rowk, 54, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV42")) {
			ActionCommonCode.handleSelectForm("Select Form LOV42", locator, input42,
					input43, Actual, Expected,
					actionKey, ID1, rowk, 55, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV43")) {
			ActionCommonCode.handleSelectForm("Select Form LOV43", locator, input43,
					input44, Actual, Expected,
					actionKey, ID1, rowk, 56, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV44")) {
			ActionCommonCode.handleSelectForm("Select Form LOV44", locator, input44,
					input45, Actual, Expected,
					actionKey, ID1, rowk, 57, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV45")) {
			ActionCommonCode.handleSelectForm("Select Form LOV45", locator, input45,
					input46, Actual, Expected,
					actionKey, ID1, rowk, 58, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV46")) {
			ActionCommonCode.handleSelectForm("Select Form LOV46", locator, input46,
					input47, Actual, Expected,
					actionKey, ID1, rowk, 59, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV47")) {
			ActionCommonCode.handleSelectForm("Select Form LOV47", locator, input47,
					input48, Actual, Expected,
					actionKey, ID1, rowk, 60, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV48")) {
			ActionCommonCode.handleSelectForm("Select Form LOV48", locator, input48,
					input49, Actual, Expected,
					actionKey, ID1, rowk, 61, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV49")) {
			ActionCommonCode.handleSelectForm("Select Form LOV49", locator, input49,
					input50, Actual, Expected,
					actionKey, ID1, rowk, 62, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV50")) {
			ActionCommonCode.handleSelectForm("Select Form LOV50", locator, input50,
					input51, Actual, Expected,
					actionKey, ID1, rowk, 63, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV51")) {
			ActionCommonCode.handleSelectForm("Select Form LOV51", locator, input51,
					input52, Actual, Expected,
					actionKey, ID1, rowk, 64, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV52")) {
			ActionCommonCode.handleSelectForm("Select Form LOV52", locator, input52,
					input53, Actual, Expected,
					actionKey, ID1, rowk, 65, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV53")) {
			ActionCommonCode.handleSelectForm("Select Form LOV53", locator, input53,
					input54, Actual, Expected,
					actionKey, ID1, rowk, 66, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV54")) {
			ActionCommonCode.handleSelectForm("Select Form LOV54", locator, input54,
					input55, Actual, Expected,
					actionKey, ID1, rowk, 67, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV55")) {
			ActionCommonCode.handleSelectForm("Select Form LOV55", locator, input55,
					input56, Actual, Expected,
					actionKey, ID1, rowk, 68, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		}

		// Action : Option LOV element Selection
		else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV101")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV101", locator, input1,
					input2, Actual, Expected,
					actionKey, ID1, rowk, 14, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV102")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV102", locator, input2,
					input3, Actual, Expected,
					actionKey, ID1, rowk, 15, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV103")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV103", locator, input3,
					input4, Actual, Expected,
					actionKey, ID1, rowk, 16, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV104")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV104", locator, input4,
					input5, Actual, Expected,
					actionKey, ID1, rowk, 17, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV105")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV105", locator, input5,
					input6, Actual, Expected,
					actionKey, ID1, rowk, 18, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);

		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV106")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV106", locator, input6,
					input7, Actual, Expected,
					actionKey, ID1, rowk, 19, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);

		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV107")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV107", locator, input7,
					input8, Actual, Expected,
					actionKey, ID1, rowk, 20, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV108")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV108", locator, input8,
					input9, Actual, Expected,
					actionKey, ID1, rowk, 21, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV109")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV109", locator, input9,
					input10, Actual, Expected,
					actionKey, ID1, rowk, 22, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV110")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV110", locator, input10,
					input11, Actual, Expected,
					actionKey, ID1, rowk, 23, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV111")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV111", locator, input11,
					input12, Actual, Expected,
					actionKey, ID1, rowk, 24, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV112")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV112", locator, input12,
					input13, Actual, Expected,
					actionKey, ID1, rowk, 25, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV113")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV113", locator, input13,
					input14, Actual, Expected,
					actionKey, ID1, rowk, 26, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV114")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV114", locator, input14,
					input15, Actual, Expected,
					actionKey, ID1, rowk, 27, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV115")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV115", locator, input15,
					input16, Actual, Expected,
					actionKey, ID1, rowk, 28, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV116")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV116", locator, input16,
					input17, Actual, Expected,
					actionKey, ID1, rowk, 29, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV117")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV117", locator, input17,
					input18, Actual, Expected,
					actionKey, ID1, rowk, 30, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV118")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV118", locator, input18,
					input19, Actual, Expected,
					actionKey, ID1, rowk, 31, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV119")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV119", locator, input19,
					input20, Actual, Expected,
					actionKey, ID1, rowk, 32, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV120")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV120", locator, input20,
					input21, Actual, Expected,
					actionKey, ID1, rowk, 33, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV121")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV121", locator, input21,
					input22, Actual, Expected,
					actionKey, ID1, rowk, 34, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV122")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV122", locator, input22,
					input23, Actual, Expected,
					actionKey, ID1, rowk, 35, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV123")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV123", locator, input23,
					input24, Actual, Expected,
					actionKey, ID1, rowk, 36, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV124")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV124", locator, input24,
					input25, Actual, Expected,
					actionKey, ID1, rowk, 37, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV125")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV125", locator, input25,
					input26, Actual, Expected,
					actionKey, ID1, rowk, 38, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV126")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV126", locator, input26,
					input27, Actual, Expected,
					actionKey, ID1, rowk, 39, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV127")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV127", locator, input27,
					input28, Actual, Expected,
					actionKey, ID1, rowk, 40, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV128")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV128", locator, input28,
					input29, Actual, Expected,
					actionKey, ID1, rowk, 41, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV129")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV129", locator, input29,
					input30, Actual, Expected,
					actionKey, ID1, rowk, 42, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV130")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV130", locator, input30,
					input31, Actual, Expected,
					actionKey, ID1, rowk, 43, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV131")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV131", locator, input31,
					input32, Actual, Expected,
					actionKey, ID1, rowk, 44, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV132")) {
			ActionCommonCode.handleSelectForm1("1Select Form LOV32", locator, input32,
					input33, Actual, Expected,
					actionKey, ID1, rowk, 45, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV133")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV133", locator, input33,
					input34, Actual, Expected,
					actionKey, ID1, rowk, 46, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV134")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV134", locator, input34,
					input35, Actual, Expected,
					actionKey, ID1, rowk, 47, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV135")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV135", locator, input35,
					input36, Actual, Expected,
					actionKey, ID1, rowk, 48, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV136")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV136", locator, input36,
					input37, Actual, Expected,
					actionKey, ID1, rowk, 49, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV137")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV137", locator, input37,
					input38, Actual, Expected,
					actionKey, ID1, rowk, 50, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV138")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV138", locator, input38,
					input39, Actual, Expected,
					actionKey, ID1, rowk, 51, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV139")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV139", locator, input39,
					input40, Actual, Expected,
					actionKey, ID1, rowk, 52, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV140")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV140", locator, input40,
					input41, Actual, Expected,
					actionKey, ID1, rowk, 53, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV141")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV141", locator, input41,
					input42, Actual, Expected,
					actionKey, ID1, rowk, 54, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV142")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV42", locator, input42,
					input43, Actual, Expected,
					actionKey, ID1, rowk, 55, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV143")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV143", locator, input43,
					input44, Actual, Expected,
					actionKey, ID1, rowk, 56, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV144")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV144", locator, input44,
					input45, Actual, Expected,
					actionKey, ID1, rowk, 57, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV145")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV145", locator, input45,
					input46, Actual, Expected,
					actionKey, ID1, rowk, 58, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV146")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV146", locator, input46,
					input47, Actual, Expected,
					actionKey, ID1, rowk, 59, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV147")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV147", locator, input47,
					input48, Actual, Expected,
					actionKey, ID1, rowk, 60, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV148")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV148", locator, input48,
					input49, Actual, Expected,
					actionKey, ID1, rowk, 61, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV149")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV149", locator, input49,
					input50, Actual, Expected,
					actionKey, ID1, rowk, 62, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV50")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV50", locator, input50,
					input51, Actual, Expected,
					actionKey, ID1, rowk, 63, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV151")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV151", locator, input51,
					input52, Actual, Expected,
					actionKey, ID1, rowk, 64, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV152")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV152", locator, input52,
					input53, Actual, Expected,
					actionKey, ID1, rowk, 65, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV153")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV153", locator, input53,
					input54, Actual, Expected,
					actionKey, ID1, rowk, 66, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV154")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV154", locator, input54,
					input55, Actual, Expected,
					actionKey, ID1, rowk, 67, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		} else if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Select Form LOV155")) {
			ActionCommonCode.handleSelectForm1("Select Form LOV155", locator, input55,
					input56, Actual, Expected,
					actionKey, ID1, rowk, 68, TCID.getStringCellValue(), SheetName, myList,
					driver, Actual, out1, Remark);
		}

	}

}
