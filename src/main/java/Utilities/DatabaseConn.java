package Utilities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import CBSV2Automation.Base;

public class DatabaseConn extends Base {

	public static String url = p.getProperty("DatabaseURL");
	public static String username = p.getProperty("DBUserName");
	public static String password = p.getProperty("DBPassword");
	public static Connection connection = null;
	public static PreparedStatement preparedStatement = null;
	public static ResultSet resultSet = null;

	// Main Function Of Database
	public static void Main() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, username, password);
	}

	// Commite the SQL Statement
	public static void Commite() throws ClassNotFoundException, SQLException {
		Main();
		preparedStatement = connection.prepareStatement(p.getProperty("commitecmd"));
		resultSet = preparedStatement.executeQuery();
		
	}
	
	public static void TrancateUserDet(String UserName) throws ClassNotFoundException, SQLException {
		Main();
		
		  try (PreparedStatement stmt = connection.prepareStatement(p.getProperty("DeletefromUserLoginDet"))) {
	            stmt.setString(1, UserName);
	            stmt.executeUpdate();
	        }

		  try (PreparedStatement stmt = connection.prepareStatement(p.getProperty("DeleteFromUserLogoutDet"))) {
	            stmt.setString(1, UserName);
	            stmt.executeUpdate();
	        }
		Commite();
	}
	
	public static void DeleteFromShmas() throws ClassNotFoundException, SQLException {
		Main();
		preparedStatement = connection.prepareStatement(p.getProperty("ShareMas"));
		resultSet = preparedStatement.executeQuery();
		
		Commite();
	}

	// Get MAXVOUGRNO Number From the STDINST Table
	public static int getMaxSRNO() throws SQLException, ClassNotFoundException {
		Main();
		int maxSRNO = 0;
		try (PreparedStatement stmt = connection.prepareStatement(p.getProperty("getMaxSRNO"))) {
			try (ResultSet maxSRNOResultSet = stmt.executeQuery()) {
				if (maxSRNOResultSet.next()) {
					maxSRNO = maxSRNOResultSet.getInt("maxsrno");
				}
			}
		}
		return maxSRNO;
	}

	// Print the Record from STDINST Table
	public static String getSTDINSTRecord() throws SQLException, ClassNotFoundException {
		Main();
		String data = "";
		int ACMSTCD1, ACMSTCD2, AC_NO1, AC_NO2, INST_AMT, SRNO, TRF_DAY, NO_OF_INST;
		Date FROM_DATE, TO_DATE;
		try (PreparedStatement stmt = connection.prepareStatement(p.getProperty("FetchStandingInstructionsRecords"))) {
			try (ResultSet Stdinst = stmt.executeQuery()) {
				while (Stdinst.next()) {
					SRNO = Stdinst.getInt("SRNO");
					ACMSTCD1 = Stdinst.getInt("ACMSTCD1");
					ACMSTCD2 = Stdinst.getInt("ACMSTCD2");
					AC_NO1 = Stdinst.getInt("AC_NO1");
					AC_NO2 = Stdinst.getInt("AC_NO2");
					FROM_DATE = Stdinst.getDate("FROM_DATE");
					TO_DATE = Stdinst.getDate("TO_DATE");
					INST_AMT = Stdinst.getInt("INST_AMT");
					TRF_DAY = Stdinst.getInt("TRF_DAY");
					NO_OF_INST = Stdinst.getInt("NO_OF_INST");

					data = "| " + SRNO + " | " + ACMSTCD1 + " | " + ACMSTCD2 + " | " + AC_NO1 + " | " + AC_NO2 + " | "
							+ FROM_DATE + " | " + TO_DATE + " | " + INST_AMT + " | " + TRF_DAY + " | " + NO_OF_INST;
				}
			}
		}
		return data;
	}

	// Get Customer Entry Record from BankMas Table
	public static String GetBankMasTableRecords() throws SQLException, ClassNotFoundException {
		Main();
		String data = "";
		String NAM_CAP, NAME, ADDR, CITY, TELE, RDISTRICT, RTALUKA, RPINCODE, POSITION, GENDER, EMAILID, CATEGORY;
		Date DT_OF_BIRTH, ENT_DATE;
		int GMSTCODE, MOBILENO, FAXNO, AGE;

		try (PreparedStatement stmt = connection.prepareStatement(p.getProperty("FetchBankMasRecord"))) {
			try (ResultSet bankmas = stmt.executeQuery()) {
				while (bankmas.next()) {
					GMSTCODE = bankmas.getInt("GMST_CODE");
					NAM_CAP = bankmas.getString("NAM_CAP");
					NAME = bankmas.getString("NAME");
					ADDR = bankmas.getString("ADDR");
					CITY = bankmas.getString("CITY");
					TELE = bankmas.getString("TELE");
					RDISTRICT = bankmas.getString("RDISTRICT");
					RTALUKA = bankmas.getString("RTALUKA");
					RPINCODE = bankmas.getString("RPINCODE");
					DT_OF_BIRTH = bankmas.getDate("DT_OF_BIRTH");
					ENT_DATE = bankmas.getDate("ENT_DATE");
					MOBILENO = bankmas.getInt("MOBILENO");
					FAXNO = bankmas.getInt("FAXNO");
					AGE = bankmas.getInt("AGE");
					POSITION = bankmas.getString("POSITION");
					GENDER = bankmas.getString("GENDER");
					EMAILID = bankmas.getString("EMAILID");
					CATEGORY = bankmas.getString("CATEGORY");

					data = " GMSTCODE : " + GMSTCODE + " \n NAM_CAP : " + NAM_CAP + "\n NAME : " + NAME + "\n ADDR : "
							+ ADDR + "\n CITY : " + CITY + "\n TELE : " + TELE + "\n RDISTRICT : " + RDISTRICT
							+ "\n RTALUKA : " + RTALUKA + "\n RPINCODE : " + RPINCODE + "\n DT_OF_BIRTH : "
							+ DT_OF_BIRTH + "\n ENT_DATE : " + ENT_DATE + "\n MOBILENO : " + MOBILENO + "\n FAXNO : "
							+ FAXNO + "\n AGE : " + AGE + "\n POSITION : " + POSITION + "\n GENDER : " + GENDER
							+ "\n EMAILID : " + EMAILID + "\n CATEGORY : " + CATEGORY;
				}
			}
		}
		return data;
	}

	// Get the GMST CODE From BANKMAS Table
	public static int GetGMSTCODE() throws SQLException, ClassNotFoundException {
		Main();
		int data = 0;
		int GMSTCODE;
		try (PreparedStatement stmt = connection.prepareStatement(p.getProperty("FetchBankMasRecord"))) {
			try (ResultSet Stdinst = stmt.executeQuery()) {
				while (Stdinst.next()) {
					GMSTCODE = Stdinst.getInt("GMST_CODE");
					data = GMSTCODE;
				}
			}
		}
		return data;
	}

	// Delete the Record From BankMas Table ,Drop GMST_CODE Sequence & Create the Sequence
	public static void deletefromBankMas() throws ClassNotFoundException, SQLException {
		Main();
		preparedStatement = connection.prepareStatement(p.getProperty("createBankmasBackupTable"));
		resultSet = preparedStatement.executeQuery();
		preparedStatement = connection.prepareStatement(p.getProperty("deletefromBankMas"));
		resultSet = preparedStatement.executeQuery();
		Commite();
	}
}
