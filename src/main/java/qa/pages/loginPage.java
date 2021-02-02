package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.Util.TestBase;

public class loginPage extends TestBase
{
	@FindBy(name="email")
	WebElement username;
	@FindBy(name="pass")
	WebElement password;
	
	public loginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public HomePage login(String uname,String pass)
	{
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		return new HomePage();
	}
public String validateHomepage()
{
	return driver.getTitle();
	}
}
