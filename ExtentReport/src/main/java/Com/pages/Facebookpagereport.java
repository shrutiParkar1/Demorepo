package Com.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

public class Facebookpagereport {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void reportsetup() {
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
	}

	@BeforeMethod
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void facebooklogin() 
	{

		test = extent.createTest("My FirstTest", "Facebook LoginTest");
		driver.get("https://www.facebook.com/");
		test.log(Status.INFO, "Successful launching of facebook site");
		driver.findElement(By.xpath("//*[@id=\"email1\"]")).sendKeys("sss@gmail.com");
		test.log(Status.PASS, "Entering username");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("ss123");
		test.log(Status.PASS, "Entering Password");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement button = driver.findElement(By.xpath("//*[@id=\"u_0_b\"]"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		test.log(Status.PASS, "Click on login button");
	}
	public static String getScreenShot(WebDriver driver,String Screenshotname) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination =System.getProperty("D:\\Selenium\\screenshots\\")+Screenshotname+dateName+".png";
		File fileDestination = new File(destination);
		Files.copy(src, fileDestination);
		
		return destination;
		
	}

	@AfterMethod
	public void Teardown(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Testcase failed is"+result.getName());
			test.log(Status.FAIL, "Testcase failed is"+result.getThrowable());
			String screenShotpath =Facebookpagereport.getScreenShot(driver,result.getName());
			test.log(Status.FAIL, "Screenshot of failed test is"+test.addScreenCaptureFromPath(screenShotpath));
		}
	        else if(result.getStatus()==ITestResult.SKIP)
	        	test.log(Status.SKIP, "Testcase skipped is"+result.getName());
		
		driver.close();
	}
	@AfterSuite
	public void CloseReport()
	{
		extent.flush();
	}

}
