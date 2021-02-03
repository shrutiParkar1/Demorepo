package dataprovider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils 
{
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public ExcelUtils(String excelpath,String sheetname)
	{
		try {
		workbook = new XSSFWorkbook(excelpath);
		sheet = workbook.getSheet(sheetname);
		}
		catch(Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		
		}
	public static int getRowCount()
	{
		int rowCount =0;
		try {
			rowCount =sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: "+rowCount);
			System.out.println("************************************");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return rowCount;
	}
	
	public static int getColCount()
	{
		int colCount =0;
		try {
			colCount =sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of cols: "+colCount);
			System.out.println("************************************");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return colCount;
	}
	
	public static String getCellDataString(int rowNum, int colNum)
	{
		String cellData =null;
		
		
		try {
			cellData =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("data: "+cellData);
			System.out.println("************************************");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return cellData;
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
