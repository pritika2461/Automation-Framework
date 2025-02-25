package CBSV2Automation;

import java.util.List;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendkeyActions {

	public static Boolean CommonSendkeyActions(XSSFCell FieldAction, XSSFCell TCID, XSSFCell Expected, XSSFCell Actual,
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
			XSSFCell ValidationXpath1) throws InterruptedException {

		Boolean isBreak1 = false;
		// Action 6: Syntax For all inputs
		if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey1")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey1",
					input1, input2, Expected, Actual,
					locator, rowk, 14, p, actionKey, myList, TCID.getStringCellValue(),
					SheetName, driver, j, ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey2")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey2",
					input2, input3, Expected, Actual,
					locator, rowk, 15, p, actionKey, myList, TCID.getStringCellValue(),
					SheetName, driver, j, ID1, ValidationXpath1, Action, Remark);

			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey3")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey3",
					input3, input4, Expected, Actual,
					locator, rowk, 16, p, actionKey, myList, TCID.getStringCellValue(),
					SheetName, driver, j, ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey4")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey4",
					input4, input5, Expected, Actual,
					locator, rowk, 17, p, actionKey, myList, TCID.getStringCellValue(),
					SheetName, driver, j, ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey5")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey5",
					input5, input6, Expected, Actual,
					locator, rowk, 18, p, actionKey, myList, TCID.getStringCellValue(),
					SheetName, driver, j, ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey6")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey6",
					input6, input7, Expected, Actual,
					locator, rowk, 19, p, actionKey, myList, TCID.getStringCellValue(),
					SheetName, driver, j, ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey7")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey7",
					input7, input8, Expected, Actual,
					locator, rowk, 20, p, actionKey, myList, TCID.getStringCellValue(),
					SheetName, driver, j, ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey8")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey8",
					input8, input9, Expected, Actual,
					locator, rowk, 21, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey9")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey9",
					input9, input10, Expected, Actual,
					locator, rowk, 22, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey10")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey10",
					input10, input11, Expected, Actual,
					locator, rowk, 23, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey11")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey11",
					input11, input12, Expected, Actual,
					locator, rowk, 24, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey12")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey12",
					input12, input13, Expected, Actual,
					locator, rowk, 25, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey13")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey13",
					input13, input14, Expected, Actual,
					locator, rowk, 26, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey14")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey14",
					input14, input15, Expected, Actual,
					locator, rowk, 27, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey15")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey15",
					input15, input16, Expected, Actual,
					locator, rowk, 28, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey16")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey16",
					input16, input17, Expected, Actual,
					locator, rowk, 29, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey17")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey17",
					input17, input18, Expected, Actual,
					locator, rowk, 30, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey18")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey18",
					input18, input19, Expected, Actual,
					locator, rowk, 31, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey19")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey19",
					input19, input20, Expected, Actual,
					locator, rowk, 32, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey20")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey20",
					input20, input21, Expected, Actual,
					locator, rowk, 33, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey21")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey21",
					input21, input22, Expected, Actual,
					locator, rowk, 34, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey22")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey22",
					input22, input23, Expected, Actual,
					locator, rowk, 35, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey23")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey23",
					input23, input24, Expected, Actual,
					locator, rowk, 36, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey24")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey24",
					input24, input25, Expected, Actual,
					locator, rowk, 37, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey25")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey25",
					input25, input26, Expected, Actual,
					locator, rowk, 38, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey26")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey26",
					input26, input27, Expected, Actual,
					locator, rowk, 39, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey27")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey27",
					input27, input28, Expected, Actual,
					locator, rowk, 40, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey28")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey28",
					input28, input29, Expected, Actual,
					locator, rowk, 41, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey29")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey29",
					input29, input30, Expected, Actual,
					locator, rowk, 42, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey30")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey30",
					input30, input31, Expected, Actual,
					locator, rowk, 43, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey31")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey31",
					input31, input32, Expected, Actual,
					locator, rowk, 44, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey32")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey32",
					input32, input33, Expected, Actual,
					locator, rowk, 45, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey33")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey33",
					input33, input34, Expected, Actual,
					locator, rowk, 46, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey34")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey34",
					input34, input35, Expected, Actual,
					locator, rowk, 47, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey35")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey35",
					input35, input36, Expected, Actual,
					locator, rowk, 48, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey36")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey36",
					input36, input37, Expected, Actual,
					locator, rowk, 49, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey37")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey37",
					input37, input38, Expected, Actual,
					locator, rowk, 50, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey38")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey38",
					input38, input39, Expected, Actual,
					locator, rowk, 51, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey39")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey39",
					input39, input40, Expected, Actual,
					locator, rowk, 52, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey40")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey40",
					input40, input41, Expected, Actual,
					locator, rowk, 53, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey41")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey41",
					input41, input42, Expected, Actual,
					locator, rowk, 54, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey42")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey42",
					input42, input43, Expected, Actual,
					locator, rowk, 55, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey43")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey43",
					input43, input44, Expected, Actual,
					locator, rowk, 56, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey44")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey44",
					input44, input45, Expected, Actual,
					locator, rowk, 57, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey45")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey45",
					input45, input46, Expected, Actual,
					locator, rowk, 58, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey46")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey46",
					input46, input47, Expected, Actual,
					locator, rowk, 59, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey47")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey47",
					input47, input48, Expected, Actual,
					locator, rowk, 60, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey48")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey48",
					input48, input49, Expected, Actual,
					locator, rowk, 61, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey49")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey49",
					input49, input50, Expected, Actual,
					locator, rowk, 62, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey50")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey50",
					input50, input51, Expected, Actual,
					locator, rowk, 63, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey51")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey52",
					input51, input52, Expected, Actual,
					locator, rowk, 64, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey53")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey53",
					input53, input54, Expected, Actual,
					locator, rowk, 65, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey54")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey54",
					input54, input55, Expected, Actual,
					locator, rowk, 66, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		} else if (Action.getStringCellValue().trim().equalsIgnoreCase("Sendkey55")) {
			boolean shouldBreak = ActionCommonCode.performSendKeyAction("Sendkey55",
					input55, input56, Expected, Actual,
					locator, rowk, 67, p,
					actionKey, myList, TCID.getStringCellValue(), SheetName, driver, j,
					ID1, ValidationXpath1, Action, Remark);
			if (shouldBreak) {
				isBreak1 = true;
			}
		}
		return isBreak1;

	}

}
