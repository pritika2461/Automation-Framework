package CBSV2Automation;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxSelectionActions {
	public static void CheckBoxSelection(XSSFCell FieldAction, XSSFCell TCID, XSSFCell Expected, XSSFCell Actual,
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
			WebDriver driver) throws InterruptedException, IOException {
		// Action : Checkbox Selection
		if (Action.getStringCellValue().trim()
				.equalsIgnoreCase("Checkbox Selection1")) {
			if (input1.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input1, input2, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection2")) {
			if (input2.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input2, input3, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection3")) {
			if (input3.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input3, input4, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection4")) {
			if (input4.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input4, input5, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection5")) {
			if (input5.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input5, input6, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection6")) {
			if (input6.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input6, input7, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection7")) {
			if (input7.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input7, input8, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection8")) {
			if (input8.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input8, input9, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection9")) {
			if (input9.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input9, input10, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection10")) {
			if (input10.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input10, input11, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection11")) {
			if (input11.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input11, input12, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection12")) {
			if (input12.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input12, input13, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection13")) {
			if (input13.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input13, input14, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection14")) {
			if (input14.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input14, input15, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection15")) {
			if (input15.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input15, input16, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection16")) {
			if (input16.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input16, input17, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection17")) {
			if (input17.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input17, input18, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection18")) {
			if (input18.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input18, input19, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection19")) {
			if (input19.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input19, input20, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection19")) {
			if (input19.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input20, input21, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection20")) {
			if (input20.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input20, input21, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection21")) {
			if (input21.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input21, input22, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection22")) {
			if (input22.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input22, input23, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection23")) {
			if (input23.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input23, input24, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection24")) {
			if (input24.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input24, input25, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection25")) {
			if (input25.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input25, input26, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection26")) {
			if (input26.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input26, input27, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection27")) {
			if (input27.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input27, input28, Actual, TCID.getStringCellValue(), ID1,
					Expected);

		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection28")) {
			if (input28.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input28, input29, Actual, TCID.getStringCellValue(), ID1,
					Expected);

		} else if (Action.getStringCellValue()
				.equalsIgnoreCase("Checkbox Selection29")) {
			if (input29.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input29, input30, Actual, TCID.getStringCellValue(),
					ID1, Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection30")) {
			if (input30.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input30, input31, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection31")) {
			if (input31.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input31, input32, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection32")) {
			if (input32.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input32, input33, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection33")) {
			if (input33.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input33, input34, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection34")) {
			if (input34.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input34, input35, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection35")) {
			if (input35.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input35, input36, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection36")) {
			if (input36.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input36, input37, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection37")) {
			if (input37.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input37, input38, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection38")) {
			if (input38.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input38, input39, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection39")) {
			if (input39.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input39, input40, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection40")) {
			if (input40.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input40, input41, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection41")) {
			if (input41.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input41, input42, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection42")) {
			if (input42.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input42, input43, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection43")) {
			if (input43.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input43, input44, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection44")) {
			if (input44.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input44, input45, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection45")) {
			if (input45.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input45, input46, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection46")) {
			if (input46.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input46, input47, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection47")) {
			if (input47.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input47, input48, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection48")) {
			if (input48.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input48, input49, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection49")) {
			if (input49.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input49, input50, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection50")) {
			if (input50.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input50, input51, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection51")) {
			if (input51.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input51, input52, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection52")) {
			if (input52.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input52, input53, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection53")) {
			if (input53.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input53, input54, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection54")) {
			if (input54.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input54, input55, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		} else if (Action.getStringCellValue().equalsIgnoreCase("Checkbox Selection55")) {
			if (input55.getStringCellValue().equalsIgnoreCase("Checked")) {
				locator.click();
			} else {
			}
			Thread.sleep(200);
			ActionCommonCode.otherCaseFunctionCall(input55, input56, Actual, TCID.getStringCellValue(), ID1,
					Expected);
		}

	}

}
