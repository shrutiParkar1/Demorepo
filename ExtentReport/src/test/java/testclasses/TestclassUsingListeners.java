package testclasses;

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

	import dataprovider.ExcelUtils;

	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;

	import java.io.File;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.math3.stat.inference.TestUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.SkipException;
	import org.testng.annotations.AfterClass;

	public class TestclassUsingListeners 
	{ 
	
		
	public static WebDriver driver;
	
	@Test(dataProvider ="test1Data")
		 public void loginTest(String username,String Password)
		  { 
		  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
		  driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Password);

	}
	
	
	@DataProvider(name ="test1Data")
	public static Object[][] getData()
	{
		String excelpath ="C:\\Users\\lenovo\\eclipse-workspace\\Datadrivenapproach"
				+ "\\src\\com\\data\\dataprovider1.xlsx";
		String sheetname ="Sheet1";
		ExcelUtils excel = new ExcelUtils(excelpath, sheetname);
		
		Object data[][]=excel.testData(excelpath,sheetname);
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
		  
		  System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://www.facebook.com/");
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   }

	  @AfterMethod
	  public void afterClass() 
	  {
		  driver.quit();
		 
	  }

	}


