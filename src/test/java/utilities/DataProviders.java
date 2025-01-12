package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//dataprovider 1
	
	@DataProvider(name="Logindata")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testdata
		
		ExcelUtilities xlutil=new ExcelUtilities(path);//creating an object for utility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols]; //created 2d array 
		
		for(int i=1;i<=totalrows;i++) //read ddata from xl storing in 2d array
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				
			}
		}
		return logindata; //returning 2d array
		
	}
	//DataProvide 2
	//DataProvide 3
	//DataProvide 4
}
