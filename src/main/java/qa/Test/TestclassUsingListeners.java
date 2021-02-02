package qa.Test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;

import com.google.common.io.Files;

import qa.Util.ExcelUtils;
import qa.Util.TestBase;
import qa.pages.HomePage;
import qa.pages.loginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class TestclassUsingListeners extends loginPage{

	public static WebDriver driver;
  // HomePage homepage;
	@Test(dataProvider = "test1Data")
	public void loginTest(String username1, String Password1) 
	{
		loginPage loginpage = new loginPage();
		loginpage.login(username1, Password1);
	}

	@DataProvider(name = "test1Data")
	public static Object[][] getData() {
		String excelpath = "C:\\Users\\lenovo\\eclipse-workspace\\"
				+ "TestngPOM\\src\\main\\java\\qa\\Util\\dataprovider1.xlsx";
		String sheetname = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelpath, sheetname);

		Object data[][] = excel.testData(excelpath, sheetname);
		return data;
	}

	/*
	 * @Test public void SuccessFulTest() {
	 * 
	 * System.out.println("Executing successful test"); }
	 * 
	 * @Test public void FailedTest() {
	 * 
	 * System.out.println("Executing failed test");
	 * 
	 * Assert.fail("Executing failed test"); }
	 * 
	 * @Test public void SkippedTest() {
	 * 
	 * System.out.println("Executing skipp test");
	 * 
	 * throw new SkipException("Executing Skipped test"); }
	 */

	@BeforeMethod
	public void beforeClass() 
	{
		TestBase.Initialization();
	}

	@AfterMethod
	public void afterClass() 
	{
		TestBase.Ending();

	}

}
