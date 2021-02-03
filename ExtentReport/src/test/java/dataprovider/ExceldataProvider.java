package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExceldataProvider 
{	@Test(dataProvider ="test1Data")
	public void test1(String username,String Password)
	{
		System.out.println("username:"+username);
		System.out.println("password:"+Password);
	}
	
	
	@DataProvider(name ="test1Data")
	public static Object[][] getData()
	{
		String excelpath ="C:\\Users\\lenovo\\eclipse-workspace\\Datadrivenapproach\\src\\com\\data\\dataprovider1.xlsx";
		Object data[][]=testData(excelpath, "Sheet1");
		return data;
	}
	
	public static Object[][] testData(String excelpath,String sheetname)
	{
		ExcelUtils excel = new ExcelUtils(excelpath, sheetname);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount][colCount];
		
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData = excel.getCellDataString(i, j);
				System.out.println(cellData+"|");
				data[i][j]= cellData;
				
				
			}
		}
		return data;
	}

}

