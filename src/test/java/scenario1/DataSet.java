package scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSet  
{

	XSSFWorkbook wb;
	@DataProvider(name="excelData")
	
	public Object[][] fileReadTest() 
	{
		File file= new File(System.getProperty("user.dir")+"\\TestData\\Data.xlsx");
		FileInputStream fs;
		Object data[][]=null;
		try 
		{
			fs = new FileInputStream(file);


			wb = new XSSFWorkbook(fs);
			
			// number of rows
			int row=wb.getSheet("userdata").getPhysicalNumberOfRows();
			
			//number of cells
			int cellNum=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
			
			data= new Object[row-1][cellNum]; // to start from 1st row instead of 0
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<cellNum;j++)
				{
					data[i-1][j]=wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
					System.out.println(data[i-1][j]+" ");
				}
				System.out.println();
			}
					
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {

			e.printStackTrace();
		}
		return data;		
	}

	} 		

