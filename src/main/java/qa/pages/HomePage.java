package qa.pages;

import java.sql.Driver;

import qa.Util.TestBase;

public class HomePage extends TestBase
{
	public String validateHomePage()
	{
		return driver.getTitle(); 
		
	}

}
