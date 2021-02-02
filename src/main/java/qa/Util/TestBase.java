package qa.Util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		try {
		prop=new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\TestngPOM\\src"
				+ "\\main\\java\\qa\\config\\config.properties");
		prop.load(fis);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public static void Initialization()
	{
		String browserName =prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			driver =new ChromeDriver();
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

	}

	public static void Ending()
	{
		driver.quit();
	}
}
