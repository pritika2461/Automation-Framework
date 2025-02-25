package CBSV2Automation;

import java.sql.SQLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import Utilities.DatabaseConn;

public class Login extends Base {

	public static void CallloginScreen() throws ClassNotFoundException, SQLException, InterruptedException {

		// Initialize WebDriver based on the browser specified in properties
		String browser = prop.getProperty("BrowserName");
		PauseResumeAutomation.checkPause();
		if (browser.equalsIgnoreCase("Chrome")) {
		    driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("Firefox")) {
		    try {
		        FirefoxOptions options = new FirefoxOptions();
		        options.setBinary(prop.getProperty("FirefoxBrowserPath"));		        
		        driver = new FirefoxDriver(options);
		    } catch(Exception e) {
		        System.out.println("Error launching Firefox: " + e.getMessage());
		    }
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}

		// Configure WebDriver settings and navigate to the login URL
		String implicitWaitTime = prop.getProperty("implicitwait");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWaitTime)));
		driver.manage().window().maximize();
		
		// Delete Records from User_Logindet & User_Logoutdet
		DatabaseConn.TrancateUserDet(prop.getProperty("UserId"));
		Thread.sleep(500);
		driver.get(prop.getProperty("LoginURL"));
		DatabaseConn.TrancateUserDet(prop.getProperty("UserId"));

		// Perform login steps
		Thread.sleep(10000);
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("UserId") + Keys.TAB);
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password") + Keys.TAB);
		driver.findElement(By.id("OK_BTN_LOGIN")).click();
		Thread.sleep(2000);
	}

	public static void ReloginScreen() throws ClassNotFoundException, SQLException, InterruptedException {
		System.out.println("Relogin by Opening Another Browser. ");

		Thread.sleep(500);
		driver.quit();
		String browser = prop.getProperty("BrowserName");
		PauseResumeAutomation.checkPause();
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}

		driver.get(prop.getProperty("LoginURL"));

		// Perform login steps
		Thread.sleep(10000);
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("UserId") + Keys.TAB);
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password") + Keys.TAB);
		driver.findElement(By.id("OK_BTN_LOGIN")).click();
		Thread.sleep(2000);
	}
}
